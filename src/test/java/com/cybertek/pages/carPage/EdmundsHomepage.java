package com.cybertek.pages.carPage;

import com.cybertek.pages.carPage.BasePage;

import static org.testng.Assert.*;

public class EdmundsHomepage extends BasePage {

    /**
     * Automatically added by comiler.
     * no-args default constructor
     * super() call to parent class
     */
    public EdmundsHomepage(){
        super();
    }


    @Override
    public void isCurrentPage() {

        assertEquals(driver.getTitle(), "New Cars, Used Cars, Car Reviews and Pricing | Edmunds");


    }
}
