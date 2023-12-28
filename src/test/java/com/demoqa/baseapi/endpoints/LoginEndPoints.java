package com.demoqa.baseapi.endpoints;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.Cookie;

import com.demoqa.base.BaseClass;
import com.demoqa.baseapi.payload.User;
import com.google.gson.Gson;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class LoginEndPoints extends BaseClass{
private static Properties prop = new Properties();
static Set<Cookie> driverCookies;

// forma en qu se obtienen datos necesarios y se crean cookies necesarias para acceder
// las cookies se guardan en una variable y pueden usarse para iniciar secion sin logear por GUI

    public void postLogin(User payload){
        Gson gson= new Gson();
        String bodyJson= gson.toJson(payload);
            prop = BaseClass.initProperties("routes");
            String post_login_url = prop.getProperty("post_login_url");
            Response response = 
                given()
                    .contentType("application/json")
                    .body(bodyJson).log().all()
                .when()
                    .post(post_login_url);
                    response.then().log().all();

                    String id= response.jsonPath().get("userId");
                    Cookie idc= new Cookie("userID",id);
                    String name= response.jsonPath().get("username");
                    Cookie userNamec= new Cookie("userName",name);
                    String token= response.jsonPath().get("token");
                    Cookie tokenc= new Cookie("token",token);
                    String expires= response.jsonPath().get("expires");
                    Cookie expiresc= new Cookie("expires",expires);
                    getDriver().manage().addCookie(idc);
                    getDriver().manage().addCookie(userNamec);
                    getDriver().manage().addCookie(tokenc);
                    getDriver().manage().addCookie(expiresc);
                    driverCookies= getDriver().manage().getCookies();
                    refreshPage();
    }

    public void refreshPage(){
        getDriver().get("https://demoqa.com/profile");
    }

    public void goToLoginPage(){
        getDriver().manage().deleteAllCookies();
        getDriver().get("https://demoqa.com/login");
    }
}
