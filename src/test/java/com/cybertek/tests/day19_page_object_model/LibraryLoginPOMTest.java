package com.cybertek.tests.day19_page_object_model;

import com.cybertek.pages.BookManagementPage;
import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LibraryLoginPOMTest extends TestBase {

    @Test
    public void invalidCredentialsTest() {

        driver.get(ConfigurationReader.getProperty("library.url"));
        // create object of LibraryLoginPage page object class
        LibraryLoginPage loginPage = new LibraryLoginPage();

        // access email WebElement and type invalid email
        loginPage.email.sendKeys("ivalid_email@gmail.com");
        loginPage.password.sendKeys("jkjkjkj");
        loginPage.signInBtn.click();

        Assert.assertTrue(loginPage.errorMsg.isDisplayed());

    }

    @Test
    public void positiveLoginTest() {
        driver.get(ConfigurationReader.getProperty("library.url"));
        LibraryLoginPage loginPage = new LibraryLoginPage();

        loginPage.email.sendKeys(ConfigurationReader.getProperty("library3.student.email"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("library3.student.password"));
        loginPage.signInBtn.click();

        BookManagementPage bookManagementPage = new BookManagementPage();
        System.out.println(bookManagementPage.bookMangtTitle.getText());
        Assert.assertTrue(bookManagementPage.bookMangtTitle.isDisplayed());
        bookManagementPage.isCurrentPage();

    }

}
