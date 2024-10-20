package com.vodadfone.Api.tests;

import com.vodadfone.Api.task.Validation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VaildationTest {


    @Test
    public static void Validation(){

        int size = Validation.checkIdsNumber() ;
        Assert.assertTrue(size > 0 );

    }
}
