package com.simplilearn.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customerdata")
@Data @NoArgsConstructor
public class Customer {

    @Id @Column(name="customer_id")@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int custID;
    @Column(name = "customer_name")
    private String custName;
    @Column(name = "customer_address")
    private  String address;
    @ElementCollection
    @CollectionTable(name = "customersubscription",joinColumns = @JoinColumn(name = "customer_id"),
    indexes = @Index(name = "index"))
    @Column(name = "subscripiton")
    private List<String> subscriptions;

    public Customer(String custName, String address) {
        this.custName = custName;
        this.address = address;
    }


}
