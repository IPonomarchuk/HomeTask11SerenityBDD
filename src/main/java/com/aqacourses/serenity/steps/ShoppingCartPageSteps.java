package com.aqacourses.serenity.steps;

import com.aqacourses.serenity.pages.ShoppingCartPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class ShoppingCartPageSteps extends ScenarioSteps {
    private static final long serialVersionUID = -6706462998071813255L;

    /**
     * Constructor
     *
     * @param pages
     */
    public ShoppingCartPageSteps(Pages pages) {
        super(pages);
    }

    /**
     * Get shopping page
     *
     * @return
     */
    private ShoppingCartPage onShoppingCartPage() {
        return pages().get(ShoppingCartPage.class);
    }

    /** Increase quantity of product by one */
    @Step("User clicks on plus button to increase quantity of product by one")
    public void userClicksOnPlusButtonToIncreaseQuantityOfProductByOne() {
        onShoppingCartPage().increaseQuantityOfProductByOne();
    }

    /** Validate total price */
    @Step("User validates the total price")
    public void userValidatesTheTotalPrice() {
        onShoppingCartPage().validateTotalPrice();
    }

    /** Delete product and verify that correct message is displayed */
    @Step("User deletes product and verifies that correct message is displayed")
    public void userDeletesProductAndVerifiesThatCorrectMessageIsDisplayed() {
        onShoppingCartPage().deleteProduct();
    }
}
