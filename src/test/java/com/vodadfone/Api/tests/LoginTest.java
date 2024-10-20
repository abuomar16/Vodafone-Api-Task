package com.vodadfone.Api.tests;

import com.vodadfone.Api.task.Login;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

public class LoginTest {

    public static String token;

    @Test
    public static void Login(){

        Response res  = Login.testLoginWithAuth() ;

        // Verifying that if Body exists and Not equel Null
        res.then().assertThat().body(not(isEmptyOrNullString())) ;
        // Verifying that if Token is Exist in Body and Not equel Null
        res.then().assertThat().body("token" ,not(isEmptyOrNullString())) ;

        //get Token and save it to use later
        token = res.jsonPath().getString("token");
        System.out.println(token);
    }
}
