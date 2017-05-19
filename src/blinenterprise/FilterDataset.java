package blinenterprise;

import java.util.HashSet;


public class FilterDataset {
   
    public HashSet<Card> defaultCardColorFilter(HashSet<Card> cardList, HashSet<Filter> filters) {
        
        HashSet<Card> tempCardList = new HashSet();
        
        for (Filter currentFilter: filters) {
            if(currentFilter.command == Filter.Commands.BLACK) {
                findCardColorFilter(cardList, tempCardList, "B");//black
            }
            else if(currentFilter.command == Filter.Commands.BLUE) {
                findCardColorFilter(cardList, tempCardList, "U");//blue
            }
            else if(currentFilter.command == Filter.Commands.GREEN) {
                findCardColorFilter(cardList, tempCardList, "G");//green
            }
            else if(currentFilter.command == Filter.Commands.WHITE) {
                findCardColorFilter(cardList, tempCardList, "W");//white
            }
            else if(currentFilter.command == Filter.Commands.RED) {
                findCardColorFilter(cardList, tempCardList, "R");//red
            }
        }    
        if (tempCardList.isEmpty()) System.out.println("empty");
        return (tempCardList.isEmpty()) ? cardList : tempCardList;
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
    
        public HashSet<Card> matchColorExactlyCardColorFilter(HashSet<Card> cardList, HashSet<Filter> filters) {
        HashSet<Card> tempCardList = new HashSet();
        
        for (Filter currentFilter: filters) {     
            if(currentFilter.command == Filter.Commands.BLACK) {
                findCardColorFilter(cardList, tempCardList, "B");//black

                cardList.clear();
                cardList.addAll(tempCardList);
                tempCardList.clear();
            }
            else if(currentFilter.command == Filter.Commands.BLUE) {
                findCardColorFilter(cardList, tempCardList, "U");//blue
                
                cardList.clear();
                cardList.addAll(tempCardList);
                tempCardList.clear();
            }
            else if(currentFilter.command == Filter.Commands.GREEN) {
                findCardColorFilter(cardList, tempCardList, "G");//green
                
                cardList.clear();
                cardList.addAll(tempCardList);
                tempCardList.clear();
            }
            else if(currentFilter.command == Filter.Commands.WHITE) {
                findCardColorFilter(cardList, tempCardList, "W");//white
                
                cardList.clear();
                cardList.addAll(tempCardList);
                tempCardList.clear();
            }
            else if(currentFilter.command == Filter.Commands.RED) {
                findCardColorFilter(cardList, tempCardList, "R");//red
                
                cardList.clear();
                cardList.addAll(tempCardList);
                tempCardList.clear();
            }
        }    
        return cardList;
    }
    
    public HashSet<Card> findCardTypeFilter(HashSet<Card> cardList, String cardType) {
        HashSet<Card> tempCardList = new HashSet();

        for (Card card : cardList){         
            
            if(card.getCardtype().toUpperCase().contains(cardType.toUpperCase())) {
                tempCardList.add(card);
                
            }
        }  
        return tempCardList;
    }
}