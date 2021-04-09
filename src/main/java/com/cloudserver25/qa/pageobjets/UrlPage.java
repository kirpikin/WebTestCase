package com.cloudserver25.qa.pageobjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UrlPage {

    private WebDriver driver;

    private By urlSelectorBy = By.id("url-selector");
    private By loadBy = By.id("launcher");
    private By resultBy = By.id("page-content");

    public UrlPage(WebDriver driver) {
        this.driver = driver;
    }

    public UrlPage selectURLType(String visibleText) {
        Select dropdown = new Select(driver.findElement(urlSelectorBy));
        dropdown.selectByVisibleText(visibleText);
        return this;
    }

    public UrlPage clickLoad() {
        driver.findElement(loadBy).click();
        return this;
    }

    public String getResult() {
        return driver.findElement(resultBy).getText();
    }

    public boolean waitResult(String resultText) {
        WebDriverWait wait = new WebDriverWait(driver, 80, 1000);
        return wait.until(ExpectedConditions.textToBe(resultBy, resultText));
    }
}
