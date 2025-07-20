package tests;

import base.BaseTest;
import pages.LoginPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);

        // Test verisi (kurgusal)
        String email = "testuser@email.com";
        String password = "Test1234";

        // Giriş işlemi
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLogin();

        // Başarılı girişte hata mesajı olmamalı
        assertNull(loginPage.getErrorMessage());
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        // Geçersiz test verisi
        String email = "wrong@email.com";
        String password = "WrongPass";

        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLogin();

        // Hata mesajı görünüyor mu kontrol edilir
        String errorMessage = loginPage.getErrorMessage();
        assertNotNull(errorMessage);
        System.out.println("Giriş hatası mesajı: " + errorMessage);
    }
}
