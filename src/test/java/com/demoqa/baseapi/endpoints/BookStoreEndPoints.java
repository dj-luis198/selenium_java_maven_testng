package com.demoqa.baseapi.endpoints;

import static io.restassured.RestAssured.*;
import java.util.Properties;

import com.demoqa.base.BaseClass;
import com.demoqa.baseapi.payload.User;

import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BookStoreEndPoints extends BaseClass{
    private static Properties prop = new Properties();
    static SessionFilter sessionFilter = new SessionFilter();

    public static Response loginUserBookStore(User user){
       Response response=given()
        .accept(ContentType.JSON)
        .contentType("application/json")
        .body(user)
       .when()
        .post("https://demoqa.com/Account/v1/Login");
        return response;
    } 

    public static Response getBooksStore(String id){
            prop = init_properties("routes");
           String delete_url = prop.getProperty("delete_url");
           Response response =
               given()
                .filter(sessionFilter)
                .accept(ContentType.JSON)
                .pathParam("UUID", id).log().all()
               .when()
                   .delete(delete_url);
               return response;
       }
    } 

