package com.nopcommerce;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyStepdefs {


    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("^user is on Login page$")
    public void userIsOnLoginPage() {
        homePage.clickOnLoginLink();
        loginPage.verifyUserIsOnLoginPage();
    }

    @When("^user enters invalid \"([^\"]*)\" or \"([^\"]*)\"$")
    public void userEntersInvalidOr(String Email, String Password) throws Throwable {
        loginPage.userEntersLoginDetails(Email, Password);
    }

    @Then("^user should able to see the \"([^\"]*)\"$")
    public void userShouldAbleToSeeThe(String Errormessage) throws Throwable {
        Assert.assertEquals(Errormessage, loginPage.getErrorMessage());

    }

    @And("^user click on login btn$")
    public void userClickOnLoginBtn() {
        loginPage.clickOnLoginButton();

    }
}
