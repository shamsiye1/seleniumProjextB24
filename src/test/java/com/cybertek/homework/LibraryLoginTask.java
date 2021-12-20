package com.cybertek.homework;

import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LibraryLoginTask extends TestBase {

    @Test
    public void loginWithInvalidEmailTest() {
        driver.get(ConfigurationReader.getProperty("library.url"));

        LibraryLoginPage loginPage = new LibraryLoginPage();
        loginPage.email.sendKeys(ConfigurationReader.getProperty("library3.student.email_1"));

        loginPage.password.sendKeys(ConfigurationReader.getProperty("library3.student.password_1"));

        loginPage.signInBtn.click();

        assertEquals(loginPage.errorMsg.getText(), "Sorry, Wrong Email or Password", "negative test case fail!!!");
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        driver.get(ConfigurationReader.getProperty("library.url"));

        LibraryLoginPage loginPage = new LibraryLoginPage();
        loginPage.email.sendKeys(ConfigurationReader.getProperty("library3.student.email_3"));

        loginPage.password.sendKeys(ConfigurationReader.getProperty("library3.student.password_3"));

        loginPage.signInBtn.click();

        assertEquals(loginPage.errorMsg.getText(), "Sorry, Wrong Email or Password", "negative test case fail!!!");
    }

}
