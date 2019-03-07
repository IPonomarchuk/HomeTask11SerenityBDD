package com.aqacourses.serenity.steps;

import com.aqacourses.serenity.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginPageSteps extends ScenarioSteps {
    private static final long serialVersionUID = -5815437205739066737L;

    /**
     * Constructor
     *
     * @param pages
     */
    public LoginPageSteps(Pages pages) {
        super(pages);
    }

    /**
     * Get Login page
     *
     * @return
     */
    private LoginPage onLoginPage() {
        return pages().get(LoginPage.class);
    }

    /** Fill in email and password to login form and click on the "Sign in" button */
    @Step("User fills in email and password to login form and click on the \"Sign in\" button")
    public void userFillsInEmailAndPasswordToLoginFormAndClickOnTheSignInButton() {
        onLoginPage().login();
    }
}
