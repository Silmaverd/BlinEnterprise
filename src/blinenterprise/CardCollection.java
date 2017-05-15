package blinenterprise;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class CardCollection {                               // Kolekcja wczytanych kart
                                                            // Ta klasa zarzadza kolekcja, ale dostep do niej ma tylko klient bazy danych
    private Collection<Card> cards;
    private CardSearchFilter cardFilterMenager;

    public CardSearchFilter getCardFilterMenager() {
        return cardFilterMenager;
    }
    
    public CardCollection(Collection<Card> c){
        cards = c;
        cardFilterMenager = new CardSearchFilter();
    }
    
    public void setCollection(Collection<Card> col){
        cards = col;
    }
    
    public Card getCardWithName(String name) throws CardNotFoundException{      // Wyszukuje i zwraca z kolekcji kartę o podanej nazwie
        for (Card card: cards){
            //System.out.println("Search for: " + name + "        analyzing: "+card.getName());
            
            if (card.getName().equals(name)) return card;
        }
        throw new CardNotFoundException("Nie znaleziono karty");
    }
    
    public Collection<Card> getCardCollection(){
        return this.cards;
    }
    
    public HashSet<Integer> getCardIDs(String name) throws CardNotFoundException{   // Zwraca wszystkie muID karty o podanej nazwie
        return getCardWithName(name).getMuIDs();
    }
    
    public String getCardDescription(String name) throws CardNotFoundException{     // Zwraca opis karty o podanej nazwie
        return getCardWithName(name).getCardDescription();
    }
    
    public String[] getCardNames(){                                                 // Zwraca tablice zawierajaca nazwy wszystkich wczytanych kart
        String[] lista = new String[cards.size()];
        int i=0;
        for (Card card : cards){
            lista[i] = card.getName();
            i++;
        }
        Arrays.sort(lista);
        return lista;
    }
    
    public HashSet<Card> getCardsContaining(String text){                           // Zwraca tablice kart o nazwach, zaczynajacych sie od podanej frazy
        HashSet<Card> lista = new HashSet();                                        // Sluzy do filtrowania listy
        for (Card card : cards){
            if (card.getName().length() >= text.length()){
                //System.out.println("comparing: " + card.getName().substring(0, text.length()) + "   " + text);
                if (card.getName().toLowerCase().substring(0, text.length()).equals(text))
                    //System.out.println("dodane");
                    lista.add(card);
            }
        }
        return lista;
    }
    
    public HashSet<Card> applySearchFilters(String text) {
        if (text.equals("Wyszukaj kartę"))
            return cardFilterMenager.applyfilters(getCardsContaining(""));
        
        return cardFilterMenager.applyfilters(getCardsContaining(text));
    }
}
