package com.cybertek.tests.day14_webtables_properties;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTableDemoTest {

    WebDriver driver;
    String url = "http://practice.cybertekschool.com/tables";

    @BeforeMethod
    public void setUp() {


        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

    }

    @Test
    public void readFromTableTest() {

        //print table data s a single string not so common, but useful sometimes
        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println("Table 1 text: " + table1.getText());

        // verify tconway@earthilink.net is anywhere in the table
        Assert.assertTrue(table1.getText().contains("tconway@earthlink.net"));

        // print all column names in single line
        WebElement allColNames = driver.findElement(By.xpath("//table[@id='table1']/thead/tr"));
        System.out.println("allColNames = " + allColNames.getText());

        // print each column name in separate lines using a loop and findElements method
        List<WebElement> firstRows = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        System.out.println("Columns count: " + firstRows.size());

        for (WebElement each : firstRows) {
            System.out.println(each.getText());
        }

        // print first col + fist cell data
        WebElement firstCol = driver.findElement(By.xpath("//table[@id='table2']/tbody/tr[1]/td[1]"));
        System.out.println(firstCol.getText());

        System.out.println("col 1, row 4 = "+getCelData(1,4));
        System.out.println("col 3, row 3: "+getCelData(3,3));

    }

    public String getCelData(int row, int col){

        String xpathStr = "//table[@id='table2']/tbody/tr["+row+"]/td["+col+"]";
        return driver.findElement(By.xpath(xpathStr)).getText();

    }

    @Test
    public void getAllColumData(){

        //print all names
        //print all emails
        List<WebElement> names = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));

        List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));

        for (int i = 0; i < names.size(); i++){
            System.out.println(i+1 + " - "+names.get(i).getText() + " " + emails.get(i).getText());
        }




    }

    @Test
    public void printAllTableDataTest(){
        // get rows and assign to rowsCount variable and print it                 tr ==> all table rows
        int rowsCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        System.out.println("rowsCount = " + rowsCount);

        for (int rowNum = 1; rowNum < rowsCount; rowNum++){

            for (int columnNum = 1; columnNum <= 6; columnNum++){

             //   String value = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowNum+"]/td["+columnNum+"]")).getText();

                String value = getCelData(rowNum, columnNum);
                System.out.println("value: "+ value);
            }


        }

    }




}
