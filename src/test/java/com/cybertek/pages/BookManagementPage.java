package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BookManagementPage {

    public BookManagementPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(tagName = "h3")
  public WebElement bookMangtTitle;

    // method to verify if we are on correct page
    public void isCurrentPage(){
        Assert.assertEquals(Driver.getDriver().getTitle(),"Library");
    }



}
