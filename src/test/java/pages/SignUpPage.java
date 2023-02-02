package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {

    @FindBy(id = "name")
    private WebElement name;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span")
    private WebElement signMeUpButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")
    private WebElement messageUserAlreadyExists;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[1]")
    private WebElement messageVerifyAccount;

    public WebElement getMessageVerifyAccount() {
        return messageVerifyAccount;
    }

    public String getEmail() {
        return email.getAttribute("type");
    }

    public String getPassword() {
        return password.getAttribute("type");
    }

    public String getConfirmPassword() {
        return confirmPassword.getAttribute("type");
    }

    public SignUpPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public WebElement getMessageUserAlreadyExists() {
        return messageUserAlreadyExists;
    }

    public void signUp(String name, String email, String password, String confirmPassword) {
        this.name.clear();
        this.name.sendKeys(name);

        this.email.clear();
        this.email.sendKeys(email);

        this.password.clear();
        this.password.sendKeys(password);

        this.confirmPassword.clear();
        this.confirmPassword.sendKeys(confirmPassword);

        this.signMeUpButton.click();
    }
}
