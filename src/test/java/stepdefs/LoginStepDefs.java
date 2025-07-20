package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import base.BaseTest;

public class LoginStepDefs {

    LoginPage loginPage;

    @Given("kullanıcı login ekranındadır")
    public void kullanıcı_login_ekranındadır() {
        loginPage = new LoginPage(BaseTest.driver);
    }

    @When("kullanıcı e-posta olarak {string} girer")
    public void kullanıcı_e_posta_olarak_girer(String email) {
        loginPage.setEmail(email);
    }

    @When("şifre olarak {string} girer")
    public void şifre_olarak_girer(String password) {
        loginPage.setPassword(password);
    }

    @When("giriş butonuna tıklar")
    public void giriş_butonuna_tıklar() {
        loginPage.clickLogin();
    }

    @Then("kullanıcı başarılı şekilde giriş yapar")
    public void kullanıcı_başarılı_şekilde_giriş_yapar() {
        // assertTrue(loginPage.successMessage.isDisplayed());
    }
}


