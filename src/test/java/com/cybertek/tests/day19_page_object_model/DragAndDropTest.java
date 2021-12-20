package com.cybertek.tests.day19_page_object_model;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DragAndDropTest extends TestBase {

    @Test
    public void guru99DragAndDropTest() {

        driver.get(ConfigurationReader.getProperty("drlagadndrop.url"));
        WebElement bank = driver.findElement(By.id("credit2"));
        WebElement accountType = driver.findElement(By.id("bank"));
        actions.dragAndDrop(bank, accountType).perform();

        WebElement sale = driver.findElement(By.id("credit1"));

//       WebElement accountType1 = driver.findElement(By.className("field15 ui-droppable ui-sortable"));
//       actions.dragAndDrop(sale, accountType1).perform();

    }

    @Test
    public void carguru() {

        driver.get(ConfigurationReader.getProperty("cargurus.url") + "/Cars/inventorylisting/viewDetailsFilterViewInventoryListing.action?sourceContext=carGurusHomePageModel&entitySelectingHelper.selectedEntity=d177&zip=22102");

        WebElement slideBtn = driver.findElement(By.xpath("//button[@aria-valuemin='3000'][1]"));
        int x = slideBtn.getLocation().getX();
        int y = slideBtn.getLocation().getY();

        actions.dragAndDropBy(slideBtn, x + 50, 0).perform();

//        actions.clickAndHold(slideBtn).sendKeys(Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT).release().build().perform(); // another way to move the slide
//


    }


}

