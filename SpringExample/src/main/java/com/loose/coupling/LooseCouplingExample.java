package com.loose.coupling;

public class LooseCouplingExample {
    public static void main(String[] args) {
        //This will be done by Spring framework which is called IoC
        UserDataProvider generic_obj_db = new UserDatabaseProvider();
        UserManager usr_mgr = new UserManager(generic_obj_db);
        System.out.println(usr_mgr.getUserInfo());

        UserDataProvider WS_obj = new WebServiceDataProvider();
        UserManager usr_mgr_WS = new  UserManager(WS_obj);
        System.out.println(usr_mgr_WS.getUserInfo());

        UserDataProvider new_DB_obj = new NewDBProvider();
        UserManager usr_mgr_newDB = new  UserManager(new_DB_obj);
        System.out.println(usr_mgr_newDB.getUserInfo());


    }
}
