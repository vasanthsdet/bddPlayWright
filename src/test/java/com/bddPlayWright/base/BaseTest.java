package com.bddPlayWright.base;

import com.microsoft.playwright.*;
import com.bddPlayWright.utils.ConfigReader;

import java.util.Arrays;

public class BaseTest {

    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext browserContext;
    protected static Page page;

    public void setUp() {
        ConfigReader config = ConfigReader.getInstance();
        String browserName = config.getProperty("browserName", "chrome");// Default to Chrome if not specified
        boolean isHeadless = Boolean.parseBoolean(config.getProperty("headless", "false"));

        if (playwright == null) {
            playwright = Playwright.create();
            switch (browserName.toLowerCase()) {
                case "firefox":
                    browser = playwright.firefox().launch();
                    break;
                case "webkit":
                    browser = playwright.webkit().launch();
                    break;
                case "chromium":
                default:
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                            .setHeadless(isHeadless).setArgs(Arrays.asList(new String[]{"--disable-blink-features=AutomationControlled"})));
                    break;
            }

            browserContext = browser.newContext();
            page = browser.newPage();
        }
    }

    public Page getPage() {
        return this.page;
    }

    public void tearDown() {
        if (browserContext != null) {
            browserContext.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
