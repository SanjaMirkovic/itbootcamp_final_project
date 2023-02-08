package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

import java.time.Duration;

/*
Test #1: Edits profile
Podaci: random podaci korišćenjem faker library-ja
assert:
Verifikovati da je prikazana poruka Profile saved successfuly
Verifikovati da svaki input sada za value atribut ima vrednost koja
je uneta u okviru forme
 */
public class ProfileTests extends BaseTest {
    private ProfilePage profilePage;
    private LoginPage loginPage;

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        profilePage = new ProfilePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeTest() {
        super.beforeTest();
//        driver.get(BASEURL + "/profile");
        homePage.getLoginButton().click();
        loginPage.logIn(VALIDEMAIL, VALIDPASSWORD);
        homePage.getMyProfile().click();
    }

    @Test
    public void testEditProfile() {
        String name = faker.name().fullName();
        String phoneNumber = faker.phoneNumber().cellPhone();
        String city = "Barranquilla";
        String country = faker.country().name();
        String twitter = "https://twitter.com/sm";
        String github = "https://github.com/sm";

        profilePage.editMyProfile(name, phoneNumber, city, country, twitter, github);

        driverWait.until(ExpectedConditions.textToBePresentInElement(profilePage.getMessageSuccessfulySaved(),
                "Profile saved successfuly"));
        Assert.assertTrue(profilePage.getMessageSuccessfulySaved().getText().contains("Profile saved successfuly"));

        Assert.assertEquals(profilePage.getName().getAttribute("value"), name);
        Assert.assertEquals(profilePage.getPhone().getAttribute("value"), phoneNumber);
        Assert.assertEquals(profilePage.getCity().getAttribute("value"), city);
        Assert.assertEquals(profilePage.getCountry().getAttribute("value"), country);
        Assert.assertEquals(profilePage.getTwitter().getAttribute("value"), twitter);
        Assert.assertEquals(profilePage.getGithub().getAttribute("value"), github);
    }
}
