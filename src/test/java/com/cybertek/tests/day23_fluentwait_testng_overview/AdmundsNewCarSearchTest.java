package com.cybertek.tests.day23_fluentwait_testng_overview;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.testng.annotations.Test;

public class AdmundsNewCarSearchTest extends TestBase {


    @Test
    public void searchForNewCarTest(){

        driver.get(ConfigurationReader.getProperty("edmunds.url"));

    }



}
