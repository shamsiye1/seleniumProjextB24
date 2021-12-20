package com.cybertek.homework;

import com.cybertek.tests.day14_webtables_properties.SmartBearTestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.SmartBearUtils;
import com.cybertek.utils.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBear_Tasks_1_2 {

    WebDriver driver;
    String url = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

    }

    @Test
    public void smartBearSoftwareLinkVerification_Test1() {
        // SmartBearUtils.loginToSmartBear(driver);
        WebElement username = driver.findElement(By.name("ctl00$MainContent$username"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.name("ctl00$MainContent$password"));
        password.sendKeys("test" + Keys.ENTER);

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        System.out.println(allLinks.size());

        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText());

        }


    }

    @Test
    public void smartBearSoftwareOrderPlacing_Test2() {


        SmartBearUtils.loginToSmartBear(driver);

        WebElement orderBtn = driver.findElement(By.linkText("Order"));
        orderBtn.click();

        Select familyAlbum = new Select(driver.findElement(By.name("ctl00$MainContent$fmwOrder$ddlProduct")));
        familyAlbum.selectByVisibleText("FamilyAlbum");
        BrowserUtils.sleep(1);
        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.clear();
        BrowserUtils.sleep(1);

        quantity.sendKeys("2");

        WebElement calculateBtn = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateBtn.click();

        Faker faker = new Faker();

        WebElement name = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName"));
        name.sendKeys(faker.name().fullName());

        WebElement street = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2"));
        street.sendKeys(faker.address().streetName());

        WebElement city = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3"));
        city.sendKeys(faker.address().city());

        WebElement state = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4"));
        state.sendKeys(faker.address().state());

        WebElement zipcode = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5"));
        zipcode.sendKeys(faker.address().zipCode().replace("-", ""));

        BrowserUtils.sleep(1);
        WebElement visaBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
        visaBtn.click();

        WebElement cardNumber = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6"));
        cardNumber.sendKeys(faker.finance().creditCard().replace("-", ""));

        WebElement expireDate = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1"));
        expireDate.sendKeys("12/21");

        WebElement processBtn = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processBtn.click();
        BrowserUtils.sleep(1);

        WebElement confirmText = driver.findElement(By.tagName("strong"));

        Assert.assertEquals(confirmText.getText(), "New order has been successfully added.", "text doesn't match");


    }

    @Test
    public void orderVerification_Test3() {

        SmartBearUtils.loginToSmartBear(driver);

//        List<WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[2]"));
//        List<WebElement> orderDate = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[5]"));

        String name = "Susan McLaren";
        String actualDate = getOrderDateByName(name);
        String expDate = "01/05/2010";

        Assert.assertEquals(actualDate, expDate,"text with date isn't matched");


    }

    public String getOrderDateByName(String name){

        String orderXpath = "//td[.='"+name+"']//..//td[5]";
        return driver.findElement(By.xpath(orderXpath)).getText();

    }


    @Test
    public void verifyOrder_Test4() {

        SmartBearUtils.loginToSmartBear(driver);
        SmartBearUtils.verifyOrder(driver, "Bobi");


    }

    @Test
    public void printNamesAndCities_Test5() {

        SmartBearUtils.loginToSmartBear(driver);
        SmartBearUtils.printNamesAndCities(driver);

    }

}
