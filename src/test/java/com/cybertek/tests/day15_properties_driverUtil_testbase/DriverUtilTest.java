package com.cybertek.tests.day15_properties_driverUtil_testbase;

import com.cybertek.utils.Driver;
import org.testng.annotations.Test;

public class DriverUtilTest {

    @Test
    public void driverClassTest(){

        Driver.getDriver().get("https://www.google.com");
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().get("https://www.sephora.com");
        Driver.getDriver().get("https://www.etsy.com");

    }


}
