package com.demoqa.baseapi.endpoints;

import java.util.Properties;
import static io.restassured.RestAssured.*;

import com.demoqa.base.BaseClass;
import com.demoqa.baseapi.payload.User;
import com.demoqa.baseapi.payload.UserBook;
import com.demoqa.baseapi.payload.UserBooks;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BooksEndPoints extends BaseClass{
    private static Properties prop = BaseClass.initProperties("routes");

    public static Response getBooks(){
        String get_books_url = prop.getProperty("get_books_url");
        Response response =
            RestAssured.given()
                .accept(ContentType.JSON)
                //.log().all()
            .when()
                .get(get_books_url);
            return response;
    }

    public static Response postBooks(User payload,UserBooks booksPayload,String token){
        String post_books_url = prop.getProperty("post_books_url");
        Response response =
            RestAssured.given()
                .accept(ContentType.JSON)
                .contentType("application/json")
                .header("Authorization","Bearer "+token)
                .auth().basic(payload.getUserName(), payload.getPassword())
                .body(booksPayload)
                //.log().all()
            .when()
                .post(post_books_url);
            return response;
    }

    public static Response deleteBooks(User payload,String token,String id){
       String delete_books_url = prop.getProperty("delete_books_url");
       Response response =
           RestAssured.given()
               .accept(ContentType.JSON)
               .header("Authorization","Bearer "+token)
               .auth().basic(payload.getUserName(), payload.getPassword())
               .queryParam("UserId",id)
               //.log().all()
           .when()
               .delete(delete_books_url);
           return response;
   }

   public static Response getBook(String isbn){
   String get_book_url = prop.getProperty("get_book_url");
   Response response =
       RestAssured.given()
           .accept(ContentType.JSON)
           .queryParam("ISBN",isbn)
           //.log().all()
       .when()
           .get(get_book_url);
       return response;
}

public static Response deleteBook(User payload,UserBook bookPayload, String token){
       String delete_book_url = prop.getProperty("delete_book_url");
       Response response =
           RestAssured.given()
               .accept(ContentType.JSON)
               .contentType("application/json")
               .header("Authorization","Bearer "+token)
               .auth().basic(payload.getUserName(), payload.getPassword())
               .body(bookPayload)
               //.log().all()
           .when()
               .delete(delete_book_url);
           return response;
   }

   public static Response putBook(User payload,UserBook bookPayload, String token,String isbn){
       String put_books_url = prop.getProperty("put_books_url");
       Response response =
           RestAssured.given()
               .accept(ContentType.JSON)
               .contentType("application/json")
               .header("Authorization","Bearer "+token)
               .auth().basic(payload.getUserName(), payload.getPassword())
               .pathParam("ISBN",isbn)
               .body(bookPayload)
               //.log().all()
           .when()
               .put(put_books_url);
           return response;
   }  
}
