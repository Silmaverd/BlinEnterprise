package blinenterprise;

import java.util.HashSet;


public class FilterDataset {
   
    public String changeColorCommandToColorSign(Filter.Commands command) {
        switch (command) {
            case BLACK:
                return "B";
            case BLUE:
                return "U";
            case GREEN:
                return "G";
            case WHITE:
                return "W";
            default:
                return "R";
        }
    }
    
    public HashSet<Card> defaultCardColorFilter(HashSet<Card> cardList, HashSet<Filter> filters) {
        
        HashSet<Card> tempCardList = new HashSet();
        
        for (Filter currentFilter: filters) {
            if(null != currentFilter.command) switch (currentFilter.command) {
                case BLACK:
                    findCardColorFilter(cardList, tempCardList,
                            changeColorCommandToColorSign(Filter.Commands.BLACK));
                    break;
                case BLUE:
                    findCardColorFilter(cardList, tempCardList,
                            changeColorCommandToColorSign(Filter.Commands.BLUE));
                    break;
                case GREEN:
                    findCardColorFilter(cardList, tempCardList,
                            changeColorCommandToColorSign(Filter.Commands.GREEN));
                    break;
                case WHITE:
                    findCardColorFilter(cardList, tempCardList,
                            changeColorCommandToColorSign(Filter.Commands.WHITE));
                    break;
                case RED:
                    findCardColorFilter(cardList, tempCardList,
                            changeColorCommandToColorSign(Filter.Commands.RED));
                    break;
                default:
                    break;
            }
        }    
        return (tempCardList.isEmpty()) ? cardList : tempCardList;
    }
    
   public HashSet<Card> matchColorExactlyCardColorFilter(HashSet<Card> cardList, HashSet<Filter> filters) {
        HashSet<Card> tempCardList = new HashSet();

        for (Filter currentFilter: filters) {     
            if(null != currentFilter.command) switch (currentFilter.command) {
                case BLACK:
                    findCardColorFilter(cardList, tempCardList,
                            changeColorCommandToColorSign(Filter.Commands.BLACK));
                    cardList.clear();
                    cardList.addAll(tempCardList);
                    tempCardList.clear();
                    break;
                case BLUE:
                    findCardColorFilter(cardList, tempCardList,
                            changeColorCommandToColorSign(Filter.Commands.BLUE));
                    cardList.clear();
                    cardList.addAll(tempCardList);
                    tempCardList.clear();
                    break;
                case GREEN:
                    findCardColorFilter(cardList, tempCardList,
                            changeColorCommandToColorSign(Filter.Commands.GREEN));
                    cardList.clear();
                    cardList.addAll(tempCardList);
                    tempCardList.clear();
                    break;
                case WHITE:
                    findCardColorFilter(cardList, tempCardList,
                            changeColorCommandToColorSign(Filter.Commands.WHITE));
                    cardList.clear();
                    cardList.addAll(tempCardList);
                    tempCardList.clear();
                    break;
                case RED:
                    findCardColorFilter(cardList, tempCardList,
                            changeColorCommandToColorSign(Filter.Commands.RED));
                    cardList.clear();
                    cardList.addAll(tempCardList);
                    tempCardList.clear();
                    break;
                default:
                    break;
            }
        }    
        return cardList;
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
    
    public HashSet<Card> findCardTypeFilter(HashSet<Card> cardList, String cardType) {
        HashSet<Card> tempCardList = new HashSet();

        for (Card card : cardList){         
            
            if(card.getCardtype().toUpperCase().contains(cardType.toUpperCase())) {
                tempCardList.add(card);
            }
        }  
        return tempCardList;
    }

    public HashSet<Card> excludeUnselectedColorsFilter(HashSet<Card> cardList, HashSet<Filter> filters) {
        HashSet<String> cardColors;
        HashSet<Filter.Commands> colorsToCheck = new HashSet();
        HashSet<Card> tempCardList = new HashSet();
        int colorsChacked = 0;
        
        for (Filter filter : filters) {
            if (filter.getCommand().equals(Filter.Commands.BLACK)||
                    filter.getCommand().equals(Filter.Commands.WHITE)||
                    filter.getCommand().equals(Filter.Commands.RED)||
                    filter.getCommand().equals(Filter.Commands.BLUE)||
                    filter.getCommand().equals(Filter.Commands.GREEN)){       
                colorsToCheck.add(filter.getCommand());
            }
        }       
        
        for (Card card : cardList){         
            cardColors = card.getCardColors();
            
            for(String color : cardColors) {
                for(Filter.Commands command : colorsToCheck) {
                    if(color.equals(changeColorCommandToColorSign(command))) 
                        colorsChacked--;
                    else colorsChacked++;
                }     
            }
            if(colorsChacked == 0) {
                tempCardList.add(card);
            }
            colorsChacked = 0;
        }
        return tempCardList;
    }
    
    public HashSet<Card> convertedManaCostFilter(HashSet<Card> cardList, Filter filterInfo) {
        HashSet<Card> tempCardList = new HashSet();

        for (Card card : cardList){         
            
            switch (filterInfo.getSubcommand()) {
                case "Greater Than":
                    if(card.getCmc() > Integer.parseInt(filterInfo.getValue())) {
                        tempCardList.add(card);
                    }   break;
                case "Greater Equal To":
                    if(card.getCmc() >= Integer.parseInt(filterInfo.getValue())) {
                        tempCardList.add(card);
                    }   break;
                case "Less Than":
                    if(card.getCmc() < Integer.parseInt(filterInfo.getValue())) {
                        tempCardList.add(card);
                    }   break;
                case "Less Equal To":
                    if(card.getCmc() <= Integer.parseInt(filterInfo.getValue())) {
                        tempCardList.add(card);
                    }   break;
                case "Equal To":
                    if(card.getCmc() == Integer.parseInt(filterInfo.getValue())) {
                        tempCardList.add(card);
                    }   break;
                case "Not Equal To":
                    if(card.getCmc() != Integer.parseInt(filterInfo.getValue())) {
                        tempCardList.add(card);
                    }   break;
                default:
                    break;
            }
        }  
        return tempCardList;
    }
}