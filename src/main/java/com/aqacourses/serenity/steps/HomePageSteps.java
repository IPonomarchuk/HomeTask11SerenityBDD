package com.aqacourses.serenity.steps;

import com.aqacourses.serenity.pages.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class HomePageSteps extends ScenarioSteps {

    private static final long serialVersionUID = 5204230629603996554L;

    /**
     * Constructor
     *
     * @param pages
     */
    public HomePageSteps(Pages pages) {
        super(pages);
    }

    /**
     * Get home page
     *
     * @return
     */
    private HomePage onHomePage() {
        return pages().get(HomePage.class);
    }

    /** Open site */
    @Step("User opens site and gets Home page")
    public void userOpensSiteAndGetsHomePage() {
        onHomePage().openSite();
    }

    @Step("User clicks on sing in link and proceed to Login page")
    public void userClicksOnSingInButtonAndProceedToLoginPage() {
        onHomePage().clickSignInLink();
    }
}
