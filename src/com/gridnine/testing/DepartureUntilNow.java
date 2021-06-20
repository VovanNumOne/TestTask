package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureUntilNow extends FilterDecorator{
    public DepartureUntilNow(Filter filter) {
        super(filter);
    }

    @Override
    public List<Flight> filterFlights(List<Flight> flight) {
        return departureUntilNowFilter(super.filterFlights(flight));
    }
    public List<Flight> departureUntilNowFilter(List<Flight> flight){
        List<Flight> flightList = flight.stream().
                filter(fl -> fl.getSegments().stream().anyMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now()))).
                collect(Collectors.toList());
        return flightList;
    }
}
