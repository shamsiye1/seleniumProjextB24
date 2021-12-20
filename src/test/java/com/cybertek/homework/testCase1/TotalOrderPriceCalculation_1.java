package com.cybertek.homework.testCase1;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TotalOrderPriceCalculation_1 {
    String url = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
    WebDriver driver;


    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(url);
    }

    @Test
    public void loginFunctionality() throws InterruptedException {

        //  <input name="ctl00$MainContent$username" type="text" id="ctl00_MainContent_username" class="txt" style="width:142px">
        WebElement userNameInput = driver.findElement(By.name("ctl00$MainContent$username"));
        userNameInput.sendKeys("Tester");

        //<input name="ctl00$MainContent$password" type="password" id="ctl00_MainContent_password" class="txt" style="width:142px">
        WebElement passwordInput = driver.findElement(By.name("ctl00$MainContent$password"));
        passwordInput.sendKeys("test");

        Thread.sleep(2);
        // <input type="submit" name="ctl00$MainContent$login_button" value="Login" id="ctl00_MainContent_login_button" class="button">
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();

        WebElement orderButton = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        orderButton.click();

        Select myMoneyOption = new Select(driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        // myMoneyOption.selectByVisibleText("MyMoney");

        Assert.assertEquals(myMoneyOption.getFirstSelectedOption().getText(), "MyMoney", "default selected option is not a myMoney");

        myMoneyOption.selectByVisibleText("FamilyAlbum");
        Thread.sleep(2000);
        WebElement quantityNumber = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
        quantityNumber.clear();
        Thread.sleep(2000);
        int quantity = 2;
        quantityNumber.sendKeys("" + quantity);
        Thread.sleep(2000);
        WebElement calculateButton = driver.findElement(By.xpath("//input[@onclick='productsChanged(); return false;']"));
        calculateButton.click();
        Thread.sleep(5000);
        WebElement totalPrice = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal"));

        WebElement perUnitPrice = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice"));


        // int quantity = Integer.parseInt(quantityNumber.getText());
        int perUnitPriceNum = Integer.parseInt(perUnitPrice.getAttribute("value"));
        int totalNumber = Integer.parseInt(totalPrice.getAttribute("value"));

        System.out.println("quantity: " + quantity);
        System.out.println("per unit price: " + perUnitPriceNum);
        System.out.println("total price: " + totalNumber);
        Assert.assertEquals(totalNumber, quantity * perUnitPriceNum, "multiple does not currect");


    }


    @AfterClass
    public void tearDown() {
        //  driver.quit();
    }
}
