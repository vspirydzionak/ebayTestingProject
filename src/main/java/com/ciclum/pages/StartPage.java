package com.ciclum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StartPage extends AbstractPage {

    private static By searchInput = By.xpath("//*[@class='gh-tb ui-autocomplete-input']");
    private static By categorySelector = By.id("gh-cat");
    private static By registerLink = By.xpath("//span[@id='gh-ug-flex']/a");

    private static WebDriver driver;

    public StartPage() {
        this.driver = AbstractPage.getDriver();
    }

    public void selectCategory() {
        Select categorySelevtor = new Select(driver.findElement(categorySelector));
        categorySelevtor.selectByValue("267");
    }

     public SearchResultPage enterBookName() {
         WebElement search = driver.findElement(searchInput);
         search.sendKeys("Lord of the rings");
         search.submit();
         return new SearchResultPage();
     }

     public void clickRegisterLink() {
         new Actions(driver).click(driver.findElement(registerLink)).build().perform();
     };

}
