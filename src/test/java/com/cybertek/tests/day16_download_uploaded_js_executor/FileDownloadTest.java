package com.cybertek.tests.day16_download_uploaded_js_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownloadTest extends TestBase {

    //    String url = "http://practice.cybertekschool.com/download";  // this process now replayced by Configuration.getProperties() method.
    @Test
    public void fileDownloadTest() {
        // navigate to download page. reading url from properties file
        // driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("download.url"));

        //locate and click on some-file.txt to download
        WebElement someFileDownload = driver.findElement(By.linkText("some-file.txt"));
        someFileDownload.click();
        BrowserUtils.sleep(1);

        // verify that file is downloaded: /Users/cybertekb24/      Downloads/some-file.txt
        String filePath = System.getProperty("user.home") + "/Downloads/some-file.txt";
        System.out.println("filePath = " + filePath);

        File file = new File(filePath);
        System.out.println("file exist = " + file.exists());

        Assert.assertTrue(file.exists(), "file download failed");

        //delete after verification complete
        file.delete();

        WebElement junitBtn = driver.findElement(By.linkText("junit-4.13-beta-3.jar"));
        junitBtn.click();




    }


}
