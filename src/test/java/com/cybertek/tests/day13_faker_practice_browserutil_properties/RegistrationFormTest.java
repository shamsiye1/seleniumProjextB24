package com.cybertek.tests.day13_faker_practice_browserutil_properties;

import com.cybertek.utils.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistrationFormTest extends RegistrationFormTestBase{

    Faker faker = new Faker();

    @Test
    public void formTest(){

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys(faker.name().username().replace(".","")); // use replace method to skip the dot(.);

        WebElement emailAddress = driver.findElement(By.xpath("//input[@placeholder='email@email.com']"));
        emailAddress.sendKeys(faker.internet().emailAddress());

       WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
       password.sendKeys(faker.internet().password());

       WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));
       phoneNumber.sendKeys(faker.phoneNumber().cellPhone().replace(".","-")
                                                            .replace("(","")
                                                            .replace(")","-")
                                                            .replace(" ",""));


       WebElement male = driver.findElement(By.xpath("//input[@value='male']"));
       male.click();

       WebElement dateOfBirth = driver.findElement(By.name("birthday"));
       dateOfBirth.sendKeys("01/01/1991");

      Select office = new Select(driver.findElement(By.xpath("(//select[@class='form-control selectpicker'])[1]")));
     office.selectByIndex(faker.number().numberBetween(1,9));

      Select jobTitle = new Select(driver.findElement(By.xpath("(//select[@class='form-control selectpicker'])[2]")));
      jobTitle.selectByIndex(faker.number().numberBetween(1,8));

        List<WebElement> selectLanguage = driver.findElements(By.xpath("//label[@class='form-check-label']"));

        for(WebElement eachLanguage : selectLanguage){
            eachLanguage.click();
        }

        WebElement signUpBtn = driver.findElement(By.id("wooden_spoon"));
        signUpBtn.click();

        Assert.assertEquals(driver.getTitle(),"Practice");

        //verify "well done!" message is displayed

        WebElement heading = driver.findElement(By.className("alert-heading"));
        Assert.assertEquals(heading.getText(),"Well done!");
        Assert.assertTrue(heading.isDisplayed(),"heading message don't match");

    }




}
