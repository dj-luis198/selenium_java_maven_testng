package com.demoqa.test.api.booktest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.baseapi.endpoints.BooksEndPoints;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.response.Response;

@Test(groups = "API")
public class GetBooks {

    @Test
    public void getBooks() {
        Response response = BooksEndPoints.getBooks();
        //response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("BooksSchema.json"));
    }
}
