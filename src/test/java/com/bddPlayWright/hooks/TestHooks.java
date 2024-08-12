package com.bddPlayWright.hooks;

import com.bddPlayWright.base.BaseTest;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.nio.file.Paths;

public class TestHooks {
    private final BaseTest baseTest;

    public TestHooks() {
        this.baseTest = new BaseTest();
    }

    @Before
    public void setUp() {
        baseTest.setUp();  // Initialize Playwright, browser, context, and page
    }

    @After
    public void tearDown() {
        baseTest.tearDown();  // Clean up browser, context, and Playwright
    }

    public BaseTest getBaseTest() {
        return baseTest;
    }

    @AfterStep
    public void takeScreenshotAfterStep(Scenario scenario) {
        // Create a unique file name based on scenario and step
        String screenshotName = scenario.getName().replaceAll(" ", "_") + "_" + scenario.getStatus() + ".png";
        String screenshotPath = "target/screenshots/" + screenshotName;

        // Take the screenshot using Playwright and save it
        Page page = baseTest.getPage(); // Ensure the page object is accessible
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)));

        // Attach the screenshot to the report
        scenario.attach(page.screenshot(), "image/png", screenshotName);
    }
}