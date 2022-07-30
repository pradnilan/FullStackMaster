package com.example.entity;

public class Response {

    private PersonEntity entity;
    private String hobby;

    public Response() {
    }

    public Response(PersonEntity entity, String hobby) {
        this.entity = entity;
        this.hobby = hobby;
    }

    public PersonEntity getEntity() {
        return entity;
    }

    public void setEntity(PersonEntity entity) {
        this.entity = entity;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
