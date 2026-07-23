package com.ceva.digilib.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.Target;

public class ApplitoolsTest {

    public static void main(String[] args) {
        // Set path to ChromeDriver executable (adjust this path as needed)
        System.setProperty("webdriver.chrome.driver", 
            "C:\\Users\\Admin\\Downloads\\chromedriver-win64\\chromedriver.exe");

        // Applitools API key (replace with your actual API key)
        String applitoolsApiKey = "wfDfqizgTAPpMHAwgIP3fAHhQeq2rynoRysKfr96v1g110";

        // Initialize WebDriver for Chrome
        WebDriver driver = new ChromeDriver();
        Eyes eyes = new Eyes();

        try {
            // Set Applitools API Key
            eyes.setApiKey(applitoolsApiKey);

            // Open the page you want to test
            driver.get("https://applitools.com/helloworld");

            // Start the visual test with Eyes (app name and test name)
            eyes.open(driver, "HelloApp", "FirstTest");

            // Visual checkpoint #1: Full page screenshot
            eyes.check("Main Page", Target.window());

            // Visual checkpoint #2: Another screenshot (you can modify as needed)
            eyes.check("Test", Target.window());

            // End the visual test (this will upload the test results to Applitools)
            eyes.close();
        } catch (Exception e) {
            // If any errors occur, abort the test
            System.out.println("Error during Applitools test: " + e.getMessage());
        } finally {
            // Ensure cleanup: close the browser and end the Eyes session
            if (eyes != null) {
                eyes.abortIfNotClosed();
            }
            if (driver != null) {
                driver.quit();
            }
        }
    }
}