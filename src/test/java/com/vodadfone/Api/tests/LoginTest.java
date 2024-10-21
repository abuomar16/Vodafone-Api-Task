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

        
        res.then().assertThat().body(not(isEmptyOrNullString())) ;
        res.then().assertThat().body("token" ,not(isEmptyOrNullString())) ;

        token = res.jsonPath().getString("token");
        System.out.println(token);
    }
}
