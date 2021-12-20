package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC5_SmartBearLoginTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        String expTitle = "Web Orders Login";
        String userName = "Tester";
        String password = "test";

        if (driver.getTitle().equals(expTitle)) {
            System.out.println("Test PASS");
        } else {
            System.out.println("Test FAILED!!");
        }
        //use NAME to locate the element
        //driver.findElement(By.name("ctl00$MainContent$username")).sendKeys(userName);

        // use ID to locate the element
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(userName);

        Thread.sleep(2000);
//        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys(password+ Keys.ENTER);

        // use NAME to locate the element
        // driver.findElement(By.name("ctl00$MainContent$password")).sendKeys(password);

        // use ID to locate the element
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);

        // use NAME to locate the element
        //   driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        // use ID to locate the element
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        String expLoginTitle = "Web Orders";

        if (driver.getTitle().equals(expLoginTitle)) {
            System.out.println(driver.getTitle() + " means: " + "Login page title Passed!");
        } else {
            System.out.println("Login page title FAILED!!");
        }

        Thread.sleep(2000);

        driver.findElement(By.partialLinkText("Log")).click();


        Thread.sleep(2000);
        driver.quit();


    }
}
