package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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
public class LoginTests extends BaseTest {

    private LoginPage loginPage;

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.getLoginButton().click();
    }

    @Test
    public void testLoginUrl (){
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
