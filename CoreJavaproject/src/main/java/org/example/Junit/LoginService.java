package org.example.Junit;

public class LoginService {

    public boolean login(String username, String password) {

        if(username == null || password == null) {
            return false;
        }

        if(username.equals("admin") && password.equals("password123")) {
            return true;
        }

        return false;
    }
}
