package com.bddPlayWright.steps;

import com.bddPlayWright.hooks.TestHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.bddPlayWright.base.BaseTest;
import com.bddPlayWright.pages.GmailLoginPage;
import org.junit.Assert;

public class GmailLoginSteps {

    private GmailLoginPage gmailLoginPage;
    private BaseTest baseTest;

    public GmailLoginSteps() {
        TestHooks hooks = new TestHooks();
        this.baseTest = hooks.getBaseTest();
        this.gmailLoginPage = new GmailLoginPage(baseTest.getPage());
    }

    @Given("I am on the Gmail login page")
    public void i_am_on_the_gmail_login_page() {
        gmailLoginPage.navigateToLoginPage();
    }

    @When("I enter my email {string}")
    public void i_enter_my_email(String email) {
        gmailLoginPage.enterEmail(email);
    }

    @And("I enter my password {string}")
    public void iEnterMyPassword(String passWord) {
        gmailLoginPage.enterPassword(passWord);
    }

    @Then("Validate password wrong message")
    public void validatePasswordWrongMessage() {
       Assert.assertTrue(gmailLoginPage.validatePasswordWrongMessage());
    }

    // other steps...
}

