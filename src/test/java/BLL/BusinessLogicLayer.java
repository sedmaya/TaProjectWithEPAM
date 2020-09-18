package BLL;

import page.CategorySearchResultPage;
import page.HomePage;
import page.NewsPage;
import page.ShareWithBBCPage;

import java.util.List;

public class BusinessLogicLayer {

    private HomePage homePage;
    private NewsPage newsPage;
    private ShareWithBBCPage shareWithBBCPage;

    public BusinessLogicLayer() {
        homePage = new HomePage();
        newsPage = new NewsPage();
        shareWithBBCPage = new ShareWithBBCPage();
    }

    public void goToNewsPage() {
        homePage.goToNewsPage();
    }

    public String actualHeadlineNewsTitle() {
        return newsPage.actualHeadlineNewsTitle();
    }

    public List<String> getSecondaryNewsTitlesList() {
        return newsPage.getSecondaryNewsTitlesList();
    }

    public CategorySearchResultPage goToCategorySearchResultsPage() {
        return newsPage.goToCategorySearchResultsPage();
    }

    public void goToShareYourStoryPage() {
        homePage.goToNewsPage();
        newsPage
                .signInPopUpHandle()
                .goToCoronavirusTab()
                .goToYourCoronavirusStoryPage()
                .goToShareWithBBCPage();

        shareWithBBCPage.InitForm();
    }

    public void fillFormWithEmptyStoryField() {
        shareWithBBCPage.fillFormWithEmptyStoryField();
    }

    public void fillFormWithEmptyNameField() {
        shareWithBBCPage.fillFormWithEmptyNameField();
    }

    public void fillFormWithInvalidEmail() {
        shareWithBBCPage.fillFormWithInvalidEmail();
    }

    public void fillFormWithUncheckedAcceptTerms() {
        shareWithBBCPage.fillFormWithUncheckedAcceptTerms();
    }

    public void fillFormWithUncheckedIAmOver16() {
        shareWithBBCPage.fillFormWithUncheckedIAmOver16();
    }

    public boolean isShareWithBBCFormValid() {
        return shareWithBBCPage.isFormValid();
    }

}
