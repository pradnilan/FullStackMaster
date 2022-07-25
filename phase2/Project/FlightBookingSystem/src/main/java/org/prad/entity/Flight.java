package org.prad.entity;

import javax.persistence.*;

@Entity
@Table(name = "flight")
public class Flight {
    @Id@Column(name = "flight_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "flight_no")
    private String flightNo;
    @Column(name = "airline")
    private String airline;
    @OneToOne(cascade = CascadeType.ALL)
    private Airplane airplane;

    public Flight() {
    }

    public Flight(String flightNo, String airline, Airplane airplane) {
        this.flightNo = flightNo;
        this.airline = airline;
        this.airplane = airplane;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
}
