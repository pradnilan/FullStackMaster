package org.prad.entity;

import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "flight_leg_instance")
@ToString
public class FlightLegInstance {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flightleg_ins_id")
    private long legInstanceId;
    @Column(name = "ins_date")
    private LocalDate departureDate;
    @Column(name="available_seats")
    private int availableSeats;
    @Column(name = "status")
    private int Status;
    @OneToOne(cascade = CascadeType.ALL)
    private FlightLeg flightLeg;
    @Column(name = "price")
    private double price;

    public FlightLegInstance() {
    }

    public FlightLegInstance(LocalDate departureDate, int availableSeats, int status, FlightLeg flightLeg, double price) {
        this.departureDate = departureDate;
        this.availableSeats = availableSeats;
        this.Status = status;
        this.flightLeg = flightLeg;
        this.price = price;
    }

    public long getLegInstanceId() {
        return legInstanceId;
    }

    public void setLegInstanceId(int legInstanceId) {
        this.legInstanceId = legInstanceId;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public FlightLeg getFlightLeg() {
        return flightLeg;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setFlightLeg(FlightLeg flightLeg) {
        this.flightLeg = flightLeg;
    }
}
