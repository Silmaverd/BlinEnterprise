package blinenterprise;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

public class CardCollection {
    private Collection<Card> cards;
    
    public CardCollection(Collection<Card> c){
        cards = c;
    }
    
    public void setCollection(Collection<Card> col){
        cards = col;
        /*for(Card card :cards){
            card.printCard();
            System.out.println("");
        }*/
    }
    
    public HashSet<Integer> getCardIDs(String name) throws CardNotFoundException{
        return getCardWithName(name).getMuIDs();
    }
    
    public String getCardDescription(String name) throws CardNotFoundException{
        return getCardWithName(name).getCardDescription();
    }
    
    public Card getCardWithName(String name) throws CardNotFoundException{
        for (Card card: cards){
            //System.out.println("Search for: " + name + "        analyzing: "+card.getName());
            
            if (card.getName().equals(name)) return card;
        }
        throw new CardNotFoundException("Nie znaleziono karty");
    }
}
