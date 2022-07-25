package org.prad.service;

import org.prad.dto.FlightSearchParam;
import org.prad.dto.FlightSearchResult;

import java.util.List;

public interface FlightSearchService {
    public List<FlightSearchResult> searchFlights(FlightSearchParam param);
    public FlightSearchResult searchFlightById(FlightSearchParam param);

}
