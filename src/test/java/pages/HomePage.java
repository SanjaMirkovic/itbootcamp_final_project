package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(className = "bmc-button")
    private WebElement bmcButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/button/span/i")
    private WebElement languageButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[2]")
    private WebElement aboutButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]/span")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]/span")
    private WebElement signUpButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/span/button/span/i")
    private WebElement leftSidebar;


    public HomePage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public WebElement getBmcButton() {
        return bmcButton;
    }

    public WebElement getLanguageButton() {
        return languageButton;
    }

    public WebElement getAboutButton() {
        return aboutButton;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public WebElement getLeftSidebar() {
        return leftSidebar;
    }
}