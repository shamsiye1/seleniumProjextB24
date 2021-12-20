package com.cybertek.pages;

import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class SmartBearDashBoardPage {


    public SmartBearDashBoardPage(){  // 1. create constructor  <== page object model design pattern
                               // singleton design pattern
        PageFactory.initElements(Driver.getDriver(), this);


    }

    public void getLink(String link){
        Driver.getDriver().findElement(By.partialLinkText(link)).click();

    }




}
