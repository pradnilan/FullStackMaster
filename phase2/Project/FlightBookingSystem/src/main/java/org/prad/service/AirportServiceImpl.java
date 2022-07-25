package org.prad.service;

import org.prad.dao.AirportDao;
import org.prad.dao.AirportDaoImpl;
import org.prad.entity.Airport;

import java.util.List;

public class AirportServiceImpl implements AirportService {

    AirportDao airportDao;

    public AirportServiceImpl() {
        airportDao=new AirportDaoImpl();
    }

    @Override
    public List<Airport> searchAllAirport() {
        return airportDao.searchAllAirport();
    }
}
