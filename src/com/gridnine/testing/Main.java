package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();
        UnfilteredFlights unfilteredFlights = new UnfilteredFlights();

        Filter flightsUntilNow = new DepartureUntilNow(unfilteredFlights);
        Filter arrivalBeforeDeparture = new ArrivalBeforeDeparture(unfilteredFlights);
        Filter groundTime = new GroundTimeMoreTwoHours(unfilteredFlights);

        flightsUntilNow.filterFlights(flightList).forEach(System.out::println);
        System.out.println("__________________________________");
        arrivalBeforeDeparture.filterFlights(flightList).forEach(System.out::println);
        System.out.println("__________________________________");
        groundTime.filterFlights(flightList).forEach(System.out::println);



    }
}
