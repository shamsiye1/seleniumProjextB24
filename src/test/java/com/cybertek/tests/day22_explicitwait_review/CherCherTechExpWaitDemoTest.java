package com.cybertek.tests.day22_explicitwait_review;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CherCherTechExpWaitDemoTest extends TestBase {


    @BeforeMethod
    public void gotoHomePage(){ // all of the below test need to go home page first, so there has another beforeMethod , otherwise this step will repeat testNumber*n time;

        driver.get(ConfigurationReader.getProperty("chercher.url"));
    }

    @Test
    public void waitForButEnabledTest(){

        WebElement alertBtn = driver.findElement(By.xpath("//button[@id='alert']"));
        alertBtn.click();

        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(alertIsPresent());
      // Alert alert = driver.switchTo().alert();
      // alert.accept();
     driver.switchTo().alert().accept();

    }

    @Test
    public void waitForBtnEnabledTest(){

        WebElement btn = driver.findElement(By.id("disable"));
        System.out.println("cher cher btn enabled = "+btn.isEnabled());  // false

        WebElement clickBtn = driver.findElement(By.id("enable-button"));
        clickBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(btn));

        System.out.println("cher cher btn enabled = "+btn.isEnabled());  // true

    }

    @Test
    public void waitForCheckBoxIsCheckedTest(){

        WebElement checkbox = driver.findElement(By.id("ch"));
        System.out.println("checkbox is checked = "+ checkbox.isSelected()); // false

        WebElement checkBtn = driver.findElement(By.xpath("//button[@id='checkbox']"));
        checkBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeSelected(checkbox));

        System.out.println("checkbox is checked = "+ checkbox.isSelected()); // true



    }







}
