package com.cybertek.tests.day17_upload_js_executer;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Guru99UploadTest extends TestBase {

    @Test
    public void uploadFileTest() {
        driver.get(ConfigurationReader.getProperty("guru99upload.url"));
        WebElement chooseFileBtn = driver.findElement(By.id("uploadfile_0"));
        //  chooseFileBtn.click();
        chooseFileBtn.sendKeys(System.getProperty("user.home") + "/Downloads/some-file.txt");
        WebElement terms = driver.findElement(By.className("field_check"));

        terms.click();

        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='button']"));
        submitBtn.click();

        WebElement resultMsg = driver.findElement(By.xpath("//h3[@id='res']"));

        BrowserUtils.sleep(1);
        Assert.assertEquals(resultMsg.getText(), "1 file\n" +
                "has been successfully uploaded.");

    }


}
