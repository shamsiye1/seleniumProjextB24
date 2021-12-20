package com.cybertek.tests.day23_fluentwait_testng_overview;

import com.cybertek.pages.carPage.EdmundsCarDetailsPage;
import com.cybertek.pages.carPage.EdmundsHomepage;
import com.cybertek.pages.carPage.EdmundsNewCarPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.testng.annotations.Test;

public class EdmundsNewCarSearchTest extends TestBase {

    @Test
    public void searchForNewCarTest(){

     driver.get(ConfigurationReader.getProperty("edmunds.url"));

        EdmundsHomepage homepage = new EdmundsHomepage();
        homepage.isCurrentPage();
        homepage.gotoNewCarPricingPge();

        EdmundsNewCarPage newCarPage = new EdmundsNewCarPage();
        newCarPage.selectMake("Toyota");

        newCarPage.selectModel("Yaris");
        BrowserUtils.sleep(2);

        newCarPage.zipcode.clear();
        BrowserUtils.sleep(2);

        newCarPage.zipcode.sendKeys("22102");
        newCarPage.goBtn.click();

        EdmundsCarDetailsPage carDetailsPage = new EdmundsCarDetailsPage();
        carDetailsPage.isCurrentPage();
        System.out.println("MSRP range: "+ carDetailsPage.getMsrpRangeValue());
    }


}
