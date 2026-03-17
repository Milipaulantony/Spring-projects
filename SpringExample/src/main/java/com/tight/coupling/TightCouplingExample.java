package com.tight.coupling;

public class TightCouplingExample {
    public static void main(String[] args) {
        UserManager usermgr = new UserManager();
        System.out.println(usermgr.getUserInfo());
    }
}
