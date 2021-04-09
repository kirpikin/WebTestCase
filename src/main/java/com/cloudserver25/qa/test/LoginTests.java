package com.cloudserver25.qa.test;

import com.cloudserver25.qa.core.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTests extends TestBase {

    @Test
    public void testPositiveMessage() {
        app.getLoginPage()
                .setFirstName("FirstName")
                .setLastName("LastName")
                .setHiddenField("HiddenField")
                .clickSubmit();

        Assertions.assertEquals("Test Passed!", app.getLoginPage().getResult());
    }
}
