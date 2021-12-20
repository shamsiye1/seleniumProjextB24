package com.cybertek.homework;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import com.cybertek.utils.TableUtils;
import org.testng.annotations.Test;

public class TableTask extends TestBase {

  //  String url = "http://practice.cybertekschool.com/tables#edit";

    @Test
    public void verifyNameList(){
        Driver.getDriver().get(ConfigurationReader.getProperty("table.url"));
        TableUtils.verifyOrder(driver, "Jason");

    }

    @Test
    public void printNameWithEmails(){
        Driver.getDriver().get(ConfigurationReader.getProperty("table.url"));
        TableUtils.printNamesAndEmails(driver);

    }




}
