package com.spring.loose.coupling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EgWithSpring {
    public static void main(String[] args) {
        ApplicationContext context
                =  new ClassPathXmlApplicationContext("applicationLooseCouplingContext.xml");

        UserManager usr_mgr_db = (UserManager)context.getBean("DBMgr");
        System.out.println(usr_mgr_db.getUserInfo());

        UserManager usr_mgr_WS = (UserManager)context.getBean("WSMgr");
        System.out.println(usr_mgr_WS.getUserInfo());

        UserManager usr_mgr_newDB = (UserManager)context.getBean("NewDBMgr");
        System.out.println(usr_mgr_newDB.getUserInfo());

    }
}
