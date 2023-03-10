package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import java.time.Duration;
import java.util.List;

/*
Osnovna klasa koju svaki test da nasledjuje. Ova klasa treba da ima:
baseUrl - url stranice https://vue-demo.daniel-avellaneda.com
beforeClass - gde se podesava drajver sa implicitnim cekanjem i
cekanjem za ucitavanje stranice i kreiraju svi pagevi potrebni za
testiranje
aftterClass - gde se gasi stranica
beforeMethod - gde se pre svakog testa ucitava baseUrl stranica
Navedene su samo obavezne assertacije, po potrebi dodajte dodatne.
 */
public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected HomePage homePage;
    protected Faker faker = new Faker();
    protected final String VALIDEMAIL = "admin@admin.com";
    protected final String VALIDPASSWORD = "12345";
    protected final String BASEURL = "https://vue-demo.daniel-avellaneda.com";

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        homePage = new HomePage(driver, driverWait);
        faker = new Faker();
    }

    @BeforeMethod
    public void beforeTest() {
        driver.get(BASEURL);
        driver.manage().window().maximize();
    }

   @AfterMethod
   public void afterTest(){

        List<WebElement> logoutButton = driver.findElements(By.className("btnLogout"));
        if(!logoutButton.isEmpty()) {
            logoutButton.get(0).click();
       }
   }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

