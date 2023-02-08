package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement messageSuccessfulySaved;

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

    public void clearAllFields(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.name.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        this.phone.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        this.city.sendKeys(Keys.SPACE, Keys.CONTROL + "a", Keys.DELETE);
        this.country.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        this.twitter.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        this.github.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
    }

    public void editMyProfile (String name, String phone, String city, String country, String twitter, String github){
       clearAllFields();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.name.sendKeys(name);
        this.phone.sendKeys(phone);
        this.city.sendKeys(Keys.ENTER, city, Keys.ARROW_DOWN, Keys.ENTER);
        this.country.sendKeys(country);
        this.twitter.sendKeys(twitter);
        this.github.sendKeys(github);
        this.saveButton.click();
    }

}
