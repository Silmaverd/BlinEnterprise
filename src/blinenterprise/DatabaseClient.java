package blinenterprise;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class DatabaseClient {
    
    private File xml;
    private CardCollection cardCollection;
    private HashSet<Card> currentCardList;
    
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
        currentCardList = (HashSet<Card>) cardCollection.getCardCollection();
    }
    
    public String getCardDescription(String name) throws CardNotFoundException{
        for (Card card: currentCardList){
           if (card.getName().equals(name)) return card.getCardDescription();
        }
        throw new CardNotFoundException("Nie znaleziono karty");
    }
    
    public String[] getCardNamesArray(){
        return cardCollection.getCardNames();
    }
    
    public String[] getCardNamesArrayContaining(String text){
        currentCardList = cardCollection.getCardsContaining(text);
        String[] list_tab = new String[currentCardList.size()];
        int i=0;
        for (Card card : currentCardList){
            list_tab[i] = card.getName();
            i++;
        }
        Arrays.sort(list_tab);
        return list_tab;
    }
    
    public Card getCardWithName(String name) throws CardNotFoundException{

        for (Card card: currentCardList){
            if (card.getName().equals(name)) return card;
        }
        throw new CardNotFoundException("Nie znaleziono karty");
    }
    
    public Image GetImage(Card card) throws CardNotFoundException {
        Image image = null;
        HashSet<Integer> muIds = card.getMuIDs();
        for(Integer cardID : muIds){ 
            //System.out.println("Trying: "+ Integer.toString(cardID));
            if (cardID == 0) continue;
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