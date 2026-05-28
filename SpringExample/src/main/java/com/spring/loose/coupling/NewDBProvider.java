package com.spring.loose.coupling;

public class NewDBProvider implements UserDataProvider {
    @Override
    public String getUserDetails() {
        return "New DB in action";
    }
}
