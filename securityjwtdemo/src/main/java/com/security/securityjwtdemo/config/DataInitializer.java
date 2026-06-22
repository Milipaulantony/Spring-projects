package com.security.securityjwtdemo.config;


import com.security.securityjwtdemo.entity.AppUser;
import com.security.securityjwtdemo.respository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {
    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public CommandLineRunner initializeData(PasswordEncoder encoder) {
        return args -> {

            // =================================
            // User 1
            // =================================

            System.out.println("*****User 1 initialized******");
            AppUser user1 = new AppUser();
            user1.setUsername("admin");
            user1.setPassword(
                    encoder.encode("admin123"));
            user1.setRole("ADMIN");
            userRepository.save(user1);

            // =================================
            // User 2
            // =================================

            System.out.println("*****User 2 initialized******");

            AppUser user2 = new AppUser();
            user2.setUsername("hr");
            user2.setPassword(
                    encoder.encode("hr123"));
            user2.setRole("HR");
            userRepository.save(user2);
            // =================================
            // User 3
            // =================================

            System.out.println("*****User 3 initialized******");
            AppUser user3 = new AppUser();
            user3.setUsername("employee");
            user3.setPassword(encoder.encode("emp123"));
            user3.setRole("EMPLOYEE");
            userRepository.save(user3);

        };

    }
}

