package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdminPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]/span")
    private WebElement adminButton;

    @FindBy(xpath = "//*[@id=\"list-item-395\"]/div[1]")
    private WebElement cities;

    @FindBy(xpath = "//*[@id=\"list-item-398\"]/div[2]")
    private WebElement users;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button")
    private WebElement createNewItem;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[5]/div/div/div[3]")
    private WebElement saveButton;

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(id = "edit")
    private WebElement editButton;

    @FindBy(id = "delete")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[3]/div[4]/button/span/i")
    private WebElement nextPage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]/text()")
    private WebElement messageSavedSuccessfuly;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]/text()")
    private WebElement messageDeletedSuccessfuly;


    public AdminPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }
}
