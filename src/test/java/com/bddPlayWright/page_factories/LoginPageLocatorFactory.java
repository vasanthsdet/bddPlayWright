package com.bddPlayWright.page_factories;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPageLocatorFactory {

    private Page page;

    public LoginPageLocatorFactory(Page page) {
        this.page = page;
    }

    // Define locators for Gmail login page
    public Locator emailInput() {
        return page.locator("input[type='email']");
    }

    public Locator passwordInput() {
        return page.locator("input[type='password']");
    }

    public Locator nextButton() {
        return page.locator("#identifierNext");
    }

    public Locator passwordNextButton() {
        return page.locator("#passwordNext");
    }

    public Locator passwordErrorMessage() {
        return page.locator("//div[@aria-live='polite']//span[contains(., 'Wrong password')]");
    }

}
