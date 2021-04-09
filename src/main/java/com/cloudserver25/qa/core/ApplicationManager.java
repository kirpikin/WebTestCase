package com.cloudserver25.qa.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.cloudserver25.qa.pageobjets.*;
import java.util.concurrent.TimeUnit;

public class ApplicationManager<T extends RemoteWebDriver> {

    private T driver;
    private String browserType;
    private LoginPage loginPage;
    private UrlPage urlPage;

    public ApplicationManager(String browserType) {
            this.browserType = browserType;
        }

    private ApplicationManager() {
    }

    public void init() {
        if (browserType.equals(BrowserType.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            driver = (T) new FirefoxDriver();
        } else if (browserType.equals(BrowserType.CHROME)) {
            WebDriverManager.chromedriver().setup();
            driver = (T) new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public void stop() {
            driver.quit();
        }

    public LoginPage getLoginPage () {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
            driver.get("http://qa.cloudserver25.com/");
        }
        return loginPage;
    }

    public UrlPage getUrlPage() {
        if (urlPage == null) {
            urlPage = new UrlPage(driver);
            driver.get("http://qa2.cloudserver25.com/");
        }
        return urlPage;
    }
}
