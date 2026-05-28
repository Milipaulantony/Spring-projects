package com.spring.loose.coupling;

//This is the class that retrieves details from the database

public class UserDatabaseProvider implements UserDataProvider {
    @Override
    public String getUserDetails(){
        return "User Details from database";
    }
}
