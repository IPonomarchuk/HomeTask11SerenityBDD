package com.aqacourses.serenity.pages;

import com.aqacourses.serenity.utils.YamlParser;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    // Title of the LoginPage
    private final String TITLE = "Login - My Store";

    // Web elements
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailTextField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement signInButton;

    /**
     * Constructor
     *
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        waitFor(divPage);
    }

    /** Verify LoginPage */
    public void verifyLoginPage() {
        Assert.assertEquals("Title is not as expected", TITLE, getDriver().getTitle());
    }

    /**
     * Fill in email and password to login form and click on the "Sign in" button
     *
     * @return new instance of MyAccountPage
     */
    public void login() {
        waitFor(emailTextField);
        emailTextField.sendKeys(YamlParser.getYamlData().getEmail());
        ;
        passwordTextField.sendKeys(YamlParser.getYamlData().getPassword());
        signInButton.click();
    }
}
