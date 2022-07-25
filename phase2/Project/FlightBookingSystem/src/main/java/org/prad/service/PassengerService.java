package org.prad.service;

import org.prad.entity.Passenger;

import java.util.List;

public interface PassengerService {
    List<Long> addPassengers(List<Passenger> passengers);
}
