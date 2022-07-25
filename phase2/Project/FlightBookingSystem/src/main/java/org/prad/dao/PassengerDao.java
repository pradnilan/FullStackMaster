package org.prad.dao;

import org.prad.entity.Passenger;

import java.util.List;

public interface PassengerDao {
    public List<Long> addPassengers(List<Passenger> passengers);
}
