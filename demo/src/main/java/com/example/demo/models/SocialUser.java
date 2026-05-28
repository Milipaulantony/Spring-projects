package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @OneToOne(mappedBy="user", cascade=CascadeType.ALL)
    //@JoinColumn(name = "user_social_profile")
    private SocialProfile socialProfile;

    @OneToMany(mappedBy="socialUser")
    private List<Post> posts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name="user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<SocialGroup> groups = new HashSet<>();

    /*
    public void setSocialProfile(SocialProfile socialProfile){
        System.out.println("I am being called here");
        this.socialProfile = socialProfile;
        if(socialProfile != null){
            System.out.println("Inside the check condition of Social User");
            socialProfile.setUser(this);
        }

    }*/

    public void setSocialProfile(SocialProfile socialProfile){
        socialProfile.setUser(this);
        this.socialProfile = socialProfile;
    }

    @Override
    public int hashCode(){
        return Objects.hash(user_id);

    }
}
