package com.aqacourses.serenity.steps;

import com.aqacourses.serenity.pages.TShirtsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class TShirtsPageSteps extends ScenarioSteps {
    private static final long serialVersionUID = 7516032003621401582L;

    /**
     * Constructor
     *
     * @param pages
     */
    public TShirtsPageSteps(Pages pages) {
        super(pages);
    }

    /**
     * Get T-Shirts page
     *
     * @return
     */
    private TShirtsPage onTshirtsPage() {
        return pages().get(TShirtsPage.class);
    }

    /**
     * Open the product by title
     *
     * @param nameOfProduct
     */
    @Step("User clicks on product")
    public void userClicksOnProduct(String nameOfProduct) {
        onTshirtsPage().openProductByTitle(nameOfProduct);
    }
}
