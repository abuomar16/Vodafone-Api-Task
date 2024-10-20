package com.vodadfone.Api.tests;

import com.vodadfone.Api.task.Booking;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.Test;

import java.io.IOException;

public class BookingTest {


    @Test(dependsOnMethods = "com.vodadfone.Api.tests.LoginTest.Login")
    public static void Booking() throws IOException {

        Response res = Booking.CreatBook(LoginTest.token);
        JSONObject Expected = Booking.getExpectadAsJson() ;
        JSONObject Actual = Booking.getActualdAsJson(res) ;
        // Compare the two JSON objects
        JSONAssert.assertEquals(Expected, Actual, true);
    }



}
