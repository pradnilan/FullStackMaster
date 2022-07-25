package org.prad.dto;

import org.prad.entity.Airport;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class FlightSearchResult {

    private long legInstanceId;
    private String manufacture;
    private String model;
    private String airline;
    private String flightNo;
    private LocalDate departureDate;
    private Airport departure;
    private Airport arrival;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int availableSeats;
    private int maxCapacity;
    private double price;
    private double total;

    public FlightSearchResult() {
    }

    public FlightSearchResult(long legInstanceId, String manufacture, String model, String airline, String flightNo, LocalDate departureDate, Airport departure, Airport arrival, LocalTime departureTime, LocalTime arrivalTime, int availableSeats, int maxCapacity, double price) {
        this.legInstanceId = legInstanceId;
        this.manufacture = manufacture;
        this.model = model;
        this.airline = airline;
        this.flightNo = flightNo;
        this.departureDate = departureDate;
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeats = availableSeats;
        this.maxCapacity = maxCapacity;
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
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

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public long getLegInstanceId() {
        return legInstanceId;
    }

    public void setLegInstanceId(long legInstanceId) {
        this.legInstanceId = legInstanceId;
    }

    @Override
    public String toString() {
        return "FlightSearchResult{" +
                "legInstanceId=" + legInstanceId +
                ", manufacture='" + manufacture + '\'' +
                ", model='" + model + '\'' +
                ", airline='" + airline + '\'' +
                ", flightNo='" + flightNo + '\'' +
                ", departureDate=" + departureDate +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", availableSeats=" + availableSeats +
                ", maxCapacity=" + maxCapacity +
                ", price=" + price +
                '}';
    }
}

