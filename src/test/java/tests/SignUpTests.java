package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignUpPage;

import java.time.Duration;

/*
Test #1: Visits the signup page
assert:
Verifikovati da se u url-u stranice javlja /signup ruta

Test #2: Checks input types
assert:
Verifikovati da polje za unos emaila za atribut type ima vrednost
email
Verifikovati da polje za unos lozinke za atribut type ima vrednost
password
Verifikovati da polje za unos lozinke za potvrdu za atribut type ima
vrednost password

Test #3: Displays errors when user already exists
Podaci:
name: Test Test
email: admin@admin.com
password: 123654
confirm password: 123654
assert:
Verifikovati da greska sadrzi poruku E-mail already exists
Verifikovati da se u url-u stranice javlja /signup ruta

Test #4: Signup
Podaci:
name: Ime i prezime polaznika
email template: izabrani email
password: izabrani password
confirm password:
assert:
Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT:
Verify your account
 */
public class SignUpTests extends BaseTest {

    private SignUpPage signUpPage;

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        signUpPage = new SignUpPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeTest() {
        super.beforeTest();
        homePage.getSignUpButton().click();
    }

    @Test
    public void testSignUpUrl(){
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void testInputTypes(){
        Assert.assertEquals(signUpPage.getEmail(), "email");
        Assert.assertEquals(signUpPage.getPassword(), "password");
        Assert.assertEquals(signUpPage.getConfirmPassword(), "password");
    }

    @Test
    public void testUserAlreadyExist(){
        signUpPage.signUp("Test Test", VALIDEMAIL, "123654", "123654");
        driverWait.until(ExpectedConditions.visibilityOf(signUpPage.getMessageUserAlreadyExists()));
        Assert.assertEquals(signUpPage.getMessageUserAlreadyExists().getText(), "E-mail already exists");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void testSignUpVerify(){
        String password = faker.internet().password();
        signUpPage.signUp("Sanja Mirkovic", faker.internet().emailAddress(), password, password);
        driverWait.until(ExpectedConditions.textToBePresentInElement(signUpPage.getMessageVerifyAccount(),
                "IMPORTANT: Verify your account"));
        Assert.assertEquals(signUpPage.getMessageVerifyAccount().getText(), "IMPORTANT: Verify your account");
        homePage.getCloseButton().click();
    }
}
