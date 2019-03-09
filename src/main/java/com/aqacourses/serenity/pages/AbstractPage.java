package com.aqacourses.serenity.pages;

import com.aqacourses.serenity.utils.YamlParser;
import java.util.List;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractPage extends PageObject {

    // Web Elements
    @FindBy(xpath = "//div/a[@class='login']")
    private WebElement signInLink;

    @FindBy(xpath = "//div/a[@class='logout']")
    private WebElement singOutButton;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li/a[@title='Dresses']")
    private WebElement dressesButton;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li/a[@title='T-shirts']")
    private WebElement tShirtsButton;

    @FindBy(xpath = "//div[@class='product-container']")
    protected List<WebElement> listOfProducts;

    @FindBy(xpath = "//span[@class='heading-counter']")
    protected WebElement counterOfProducts;

    @FindBy(xpath = "//div[@id='page']")
    protected WebElement divPage;

    private String PRODUCT_DETAIL_LINK_XPATH = "//h5/a[@title='%s']";

    /**
     * Constructor
     *
     * @param driver
     */
    public AbstractPage(WebDriver driver) {
        super(driver);
    }

    /** Maximize window and open site */
    public void openSite() {
        getDriver().manage().window().maximize();
        getDriver().get(YamlParser.getYamlData().getUrl());
    }

    /**
     * Click on the "Sign in" link
     *
     * @return new instance of LoginPage
     */
    public void clickSignInLink() {
        waitFor(signInLink);
        signInLink.click();
    }

    /**
     * Click on the "Sign out" button
     *
     * @return new instance of LoginPage
     */
    public void logout() {
        waitFor(singOutButton);
        singOutButton.click();
    }

    /**
     * Click on the "Dresses" button
     *
     * @return new instance of DressesPage
     */
    public void openDressesPage() {
        waitFor(dressesButton);
        dressesButton.click();
    }

    /**
     * Click on the "T-Shirts" button
     *
     * @return new instance of TShirtsPage
     */
    public void openTShirtsPage() {
        waitFor(tShirtsButton);
        tShirtsButton.click();
    }

    /**
     * Open the product
     *
     * @return new instance of ProductPage
     */
    public void openProductByTitle(String title) {

        getDriver().findElement(By.xpath(String.format(PRODUCT_DETAIL_LINK_XPATH, title))).click();
    }
}
