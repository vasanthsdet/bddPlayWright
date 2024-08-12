package com.bddPlayWright.hooks;

import com.bddPlayWright.base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

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
}