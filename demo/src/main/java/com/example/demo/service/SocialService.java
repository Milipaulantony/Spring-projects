package com.example.demo.service;

import com.example.demo.models.SocialUser;
import com.example.demo.repository.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SocialService {
    @Autowired
    private SocialUserRepository user_db;

    public List<SocialUser> findAllUsers() {
        return user_db.findAll();
    }

    public SocialUser createUser(SocialUser user) {
        //return user_db.save(user);

        if (user.getSocialProfile() != null) {
            // ensure owning side is set
            user.getSocialProfile().setUser(user);
        }

        return user_db.save(user);
    }
}
