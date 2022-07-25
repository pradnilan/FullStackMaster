package org.prad.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_id")
    private long profileId;
    @Column(name = "profile_name")
    private String profileType; //administrator or customer

    public UserProfile() {
    }

    public UserProfile(String profileType) {
        this.profileType = profileType;
    }

    public long getProfileId() {
        return profileId;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }

    public String getProfileType() {
        return profileType;
    }

    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "profileId=" + profileId +
                ", profileName='" + profileType + '\'' +
                '}';
    }
}
