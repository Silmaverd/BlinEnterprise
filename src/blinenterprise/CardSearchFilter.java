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
            filters.add(newFilter);  
            System.out.println(newFilter.getCommand().toString());
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
        boolean noFilterApplied = true;
        if(!filters.isEmpty()){
            for (Filter currentFilter: filters) {
                if(currentFilter.command == Filter.Commands.MATCHCOLORSEXACTLY) {
                    System.out.println("TO IMPLEMENT");                             //todo
                }
            }
            if(noFilterApplied){
                cardList = filterData.defaultCardColorFilter(cardList, filters);
            }
        }
    return cardList;
    }
}