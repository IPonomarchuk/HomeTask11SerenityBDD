package com.aqacourses.serenity.steps;

import com.aqacourses.serenity.pages.ProductPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class ProductPageSteps extends ScenarioSteps {
    private static final long serialVersionUID = 2039429426548289341L;

    /**
     * Constructor
     *
     * @param pages
     */
    public ProductPageSteps(Pages pages) {
        super(pages);
    }

    /**
     * Get Product page
     *
     * @return
     */
    private ProductPage onProductPage() {
        return pages().get(ProductPage.class);
    }

    /**
     * Verify breadcrumb
     *
     * @param actualBreadcrumb
     */
    @Step("Verify breadcrumb")
    public void verifyBreadcrumb(String actualBreadcrumb) {
        onProductPage().verifyBreadcrumb(actualBreadcrumb);
    }

    /** Add product to shopping cart and proceed to checkout */
    @Step("User clicks on Add to cart button and then clicks on Proceed to checkout button")
    public void userClicksOnAddToCartButtonAndThenClicksOnProceedToCheckoutButton() {
        onProductPage().addProductToShoppingCartAndProceedToCheckout();
    }
}
