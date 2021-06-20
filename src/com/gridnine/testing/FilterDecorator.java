package com.gridnine.testing;

import java.util.List;

public class FilterDecorator implements Filter{
    private Filter filter;

    public FilterDecorator(Filter filter) {
        this.filter = filter;
    }

    @Override
    public List<Flight> filterFlights(List<Flight> flight) {
        return filter.filterFlights(flight);
    }
}
