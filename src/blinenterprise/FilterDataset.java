package blinenterprise;

import java.util.HashSet;


public class FilterDataset {
   
    public HashSet<Card> defaultCardColorFilter(HashSet<Card> cardList, HashSet<Filter> filters) {
        
        HashSet<Card> tempCardList = new HashSet();
        
        for (Filter currentFilter: filters) {
            if(currentFilter.command == Filter.Commands.BLACK) {
                tempCardList = findCardColorFilter(cardList, tempCardList, "B");//black
            }
            else if(currentFilter.command == Filter.Commands.BLUE) {
                tempCardList = findCardColorFilter(cardList, tempCardList, "U");//blue
            }
            else if(currentFilter.command == Filter.Commands.GREEN) {
                tempCardList = findCardColorFilter(cardList, tempCardList, "G");//green
            }
            else if(currentFilter.command == Filter.Commands.WHITE) {
                tempCardList = findCardColorFilter(cardList, tempCardList, "W");//white
            }
            else if(currentFilter.command == Filter.Commands.RED) {
                tempCardList = findCardColorFilter(cardList, tempCardList, "R");//red
            }
        }    
        return tempCardList;
    }
    
    public HashSet<Card> findCardColorFilter(HashSet<Card> cardList, 
        HashSet<Card> tempCardList, String colorName) {
        
        HashSet<String> cardColors;
        Boolean matchingColorFound;
        
        for (Card card : cardList){         
            cardColors = card.getCardColors();
            matchingColorFound = false;
            
            for(String color : cardColors) {
                if(color.equals(colorName)) {
                    matchingColorFound = true;
                }
            }
            if(matchingColorFound) {
                tempCardList.add(card);
            }
        }
        
        return tempCardList;
    }
}