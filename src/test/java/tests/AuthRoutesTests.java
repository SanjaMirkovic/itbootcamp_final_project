package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
Test #1: Forbids visits to home url if not authenticated
assert:
Ucitati /home stranu kada korisnik nije ulogovan
Verifikovati da se u url-u stranice javlja ruta /login

Test #2: Forbids visits to profile url if not authenticated
assert:
Ucitati /profile stranu
Verifikovati da se u url-u stranice javlja ruta /login

Test #3: Forbids visits to admin cities url if not authenticated
assert:
Ucitati /admin/cities stranu
Verifikovati da se u url-u stranice javlja ruta /login

Test #4: Forbids visits to admin users url if not authenticated
assert:
Ucitati /admin/users stranu
Verifikovati da se u url-u stranice javlja ruta /login
 */
public class AuthRoutesTests extends BaseTest {

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
    }

    @BeforeMethod
    public void beforeTest() {
        super.beforeTest();
    }

    @Test
    public void testForbidsVisitsToHomeUrIfNotAuthenticated() {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
    @Test
    public void testForbidsVisitsToProfileUrlIfNotAuthenticated () {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
    @Test
    public void testForbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
    @Test
    public void testForbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

}

