package com.myapp.tests.day_02.pac_01_multipleElements_checkbox_radio;

import com.myapp.utils.BrowserUtils;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class P05_RadioButtons {


    @Test
    void test1() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/radio_buttons");
        Locator hockey = page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Hockey"));
        BrowserUtils.sleepWithThread(3);
        System.out.println(hockey.isChecked());
        hockey.check();
        BrowserUtils.sleepWithThread(3);
        System.out.println(hockey.isChecked());
        BrowserUtils.sleepWithThread(3);
        page.close();
        browser.close();
        playwright.close();
    }
}
