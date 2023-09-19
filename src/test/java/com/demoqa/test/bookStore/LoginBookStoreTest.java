package com.demoqa.test.bookStore;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.api.endpoints.BookStoreEndPoints;
import com.demoqa.api.payload.User;
import com.demoqa.base.BaseTest;
import com.demoqa.pages.bookStore.BookStorePage;

import io.restassured.response.Response;

public class LoginBookStoreTest extends BaseTest{
    User user;

    @Test(priority = 1)
    public void login(){
        user= new User();
        user.setUserName("test");
        user.setPassword("Az25288@");
        Response response=BookStoreEndPoints.loginUserBookStore(user);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 2)
    public void deleteUser(){
        BookStorePage bookStore= new BookStorePage();
        bookStore.goToo();
    }


}
