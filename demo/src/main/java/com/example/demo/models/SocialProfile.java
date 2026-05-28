package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profile_id;

    //This will be considered the owner
    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private SocialUser user;

    private String description;

    /*
    public void setUser(SocialUser user) {
        this.user = user;
        if(user.getSocialProfile() != this) {
            System.out.println("Check in socialprofile");
            user.setSocialProfile(this);
        }
    }*/

    public void setSocialUser(SocialUser socialUser){
        this.user = socialUser;
        if (user.getSocialProfile() != this)
            user.setSocialProfile(this);
    }

}
