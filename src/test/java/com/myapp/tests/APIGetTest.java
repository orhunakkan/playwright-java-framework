package com.myapp.tests;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class APIGetTest {

    private Playwright playwright;
    private APIRequestContext requestContext;

    // Dummy implementation for JSON schema validation
    private static boolean validateJsonSchema(String responseBody, String schema) {
        // Implement JSON schema validation logic here
        // This could involve using a library like justify or json-schema-validator
        return true; // This line is just a placeholder
    }

    @BeforeEach
    public void setup() {
        playwright = Playwright.create();
        requestContext = playwright.request().newContext();
    }

    @Test
    public void testGetResponseStatus() {
        String endpoint = "https://your.api/endpoint";
        APIResponse response = requestContext.get(endpoint);
        assertEquals(200, response.status(), "Response status should be 200");
    }

    @Test
    public void testResponseMatchesJsonSchema() throws IOException {
        String endpoint = "https://your.api/endpoint";
        APIResponse response = requestContext.get(endpoint);

        String schemaPath = "schemas/getSchema.json";
        String expectedSchema = Files.readString(Paths.get(schemaPath));

        // Assume validateJsonSchema is a method you implement that checks JSON validity
        assertTrue(validateJsonSchema(Arrays.toString(response.body()), expectedSchema), "JSON does not match schema");
    }

    @AfterEach
    public void cleanup() {
        requestContext.dispose();
        playwright.close();
    }

}
