
package com.epam.ta.test;

import com.epam.ta.page.CategorySearchResultPage;
import com.epam.ta.page.HomePage;
import com.epam.ta.page.NewsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewsPageTests extends CommonConditions {

    @BeforeMethod
    public void goToNewsTab() {
        getHomePage.clickNewsTab();
    }

    HomePage getHomePage = new HomePage(driver);
    NewsPage getNewsPage = new NewsPage(driver);
    CategorySearchResultPage getCategorySearchResultPage = new CategorySearchResultPage(driver);

    @Test
    public void checkMainNewsTitle() {
        waitForElementVisibility(WAIT_TIMEOUT_SECONDS,getNewsPage.getHeadlineNewsTitle());
        Assert.assertEquals(getNewsPage.getHeadlineNewsTitleText(), "Half a million flee 'unprecedented' Oregon fires");
    }

    @Test
    public void checkSecondaryNewsTitles() {

        waitForElementVisibility(WAIT_TIMEOUT_SECONDS, getNewsPage.getHeadlineNewsTitle());
        List<String> actualSecondaryArticlesTitlesList = new ArrayList<>();
        List<WebElement> elementList = getNewsPage.getSecondaryNewsTitlesList();
        for (WebElement element : elementList) {
            actualSecondaryArticlesTitlesList.add(element.getText());
        }

        Assert.assertEquals(actualSecondaryArticlesTitlesList, Arrays.asList(
                "EU ultimatum to UK over Brexit talks",
                "Deadly wildfires rage up and down US West Coast",
                "Trump denies lying about risks of coronavirus",
                "Actress Dame Diana Rigg dies aged 82",
                "'It's like night-time in the daytime'"));
    }

    @Test
    public void checkFirstArticleTitle() {

        waitForElementIsClickable(WAIT_TIMEOUT_SECONDS, getNewsPage.getHeadlineNewsCategoryLink());
        String searchKeys = getNewsPage.getHeadlineNewsCategoryLinkText();
        getNewsPage.searchByHeadlineNewsCategory(searchKeys);
        Assert.assertEquals(getCategorySearchResultPage.getSearchedMainNewsTittle(), "Americans, go home: Tension at Canada-US border");
    }
}
