package com.loose.coupling;


public class UserManager {
    //reference variable of the interface
    private UserDataProvider udp_interface_obj;

    //Dependency injection externally
    public UserManager(UserDataProvider udp_interface_obj) {
        this.udp_interface_obj = udp_interface_obj;
    }

    public String getUserInfo(){
        return udp_interface_obj.getUserDetails();
    }
}
