package com.simplilearn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

@Entity
@Data@NoArgsConstructor@AllArgsConstructor
public class UserEntity {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String mobile;
    private String email;
    @OneToOne( cascade =CascadeType.MERGE)
    @JoinColumn(name = "address_id")
    private AddressEntity address;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;
}
