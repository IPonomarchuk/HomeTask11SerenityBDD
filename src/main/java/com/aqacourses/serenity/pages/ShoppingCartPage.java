package com.aqacourses.serenity.pages;

import java.math.BigDecimal;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends AbstractPage {

    // Web elements
    @FindBy(xpath = "//a[@title='Add']//span")
    private WebElement plusButton;

    @FindBy(xpath = "//td[@class='cart_unit']/span")
    private WebElement unitPrice;

    @FindBy(xpath = "//td[@class='cart_total']/span")
    private WebElement totalPrice;

    @FindBy(xpath = "//td[@class='cart_quantity text-center']/input[@type='hidden']")
    private WebElement quantityOfProducts;

    private String QUANTITY_OF_PRODUCTS_XPATH =
            "//td[@class='cart_quantity text-center']/input[@type='hidden']";

    @FindBy(xpath = "//i[@class='icon-trash']")
    private WebElement deleteButton;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement emptyShoppingCart;

    private final String MESSAGE_EMPTY_SHOPPING_CART = "Your shopping cart is empty.";

    /**
     * Constructor
     *
     * @param driver
     */
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    /** Increase quantity of product by one */
    public void increaseQuantityOfProductByOne() {
        WebElement quantityOfProducts =
                getDriver().findElement(By.xpath(QUANTITY_OF_PRODUCTS_XPATH));
        int intQuantity = Integer.parseInt(quantityOfProducts.getAttribute("value"));
        plusButton.click();
        System.out.println("Till wait - " + intQuantity);

        waitFor(
                ExpectedConditions.textToBePresentInElementValue(
                        By.xpath(QUANTITY_OF_PRODUCTS_XPATH), String.valueOf(intQuantity + 1)));
    }

    /** Validate total price */
    public void validateTotalPrice() {

        BigDecimal bigDecimalUnitPrice =
                new BigDecimal(unitPrice.getText().replaceAll("[^0-9,.]", ""));
        BigDecimal bigDecimalTotalPrice =
                new BigDecimal(totalPrice.getText().replaceAll("[^0-9,.]", ""));
        WebElement quantityOfProducts =
                getDriver().findElement(By.xpath(QUANTITY_OF_PRODUCTS_XPATH));
        int intQuantity = Integer.parseInt(quantityOfProducts.getAttribute("value"));
        System.out.println("After wait - " + intQuantity);
        Assert.assertEquals(
                "Total price isn't correct",
                bigDecimalTotalPrice,
                (bigDecimalUnitPrice.multiply(new BigDecimal(intQuantity))));
    }

    /** Delete product and verify that message is displayed */
    public void deleteProduct() {
        deleteButton.click();
        waitFor(emptyShoppingCart);
        Assert.assertEquals(
                "Message is not the same as expected",
                MESSAGE_EMPTY_SHOPPING_CART,
                emptyShoppingCart.getText());
    }
}
