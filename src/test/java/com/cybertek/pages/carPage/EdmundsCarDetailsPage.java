package com.cybertek.pages.carPage;

import com.cybertek.pages.carPage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EdmundsCarDetailsPage extends BasePage {
    @FindBy(xpath = "//span[@class='d-inline-block']")
    public WebElement msrpRange;

    public String getMsrpRangeValue(){
        return msrpRange.getText();
    }

    @Override
    public void isCurrentPage() {

        Assert.assertEquals(driver.getTitle(),"2020 Toyota Yaris Prices, Reviews, and Pictures | Edmunds");

    }
}
