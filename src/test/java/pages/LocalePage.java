package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalePage extends BasePage{

    @FindBy(xpath = "//*[@id=\"list-item-75\"]/div")
    private WebElement es;
    @FindBy(xpath = "//*[@id=\"list-item-73\"]/div")
    private WebElement en;
    @FindBy(xpath = "//*[@id=\"list-item-77\"]/div")
    private WebElement fr;

    public WebElement getEs() {
        return es;
    }
    public WebElement getEn() {
        return en;
    }

    public WebElement getFr() {
        return fr;
    }

    public LocalePage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

}
