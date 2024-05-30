package com.myapp.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class BrowserFactory {
    public static Browser getBrowser(String browserFromConfig, Playwright playwright) {
        return switch (browserFromConfig) {
            case "chrome" -> playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            case "firefox" -> playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            default -> null;
        };
    }
}
