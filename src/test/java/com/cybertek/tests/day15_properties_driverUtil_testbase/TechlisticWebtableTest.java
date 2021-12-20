package com.cybertek.tests.day15_properties_driverUtil_testbase;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TechlisticWebtableTest extends TestBase {

    @Test
    public void tallBuildingsTableTest() {
        // go to https://www.techlistic.com/p/demo-selenium-practice.html
        // assert current url contains "techlistic"
        // print all building names

        driver.get(ConfigurationReader.getProperty("tecchlistic.url"));

        List<WebElement> buildings = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr/th"));
        for (WebElement building : buildings) {
            System.out.println("Building name: " + building.getText());
        }

        // for find 4 buildings
        //     xpath       //table[@class='tsc_table_s13']//td[contains(text(),'buildings')]
        //     xpath      //table[@class='tsc_table_s13']/tfoot/tr/td


        WebElement total_Value = driver.findElement(By.xpath("//table[@class='tsc_table_s13']//td[contains(text(),'buildings')]"));

        String digitValue = "";
        char[] total_ValueArray = total_Value.getText().toCharArray();
        for (char each : total_ValueArray) {

            if (Character.isDigit(each)) {

                digitValue += each;

            }

        }
        Assert.assertEquals(Integer.parseInt(digitValue), buildings.size(), " length doesn't match");


    }

    @Test
    public void assignment2_printRowWise() {

        Driver.getDriver().get(ConfigurationReader.getProperty("tecchlistic.url"));

        List<WebElement> rowList = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr"));

        for (WebElement webElement : rowList) {

            System.out.println(webElement.getText());
        }
    }

    @Test
    public void assignment3_verifySingleValue() {

        Driver.getDriver().get(ConfigurationReader.getProperty("tecchlistic.url"));

        String expectedHeight = "829m";

        String actualHeight = getHeightByStrName("Burj Khalifa");

        Assert.assertEquals(actualHeight, expectedHeight, "height don't equal");

//        List<WebElement> structureList = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr/th"));
//
//        List<WebElement> heights = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr/td[3]"));
//
//        String structureName = "Burj Khalifa";
//        String height = "829m";
//        boolean result = false;
//        for (int i = 0; i < structureList.size(); i++) {
//
//            if (structureList.get(i).getText().equals(structureName) && heights.get(i).getText().equals(height)) {
//                result = true;
//                return;
//
//            }
//
//
//        }
//        Assert.assertTrue(result, "result doesn't match");

    }

    @Test
    public void assignent4_verifyLasRow() {

        Driver.getDriver().get(ConfigurationReader.getProperty("tecchlistic.url"));

        List<WebElement> LastRows = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tfoot/tr/*"));

        int expect = 2;
        Assert.assertEquals(LastRows.size(), expect, "last rows has more than 2 column");

    }


    public String getHeightByStrName(String strName) {
        String xpath = "//th[.='" + strName + "']//..//td[3]";
        return driver.findElement(By.xpath(xpath)).getText();
    }


}
