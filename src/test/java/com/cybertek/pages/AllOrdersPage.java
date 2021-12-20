package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllOrdersPage extends SmartBearDashBoardPage{

//    *** Homework for later
//    create POM pages for allProducts and Order page
//    Homework 2
//    Go to http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//    Login: credentials(Tester and test)
//    Navigate to Orders link, then navigate back to AllOrders link
//    click on one checkBox for "Charles Dodgeson"
//    then click deleteButton
//    then logout from the page





   // this is child class don't need to create constructor
    // constructor is not inherited, however, child class has to small parent class constructor

    @FindBy (id = "ctl00_MainContent_btnDelete")
    public WebElement deleteSelector;

    // go to other links in the all order page. don't need to create getLink method

    public void selectCheckbox(String name){
// //td[.='Charles Dodgeson']/..//input[@type='checkbox']

        Driver.getDriver().findElement(By.xpath("//td[.='"+name+"']/..//input[@type='checkbox']")).click();


    }



}
