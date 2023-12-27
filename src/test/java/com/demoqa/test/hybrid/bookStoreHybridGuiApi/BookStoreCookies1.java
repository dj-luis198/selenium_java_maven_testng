package com.demoqa.test.hybrid.bookStoreHybridGuiApi;

import java.time.Duration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.demoqa.baseapi.endpoints.LoginEndPoints;
import com.demoqa.baseapi.payload.User;
import com.demoqa.base.BaseTest;

public class BookStoreCookies1 extends BaseTest {

    @BeforeClass
    public void preconditions() {
        LoginEndPoints loginEndPoints = new LoginEndPoints();
        User userLogin = new User();
        userLogin.setUserName("login");
        userLogin.setPassword("Az25288@");
        loginEndPoints.postLogin(userLogin);
    }

    @Test
    public void cookies() {
        try {
            Thread.sleep(Duration.ofSeconds(15));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
