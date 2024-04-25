package com.myapp.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P03_LocatorsAndText {

    @Test
    public void test01() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/");
        System.out.println(page.url());
        Assertions.assertEquals("https://practice.cydeo.com/", page.url());
        System.out.println(page.title());
        Assertions.assertEquals("Practice", page.title());

        page.close();
        browser.close();
        playwright.close();

    }

    @Test
    void test02() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.setViewportSize(1920, 1080);
        page.navigate("https://practice.cydeo.com/");
        page.click("text=A/B Testing");
        Assertions.assertEquals("No A/B Test", page.title());

        page.close();
        browser.close();
        playwright.close();

    }
}
