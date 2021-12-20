package com.cybertek.tests.day16_download_uploaded_js_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import net.bytebuddy.matcher.CollectionOneToOneMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {

    @Test
    public void uploadingFileTest(){
        driver.get(ConfigurationReader.getProperty("upload.url"));
        WebElement uploadSelect = driver.findElement(By.id("file-upload"));

        uploadSelect.sendKeys(System.getProperty("user.home") + "/Downloads/some-file.txt");

        WebElement uploadBtn = driver.findElement(By.id("file-submit"));
        uploadBtn.click();

        //verify file is uploaded check filename is displayed on page

        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "File Uploaded!","message matched");

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='uploaded-files']")).getText(),"some-file.txt");


    }


}
