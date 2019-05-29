package com.nopcommerce;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

public class Utils extends BasePage {

    private static By by;
    private static Object text;

    //Clicking element
    public static void clickElementBy(By by) {
        driver.findElement(by).click();
    }

    //SendText element
    public static void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys((CharSequence) text);
    }

    //click in element
    public static void clickElements(By by) {
        driver.findElement(by).click();
    }

    //entering elements
    public static void enterElements(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }


    //selectTextByValue
    public static void selectTextByValue(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(java.lang.String.valueOf(text));
    }

    //select Dropdown Method  by Index
    public static void selectByIndex(By by, int indexNumber) {
        Select select;
        new Select(driver.findElement(by)).selectByIndex(indexNumber);
    }

    //waitFor element
    public static void waitForElement(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //getTextForm element
    public static java.lang.String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //getRandomNumber
    public static int getRandomNumber() {
        return (int) (Math.random() * 5000 + 1);
    }

    //Clear Text from inout box/area
    public static void clearField(By by) {
        driver.findElement(by).clear();
    }

    //get attribute by value
    public static java.lang.String getValue(By by) {
        return driver.findElement(by).getText();
    }

    //create timestamp with current day-month-year -hour-minute-second
    public static java.lang.String randomDate() {
        DateFormat format = new SimpleDateFormat("ddMMyyHHmmSS");
        return format.format(new Date());
    }

    //create timestamp with current day-month-hour-minute
    public static java.lang.String randomNumber() {
        DateFormat format = new SimpleDateFormat("ddMMHHmm");
        return format.format(new Date());
    }

    //clear text from input box area
    public static void clearText(By by) {
        driver.findElement(by).clear();
    }

    //enter text in input field
    public static void inputField(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //clear and enter Text in input field
    public static void clearAndEnterText(By by, String text2) {
        Utils.by = by;
        Utils.text = text;
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text2);
    }

    //checking webElement present in DOM
    protected static boolean webElementPresent(By by) {
        try {
            driver.findElement(by).click();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //Element displayed or not
    public static boolean elementDisplayedOrNot(By by) {
        try {
            driver.findElement(by).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //wait to be display time
    public static void waitForElementDisplay(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //wait for fixed time given in seconds
    public static void waitForElementToBeClickable(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //try to click element three times if not available in first go
    public boolean retryForElement(By by) {
        boolean result = false;
        int attempt = 0;
        while (attempt < 3) {
            try {
                Thread.sleep(20);
                driver.findElement(by).click();
                result = true;
            } catch (Exception e) {
            }
            attempt++;
        }
        return result;
    }

    //wait for locators to be clickable for given time in seconds
    public static void waitForLocatorToBeClickable(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //wait for visibility of element with given time
    public static void explicitwaitForVisibilty(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //capture ScreenShot
    public static void captureScreenShot() {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("src\\BrowserDrivers\\chromedriver.exe" + System.currentTimeMillis()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //get selected value from dropdown
    public static void selectByValue(By by, String data) {
        Select dob = new Select(driver.findElement(by));
        dob.selectByValue(data);
    }

    //get selected value from dropdown
    public static void selectByVisibleText(By by, String data) {
        Utils.text = text;
        Utils.by = by;
        Select dob = new Select(driver.findElement(by));
        dob.selectByVisibleText(data);
    }

    //select text from value
    public static void getActualText(By by, String Text) {
        driver.findElement(by).getText();
    }

    //get css property of element
    public static String getAttributeOfElement(WebElement element, String css) {
        String value = element.getCssValue(css);
        return value;
    }

    //wait for alert to display
    public boolean isAlertPresent() {
        boolean present = false;
        try {
            Alert alert = driver.switchTo().alert();
            present = true;
            alert.accept();
        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
        }
        return present;
    }

    //(send/type)Text to field like name ,username or password
    public static void typeText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys((CharSequence) text);
    }

    //assertion by string variables
    public static void assertByGetTextByAttribute(String actualText, By by, String attributeValue) {
        Assert.assertEquals(actualText, getTextByAttributeValue(by, attributeValue));
    }

    private static String getTextByAttributeValue(By by, String attributeValue) {
        return attributeValue;
    }


    public void assertByGetText(By result, String your_registration_completed, String match_fail) {
    }

    //close Browser window
    public static void close() {
        driver.close();
    }

    //quit Browser window
    public static void quit() {
        driver.quit();
    }

    //assert by url
    public void assertUrl(String text) {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }

    //current Url
    public static void assertCurrentUrl(String url) {
        Assert.assertTrue(driver.getCurrentUrl().equals(url));

    }

    protected void enterElement(String email) {
    }

    protected void enterElements(String email) {
    }

    //Method for check product is arranging in ascending or High to Low
    // public static boolean ascendingOrHighToLowOrder(By by){
    // List<WebElement> productName_Webelememt = driver.findElements(by);

    // List<String> product_names = new ArrayList<~>();

    //for (WebElement e : productName_Webelememt)
    // {
    // String s = e.getText();
    // product_names.add(s);
    // }
    // boolean isSorted = Ordering.natural().isOrdered(product_names);
    //return isSorted;
    // }

}
