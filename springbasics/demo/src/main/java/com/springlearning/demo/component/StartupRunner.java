package com.springlearning.demo.component;

import com.springlearning.demo.service.NotificationManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
 Need String Bean?
↓
Spring searches Container
↓
Found appName Bean
↓
Injects automatically

 */

@Component
public class StartupRunner implements CommandLineRunner {

    private final NotificationManager manager;
    private final String appName;

    public StartupRunner(NotificationManager manager, String appName) {
        this.manager = manager;
        this.appName = appName;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(appName);
        manager.notifyUser();
    }
}
