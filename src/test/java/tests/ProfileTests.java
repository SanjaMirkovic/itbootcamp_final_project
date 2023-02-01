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
    public void beforeMethod() {
        super.beforeMethod();
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
    }

    @Test
    public void testEditProfile(){
        loginPage.logIn("admin@admin.com", "12345");
        homePage.getMyProfile().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Faker faker = new Faker();
        profilePage.editMyProfile(faker.name().firstName(), faker.phoneNumber().toString(), faker.country().toString(),
                faker.internet().url(), faker.internet().url());
        driverWait.until(ExpectedConditions.textToBePresentInElement(profilePage.getMessageSuccessfulySaved(),
                "Profile saved successfuly"));
        Assert.assertEquals(profilePage.getMessage().getText(), "Profile saved successfuly");
    }
}
