package com.demoqa.test.bookStoreHybridGuiApi;

import java.time.Duration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.demoqa.api.endpoints.LoginEndPoints;
import com.demoqa.api.payload.User;
import com.demoqa.base.BaseTest;

public class BookStoreCookies1 extends BaseTest {

    @BeforeClass
    public void preconditions() {
        User userLogin = new User();
        userLogin.setUserName("login");
        userLogin.setPassword("Az25288@");
        LoginEndPoints.postLogin(userLogin);
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
