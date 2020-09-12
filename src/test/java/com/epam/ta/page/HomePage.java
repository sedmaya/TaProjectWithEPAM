package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {

    private static final String BASE_URL = "https://www.bbc.com";

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@id='orb-nav-links']//a[.='News']")
    private WebElement newsTab;

    public void clickNewsTab() {
        newsTab.click();
    }

    @Override
    public HomePage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

}
