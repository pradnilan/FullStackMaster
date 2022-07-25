package org.prad.entity;


import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name="flight_leg")
public class FlightLeg {

    @Id @Column(name = "leg_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int legId;
    @OneToOne(cascade = CascadeType.ALL)
    private Airport departure;
    @OneToOne(cascade = CascadeType.ALL)
    private Airport arrival;
    @Column(name = "departure_time")
    private LocalTime departureTime;
    @Column(name = "arrival_time")
    private LocalTime arrivalTime;
    @Column(name = "flight_duration")
    private LocalTime flightDuration;
    @OneToOne(cascade = CascadeType.ALL)
    private Flight flight;

    public FlightLeg() {
    }

    public FlightLeg(Airport departure, Airport arrival, LocalTime departureTime, LocalTime arrivalTime, Flight flight) {
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flight = flight;
        this.flightDuration=LocalTime.of(arrivalTime.getHour()-departureTime.getHour(),
                arrivalTime.getMinute()-departureTime.getMinute());
    }

    public int getLegId() {
        return legId;
    }

    public void setLegId(int legId) {
        this.legId = legId;
    }

    public Airport getDeparture() {
        return departure;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    public void setArrival(Airport arrival) {
        this.arrival = arrival;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(LocalTime flightDuration) {
        this.flightDuration = flightDuration;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
