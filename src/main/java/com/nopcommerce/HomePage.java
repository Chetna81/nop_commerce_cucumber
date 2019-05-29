package com.nopcommerce;


import org.openqa.selenium.By;

public class HomePage extends Utils {

    LoadProp loadProp = new LoadProp();

    By _loginLink = By.linkText("Log in");


    //click on login
    public void clickOnLoginLink(){

        clickElementBy(_loginLink);
    }



}
