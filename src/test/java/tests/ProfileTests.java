package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProfilePage;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileTests extends BaseTest {

    @Test
    public void testProfileInfoDisplayed() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("user@example.com");
        loginPage.setPassword("Password123");
        loginPage.clickLogin();

        // Profile sayfası elemanları görünüyor mu kontrolü
        ProfilePage profilePage = new ProfilePage(driver);

        assertNotNull(profilePage.nameInput);
        assertNotNull(profilePage.surnameInput);
        assertNotNull(profilePage.emailInput);
        assertNotNull(profilePage.phoneInput);
        assertNotNull(profilePage.addressInput);
        assertNotNull(profilePage.passwordInput);
        assertNotNull(profilePage.notificationToggle);
        assertNotNull(profilePage.deleteAccountButton);
    }

    @Test
    public void testInvalidEmailFormat() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("user@example.com");
        loginPage.setPassword("Password123");
        loginPage.clickLogin();

        // Geçersiz email girişi
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.setEmail("invalidemail");
        profilePage.clickUpdate();

        // Hata mesajı bekleniyor
        String error = profilePage.getSuccessMessage(); // Eğer geçersizse, backend bunu mesajla belirtmeli
        assertEquals("Please enter a valid email address", error);
    }

    @Test
    public void testDeleteAccountModalAppears() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("user@example.com");
        loginPage.setPassword("Password123");
        loginPage.clickLogin();

        // Silme butonuna tıklanır
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickDeleteAccount();

        // Modal görünür mü?
        assertTrue(profilePage.deleteModalTitle.isDisplayed());
        assertEquals("Delete Account", profilePage.getDeleteModalText());
    }
}
