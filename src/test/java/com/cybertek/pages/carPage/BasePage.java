package com.cybertek.pages.carPage;


import com.cybertek.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// this is parent class for all page object classes
public abstract class BasePage {

    // WebDriver variable just in case any of children need
    protected WebDriver driver;

    @FindBy(xpath = "//img[@alt='Home']")
    public WebElement edmundsLogo;

    @FindBy(xpath = "//span[.=' Car Pricing']")
    public WebElement newCarPricingLink;

    public BasePage() {

        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
        //  isCurrentPage();

    }

    public void gotoNewCarPricingPge() {
        newCarPricingLink.click();
    }

    /**
     * abstract method to be implemented by child page object classes
     * this is to verify that we are at correct  page
     * using titile of the page or anything other
     */
    public abstract void isCurrentPage();  // abstraction just had method signature no body.

}
