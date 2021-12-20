package com.cybertek.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    // WebDriverFactory class:
    //  is used to create WebDriver(Selenium) object and return it. it will open the browser and maximize it
    // method: getDriver(String browserType)
    // it will check browser type and returns object:
    // if browserType is "chrome" it will set up chrome driver, and return new chromedriver.

    public static WebDriver getDriver(String browserType){
        if (browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if (browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else{
            System.out.println("Invalid BrowserType= "+ browserType);
            return null; // null means no object;
        }



    }

}
