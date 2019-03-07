package com.aqacourses.serenity.pages;

import org.openqa.selenium.WebDriver;

public class TShirtsPage extends AbstractPage {

    /**
     * Constructor
     *
     * @param driver
     */
    public TShirtsPage(WebDriver driver) {
        super(driver);
        waitFor(divPage);
    }
}
