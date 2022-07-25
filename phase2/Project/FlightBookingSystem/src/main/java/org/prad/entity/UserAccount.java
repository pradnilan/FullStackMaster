package org.prad.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_accounts")
public class UserAccount extends User {

    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    private UserProfile profile;

    public UserAccount() {
    }

    public UserAccount(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    public UserAccount(String userName, String password, UserProfile profile) {
        this.userName = userName;
        this.password = password;
        this.profile = profile;
    }

    public UserAccount(String salutation, String firstName, String lastName, String userName, String password, UserProfile profile) {
        super(salutation, firstName, lastName);
        this.userName = userName;
        this.password = password;
        this.profile = profile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserProfile getProfile() {
        return profile;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", profile=" + profile +
                '}';
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }


}
