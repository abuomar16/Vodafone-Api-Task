package com.vodadfone.Api.task;
import static io.restassured.RestAssured.*;
import java.io.File;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Login {

    public static String token;
    public static int id;

    @Test
    public static Response testLoginWithAuth() {

        // Read credentials from credentials.json file at  Resources Folder
        String credentialsFilePath ="Resources/credentials.json" ;
        File credentials = new File(credentialsFilePath);

        // extract Response
        Response response = given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON)
                .body(credentials)
                .when()
                .post("/auth")
                .then()
                .log().all()
                .extract().response();
        return response  ;
    }
}
