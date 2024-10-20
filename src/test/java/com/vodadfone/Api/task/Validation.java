package com.vodadfone.Api.task;

import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Validation {


    public static int checkIdsNumber(){

        Response res =
                given()
                        .baseUri("https://restful-booker.herokuapp.com")
                        .when()
                        .get("/booking")
                        .then()
                        .statusCode(200) // Verify that the response status is 200 OK
                        .extract()
                        .response();

        List<Integer> bookingIds = res.jsonPath().getList("bookingid");
        System.out.println(bookingIds);


        return bookingIds.size() ;


    }
}
