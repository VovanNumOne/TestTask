package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class GroundTimeMoreTwoHours extends FilterDecorator{


    public GroundTimeMoreTwoHours(Filter filter) {
        super(filter);
    }

    @Override
    public List<Flight> filterFlights(List<Flight> flight) {
        return twoHoursFilter(super.filterFlights(flight));
    }

    public List<Flight> twoHoursFilter(List<Flight> flight){
        List<Flight> flightList = new ArrayList<>();
        for (Flight fl: flight) {
            long groundTime = 0;
            for(int i = 0; i<fl.getSegments().size()-1; i++){
                LocalDateTime arrival = fl.getSegments().get(i).getArrivalDate();
                LocalDateTime departureNext =fl.getSegments().get(i+1).getDepartureDate();
                long tempGroundTime = ChronoUnit.HOURS.between(arrival,departureNext);
                groundTime = groundTime+tempGroundTime;
            }
            if(groundTime<2){
                flightList.add(fl);
            }

        }
        return flightList;
    }
}
