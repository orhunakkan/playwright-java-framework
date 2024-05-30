package com.myapp.tests.day_03.pac_03_using_singleton_with_playwright;

import com.myapp.utils.Driver;
import org.junit.jupiter.api.Test;

public class P02_LoginFormWithSingleton {

    @Test
    void test1() {
        Driver.getPage().navigate("https://practice.cydeo.com/login");
        Driver.getPage().locator("input").first().fill("ORHUN");
        Driver.getPage().locator("input").last().fill("SuperSecretPassword");
        Driver.getPage().getByTestId("wooden_spoon").click();
        Driver.closeDriver();
    }
}
