package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalBeforeDeparture extends FilterDecorator{

    public ArrivalBeforeDeparture(Filter filter) {
        super(filter);
    }

    @Override
    public List<Flight> filterFlights(List<Flight> flight) {
        return ArrivalBeforeDepartureFilter(super.filterFlights(flight));
    }
    public List<Flight> ArrivalBeforeDepartureFilter(List<Flight> flight){
        List<Flight> flightList = flight.stream().
                filter(fl -> fl.getSegments().stream().anyMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate()))).
                collect(Collectors.toList());
        return flightList;
    }
}
