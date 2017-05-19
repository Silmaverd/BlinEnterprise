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
    private CardCollection cardCollection;                                          // Klient bazy danych przechowuje kolekcje wczytanych kart jako obiekt CardCollection
                                                                                    // Tylko klient bazy danych ma dostep do kolekcji kart (wzorzec projektowy Proxy)
    private HashSet<Card> currentCardList;
    
    private HashSet<Card> ParseXML(){                                               // Dekowanie bazy danych XML
        HashSet<Card> cards = new HashSet<>();
        try {
            File inputFile = new File("cards.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();              // Fabryka SAXParsera tworzy nam obiekt Parsera
            SAXParser saxParser = factory.newSAXParser();
            XMLHandler xmlHandler = new XMLHandler();                               // Handler okreslajacy sposob parsowania
            saxParser.parse(inputFile, xmlHandler);                                 // Plik bazy danych jest parsowany
            
            cards = (HashSet<Card>) xmlHandler.getCardCollection();                 // Wczytywanie do hashsetu wczytanej kolekcji kart                              
            return cards;
        } catch (IOException | ParserConfigurationException | SAXException e) {
        }finally{
            return cards;
        }
    }
    
    public DatabaseClient(){                                                        // Inicjalizacja kolekcji
        xml = new File("cards.xml");                                                // Baza danych jest w pliku xml
        cardCollection = new CardCollection(new HashSet<>());                       // Plik dekodowany jest za pomoca SAX Parsera
        Collection<Card> col = ParseXML();
        cardCollection.setCollection(col);
        currentCardList = (HashSet<Card>) cardCollection.getCardCollection();
    }
    
    public String getCardDescription(String name) throws CardNotFoundException{     // Zwraca z kolekcji opis karty
        for (Card card: currentCardList){
           if (card.getName().equals(name)) return card.getCardDescription();
        }
        throw new CardNotFoundException("Nie znaleziono karty");
    }
    
    public String[] getCardNamesArray(){
        return cardCollection.getCardNames();
    }
    
    public CardSearchFilter getCardFilterMenager(){
        return cardCollection.getCardFilterMenager();
    }
    
    public String[] getCardNamesArrayContaining(String text){                   // Zwraca z kolekcji posortowana tablice kart zawierajacych wpisana fraze
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
    
    public String[] getFilteredCardNames(String text){
        if (text.equals("wyszukaj kartę")) {
            currentCardList = cardCollection.applySearchFilters("");  
        } else {
            currentCardList = cardCollection.applySearchFilters(text); 
        }
        String[] list_tab = new String[currentCardList.size()];
        int i=0;
        for (Card card : currentCardList){
            list_tab[i] = card.getName();
            i++;
        }
        Arrays.sort(list_tab);
        return list_tab;
    }
    
    public Card getCardWithName(String name) throws CardNotFoundException{  // Zwraca kolekcji kartę o podanej nazwie jako obiekt klasy Card

        for (Card card: currentCardList){
            if (card.getName().equals(name)) return card;
        }
        throw new CardNotFoundException("Nie znaleziono karty");
    }
    
    public Image GetImage(Card card) throws CardNotFoundException {         // Zwraca obrazek karty
        Image image = null;
        HashSet<Integer> muIds = card.getMuIDs();                           // Lista muID danej karty
        for(Integer cardID : muIds){                                        // Niektore obrazki sa niepoprawne, wiec iterujemy, dopoki nie znajdziemy poprawnego
            //System.out.println("Trying: "+ Integer.toString(cardID));
            if (cardID == 0) continue;
            try {
                URL url = new URL( "http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid="+Integer.toString(cardID)+"&type=card");      // Dostep do bazy Gatherer
                image = ImageIO.read(url);
            } catch (IOException e) {
                System.out.println("Shieeeeeeeeeeeeeeeet");
            }
            if (cardID != 0){                                               // Jezeli zostal znaleziony poprawny obrazek to konczymy iteracje
                break;
            }
        }
        return image;
    }
    
    public void removeAllFilters() {
        cardCollection.removeAllFilters();
    }
}