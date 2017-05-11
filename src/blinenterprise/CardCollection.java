package blinenterprise;

import java.io.IOException;
import java.util.Arrays;
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
    
    public Collection<Card> getCardCollection(){
        return this.cards;
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
    
    public String[] getCardNames(){
        String[] lista = new String[cards.size()];
        int i=0;
        for (Card card : cards){
            lista[i] = card.getName();
            i++;
        }
        Arrays.sort(lista);
        return lista;
    }
    
    public HashSet<Card> getCardsContaining(String text){
        HashSet<Card> lista = new HashSet();
        for (Card card : cards){
            if (card.getName().length() >= text.length()){
                //System.out.println("comparing: " + card.getName().substring(0, text.length()) + "   " + text);
                if (card.getName().substring(0, text.length()).equals(text))
                    //System.out.println("dodane");
                    lista.add(card);
            }
        }
        return lista;
    }
}
