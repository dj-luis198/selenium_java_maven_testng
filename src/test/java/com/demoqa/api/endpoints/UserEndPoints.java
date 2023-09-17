package com.demoqa.api.endpoints;

import static io.restassured.RestAssured.*;
import java.util.Properties;
import com.demoqa.api.payload.User;
import com.demoqa.base.BaseClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints extends BaseClass{
    private static Properties prop = new Properties();
    

    public static Response postUser(User payload){
        prop = BaseClass.init_properties("routes");
        String post_url = prop.getProperty("post_url");
        Response response =
            given()
                //.accept(ContentType.JSON)
                .contentType("application/json")
                .body(payload).log().all()
            .when()
                .post(post_url);
            return response;
    }

    public static Response tokenUser(User payload){
        prop = BaseClass.init_properties("routes");
        String token_url = prop.getProperty("token_url");
        Response response =
            given()
                .accept(ContentType.JSON)
                .header("Content-type","application/json")
                .body(payload).log().all()
            .when()
                .post(token_url);
            return response;
    }

    public static Response authorizedUser(User payload,String token){
         prop = BaseClass.init_properties("routes");
        String authorized_url = prop.getProperty("authorized_url");
        Response response =
            given()
                .accept(ContentType.JSON)
                .header("Content-type","application/json")
                .header("Authorization","Bearer "+token)
                .body(payload).log().all()
            .when()
                .post(authorized_url);
            return response;
    }

    public static Response getUser(User payload,String token,String id){
         prop = BaseClass.init_properties("routes");
        String get_url = prop.getProperty("get_url");
        Response response =
            given()
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .auth().basic(payload.getUserName(), payload.getPassword())
                .pathParam("UUID", id).log().all()
            .when()
                .get(get_url);
            return response;
    }

    public static Response deleteUser(User payload,String token,String id){
         prop = BaseClass.init_properties("routes");
        String delete_url = prop.getProperty("delete_url");
        Response response =
            given()
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .auth().basic(payload.getUserName(), payload.getPassword())
                .pathParam("UUID", id).log().all()
            .when()
                .delete(delete_url);
            return response;
    }

    
}
