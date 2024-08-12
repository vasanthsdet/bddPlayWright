package com.bddPlayWright.pages;

import com.microsoft.playwright.Page;
import com.bddPlayWright.page_factories.LoginPageLocatorFactory;
import org.junit.Assert;

public class GmailLoginPage {

    private final Page page;
    private final LoginPageLocatorFactory loginPageLocatorFactory;

    public GmailLoginPage(Page page) {
        this.page = page;
        this.loginPageLocatorFactory = new LoginPageLocatorFactory(page);
    }

    public void navigateToLoginPage() {
        page.navigate("https://mail.google.com/");
    }

    public void enterEmail(String email) {
        loginPageLocatorFactory.emailInput().fill(email);
        loginPageLocatorFactory.nextButton().click();
    }

    public void enterPassword(String password) {
        loginPageLocatorFactory.passwordInput().fill(password);
        loginPageLocatorFactory.passwordNextButton().click();
    }

    public boolean validatePasswordWrongMessage() {
        loginPageLocatorFactory.passwordErrorMessage().waitFor();
        return loginPageLocatorFactory.passwordErrorMessage().isVisible();
    }
}
