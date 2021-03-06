package blinenterprise;

import java.util.HashSet;


public class CardSearchFilter {
    
    HashSet<Filter> filters;
    FilterDataset filterData;
    
    public CardSearchFilter() {
        filters = new HashSet();
        filterData = new FilterDataset();
    }
    
    public void addFilter(Filter newFilter) {           
            if (newFilter.compareCommand(Filter.Commands.SELECTTYPE)) {
                removeFilter(newFilter);    // there could be only one SELECTTYPE filter
            }
            if (newFilter.compareCommand(Filter.Commands.CONVERTEDMANACOST)) {
                removeFilter(newFilter);    // there could be only one CONVERTEDMANACOST filter
            }
            filters.add(newFilter); 
    }
    
    public void removeFilter(Filter removeFilter) {
        HashSet<Filter> newFilters = new HashSet();
        for (Filter currentFilter: filters) {
            if(!removeFilter.compareCommand(currentFilter)) {
                newFilters.add(currentFilter);
            } 
        }
        filters = newFilters;
    }
    
    public HashSet<Card> applyfilters(HashSet<Card> cardList) {
        boolean defaultColorFilter = true;
        boolean excludeUnselectedColorsFilter = false;
        boolean convertedManaCost = false;
        
        if(!filters.isEmpty()){
            for (Filter currentFilter: filters) {
                if(currentFilter.command == Filter.Commands.MATCHCOLORSEXACTLY) {
                    cardList = filterData.matchColorExactlyCardColorFilter(cardList, filters);
                    defaultColorFilter = false;
                }
                if(currentFilter.command == Filter.Commands.SELECTTYPE) {
                    cardList = filterData.findCardTypeFilter(cardList, currentFilter.getValue());
                }
                if(currentFilter.command == Filter.Commands.EXCLUDEUNSELECTEDCOLORS) {
                    excludeUnselectedColorsFilter = true;
                }
                if(currentFilter.command == Filter.Commands.CONVERTEDMANACOST) {
                    cardList = filterData.convertedManaCostFilter(cardList, currentFilter);
                }
            }
            if(defaultColorFilter)
                cardList = filterData.defaultCardColorFilter(cardList, filters);          
            if(excludeUnselectedColorsFilter)
                cardList = filterData.excludeUnselectedColorsFilter(cardList, filters);
        }
    return cardList;
    }
    
    public void removeAllFilters() {
        filters.clear();
    }
}