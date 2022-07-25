package org.prad.service;

import org.prad.dao.FlightResultDao;
import org.prad.dao.FlightResultDaoImpl;
import org.prad.dto.FlightSearchParam;
import org.prad.dto.FlightSearchResult;

import java.util.List;

public class FlightSearchServiceImpl implements FlightSearchService {

    FlightResultDao flightResultDao;

    public FlightSearchServiceImpl() {
        flightResultDao = new FlightResultDaoImpl();
    }

    @Override
    public List<FlightSearchResult> searchFlights(FlightSearchParam param) {
        return flightResultDao.searchFlights(param);
    }

    @Override
    public FlightSearchResult searchFlightById(FlightSearchParam param) {
        return flightResultDao.searchFlightById(param);
    }
}
