package com.cybertek.tests.day10_alerts_iframes_windows;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import all static methods/Variables of Assert class
import static org.testng.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDepartmentNamesListTest {
    WebDriver driver;
    String url = "https://www.amazon.ca/";

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void amazonDepartmentTest() throws InterruptedException {

        //assert Amazon home page is displayed

        String expTitle = "Amazon.ca: Low Prices – Fast Shipping – Millions of Items";
        assertEquals(driver.getTitle(), expTitle, "title wasn't match");

        //assert that "All" option is selected by default/automatically
        Select departments = new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));


        assertEquals(departments.getFirstSelectedOption().getText(), "All Departments", "All is not selected");

        // get All available options in dropdown and print out
        List<WebElement> allDepartments = departments.getOptions(); //getOptions() method can

        int countOfDepartments = allDepartments.size();

        System.out.println("countOfDepartments = " + countOfDepartments);

        assertEquals(countOfDepartments, 39, "cont number failed");
        assertTrue(countOfDepartments > 10, "options less than 10");

        System.out.println(allDepartments.get(5).getText());

        //loop and print all available options
        for (WebElement dept : allDepartments) {
            System.out.println(dept.getText());
        }
        System.out.println("========================================");
        allDepartments.forEach(dept -> System.out.println(dept.getText())); // this is the way that using lambda expression to get all options name

//        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
//        searchBox.sendKeys("modern study desk"+ Keys.ENTER);

        // select each item by order and wait 400 ms in between

        for (WebElement dept : allDepartments) {
            departments.selectByVisibleText(dept.getText());
            Thread.sleep(400);
        }


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
