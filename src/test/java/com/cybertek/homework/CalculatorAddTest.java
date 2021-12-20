package com.cybertek.homework;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorAddTest {
    public static void main(String[] args) throws InterruptedException {
        int num1 = 5;
        int num2 = 3;

        int expResult = num1 + num2;
        String appUrl = "https://www.calculator.net/";


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get(appUrl);

        System.out.println("//span[.='" + num1 + "']"); // // span[.='5']
        // <span onclick="r(5)" class="scinm">5</span>
        WebElement num1Elem = driver.findElement(By.xpath("//span[.='" + num1 + "']"));

        //<span onclick="r(3)" class="scinm">3</span>
        WebElement num2Elem = driver.findElement(By.xpath("//span[.='" + num2 + "']"));


        //<span onclick="r('+')" class="sciop">+</span>
        WebElement plus = driver.findElement(By.xpath("//span[.='+']"));
        // WebElement plus1= driver.findElement(By.xpath("//span[.='']"))

        //<span onclick="r('-')" class="sciop">–</span>
        WebElement minus = driver.findElement(By.xpath("//span[.='–']"));

        //<span onclick="r('=')" class="scieq">=</span>
        WebElement equal = driver.findElement(By.xpath("//span[.='=']"));

        num1Elem.click();
        Thread.sleep(1234);

        plus.click();
        Thread.sleep(1234);

        num2Elem.click();

        //<div id="sciOutPut">&nbsp;8</div>
        String actResult = driver.findElement(By.cssSelector("div[id='sciOutPut']")).getText(); // //#sciOutPut


        int actualResult = Integer.parseInt(actResult.trim());

        if (actualResult == expResult) {
            System.out.println("PASS: calculation passed");
        } else {
            System.out.println("Fail: calculation failed!!!");
        }

        Thread.sleep(1000);
        driver.quit();


    }


}
