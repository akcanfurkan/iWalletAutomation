package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    public ProfilePage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // ELEMENTLER

    @AndroidFindBy(id = "com.iwallet:id/nameInput")
    public MobileElement nameInput;

    @AndroidFindBy(id = "com.iwallet:id/surnameInput")
    public MobileElement surnameInput;

    @AndroidFindBy(id = "com.iwallet:id/emailInput")
    public MobileElement emailInput;

    @AndroidFindBy(id = "com.iwallet:id/phoneInput")
    public MobileElement phoneInput;

    @AndroidFindBy(id = "com.iwallet:id/addressInput")
    public MobileElement addressInput;

    @AndroidFindBy(id = "com.iwallet:id/passwordInput")
    public MobileElement passwordInput;

    @AndroidFindBy(id = "com.iwallet:id/notificationToggle")
    public MobileElement notificationToggle;

    @AndroidFindBy(id = "com.iwallet:id/updateButton")
    public MobileElement updateButton;

    @AndroidFindBy(id = "com.iwallet:id/deleteAccountButton")
    public MobileElement deleteAccountButton;

    @AndroidFindBy(id = "com.iwallet:id/deleteModalTitle")
    public MobileElement deleteModalTitle;

    @AndroidFindBy(id = "com.iwallet:id/confirmDeleteButton")
    public MobileElement confirmDeleteButton;

    @AndroidFindBy(id = "com.iwallet:id/cancelDeleteButton")
    public MobileElement cancelDeleteButton;

    @AndroidFindBy(id = "com.iwallet:id/successToast")
    public MobileElement successToast;

    // METOTLAR

    public void setName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void setSurname(String surname) {
        surnameInput.clear();
        surnameInput.sendKeys(surname);
    }

    public void setEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void setPhone(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void setAddress(String address) {
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void setPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickUpdate() {
        updateButton.click();
    }

    public void clickDeleteAccount() {
        deleteAccountButton.click();
    }

    public void confirmDelete() {
        confirmDeleteButton.click();
    }

    public void cancelDelete() {
        cancelDeleteButton.click();
    }

    public String getSuccessMessage() {
        return successToast.getText();
    }

    public String getDeleteModalText() {
        return deleteModalTitle.getText();
    }
}
