package com.aqacourses.serenity.tests;

import com.aqacourses.serenity.steps.*;
import com.aqacourses.serenity.utils.Categories;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

// Serenity runner
@RunWith(SerenityRunner.class)
public class ShoppingCartTest {

    // If you need you can use driver
    @Managed WebDriver driver;

    // Also you can use pages
    @ManagedPages Pages pages;

    // Steps
    @Steps HomePageSteps homePageSteps;
    @Steps LoginPageSteps loginPageSteps;
    @Steps MyAccountPageSteps myAccountPageSteps;
    @Steps TShirtsPageSteps tShirtsPageSteps;
    @Steps ProductPageSteps productPageSteps;
    @Steps ShoppingCartPageSteps shoppingCartPageSteps;

    @Test
    public void testShoppingCartTest() {

        // Open site
        homePageSteps.userOpensSiteAndGetsHomePage();
        // Click on the "Sign in" link
        homePageSteps.userClicksOnSingInButtonAndProceedToLoginPage();
        // Fill in email and password to login form and click on the "Sign in" button
        loginPageSteps.userFillsInEmailAndPasswordToLoginFormAndClickOnTheSignInButton();
        // Open TShirtsPage
        myAccountPageSteps.userClicksOnTShirtsButton();
        // Open the product
        tShirtsPageSteps.userClicksOnProduct("Faded Short Sleeve T-shirts");
        // Verify breadcrumb
        productPageSteps.verifyBreadcrumb(
                Categories.WOMEN.toString() + ">" + Categories.TOPS + ">" + Categories.TSHIRTS);
        // Add product to shopping cart and proceed to checkout
        productPageSteps.userClicksOnAddToCartButtonAndThenClicksOnProceedToCheckoutButton();
        // Increase quantity of product by one
        shoppingCartPageSteps.userClicksOnPlusButtonToIncreaseQuantityOfProductByOne();
        // Validate total price
        shoppingCartPageSteps.userValidatesTheTotalPrice();
        // Delete product and verify that message is displayed
        shoppingCartPageSteps.userDeletesProductAndVerifiesThatCorrectMessageIsDisplayed();
    }
}
