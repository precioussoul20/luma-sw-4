package com.softwaretestingboard.magento.utilities;

import com.softwaretestingboard.magento.browserfactory.ManageBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.*;
import java.util.function.Function;

public class Utility extends ManageBrowser {

    // This method will click on element
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
    }

    // This method will send text on element
    public void sentTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    // This method will get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //************************************************* Alerts Methods *************************************************

    // This method will switch to alert
    public void switchAlert() {
        driver.switchTo().alert();
    }

    // This method will accept alert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    // This method will dismiss alert
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    // This method will get text from alert
    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    // This method will send text from text
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //****************************************  Select Class Methods ********************************************

    // This method will select the option by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    // This method will select the option by value
    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
    }

    // This method will select the option by index
    public void selectByIndexFromDropDown(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);
    }

    // This method will select the option by contains text
    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }

    // **************************************  Window Handle Methods **************************************************

    // This method will close all windows
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    // This method will switch to parent window
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    // This method will find that we switch to right window
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }

    //****************************************** Action Methods  **************************************************

    // This method will use to hover mouse on element
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    // This method will use to hover mouse on element and click
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    //**************************************  Waits Methods  ********************************************************

    // This method will use to wait until VisibilityOfElementLocated
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    //****************************************** ScreenShot Methods **********************************************

    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    public static String takeScreenShot(String fileName) {
        String filepath = System.getProperty("user.dir") + "/test-outout/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filepath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    //**********************************************************************************************************

    public void verifyFinalPrice(By by) {
        List<WebElement> originalList = findElementsFromWebPage(by);
        List<Double> originalProductPriceList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductPriceList.add(Double.valueOf(product.getText().replace("$", "")));
        }
        System.out.println("Before Sorting: " + originalProductPriceList);
        List<WebElement> afterSortingList = findElementsFromWebPage(by);
        List<Double> afterSortingProductPrice = new ArrayList<>();
        for (WebElement product : afterSortingList) {
            afterSortingProductPrice.add(Double.valueOf(product.getText().replace("$", "")));
        }
        Collections.sort(originalProductPriceList);
        System.out.println("After Sorting: " + afterSortingProductPrice);
        // Assert.assertEquals(originalProductPriceList, afterSortingProductPrice,"Error");
    }

    private List<WebElement> findElementsFromWebPage(By by) {
        return null;
    }


    public void verifyProductSize(By by) {
        List<WebElement> elementList = findElementsFromWebPage(by);
        System.out.println("Total elements are : " + elementList.size());
    }
    public void elementFilter(By by){
        List<WebElement> elementListDisplay = findElementsFromWebPage(by);
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product : elementListDisplay) {

            originalProductNameList.add(product.getText());
        }
        Collections.sort(originalProductNameList);
        System.out.println(originalProductNameList + "\n");
        List<WebElement> afterSortingElementList = findElementsFromWebPage(by);
        List<String> afterSortingProductName = new ArrayList<>();
        for (WebElement product : afterSortingElementList) {
            afterSortingProductName.add(product.getText());
        }
        System.out.println(afterSortingProductName);
        //Assert.assertEquals(originalProductNameList,afterSortingProductName,"Not sorted in Alphabetical order");
    }


    public String getAttributeValue(By by,String name){
        return driver.findElement(by).getAttribute(name);
    }
}
