package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.form.ShareWithBBCForm;
import util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShareWithBBCPage extends BasePage {

    private static final int FORM_EMPTY_FIELD = 0;
    private static final int FORM_FIELD_TEXT_LENGTH = 9;
    private ShareWithBBCForm formSubmit;

    public ShareWithBBCPage() {
    }

    HashMap<String, String> formFieldsData = new HashMap<>();
    List<String> checkboxNamesToBeClicked = new ArrayList<>();

    @FindBy(xpath = "//div[@class='embed-content-container']")
    protected WebElement formComplexElement;

    @FindBy(xpath = "//textarea[@placeholder='Tell us your story. ']")
    private WebElement tellYourStoryField;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement yourNameContactInfoField;

    @FindBy(xpath = "//input[@placeholder='Email address']")
    private WebElement yourEmailContactInfoField;

    @FindBy(xpath = "//span//*[text() = 'I am over 16 years old']")
    private WebElement iAmOver16Checkbox;

    @FindBy(xpath = "//span//*[text() = 'Terms of Service']")
    private WebElement iAcceptTermsCheckbox;

    public WebElement getFormComplexElement() {
        waitForElementVisibility(WAIT_TIMEOUT_SECONDS, formComplexElement);
        return formComplexElement;
    }

    public void InitForm() {
        formSubmit = new ShareWithBBCForm(getFormComplexElement());
    }

    public boolean isFormValid() {
        return formSubmit.isSubmitButtonEnabled();
    }

    public String getIAmOver16CheckboxTextLabel() {
        waitForElementVisibility(WAIT_TIMEOUT_SECONDS, iAmOver16Checkbox);
        return iAmOver16Checkbox.getText();
    }

    public String getIAcceptTermsTextLabel() {
        waitForElementVisibility(WAIT_TIMEOUT_SECONDS, iAcceptTermsCheckbox);
        return iAcceptTermsCheckbox.getText();
    }

    public void fillFormWithEmptyStoryField() {

        formFieldsData.put("Tell us your story. ", StringUtils.generateRandomStringWithSetLength(FORM_EMPTY_FIELD));
        formFieldsData.put("Name", StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        checkboxNamesToBeClicked.add(getIAmOver16CheckboxTextLabel());
        checkboxNamesToBeClicked.add(getIAcceptTermsTextLabel());
        setFormSubmit();

    }

    public void fillFormWithEmptyNameField() {

        formFieldsData.put("Tell us your story. ", StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        formFieldsData.put("Name", StringUtils.generateRandomStringWithSetLength(FORM_EMPTY_FIELD));
        checkboxNamesToBeClicked.add(getIAmOver16CheckboxTextLabel());
        checkboxNamesToBeClicked.add(getIAcceptTermsTextLabel());
        setFormSubmit();

    }

    public void fillFormWithInvalidEmail() {

        formFieldsData.put("Tell us your story. ", StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        formFieldsData.put("Name", StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        formFieldsData.put("Email address", StringUtils.generateRandomInvalidEmailWithSetLength(FORM_FIELD_TEXT_LENGTH));
        checkboxNamesToBeClicked.add(getIAmOver16CheckboxTextLabel());
        checkboxNamesToBeClicked.add(getIAcceptTermsTextLabel());
        setFormSubmit();

    }

    public void fillFormWithUncheckedAcceptTerms() {

        formFieldsData.put("Tell us your story. ", StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        formFieldsData.put("Name", StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        checkboxNamesToBeClicked.add(getIAmOver16CheckboxTextLabel());
        setFormSubmit();

    }

    public void fillFormWithUncheckedIAmOver16() {

        formFieldsData.put("Tell us your story. ", StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        formFieldsData.put("Name", StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        checkboxNamesToBeClicked.add(getIAcceptTermsTextLabel());
        setFormSubmit();

    }

    public void setFormSubmit() {
        formSubmit.FillShareWithBBCInputs(formFieldsData);
        formSubmit.ClickCheckBoxes(checkboxNamesToBeClicked);
        formSubmit.ClickSubmitStoryButton();
    }
}
