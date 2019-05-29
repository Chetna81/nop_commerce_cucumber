package com.nopcommerce;

import org.openqa.selenium.By;

public class LoginPage extends Utils {


    HomePage homePage = new HomePage();
    LoadProp loadProp = new LoadProp();



    By _email = By.id("Email");
    By _password = By.id("Password");
    By _loginBtn = By.xpath("//input[@class='button-1 login-button']");
    By _ErrorMessage = By.xpath("//div[@class='message-error validation-summary-errors']");


    public void verifyUserIsOnLoginPage() {
        assertUrl("login");
    }


    public void userEntersLoginDetails(String Email, String Password) {
        enterElements(_email, Email);
        enterElements(_password, Password);
        clickElementBy(_loginBtn);
    }

    public void clickOnLoginButton() {
        clickElementBy(_loginBtn);
    }


    public String getErrorMessage(){
        return getTextFromElement(_ErrorMessage);

    }

}


