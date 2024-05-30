package com.myapp.tests.day_04.pac_01_upload_actions_js;

import com.myapp.utils.BrowserUtils;
import com.myapp.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class P01_UploadFile {

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://practice.cydeo.com/upload");
    }

    @Test
    void test1() {
        //path of your project
        String pathOfFile = System.getProperty("user.dir") + "/src/test/resources/uploadtest.txt";
        // Driver.getPage().getByTestId("file-upload").setInputFiles(Path.of(pathOfFile));
        Driver.getPage().getByTestId("file-upload").setInputFiles(Paths.get(pathOfFile));
        /*
        for multiple files
        Driver.getPage().getByLabel("Upload files").setInputFiles(new Path[] {Paths.get("pathOfFirstFile"), Paths.get
        ("pathOfSecondFile")});

         */
        BrowserUtils.sleepWithThread(3);
        // if you want to delete uploaded file go on with below line
        // Driver.getPage().getByTestId("file-upload").setInputFiles(new Path[0]);

        BrowserUtils.sleepWithThread(3);
        // Driver.getPage().getByTestId("file-submit").click();
        // System.out.println(Driver.getPage().locator("//h3").textContent());

        // Assertions.assertEquals("File Uploaded!",Driver.getPage().locator("//h3").textContent());

    }

    @AfterEach
    void tearDown() {
        Driver.closeDriver();
    }
}
