package com.ciclum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends AbstractPage {

    private static By firstNameInput = By.xpath("//div[@id='firstname_r']/input[@name='firstname']");

    private static By lastNameInput = By.xpath("//div[@id='lastname_r']/input[@name='lastname']");

    private static By emailInput = By.xpath("//div[@id='email_r']/input[@name='email']");

    private static By passwordInput = By.xpath("//div[@id='PASSWORD_r']/input[@name='PASSWORD']");

    private static By passwordHelper = By.xpath("//div[@id='PASSWORD_helper']");

    private static By passwordHelperMessage = By.xpath("//div[@id='PASSWORD_w']");

    private static By submitButton = By.id("ppaFormSbtBtn");

    private static By disabledButtonText = By.id("ppaFormSbtBtnDisabledText");

    private static By errorMessages = By.className("fv-et");

    private static WebDriver driver;

    public RegisterPage() {
        this.driver = AbstractPage.getDriver();
    }

    public void enterFirstName(String firstName) {
        enterText(driver.findElement(firstNameInput), firstName);
    }

    public void enterLastName(String lastName) {
        enterText(driver.findElement(lastNameInput), lastName);
    }

    public void enterEmail(String email) {
        enterText(driver.findElement(emailInput), email);
    }

    public void enterPassword(String password) {
        enterText(driver.findElement(passwordInput), password);
        new WebDriverWait(driver, 15000).until(ExpectedConditions.invisibilityOfElementLocated(passwordHelper));
        new WebDriverWait(driver, 15000).until(ExpectedConditions.invisibilityOfElementLocated(passwordHelperMessage));
    }

    public void clickSubmitButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        new Actions(driver).click(button).build().perform();
    }

    public boolean isSubmitDisabled() {
        return driver.findElement(disabledButtonText).isDisplayed();
    }

    public void clickFirstNameInput(){
        doActionClickOn(firstNameInput);
    }
    public void clickLastNameInput(){
        doActionClickOn(lastNameInput);
    }

    public void clickPasswordInput(){
        doActionClickOn(passwordInput);
    }

    public boolean isErrorMessagesThrown() {
        return driver.findElements(errorMessages).size()!=0;
    }


}
