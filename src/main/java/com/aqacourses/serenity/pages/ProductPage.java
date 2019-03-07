package com.aqacourses.serenity.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    // Web elements
    @FindBy(xpath = "//div[@class='breadcrumb clearfix']")
    private WebElement fullBreadcrumb;

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckoutButton;

    /**
     * Constructor
     *
     * @param driver
     */
    public ProductPage(WebDriver driver) {
        super(driver);
        waitFor(divPage);
    }

    /** Verify breadcrumb on the ProductPage */
    public void verifyBreadcrumb(String breadcrumb) {
        String stringBreadcrumb = fullBreadcrumb.getText().replaceFirst("> ", "");
        Assert.assertEquals(
                "Breadcrumb isn't correct",
                breadcrumb,
                stringBreadcrumb.substring(0, stringBreadcrumb.lastIndexOf(">")));
    }

    /**
     * Add product to shopping cart and proceed to checkout
     *
     * @return new instance of ShoppingCartPage
     */
    public void addProductToShoppingCartAndProceedToCheckout() {
        waitFor(addToCartButton);
        addToCartButton.click();
        waitFor(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
    }
}
