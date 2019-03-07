package com.aqacourses.serenity.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends AbstractPage {

    // User name
    private final String MY_NAME = "MyTestFirstName MyTestLastName";

    // Web elements
    @FindBy(xpath = "//div/a[@class='account']")
    private WebElement name;

    /**
     * Constructor
     *
     * @param driver
     */
    public MyAccountPage(WebDriver driver) {
        super(driver);
        waitFor(divPage);
    }

    /** Verify name */
    public void verifyName() {
        Assert.assertEquals("Name isn't correct", MY_NAME, name.getText());
    }
}
