package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.pages.GearPage;
import com.softwaretestingboard.magento.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GearTest extends TestBase {

    GearPage gear = new GearPage();


    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {

        // Mouse Hover on Gear Menu
        gear.mouseHoverOnGearMenu();
        // Click on Bags
        gear.clickOnBags();
        // Click on Product Name ‘Overnight Duffle’
        gear.clickOnBagProductName();
        // Verify the text ‘Overnight Duffle’
        Assert.assertEquals(gear.verifyTheTextOvernightDuffle(), "Overnight Duffle");
        // Change Qty 3
        gear.changeBagQuantity();
        // Click on ‘Add to Cart’ Button.
        gear.clickOnAddToCartButton();
        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        Assert.assertEquals(gear.verifyTextYouAdded_ProductNameMessage(), "You added Overnight Duffle to your shopping cart.");
        // Click on Product Name ‘Overnight Duffle’
        gear.clickOnShoppingCartInToMessage();
        // Verify the product name ‘Overnight Duffle’
        Assert.assertEquals(gear.verifyTheBagProductName(), "Overnight Duffle");
        //Verify the Qty is ‘3’
        Assert.assertEquals(gear.verifyTheProductQuantity(), "3");
        // Verify the product price ‘$135.00’
        Assert.assertEquals(gear.verifyTheProductPrice(), "$135.00");
        // Change Qty to ‘5’
        Thread.sleep(2000);
        gear.changeShoppingCartQuantity();
        // Click on ‘Update Shopping Cart’ button
        gear.updateShoppingCartButton();
        // Verify the product price ‘$225.00’
        Assert.assertEquals(gear.verifyTheFinalProductPrice(), "$225.00");

    }

}
