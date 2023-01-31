package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait driverWait;

    public BasePage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.driver = webDriver;
        this.driverWait = webDriverWait;
        PageFactory.initElements(this.driver, this);
    }
}
