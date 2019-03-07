package com.aqacourses.serenity.steps;

import com.aqacourses.serenity.pages.MyAccountPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class MyAccountPageSteps extends ScenarioSteps {
    private static final long serialVersionUID = 3153311621080689535L;

    /**
     * Constructor
     *
     * @param pages
     */
    public MyAccountPageSteps(Pages pages) {
        super(pages);
    }

    /**
     * Get My Account page
     *
     * @return
     */
    private MyAccountPage onMyAccountPage() {
        return pages().get(MyAccountPage.class);
    }

    /** Click on the "T-Shirts" button */
    @Step("User clicks on T-Shirts button")
    public void userClicksOnTShirtsButton() {
        onMyAccountPage().openTShirtsPage();
    }
}
