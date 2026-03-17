package org.example.Junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginServiceTest {

    LoginService loginService = new LoginService();

    @Test
    void sanityTest_LoginWithValidCredentials() {

        boolean result = loginService.login("admin", "password123");

        assertTrue(result, "Login should succeed with valid credentials");
    }
}
