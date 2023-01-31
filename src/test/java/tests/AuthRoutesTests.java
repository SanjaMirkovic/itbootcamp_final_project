package tests;
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
Locale Tests
Test #1: Set locale to ES
assert:
 */
public class AuthRoutesTests extends BaseTest {
}
