package com.cloudserver25.qa.pageobjets;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private JavascriptExecutor js;

    private By firstNameBy = By.id("firstname");
    private By lastNameBy = By.id("lastname");
    private By hiddenFieldBy = By.id("hiddenfield");
    private By submitBy = By.cssSelector("input[value='Submit']");
    private By resultBy = By.tagName("p");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public LoginPage setFirstName(String firstName) {
        WebElement element = driver.findElement(firstNameBy);
        element.clear();
        element.sendKeys(firstName);
        return this;
    }

    public LoginPage setLastName(String lastName) {
        WebElement element = driver.findElement(lastNameBy);
        element.clear();
        element.sendKeys(lastName);
        return this;
    }

    public LoginPage setHiddenField(String hiddenField) {
        js.executeScript("document.getElementById('hiddenfield').removeAttribute('hidden')");
        driver.findElement(hiddenFieldBy).sendKeys(hiddenField);
        return this;
    }

    public LoginPage clickSubmit() {
        driver.findElement(submitBy).click();
        return this;
    }

    public String getResult() {
        return driver.findElement(resultBy).getText();
    }
}
