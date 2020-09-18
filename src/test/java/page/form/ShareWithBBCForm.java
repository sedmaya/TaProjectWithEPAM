package page.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShareWithBBCForm extends BaseForm {

    public ShareWithBBCForm(WebElement formComplexElement) {
        super(formComplexElement);
    }

    public void ClickCheckBoxes(List<String> checkboxesToBeClicked) {
        for (String checkBoxLabel : checkboxesToBeClicked) {
            WebElement checkBox = formComplexElement.findElement(By.xpath("//span//*[text() = '" + checkBoxLabel + "']//preceding::input[1]"));
            checkBox.click();
        }
    }

    public void ClickSubmitStoryButton() {
        submitButton.click();
    }
}
