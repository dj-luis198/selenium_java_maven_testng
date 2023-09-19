package com.demoqa.api.test.booktest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.api.endpoints.BooksEndPoints;
import com.demoqa.util.dataProvider.apiData;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.response.Response;

public class GetBook {

    @Test(dataProvider = "bookUserSimplecol5Data", dataProviderClass = apiData.class)
    public void getBook(String book) {
        Response response = BooksEndPoints.getBook(book);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("BookSchema.json"));
    }
}
