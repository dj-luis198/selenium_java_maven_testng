package com.demoqa.api.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.api.endpoints.UserEndPoints;
import com.demoqa.api.payload.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
//import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

public class UserTest {

    User user;
    String id="02534a00-1a61-42d1-8bb1-ec0ec53aba87";
    String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImRhbmllbDVmIiwicGFzc3dvcmQiOiJBejI1Mjg4QCIsImlhdCI6MTY5NTA5MjA3MH0.oUKlumVYoUEW6uw591gSfHdu01SDvGl452TB6I71cjg";
    //String id="652e22d7-67f5-419f-b58e-b2eae259170f";
    //String id="8caf9ee3-ea99-4e37-9942-9b34ae78b421";
    //String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRlc3QiLCJwYXNzd29yZCI6IkF6MjUyODhAIiwiaWF0IjoxNjk1MDU5ODg0fQ.1rR4TaxSzi_0NQScLcPP0rUcoCDBVgr53TGuSwVNNWs";
    //String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImRhbmllbDVmIiwicGFzc3dvcmQiOiJBejI1Mjg4QCIsImlhdCI6MTY5NTA3ODIzMn0.gVB9liYGemPbJ7PxmYwU5yyWYsa5JDtgot4HeLFXtOA";
    @Test(priority = 1)
    public void createUser() throws JsonProcessingException{
        user= new User();
        user.setUserName("daniel5f");
        //user.setUserName("test");
        user.setPassword("Az25288@");
        Response response= UserEndPoints.postUser(user);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),201);
        id=response.jsonPath().get("userID");
    }

    @Test(priority = 2)
    public void getTokenUser(){
        user= new User();
        user.setUserName("daniel5f");
        //user.setUserName("test");
        user.setPassword("Az25288@");
        
        Response response= UserEndPoints.tokenUser(user);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),200);
        token=response.jsonPath().get("token");
    }

    @Test(priority = 3)
    public void authUser(){
       user= new User();
       user.setUserName("daniel5f");
        //user.setUserName("test");
        user.setPassword("Az25288@");
        
        Response response= UserEndPoints.authorizedUser(user,token);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(priority = 4)
    public void getUser(){
        user= new User();
        user.setUserName("daniel5f");
        //user.setUserName("test");
        user.setPassword("Az25288@");
        
        Response response= UserEndPoints.getUser(user,token,id);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),200);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("schemas\\FUserSchema.json"));
        Assert.assertEquals(response.body().jsonPath().get("username"), user.getUserName());
        Assert.assertEquals(response.body().jsonPath().get("userId"), id);
        Assert.assertEquals(response.body().jsonPath().get("books").toString(),"[]");
    }

    @Test(priority = 5)
    public void deleteUser(){
       user= new User();
       user.setUserName("daniel5f");
        //user.setUserName("test");
        user.setPassword("Az25288@");
        
        Response response= UserEndPoints.deleteUser(user,token,id);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),204);
    }
    
}
