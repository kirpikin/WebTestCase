package com.cloudserver25.qa.test;

import com.cloudserver25.qa.core.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UrlTests extends TestBase {

    @Test
    public void testWrongUrl() {
        app.getUrlPage()
                .selectURLType("Please select")
                .clickLoad();

        Assertions.assertTrue(app.getUrlPage().waitResult("WRONG URL"));
    }

    @Test
    public void testFailureUrl() {
        app.getUrlPage()
                .selectURLType("Wrong")
                .clickLoad();

        Assertions.assertEquals("Please wait...", app.getUrlPage().getResult());
        Assertions.assertTrue(app.getUrlPage().waitResult("FAILURE"));
    }

    @Test
    public void testCorrectUrl() {
        app.getUrlPage()
                .selectURLType("Correct")
                .clickLoad();

        Assertions.assertTrue(app.getUrlPage().waitResult("Nice! Great success!"));
    }
}
