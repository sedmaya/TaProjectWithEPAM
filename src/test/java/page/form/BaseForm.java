package page.form;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Map;

public abstract class BaseForm {

    protected WebElement formComplexElement;
    protected WebElement submitButton;

    public BaseForm(WebElement formComplexElement) {
        this.formComplexElement = formComplexElement;
        submitButton = formComplexElement.findElement(By.xpath("//button[text()='Submit']"));

    }

    public void FillShareWithBBCInputs(Map<String, String> placeholderValues) {
        for (Map.Entry<String, String> keyValue : placeholderValues.entrySet()) {
            WebElement fieldName = findPlaceholderChild(keyValue.getKey());
            fieldName.sendKeys(keyValue.getValue(), Keys.ENTER);
        }
    }

    public WebElement findPlaceholderChild(String value) {
        return formComplexElement.findElement(By.xpath("//*[@placeholder= '" + value + "']"));
    }

    public boolean isSubmitButtonEnabled() {
        return submitButton.isEnabled();
    }
}


