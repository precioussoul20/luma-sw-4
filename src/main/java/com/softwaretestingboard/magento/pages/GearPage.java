package com.softwaretestingboard.magento.pages;

import com.softwaretestingboard.magento.utilities.Utility;
import org.openqa.selenium.By;

public class GearPage extends Utility {
    By gearMenu = By.xpath("//span[normalize-space()='Gear']");
    By clickOnBags = By.xpath("//span[normalize-space()='Bags']");
    By textOvernightDuffle = By.xpath("//span[@class='base']");
    By bagQuantity = By.xpath("//input[@id='qty']");
    By addToCartButton = By.xpath("//button[@id='product-addtocart-button']");
    By youAdded_ProductTextMessage = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    By shoppingCart = By.xpath("//a[normalize-space()='shopping cart']");
    By verifyTextShoppingCart = By.xpath("//span[@class='base']");
    By bagProductName = By.xpath("//a[normalize-space()='Overnight Duffle']");
    By productName = By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']");
    By verifyProductName = By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']");
    By verifyProductQuantity = By.xpath("//input[@title='Qty']");
    By verifyProductPrice = By.xpath("(//span[@class='cart-price']//span)[2]");
    By changeQuantity = By.xpath("(//input[@class='input-text qty'])[1]");
    By shoppingCartButton = By.xpath("//span[normalize-space()='Update Shopping Cart']");
    By newProductPrice = By.xpath("(//span[@class='cart-price']//span)[2]");

    public void mouseHoverOnGearMenu() throws InterruptedException {
        Thread.sleep(2000);
        mouseHoverToElement(gearMenu);
    }
    public void clickOnBags() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(clickOnBags);
    }
    public String verifyTheTextOvernightDuffle() {
        return getTextFromElement(textOvernightDuffle);
    }
    public void changeBagQuantity() {
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sentTextToElement(bagQuantity, "3");
    }
    public void clickOnAddToCartButton() {
        mouseHoverToElementAndClick(addToCartButton);
    }
    public String verifyTextYouAdded_ProductNameMessage() {
        return getTextFromElement(youAdded_ProductTextMessage);
    }
    public void clickOnShoppingCartInToMessage() {
        clickOnElement(shoppingCart);
    }
    public String verifyTextShoppingCart() {
        return getTextFromElement(verifyTextShoppingCart);
    }
    public String verifyTheProductName() {
        return getTextFromElement(productName);
    }
    public String verifyTheBagProductName() {
        return getTextFromElement(verifyProductName);
    }
    public String verifyTheProductQuantity()  {
        return getTextFromElement(verifyProductQuantity);
    }

    public String verifyTheProductPrice() {
        return getTextFromElement(verifyProductPrice);
    }
    public void changeShoppingCartQuantity(){
        sentTextToElement(changeQuantity, "5");
    }
    public void updateShoppingCartButton(){
        clickOnElement(shoppingCartButton);
    }
    public String verifyTheFinalProductPrice() throws InterruptedException {
        Thread.sleep(2000);
        return getTextFromElement(newProductPrice);
    }
    public void clickOnBagProductName() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(bagProductName);
    }

}
