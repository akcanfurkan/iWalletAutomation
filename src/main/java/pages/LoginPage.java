package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Elementler

    @AndroidFindBy(id = "com.iwallet:id/emailInput")
    public MobileElement emailInput;

    @AndroidFindBy(id = "com.iwallet:id/passwordInput")
    public MobileElement passwordInput;

    @AndroidFindBy(id = "com.iwallet:id/loginButton")
    public MobileElement loginButton;

    @AndroidFindBy(id = "com.iwallet:id/errorMessage")
    public MobileElement errorMessage;

    //Metotlar

    public void setEmail(String email) {
        emailInput.sendKeys(email); // yeni e-posta girer.
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}


