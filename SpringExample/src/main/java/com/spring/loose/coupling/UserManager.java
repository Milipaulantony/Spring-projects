package com.spring.loose.coupling;


public class UserManager {
    private UserDataProvider udp_interface_obj;

    public UserManager(UserDataProvider udp_interface_obj) {
        this.udp_interface_obj = udp_interface_obj;
    }

    public String getUserInfo(){
        return udp_interface_obj.getUserDetails();
    }
}
