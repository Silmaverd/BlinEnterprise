package blinenterprise;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;
import java.util.Iterator;

public class DatabaseClient {
    
    private File xml;
    private CardCollection cardCollection;
    
    private HashSet<Card> ParseXML(){
        HashSet<Card> cards = new HashSet<>();
        try {
            File inputFile = new File("cards.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLHandler xmlHandler = new XMLHandler();
            saxParser.parse(inputFile, xmlHandler);
            
            cards = (HashSet<Card>) xmlHandler.getCardCollection();   /// wczytywanie do hashsetu kolekcji kart                              
            return cards;
        } catch (IOException | ParserConfigurationException | SAXException e) {
        }finally{
            return cards;
        }
    }
    
    public DatabaseClient(){      
        xml = new File("cards.xml");
        cardCollection = new CardCollection(new HashSet<>());
        Collection<Card> col = ParseXML();
        cardCollection.setCollection(col);
    }
    
    public String getCardDescription(String name) throws CardNotFoundException{
        return cardCollection.getCardDescription(name);
    }
    
    public String[] getCardNamesArray(){
        return cardCollection.getCardNames();
    }
    
    public String[] getCardNamesArrayContaining(String text){
        return cardCollection.getCardsContaining(text);
    }
    
    public Card getCardWithName(String name) throws CardNotFoundException{
        return cardCollection.getCardWithName(name);
    }
    
    public Image GetImage(String cardName) throws CardNotFoundException {
        Image image = null;
        HashSet<Integer> muIds = cardCollection.getCardIDs(cardName);
        for(Integer cardID : muIds){ 
            //System.out.println("Trying: "+ Integer.toString(cardID));
            try {
                URL url = new URL( "http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid="+Integer.toString(cardID)+"&type=card");
                image = ImageIO.read(url);
                //System.out.println("http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid="+Integer.toString(cardID)+"&type=card");
            } catch (IOException e) {
                System.out.println("Shieeeeeeeeeeeeeeeet");
            }
            if (cardID != 0){
                break;
            }
        }
        return image;
    }
}