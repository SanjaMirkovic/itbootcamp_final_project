package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProfilePage extends BasePage {

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "urlTwitter")
    private WebElement twitter;
    @FindBy(id = "urlGitHub")
    private WebElement github;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button/span")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement messageSuccessfulySaved;
    @FindBy(className = "v-snack__content")
    private WebElement message;

    public WebElement getMessage() {
        return message;
    }

    public ProfilePage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getMessageSuccessfulySaved() {
        return messageSuccessfulySaved;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getTwitter() {
        return twitter;
    }

    public WebElement getGithub() {
        return github;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public void selectCity(String city){
        Select selectCity = new Select(this.city);
        selectCity.selectByVisibleText(city);
    }

    public void editMyProfile (String name, String phone, String country, String twitter, String github){
        this.name.clear();
        this.name.sendKeys(name);

        this.phone.clear();
        this.phone.sendKeys(phone);

        this.country.clear();
        this.country.sendKeys(country);

        this.twitter.clear();
        this.twitter.sendKeys(twitter);

        this.github.clear();
        this.github.sendKeys(github);

        saveButton.click();
    }

}