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
        if(!filters.isEmpty()){
            for (Filter currentFilter: filters) {
                if(currentFilter.command == Filter.Commands.MATCHCOLORSEXACTLY) {
                    cardList = filterData.matchColorExactlyCardColorFilter(cardList, filters);
                    defaultColorFilter = false;
                }
                if(currentFilter.command == Filter.Commands.SELECTTYPE) {
                    cardList = filterData.findCardTypeFilter(cardList, currentFilter.getValue());
                }
            }
            if(defaultColorFilter){
                cardList = filterData.defaultCardColorFilter(cardList, filters);
            }
        }
    return cardList;
    }
    
    public void removeAllFilters() {
        filters.clear();
    }
}