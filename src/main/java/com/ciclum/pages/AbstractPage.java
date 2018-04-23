package com.ciclum.pages;

import com.ciclum.utils.PropertyHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public abstract class AbstractPage {

    private static WebDriver driver = null;

    public AbstractPage() {
        this.driver = this.getDriver();
    }

    public static synchronized WebDriver getDriver() {
        if (driver == null) {
            synchronized (AbstractPage.class) {
                if (driver == null) {
                    String path = new PropertyHandler().getChromeDriverPath();
                    List<String> args = new PropertyHandler().getChromeOptionsArgs();
                    System.setProperty("webdriver.chrome.driver", path);
                    ChromeOptions options = new ChromeOptions();
                    options.setCapability("chrome.binary", path);
                    options.addArguments(args);
                    driver = new ChromeDriver(options);
                }
            }
        }
        return driver;
    }

    public void enterText(WebElement element, String text) {
        clearInput(element);
        element.sendKeys(text);
    }

    public void clearInput(WebElement element) {
        element.clear();
    }


    public void doActionClickOn(By element) {
        new Actions(getDriver()).click(driver.findElement(element)).build().perform();
    }


    public void openPage(String url) {
        driver.get(url);
    }

    public static void closePage() {
        driver.close();
    }

}
