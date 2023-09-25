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
    String id="e47a5785-5660-4a93-83ef-90668ea4a140";
    String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Im1hcmlvMzUiLCJwYXNzd29yZCI6Im1BcmlvdXVnQDMiLCJpYXQiOjE2OTU2MDg3MTF9.qTwwggqind3jMvgnYTfTwTGnwBOL89E3qpQquS2rCAo";
    //String id="652e22d7-67f5-419f-b58e-b2eae259170f";
    //String id="8caf9ee3-ea99-4e37-9942-9b34ae78b421";
    //String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRlc3QiLCJwYXNzd29yZCI6IkF6MjUyODhAIiwiaWF0IjoxNjk1MDU5ODg0fQ.1rR4TaxSzi_0NQScLcPP0rUcoCDBVgr53TGuSwVNNWs";
    //String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImRhbmllbDVmIiwicGFzc3dvcmQiOiJBejI1Mjg4QCIsImlhdCI6MTY5NTA3ODIzMn0.gVB9liYGemPbJ7PxmYwU5yyWYsa5JDtgot4HeLFXtOA";
    @Test(priority = 1)
    public void createUser() throws JsonProcessingException{
        user= new User();
        user.setUserName("mario35");
        //user.setUserName("test");
        user.setPassword("mAriouug@3");
        Response response= UserEndPoints.postUser(user);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),201);
        id=response.jsonPath().get("userID");
    }

    @Test(priority = 2)
    public void getTokenUser(){
        user= new User();
        user.setUserName("mario35");
        //user.setUserName("test");
        user.setPassword("mAriouug@3");
        
        Response response= UserEndPoints.tokenUser(user);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),200);
        token=response.jsonPath().get("token");
    }

    @Test(priority = 3)
    public void authUser(){
       user= new User();
       user.setUserName("mario35");
        //user.setUserName("test");
        user.setPassword("mAriouug@3");
        
        Response response= UserEndPoints.authorizedUser(user,token);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(priority = 4)
    public void getUser(){
        user= new User();
        user.setUserName("mario35");
        //user.setUserName("test");
        user.setPassword("mAriouug@3");
        
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
       user.setUserName("mario35");
        //user.setUserName("test");
        user.setPassword("mAriouug@3");
        
        Response response= UserEndPoints.deleteUser(user,token,id);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),204);
    }
    
}
