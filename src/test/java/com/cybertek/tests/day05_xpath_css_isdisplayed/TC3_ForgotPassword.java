package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_ForgotPassword {
    public static void main(String[] args) throws InterruptedException {

//        1. Open Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

//        3. Enter any email into input box
//        4. Click on Retrieve password
        driver.findElement(By.name("email")).sendKeys("begaxe1399@epeva.com" + Keys.ENTER);

//        5. Verify URL contains:
//        Expected: “email_sent”

        String expUrl = "email_sent";
        String actUrl = driver.getCurrentUrl();
        System.out.println(actUrl);

        if (actUrl.contains(expUrl)) {
            System.out.println("Verification successful");
        } else {
            System.out.println("FAILED!!!");
        }

//        6. Verify textBox displayed the content as expected.
//                Expected: “Your e-mail’s been sent!”
        String actText = driver.findElement(By.tagName("h4")).getText();
        String expText = "Your e-mail's been sent!";

        if (actText.contains(expText)) {
            System.out.println("PASS: message displayed correctly");
        } else {
            System.out.println("FAIL: message is not displayed as expected");
        }

        System.out.println("Name attribute value of message element= " + driver.findElement(By.tagName("h4")).getAttribute("name"));

        Thread.sleep(5000);
        //  driver.close();


    }
}
