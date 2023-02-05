package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LocalePage;
import pages.LoginPage;
import pages.ProfilePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/*
Test #1: Visits the admin cities page and list cities
Podaci:
admin email: admin@admin.com
admin password: 12345
assert:
Verifikovati da se u url-u stranice javlja /admin/cities ruta
Verifikovati postojanje logout dugmeta

Test #2: Create new city
Podaci: random grad korisćenjem faker library-ja
assert:
Verifikovati da poruka sadrzi tekst Saved successfully


Test #3: Edit city
Podaci: edituje se grad koji je u testu 2 kreiran na isto ime + - edited
(primer: Beograd – Beograd edited)
assert:
Verifikovati da poruka sadrzi tekst Saved successfully

Test #4: Search city
Podaci: editovani grad iz testa #3
assert:
Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage

Test #5: Delete city
Podaci: editovani grad iz testa #3
assert:
U polje za pretragu uneti staro ime grada
Sacekati da broj redova u tabeli bude 1
Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
Kliknuti na dugme Delete iz prvog reda
Sacekati da se dijalog za brisanje pojavi
Kliknuti na dugme Delete iz dijaloga
Sacekati da popu za prikaz poruke bude vidljiv
Verifikovati da poruka sadrzi tekst Deleted successfully
 */
public class AdminCitiesTests extends BaseTest {

    private AdminPage adminPage;
    private LoginPage loginPage;
    Faker faker = new Faker();
    private String city = faker.address().city();


    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        adminPage = new AdminPage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeTest() {
        super.beforeTest();
        homePage.getLoginButton().click();
        loginPage.logIn("admin@admin.com", "12345");
        homePage.getAdminButton().click();
        homePage.getCities().click();
    }

    @Test
    public void testAdminPagesAndLists() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
    }

    @Test
    public void testCreateNewCity() {
        adminPage.createNewCity(city);
        driverWait.until(ExpectedConditions.elementToBeClickable(adminPage.getSaveButton()));
        driverWait.until(ExpectedConditions.textToBePresentInElement(adminPage.getErrorMessage(),
                "Saved successfully"));
        Assert.assertTrue(adminPage.getErrorMessage().getText().contains("Saved successfully"));
    }

    @Test
    public void testEditCity() {
        adminPage.editCity(city);
        driverWait.until(ExpectedConditions.textToBePresentInElement(adminPage.getErrorMessage(),
                "Saved successfully"));
        Assert.assertTrue(adminPage.getErrorMessage().getText().contains("Saved successfully"));
    }

    @Test
    public void testSearchCity() {
        adminPage.getSearchField().sendKeys(city + " edited");
        driverWait.until(ExpectedConditions.textToBePresentInElement(adminPage.getCityNameField(), city + " edited"));
        Assert.assertTrue(adminPage.getCityNameField().getText().contains(city));
    }

    @Test
    public void testDeleteCity() {
        adminPage.getSearchField().sendKeys(city + " edited");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        adminPage.getDeleteButton().click();
        driverWait.until(ExpectedConditions.elementToBeClickable(adminPage.getDeleteButton()));
        adminPage.getDialogButton().click();
        driverWait.until(ExpectedConditions.textToBePresentInElement(adminPage.getErrorMessage(),
                "Deleted successfully"));
        Assert.assertTrue(adminPage.getErrorMessage().getText().contains("Deleted successfully"));
    }
}
