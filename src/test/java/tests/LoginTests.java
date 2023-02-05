package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

/*
Test #1: Visits the login page
assert:
Verifikovati da se u url-u stranice javlja ruta /login

Test #2: Checks input types
assert:
Verifikovati da polje za unos emaila za atribut type ima vrednost
email
Verifikovati da polje za unos lozinke za atribut type ima vrednost
password

Test #3: Displays errors when user does not exist
Podaci: random email i password koristeći faker libarary
asssert:
Verifikovati da greska sadrzi poruku User does not exists
Verifikovati da se u url-u stranice javlja /login ruta

Test #4: Displays errors when password is wrong
Podaci: email: admin@admin.com i proizvoljan password
asssert:
Verifikovati da greska sadrzi poruku Wrong password
Verifikovati da se u url-u stranice javlja /login ruta

Test #5: Login
Podaci:
email: admin@admin.com
password: 12345
asssert:
Verifikovati da se u url-u stranice javlja /home ruta

Test #6: Logout
assert:
Verifikovati da je dugme logout vidljivo na stranici
Verifikovati da se u url-u stranice javlja /login ruta
Verifikovati da se nakon pokušaja otvaranja /home rute, u url-u
stranice javlja /login ruta (otvoriti sa driver.get home page i proveriti
da li vas redirektuje na login)
 */
import com.github.javafaker.Faker;

import java.time.Duration;

public class LoginTests extends BaseTest {

    private LoginPage loginPage;
    private final String VALIDEMAIL = "admin@admin.com";
    private final String VALIDPASSWORD = "12345";

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeTest() {
        super.beforeTest();
        homePage.getLoginButton().click();
    }

    @Test(priority = 1)
    public void testLoginUrl (){
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void testEmailAndPasswordField () {
        Assert.assertEquals(loginPage.getEmail().getAttribute("type"), "email");
        Assert.assertEquals(loginPage.getPassword().getAttribute("type"), "password");
    }

    @Test
    public void testErrorMessageUserDoNotExists(){
        Faker faker = new Faker();
        loginPage.logIn(faker.internet().emailAddress(), faker.internet().password());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "User does not exists");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void testErrorMessageWrongPassword(){
        loginPage.logIn(VALIDEMAIL, "1234567");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Wrong password");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    private void testLoginAdmin (){
        loginPage.logIn(VALIDEMAIL, VALIDPASSWORD);
        driverWait.until(ExpectedConditions.urlContains("/home"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
    }

    @Test
    private void testLogout(){
        loginPage.logIn(VALIDEMAIL, VALIDPASSWORD);
        WebElement logoutButton = driver.findElement(By.className("btnLogout"));
        Assert.assertTrue(logoutButton.isDisplayed());
        logoutButton.click();
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

}


