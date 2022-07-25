package org.prad.dto;

import java.time.LocalDate;

public class FlightSearchParam {

    private long legInstanceId;
    private LocalDate date;
    private String departure;
    private String arrival;
    private int noSeats;
    private String departureCode;
    private String arrivalCode;

    public FlightSearchParam(long l) {
    }

    public FlightSearchParam(long legInstanceId, int noSeats) {
        this.legInstanceId = legInstanceId;
        this.noSeats = noSeats;
    }

    public FlightSearchParam(LocalDate date, String departureCode, String arrivalCode, int noSeats) {
        this.date = date;
        this.departureCode = departureCode;
        this.arrivalCode = arrivalCode;
        this.noSeats = noSeats;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getNoSeats() {
        return noSeats;
    }

    public void setNoSeats(int noSeats) {
        this.noSeats = noSeats;
    }

    public String getDepartureCode() {
        return departureCode;
    }

    public void setDepartureCode(String departureCode) {
        this.departureCode = departureCode;
    }

    public String getArrivalCode() {
        return arrivalCode;
    }

    public void setArrivalCode(String arrivalCode) {
        this.arrivalCode = arrivalCode;
    }

    public long getLegInstanceId() {
        return legInstanceId;
    }

    public void setLegInstanceId(long legInstanceId) {
        this.legInstanceId = legInstanceId;
    }
}
