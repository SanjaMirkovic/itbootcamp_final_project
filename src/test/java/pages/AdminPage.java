package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdminPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button")
    private WebElement createNewItem;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]/span")
    private WebElement saveButton;

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(id = "edit")
    private WebElement editButton;

    @FindBy(id = "delete")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement errorMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]")
    private WebElement cityNameField;
    @FindBy(className = "v-btn__content")
    private WebElement dialogButton;

    public WebElement getDialogButton() {
        return dialogButton;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public AdminPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public void createNewCity(String name) {
        this.createNewItem.click();
        this.nameField.sendKeys(Keys.CONTROL + "a");
        this.nameField.sendKeys(Keys.DELETE);
        this.nameField.sendKeys(name);
        this.saveButton.click();
    }

    public void editCity(String name) {
        this.editButton.click();
        this.nameField.clear();
        this.nameField.sendKeys(name + " edited");
        this.saveButton.click();
    }

}
