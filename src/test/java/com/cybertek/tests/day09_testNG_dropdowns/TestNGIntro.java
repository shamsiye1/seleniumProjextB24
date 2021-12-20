package com.cybertek.tests.day09_testNG_dropdowns;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGIntro {
    // can be used by each test
    String url = "https://www.etsy.com";

    @BeforeClass
    public void setUp() {
        System.out.println("@BeforeClass setUp method....");
        System.out.println("Opened browser and navigating to " + url);
        System.out.println("=============================================");
    }

    @BeforeMethod
    public void setUpApp() {

        System.out.println("@BeforeMethod setUpApp method is running.....");
        System.out.println("Navigating back to " + url);
        System.out.println("============================================");
    }


    @Test(priority = 1)
    public void test1() {
        System.out.println("running test1.....");
        Assert.assertEquals(10, 10, "two number not equal");
        int num = 15;
        Assert.assertEquals(15, num, "two number isn't equal");


    }

    @Test(priority = 2) // if we use priority keyword, it can re do the order
    public void myTest2() {

        System.out.println("Running my test 2...");

        String name = "bob";
        Assert.assertTrue(name.contains("o"));

    }

    @AfterMethod // runs after every test
    public void tearDown() {
        System.out.println("@AfterMethod tearDown is running ...");
        System.out.println("=================================================");
    }

    public void cleanUp() {
        System.out.println("@AfterClass cleanUp method is running....");
        System.out.println("==========================================");
    }


}
