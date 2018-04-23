package com.ciclum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends AbstractPage {

    private static By searchResults = By.xpath("//li[@class='lvprice prc']");
    private static By registerLink = By.xpath("//span[@id='gh-ug-flex']/a");
    private static By userNameLabel = By.xpath("//button[@id='gh-ug']/b[1]");

    private static WebDriver driver;

    public SearchResultPage() {
        this.driver = AbstractPage.getDriver();
    }

    public Long getFirstPrice() {
      List<String>titles = new ArrayList<>();
      driver.findElements(searchResults).stream().forEach(it ->titles.add(it.getText()));
      return Long.parseLong(titles.get(0).substring(4,6).replaceAll("\\p{Punct}", "\\."));
    }

    public void clickRegisterLink() {
        new Actions(driver).click(driver.findElement(registerLink)).build().perform();
    }

    public String getUserName() {
        return driver.findElement(userNameLabel).getText();
    }

}
