package com.vodadfone.Api.task;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;


public class Booking {

   public static String BookDataPath = "Resources/BookData.json";

    public static Response  CreatBook(String token) throws IOException {

        
        int id = Booking.postBook(token) ;
        Response res =  Booking.GetBook(id ,token) ;
        return res ;

    }

        public static int postBook(String token) throws IOException {

        // Read Book Data  from BookData.json file at Resources Folder
        File bookData = new File(BookDataPath);

        // Step 1 : Create a book
        Response response = given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .body(bookData)
                .when()
                .post("/booking")
                .then()
                .log().all() 
                .statusCode(200) 
                .extract()
                .response();
        //  Extract the booking ID from the response
        int id = response.jsonPath().getInt("bookingid");
        return id;
    }

    public  static Response  GetBook( int id , String token) {

        // Step 2 : Fetch the booking data by booking ID
        Response response = given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .when()
                .get("/booking/" + id)
                .then()
                .log().all() 
                .statusCode(200) 
                .extract()
                .response();

        return response ;

    }



    public static JSONObject getExpectadAsJson() throws FileNotFoundException {

        // Load expected data from the JSON file
        JSONObject expectedJson = new JSONObject(new JSONTokener(new FileInputStream(BookDataPath)));
        System.out.println(expectedJson);
        return expectedJson ;
    }

    public static JSONObject getActualdAsJson(Response  response ) {

        // Extract the response body as a JSONObject
        JSONObject actualJson = new JSONObject(response.getBody().asString());
        System.out.println(actualJson);

        return actualJson ;
    }


}
