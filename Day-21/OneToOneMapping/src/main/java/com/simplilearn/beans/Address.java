package com.simplilearn.beans;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee_address")
public class Address {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int addressId;
    @Column(name = "street")
    private String street;
    @Column(name = "unit")
    private String unit;
    @Column(name = "postalcode")
    private String postalCode;

    public Address(String street, String unit, String postalCode) {
        this.street = street;
        this.unit = unit;
        this.postalCode = postalCode;
    }
}
