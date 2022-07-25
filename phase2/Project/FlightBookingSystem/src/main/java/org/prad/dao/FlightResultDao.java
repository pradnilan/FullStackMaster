package org.prad.dao;

import org.prad.dto.FlightSearchParam;
import org.prad.dto.FlightSearchResult;
import java.util.List;

public interface FlightResultDao<list> {

    public List<FlightSearchResult> searchFlights(FlightSearchParam param);
    public FlightSearchResult searchFlightById(FlightSearchParam param);

}
