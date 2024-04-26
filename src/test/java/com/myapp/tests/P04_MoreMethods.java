package com.myapp.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P04_MoreMethods {

    @Test
    void test04() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://library2.cybertekschool.com/login.html");
        page.getByPlaceholder("Email address").fill("me@me.com");
        page.getByLabel("Password").fill("myPassword");
//        page.querySelector("#inputPassword").fill("myPassword");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();

        System.out.println(page.getByRole(AriaRole.ALERT).isVisible());
        System.out.println(page.getByRole(AriaRole.ALERT).textContent());

        page.close();
        browser.close();
        playwright.close();

    }

    @Test
    void test05() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/registration_form");
        String expectedTitle = "Registration form";
        String actualTitle = page.getByRole(AriaRole.HEADING).textContent();

        Assertions.assertEquals(expectedTitle, actualTitle);

        String placeholder = page.querySelector("//input[@name='firstname']").getAttribute("placeholder");
        System.out.println(placeholder);

        // Difference between interText() and textContent()

        System.out.println(page.getByRole(AriaRole.HEADING).innerText()); // Pure text
        System.out.println(page.getByRole(AriaRole.HEADING).textContent()); // It will get you paragraph etc. More Specific



        page.close();
        browser.close();
        playwright.close();
    }

}
