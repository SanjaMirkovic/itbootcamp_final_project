package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LocalePage;
import pages.LoginPage;

/*
Test #1: Set locale to ES
assert:
Postaviti jezik na ES
Verifikovati da se na stranici u hederu javlja tekst Página de
aterrizaje

Test #2: Set locale to EN
assert:
Postaviti jezik na EN
Verifikovati da se na stranici u hederu javlja tekst Landing

Test #3: Set locale to FR
assert:
Postaviti jezik na FR
Verifikovati da se na stranici u hederu javlja tekst Page
d'atterrissage
 */
public class LocaleTests extends BaseTest {

    private LocalePage localePage;

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        localePage = new LocalePage(driver, driverWait);
    }

    @Test
    public void testES() {
        homePage.getLanguageButton().click();
        localePage.getEs().click();
        Assert.assertEquals(homePage.getTitle().getText(), "Página de aterrizaje");
    } @Test
    public void testEN() {
        homePage.getLanguageButton().click();
        localePage.getEn().click();
        Assert.assertEquals(homePage.getTitle().getText(), "Landing");
    } @Test
    public void testFR() {
        homePage.getLanguageButton().click();
        localePage.getFr().click();
        Assert.assertEquals(homePage.getTitle().getText(), "Page d'atterrissage");
    }

}
