package com.cybertek.homework;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GasMileageCalculator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        String appUrl="https://www.calculator.net";
        driver.get(appUrl);

        //        - Search for “gas mileage” using search box

//        <input type="text" name="calcSearchTerm" id="calcSearchTerm" class="inlongest" onkeyup="return calcSearch();" onfocus="document.onkeydown=null;">

        WebElement gasMileage= driver.findElement(By.xpath("//input[@id='calcSearchTerm']"));

        //- Click on the “Gas Mileage Calculator” link
        gasMileage.sendKeys("Gas Mileage Calculator");

//        <a href="/gas-mileage-calculator.html">Gas Mileage Calculator</a>

        WebElement gasMileageLink= driver.findElement(By.xpath("//a[.='Gas Mileage Calculator']"));
        gasMileageLink.click();

//        On Next page verify:
//o Title equals: “Gas Mileage Calculator”
//o “Gas Mileage Calculator” label is displayed

        String expTitle="Gas Mileage Calculator";
        String actTitle= driver.getTitle();

        if (actTitle.equalsIgnoreCase(expTitle)){
            System.out.println("Result: pass!");
        }else {
            System.out.println("Result: failed!!!");
        }

        //<h1>Gas Mileage Calculator</h1>
        WebElement gasMileageLabel= driver.findElement(By.tagName("h1"));
        gasMileageLabel.isDisplayed();
        System.out.println(gasMileageLabel.isDisplayed());

//- Locate, clear and type “7925” into “Current odometer” field

      // <input type="text" name="mucodreading" id="mucodreading" value="18900" class="inlong" onkeyup="iptfieldCheck(this, 'r', 'pn');">
        WebElement currentMeter= driver.findElement(By.id("mucodreading"));
        currentMeter.clear();
        currentMeter.sendKeys("7925");

        //- Locate, clear and type “7550” into “Previous odometer” field
        //<input type="text" name="mupodreading" id="mupodreading" value="18300" class="inlong" onkeyup="iptfieldCheck(this, 'r', 'pn');">
        WebElement preMeter=driver.findElement(By.id("mupodreading"));
        preMeter.clear();
        preMeter.sendKeys("7550");

        //- Locate, clear and type “16” into “Gas added” field
//- Locate, clear and type “3.55” into “Gas price” field and Click on Calculate button
         //<input type="text" name="mugasputin" id="mugasputin" value="50" class="inlong" onkeyup="iptfieldCheck(this, 'r', 'pn');">
        WebElement gasAddTank= driver.findElement(By.id("mugasputin"));
        gasAddTank.clear();
        gasAddTank.sendKeys("16");

        //<input type="text" name="mugasprice" id="mugasprice" value="1" class="inlong indollar" onkeyup="iptfieldCheck(this, '', 'pn');">
        WebElement gasPrice= driver.findElement(By.id("mugasprice"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55"+ Keys.ENTER);

//        Locate and print the mpg value
       //<p class="verybigtext" style="padding-top:10px;">Gas mileage: <font color="green"><b>23.44 km/L  or 4.27  L/100 km </b></font> <span class="bigtext">(55.13 mpg)</span></p>

        WebElement result= driver.findElement(By.xpath("//p[@class='verybigtext']"));
        System.out.println(result.getText());




















        Thread.sleep(3000);
        driver.quit();
















    }
}
