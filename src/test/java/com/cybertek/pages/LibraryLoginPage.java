package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {

    public LibraryLoginPage() {
       /** // when we write page object classes, we always need to add a constructor  // in the constructor, we add a command to initialize all the elements.


        // Selenium command to initialize the elements below
        // pageFactory ==> it is a class that comes from Selenium library. this class is used while implement POM pattern
        // It helps with initializing all the webElements that are added to the class.

        // if we don't add PageFactory to our constructor, then we will get NullPointerException.

        // it has a method */
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement email;  // <===  email = driver.findElement(By.id("email"));

    @FindBy(id = "inputPassword")
    public WebElement password;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInBtn;

    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement errorMsg;


}
