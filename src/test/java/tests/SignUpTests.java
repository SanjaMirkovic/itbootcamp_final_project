package tests;
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
}
