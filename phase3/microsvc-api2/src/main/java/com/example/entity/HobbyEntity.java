package com.example.entity;

import javax.persistence.*;

@Entity
public class HobbyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private int personId;
    private String hobbyName;

    public HobbyEntity() {
    }

    public HobbyEntity(int id, int personId, String hobbyName) {
        this.id = id;
        this.personId = personId;
        this.hobbyName = hobbyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }
}
