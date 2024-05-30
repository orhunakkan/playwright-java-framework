package com.myapp.tests.day_04.pac_02_pom_waits_actions;

import com.myapp.pages.LibraryLoginPage;
import com.myapp.utils.BrowserUtils;
import com.myapp.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P01_POMPractice {

    LibraryLoginPage libraryLoginPage;

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://library1.cydeo.com");
        libraryLoginPage = new LibraryLoginPage();
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }

    @Test
    void test1() {
        libraryLoginPage.getEmailInput().fill("invalid");
        libraryLoginPage.getPasswordInput().fill("invalid");
        libraryLoginPage.getSignInButton().click();
    }

    @Test
    void test2() {
        libraryLoginPage.login("invalid", "invalid");
        Assertions.assertTrue(libraryLoginPage.getErrorMessage().isVisible());
    }
}
