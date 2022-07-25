package org.prad.service;

import org.prad.dao.FlightResultDao;
import org.prad.dao.FlightResultDaoImpl;
import org.prad.dao.PassengerDao;
import org.prad.dao.PassengerDaoImpl;
import org.prad.entity.Passenger;

import java.util.List;

public class PassengerServiceImpl implements PassengerService {

    PassengerDao passengerDao;

    public PassengerServiceImpl () {
        passengerDao = new PassengerDaoImpl();
    }

    @Override
    public List<Long> addPassengers(List<Passenger> passengers) {
        return passengerDao.addPassengers(passengers);
    }


}
