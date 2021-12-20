package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_ForgotPassword_xpath_css {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/forgot_password");

//        <a class="nav-link" href="/">Home</a>
        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        System.out.println(homeLink.getText() + " is displayed: " + homeLink.isDisplayed());
//
//        //<h2>Forgot Password</h2>
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        System.out.println(forgotPasswordHeader.getText() + " is displayed: " + forgotPasswordHeader.isDisplayed());

//      <label for="email">E-mail</label>
        WebElement emailText = driver.findElement(By.xpath("//label[.='E-mail']"));

        System.out.println(emailText.getText() + " is display: " + emailText.isDisplayed());
        //<input type="text" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required="">
        WebElement emailInputBox = driver.findElement(By.xpath("//input[@pattern='[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$']"));
        System.out.println(emailInputBox.getText() + " is dislpayed: " + emailInputBox.isDisplayed());

        //<i class="icon-2x icon-signin">Retrieve password</i>
        WebElement passwordButton = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
        System.out.println(passwordButton.getText() + "is displayed: " + passwordButton.isDisplayed());
        System.out.println(passwordButton.getText());

        // <div style="text-align: center;">Powered by <a target="_blank" href="https://cybertekschool.com/">Cybertek School</a></div>
        WebElement poweredByText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        System.out.println(poweredByText.getText() + " is displayed: " + poweredByText.isDisplayed());


        Thread.sleep(5000);
        driver.quit();
    }
}
