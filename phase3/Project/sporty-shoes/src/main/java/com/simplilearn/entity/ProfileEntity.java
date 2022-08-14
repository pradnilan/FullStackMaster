package com.simplilearn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data@NoArgsConstructor@AllArgsConstructor
public class ProfileEntity {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_id")
    private int profileId;
    private String role;

}
