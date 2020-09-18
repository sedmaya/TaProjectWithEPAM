package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategorySearchResultPage extends BasePage {

    public CategorySearchResultPage() {

    }

    @FindBy(xpath = "(//a[@class='css-vh7bxp-PromoLink ett16tt7'])[1]/span")
    private WebElement searchedFirstMainNewsTittle;

    public String actualFieldArticleName() {
        waitForElementVisibility(30, searchedFirstMainNewsTittle);
        return searchedFirstMainNewsTittle.getText();
    }
}
