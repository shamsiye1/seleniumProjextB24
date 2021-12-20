package com.cybertek.tests.day08_implicitwait_checkbox_radio_testing;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class EtsyRadioCheckboxTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.etsy.com/ca/");

        //search for wooden spoon
        WebElement searchField= driver.findElement(By.name("search_query"));
        searchField.sendKeys("wooden spoon"+ Keys.ENTER);

        // click on all filters
        //<span class="wt-hide-xs wt-show-md filter-expander">All Filters</span>

        WebElement filterButton= driver.findElement(By.xpath("//span[.='All Filters']"));
        filterButton.click();

        //<label for="special-offers-free-shipping" class="wt-checkbox__label wt-display-inline">
        //            FREE delivery
        //        </label>

//        <label for="special-offers-on-sale" class="wt-checkbox__label wt-display-inline">
//            On sale
//        </label>
        WebElement freeDelivery= driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']"));
        freeDelivery.click();

        WebElement saleButton= driver.findElement(By.xpath("//label[@for='special-offers-on-sale']"));
        saleButton.click();

        //<div class="wt-radio wt-radio--small wt-mb-xs-1 " data-radio-custom="">
        //    <input type="radio" id="price-input-1" name="price_bucket_range" value="_25" class="radio price-bucket" data-path="_25" data-context="price" aria-label="Under CA$25">
        //    <label for="price-input-1" class="wt-radio__label wt-display-inline">
        //        Under CA$25
        //    </label>
        //</div>

        WebElement under25$= driver.findElement(By.xpath("//label[@for='price-input-1']"));
        under25$.click();

        //<div class="wt-checkbox wt-checkbox--small" data-checkbox-toggle="">
        //        <input type="checkbox" id="max-processing-days-1" name="max_processing_days" value="1">
        //        <label for="max-processing-days-1" class="wt-checkbox__label wt-display-inline">
        //            1 business day
        //        </label>
        //    </div>

        WebElement oneDayShip= driver.findElement(By.xpath("//label[@for='max-processing-days-1']"));
        oneDayShip.click();


        //<button class="wt-btn wt-btn--primary wt-width-full wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3" type="submit" form="search-filter-form" aria-label="Apply" data-wt-overlay-close="">
        //        Apply
        //    </button>
        WebElement applyButton= driver.findElement(By.xpath("(//button[@type='submit'])[4]"));
        applyButton.click();

//<span class="wt-text-caption wt-text-link-no-underline">
//            2 Results
//
//    </span>

        WebElement result= driver.findElement(By.xpath("//span[contains(text(),'Results')]"));

        System.out.println("results= "+ result.getText());

















        Thread.sleep(3000);
      driver.quit();








    }
}
