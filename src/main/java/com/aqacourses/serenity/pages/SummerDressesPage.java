package com.aqacourses.serenity.pages;

import org.openqa.selenium.WebDriver;

public class SummerDressesPage extends DressesPage {

    /**
     * Constructor
     *
     * @param driver
     */
    public SummerDressesPage(WebDriver driver) {
        super(driver);
        waitFor(divPage);
    }
}
