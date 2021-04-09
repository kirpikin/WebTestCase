package com.cloudserver25.qa.core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;


public class TestBase {
    public static final ApplicationManager app = new ApplicationManager<ChromeDriver>(BrowserType.CHROME);

    @BeforeAll
    public static void setUp() {
        app.init();
    }

    @AfterAll
    public static void tearDown() {
        app.stop();
    }
}
