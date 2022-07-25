package org.prad.entity;

import javax.persistence.*;

@Entity
@Table(name = "airplane")
public class Airplane {

    @Id@Column(name = "airplane_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "model")
    private String model;
    @Column(name = "manufacture")
    private String manufacture;
    @Column(name="capacity")
    private int capacity;

    public Airplane() {
    }

    public Airplane(String model,int capacity,String manufacture) {
        this.model = model;
        this.manufacture = manufacture;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
