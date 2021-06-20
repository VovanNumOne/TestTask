package com.gridnine.testing;

import java.util.List;

public class UnfilteredFlights implements Filter {
    @Override
    public List<Flight> filterFlights(List<Flight> flight) {
        return flight;
    }
}
