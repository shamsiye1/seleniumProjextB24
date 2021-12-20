package com.cybertek.homework;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FindElementsAllPages {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.get("https://www.apple.com");
//<a class="ac-gn-link ac-gn-link-mac" href="/ca/mac/" data-analytics-title="mac">
//					<span class="ac-gn-link-text">Mac</span>
//				</a>
        WebElement mac = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-mac']"));
        mac.click();
        Thread.sleep(5000);
        System.out.println("Mac page title: " + driver.getTitle());

        List<WebElement> macPageLinks = driver.findElements(By.xpath("//a"));

        System.out.println("macPageLinks: " + macPageLinks.size());
        List macPageMissingText = new ArrayList();

        for (WebElement eachLink : macPageLinks) {
            if (eachLink.getText() == null || eachLink.getText().isEmpty()) {
                macPageMissingText.add(eachLink);
            }
        }
        System.out.println(macPageMissingText.size() + " links in Mac page text is missing");


        List macPageHasText = new ArrayList();
        for (WebElement eachLink : macPageLinks) {
            if (!eachLink.getText().isEmpty()) {
                macPageHasText.add(eachLink);
            }
        }
        System.out.println(macPageHasText.size() + " links has text");

        System.out.println("============================================");

//        <a class="ac-gn-link ac-gn-link-ipad" href="/ipad/" data-analytics-title="ipad">
//					<span class="ac-gn-link-text">iPad</span>
//				</a>
        WebElement ipadButton = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-ipad']"));

        ipadButton.click();
        Thread.sleep(3000);

        System.out.println("ipad page title: " + driver.getTitle());

        List<WebElement> ipadAllLinks = driver.findElements(By.xpath("//a"));
        System.out.println("ipadAllLinks: " + ipadAllLinks.size());

        List ipadMissingTextLinks = new ArrayList();

        for (WebElement eachLink : ipadAllLinks) {
            if (eachLink.getText() == null || eachLink.getText().isEmpty()) {
                ipadMissingTextLinks.add(eachLink);
            }
        }
        System.out.println(ipadMissingTextLinks.size() + " links in ipad page text is missing");

        List ipadHasText = new ArrayList();
        for (WebElement eachLink : ipadAllLinks) {
            if (!eachLink.getText().isEmpty()) {
                ipadHasText.add(eachLink);
            }
        }
        System.out.println(ipadHasText.size() + " links has text");
        System.out.println("----------------------------------------------");

//        <a class="ac-gn-link ac-gn-link-iphone" href="/iphone/" data-analytics-title="iphone">
//					<span class="ac-gn-link-text">iPhone</span>
//				</a>
        WebElement iPhoneButton = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']"));
        iPhoneButton.click();
        Thread.sleep(3000);

        System.out.println("iPhone page title: " + driver.getTitle());

        List<WebElement> iphoneAllLinks = driver.findElements(By.xpath("//a"));
        System.out.println("iphoneAllLinks: " + iphoneAllLinks.size());

        List iphoneMissingTextLinks = new ArrayList();

        for (WebElement eachLink : iphoneAllLinks) {
            if (eachLink.getText() == null || eachLink.getText().isEmpty()) {
                iphoneMissingTextLinks.add(eachLink);
            }
        }
        System.out.println(iphoneMissingTextLinks.size() + " links in iphone page text is missing");

        List iphoneHasText = new ArrayList();
        for (WebElement eachLink : iphoneAllLinks) {
            if (!eachLink.getText().isEmpty()) {
                iphoneHasText.add(eachLink);
            }
        }
        System.out.println(iphoneHasText.size() + " links has text");

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");

//        <a class="ac-gn-link ac-gn-link-watch" href="/watch/" data-analytics-title="watch">
//					<span class="ac-gn-link-text">Watch</span>
//				</a>
        WebElement watchButton = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-watch']"));
        watchButton.click();
        Thread.sleep(3000);

        System.out.println("watch page title: " + driver.getTitle());

        List<WebElement> watchLinkAllLinks = driver.findElements(By.xpath("//a"));
        System.out.println("watchLinkAllLinks: " + watchLinkAllLinks.size());

        List watchMissingTextLinks = new ArrayList();

        for (WebElement eachLink : watchLinkAllLinks) {
            if (eachLink.getText() == null || eachLink.getText().isEmpty()) {
                watchMissingTextLinks.add(eachLink);
            }
        }
        System.out.println(watchMissingTextLinks.size() + " links in watch page text is missing");

        List watchHasText = new ArrayList();
        for (WebElement eachLink : watchLinkAllLinks) {
            if (!eachLink.getText().isEmpty()) {
                watchHasText.add(eachLink);
            }
        }
        System.out.println(watchHasText.size() + " links has text");

        System.out.println("**************************************************");

//    <a class="ac-gn-link ac-gn-link-tvhome" href="/tv-home/" data-analytics-title="tv and home">
//					<span class="ac-gn-link-text">TV &amp; Home</span>
//				</a>
        WebElement TVButton = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-tvhome']"));
        TVButton.click();
        Thread.sleep(30000);

        System.out.println("TV page title: " + driver.getTitle());

        List<WebElement> tvLinkAllLinks = driver.findElements(By.xpath("//a"));
        System.out.println("tvLinkAllLinks: " + tvLinkAllLinks.size());

        List tvMissingTextLinks = new ArrayList();

        for (WebElement eachLink : tvLinkAllLinks) {
            if (eachLink.getText() == null || eachLink.getText().isEmpty()) {
                tvMissingTextLinks.add(eachLink);
            }
        }
        System.out.println(tvMissingTextLinks.size() + " links in TV page text is missing");

        List tvHasText = new ArrayList();
        for (WebElement eachLink : tvLinkAllLinks) {
            if (!eachLink.getText().isEmpty()) {
                tvHasText.add(eachLink);
            }
        }
        System.out.println(tvHasText.size() + " links has text");

        System.out.println("//////////////////////////////////////////////////////////");
//<a class="ac-gn-link ac-gn-link-support" href="https://support.apple.com/en-ca" data-analytics-title="support">
//					<span class="ac-gn-link-text">Support</span>
//				</a>
        WebElement supportButton = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-support']"));
        supportButton.click();
        Thread.sleep(3000);

        System.out.println("support page title: " + driver.getTitle());

        List<WebElement> supportLinkAllLinks = driver.findElements(By.xpath("//a"));
        System.out.println("supportLinkAllLinks: " + supportLinkAllLinks.size());

        List supportMissingTextLinks = new ArrayList();

        for (WebElement eachLink : supportLinkAllLinks) {
            if (eachLink.getText() == null || eachLink.getText().isEmpty()) {
                supportMissingTextLinks.add(eachLink);
            }
        }
        System.out.println(supportMissingTextLinks.size() + " links in support page text is missing");

        List supportHasText = new ArrayList();
        for (WebElement eachLink : supportLinkAllLinks) {
            if (!eachLink.getText().isEmpty()) {
                supportHasText.add(eachLink);
            }
        }
        System.out.println(supportHasText.size() + " links has text");

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        //<a class="ac-gn-link ac-gn-link-music" href="https://www.apple.com/music/" data-analytics-title="music">
        //					<span class="ac-gn-link-text">Music</span>
        //				</a>

        WebElement musicButton = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-music']"));

        musicButton.click();
        Thread.sleep(3000);

        System.out.println("music page title: " + driver.getTitle());

        List<WebElement> musicLinkAllLinks = driver.findElements(By.xpath("//a"));
        System.out.println("musicLinkAllLinks: " + musicLinkAllLinks.size());

        List musicMissingTextLinks = new ArrayList();

        for (WebElement eachLink : musicLinkAllLinks) {
            if (eachLink.getText() == null || eachLink.getText().isEmpty()) {
                musicMissingTextLinks.add(eachLink);
            }
        }
        System.out.println(musicMissingTextLinks.size() + " links in music page text is missing");

        List musicHasText = new ArrayList();
        for (WebElement eachLink : musicLinkAllLinks) {
            if (!eachLink.getText().isEmpty()) {
                musicMissingTextLinks.add(eachLink);
            }
        }
        System.out.println(musicMissingTextLinks.size() + " links has text");

        driver.quit();


    }
}
