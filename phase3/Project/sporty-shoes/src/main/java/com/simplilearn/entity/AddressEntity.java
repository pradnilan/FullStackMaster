package com.simplilearn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data@NoArgsConstructor@AllArgsConstructor
public class AddressEntity {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    private String unitNo;
    private String street;
    private String city;
    private String country;
    private String zipCode;

}
