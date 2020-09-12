package com.epam.ta.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewsPage extends BasePage {
    private final String PAGE_URL = "https://www.bbc.com/news";

    public NewsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[contains(@class, 'gs-u-display-inline-block@m')]//h3")
    private WebElement headlineNewsTitle;

    @FindBy(id = "sign_in")
    private WebElement signInPopUp;

    @FindBy(xpath = " //div[@class='sign_in-container']/button[@aria-label='close']")
    private WebElement signInPopUpCloseButton;

    @FindBy(xpath = "//div[contains(@class,'secondary-item')]//h3")
    private List<WebElement> secondaryNewsTitles;

    @FindBy(xpath = "//div[contains(@class,'gs-u-display-inline-block@m')]//a[contains(@class, 'nw-c-section-link')]//span[text()]")
    private WebElement headlineNewsCategoryLink;

    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchBar;

    @FindBy(xpath = "//nav[@class='nw-c-nav__wide']//span[.='Coronavirus']")
    private WebElement coronavirusNewsNavigationTab;


    public WebElement getHeadlineNewsTitle() {
        return headlineNewsTitle;
    }

    public String getHeadlineNewsTitleText() {
        return headlineNewsTitle.getText();
    }

    public List<WebElement> getSecondaryNewsTitlesList() {
        return secondaryNewsTitles;
    }

    public WebElement getHeadlineNewsCategoryLink() {
        return headlineNewsCategoryLink;
    }

    public String getHeadlineNewsCategoryLinkText() {
        return headlineNewsCategoryLink.getText();
    }

    public void searchByHeadlineNewsCategory(String keyword) {
        searchBar.sendKeys(keyword, Keys.ENTER);
    }

    public WebElement getSignInPopUp() {
        return signInPopUp;
    }

    public void clickSignInPopUpCloseButton() {
        signInPopUpCloseButton.click();
    }

    public WebElement getCoronavirusNewsNavigationTab() {
        return coronavirusNewsNavigationTab;
    }

    public void clickCoronavirusNewsNavigationTab() {
        coronavirusNewsNavigationTab.click();
    }

  @Override
    public NewsPage openPage()
    {
        driver.navigate().to(PAGE_URL);
        return this;
    }

}
