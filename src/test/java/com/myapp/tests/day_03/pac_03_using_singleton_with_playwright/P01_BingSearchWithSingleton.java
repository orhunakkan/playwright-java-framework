package com.myapp.tests.day_03.pac_03_using_singleton_with_playwright;

import com.myapp.utils.BrowserUtils;
import com.myapp.utils.ConfigurationReader;
import com.myapp.utils.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P01_BingSearchWithSingleton {

    @Test
    void bing_search_1() {
        Driver.getPage().navigate(ConfigurationReader.getProperty("bingURL"));
        BrowserUtils.sleepWithThread(3);
        Driver.getPage().getByTestId("bnp_btn_accept").click();
        BrowserUtils.sleepWithThread(3);
        Driver.getPage().getByTestId("sb_form_q").fill("playwright");
        Driver.getPage().getByTestId("sb_form_q").press("Enter");
        Assertions.assertTrue(Driver.getPage().title().contains("playwright"));
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }
}
