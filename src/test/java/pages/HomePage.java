package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/button/span/i")
    private WebElement languageButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]/span")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]/span")
    private WebElement signUpButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]")
    private WebElement myProfile;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]")
    private WebElement adminButton;

    @FindBy(className = "v-list-item__title")
    private WebElement cities;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement title;

    @FindBy(className = "btnClose")
    private WebElement closeButton;

    public WebElement getCloseButton() {
        return closeButton;
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getCities() {
        return cities;
    }

    public WebElement getAdminButton() {
        return adminButton;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getMyProfile() {
        return myProfile;
    }

    public WebElement getLanguageButton() {
        return languageButton;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public HomePage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

}
