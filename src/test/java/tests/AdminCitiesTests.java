package tests;
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
}
