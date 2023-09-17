package com.demoqa.api.test.booktest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.api.endpoints.BooksEndPoints;

import io.restassured.response.Response;

public class GetBooks {

    @Test
    public void getBooks() {
        Response response = BooksEndPoints.getBooks();
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
    }
    
}
