package com.aqacourses.serenity.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DressesPage extends AbstractPage {

    // Web elements
    @FindBy(xpath = "//div[@class='block_content']//li/a[contains(text(),'Summer Dresses')]")
    private WebElement summerDressesButton;

    @FindBy(xpath = "//input[@id='layered_id_attribute_group_8'][@style='background: #ffffff;']")
    private WebElement whiteCheckBox;

    @FindBy(xpath = "//span[@class='cat-name'][contains(text(),'Summer Dresses > Color White')]")
    private WebElement whiteColorFilter;

    /**
     * Constructor
     *
     * @param driver
     */
    public DressesPage(WebDriver driver) {
        super(driver);
        waitFor(divPage);
    }

    /**
     * Click on the "Summer Dresses" button
     *
     * @return new instance of SummerDressesPage
     */
    public void chooseSummerDressesCategory() {
        waitFor(summerDressesButton);
        summerDressesButton.click();
    }

    /** Click on the "White" checkbox */
    public void chooseWhiteDresses() {
        waitFor(whiteCheckBox);
        whiteCheckBox.click();
        waitFor(whiteColorFilter);
    }

    /** Verify that quantity of products on the page is the same as in the message */
    public void verifyQuantityOfProducts() {

        waitFor(counterOfProducts);
        Assert.assertEquals(
                "Quantity of products on the page is not the same as in the message",
                listOfProducts.size(),
                Integer.parseInt(counterOfProducts.getText().replaceAll("[\\D]", "")));
    }
}
