package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategorySearchResultPage extends BasePage {

    private final String PAGE_URL = "https://www.bbc.co.uk/search";

    public CategorySearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "(//a[@class='css-vh7bxp-PromoLink ett16tt7'])[1]/span")
    private WebElement searchedFirstMainNewsTittle;

    public String getSearchedMainNewsTittle() {
        return searchedFirstMainNewsTittle.getText();
    }

    @Override
    public CategorySearchResultPage openPage()
    {
        driver.navigate().to(PAGE_URL);
        return this;
    }

}
