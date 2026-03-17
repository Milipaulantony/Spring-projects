package com.tight.coupling;

//This manages the databases and all the methods
//Here usermanager is tightly coupled user database class so any change to database
//will change the code here
public class UserManager {
    private UserDatabase userDB = new UserDatabase();

    public String getUserInfo(){
        return userDB.getUserDetails();
    }
}
