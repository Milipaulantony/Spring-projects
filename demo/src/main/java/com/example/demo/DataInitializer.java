package com.example.demo;

import com.example.demo.models.Post;
import com.example.demo.models.SocialGroup;
import com.example.demo.models.SocialProfile;
import com.example.demo.models.SocialUser;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.SocialGroupRepository;
import com.example.demo.repository.SocialProfileRepository;
import com.example.demo.repository.SocialUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    private final PostRepository post_table;
    private final SocialGroupRepository group_table;
    private final SocialProfileRepository profile_table;
    private final SocialUserRepository user_table;


    public DataInitializer(PostRepository post_table, SocialGroupRepository group_table, SocialProfileRepository profile_table, SocialUserRepository user_table) {
        this.post_table = post_table;
        this.group_table = group_table;
        this.profile_table = profile_table;
        this.user_table = user_table;
    }

    @Bean
    public CommandLineRunner initializeData(){
        return (args -> {
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            user_table.save(user1);
            user_table.save(user2);
            user_table.save(user3);

            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            group1.getUsers().add(user1);
            group1.getUsers().add(user2);

            group2.getUsers().add(user2);
            group2.getUsers().add(user3);

            group_table.save(group1);
            group_table.save(group2);

            user1.getGroups().add(group1);

            user2.getGroups().add(group1);
            user2.getGroups().add(group2);

            user3.getGroups().add(group2);

            user_table.save(user1);
            user_table.save(user2);
            user_table.save(user3);


            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();

            post1.setSocialUser(user1);
            post2.setSocialUser(user2);
            post3.setSocialUser(user3);

            post_table.save(post1);
            post_table.save(post2);
            post_table.save(post3);

            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            profile1.setUser(user1);
            profile2.setUser(user2);
            profile3.setUser(user3);

            profile_table.save(profile1);
            profile_table.save(profile2);
            profile_table.save(profile3);

        });
    }
}
