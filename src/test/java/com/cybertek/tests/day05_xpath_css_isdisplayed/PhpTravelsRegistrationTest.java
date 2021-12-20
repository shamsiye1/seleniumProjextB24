package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class PhpTravelsRegistrationTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/");

//   <a href="https://www.phptravels.net/signup" class="theme-btn theme-btn-small waves-effect">Signup</a>
        WebElement signUp= driver.findElement(By.xpath("//a[@class='theme-btn theme-btn-small waves-effect']"));
        signUp.click();

        //<input class="form-control" type="text" placeholder="First Name" name="first_name" value="" required="">
       WebElement firstName= driver.findElement(By.xpath("//input[@placeholder='First Name']"));
       firstName.sendKeys("zilnaz");


        //<input class="form-control" type="text" placeholder="Last Name" name="last_name" value="" required="">
        WebElement lastName= driver.findElement(By.name("last_name"));
        lastName.sendKeys("muradel");

        //<input class="form-control" type="text" placeholder="Phone" name="phone" value="" required="">
        WebElement phoneNum= driver.findElement(By.xpath("//input[@placeholder='Phone']"));
        phoneNum.sendKeys("555844524898");

        //<input class="form-control" type="text" placeholder="Email" name="email" value="" required="">
        WebElement email= driver.findElement(By.xpath("//input[@placeholder='Email']"));
        String email2 = "zilnazim"+ new Random().nextInt()+ "@google.com";
        email.sendKeys(email2);
        // <input class="form-control" type="password" placeholder="Password" name="password" value="" required="">
        WebElement password= driver.findElement(By.xpath("//input[@placeholder='Password']"));
       password.sendKeys("4566587"+ Keys.ENTER);

       String expTitle= "Login - PHPTRAVELS";
       String actTitle= driver.getTitle();
       if (actTitle.equalsIgnoreCase(expTitle)){
           System.out.println("verification passed");
       }else {
           System.out.println("FAILED!!!");
       }


       //<input class="form-control" type="email" placeholder="Email" required="required" name="email">
        WebElement loginEmail= driver.findElement(By.xpath("//input[@placeholder='Email']"));

       loginEmail.sendKeys(email2);

       //<input class="form-control" type="password" placeholder="Password" required="required" name="password">
        WebElement loginPassword= driver.findElement(By.xpath("//input[@placeholder='Password']"));
        loginPassword.sendKeys("4566587"+Keys.ENTER);

        //<button type="submit" class="btn btn-default btn-lg btn-block effect ladda-button waves-effect" data-style="zoom-in"><span class="ladda-label">Login</span><span class="ladda-spinner"></span></button>
//        WebElement loginBotton= driver.findElement(By.xpath("//button[@type='submit']"));
//        loginBotton.click();


//       <h2 class="sec__title font-size-30 text-white">Hi, <span style="text-transform:capitalize">zilnaz</span> Welcome Back</h2>
        String actWelcomeMSG= driver.findElement(By.xpath("//h2[@class='sec__title font-size-30 text-white']")).getText();
        System.out.println(actWelcomeMSG.contains("Zilnaz"));
        System.out.println(actWelcomeMSG);
        String firstNameConfirm="Zilnaz";
        Thread.sleep(3000);
        driver.navigate().refresh();

        if (actWelcomeMSG.contains(firstNameConfirm)){
            System.out.println(firstName +" is inclueded: "+firstName.isDisplayed());
        }else {
            System.out.println("verification failed");
        }




























































        Thread.sleep(5000);
        //driver.quit();

    }
}
