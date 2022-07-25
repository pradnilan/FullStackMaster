package org.prad.entity;

import javax.persistence.*;

@Entity
@Table(name = "passengers")
public class Passenger extends User {

   @Column(name = "booking_id")
    private long bookingId;
    @Column(name = "passport_no")
    private String passportNo;

    public Passenger() {
    }

    public Passenger(String passportNo) {
        this.passportNo = passportNo;
    }

    public Passenger(String salutation, String firstName, String lastName,String passportNo) {
        super(salutation, firstName, lastName);
        this.passportNo = passportNo;
    }



   public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                ", passportNo='" + passportNo + '\'' +
                '}';
    }
}
