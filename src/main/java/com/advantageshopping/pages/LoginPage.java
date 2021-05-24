package com.advantageshopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

    public final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "usernameRegisterPage")
    public WebElement inputUserName;

    @FindBy(name = "emailRegisterPage")
    public WebElement inputEmail;

    @FindBy(name = "passwordRegisterPage")
    public WebElement inputPassword;

    @FindBy(name = "confirm_passwordRegisterPage")
    public WebElement inputConfirmPassword;

    @FindBy(name = "first_nameRegisterPage")
    public WebElement inputFirstName;

    @FindBy(name = "last_nameRegisterPage")
    public WebElement inputLastName;

    @FindBy(name = "phone_numberRegisterPage")
    public WebElement inputPhone;

    @FindBy(name = "countryListboxRegisterPage")
    public WebElement selectCountry;

    @FindBy(name = "cityRegisterPage")
    public WebElement inputCity;

    @FindBy(name = "addressRegisterPage")
    public WebElement inputAddress;

    @FindBy(name = "state_/_province_/_regionRegisterPage")
    public WebElement inputState;

    @FindBy(name = "postal_codeRegisterPage")
    public WebElement inputPostalCode;

    @FindBy(name = "allowOffersPromotion")
    public WebElement checkPromotions;

    @FindBy(className = "checkboxText")
    public WebElement checkAgree;

    @FindBy(id = "register_btnundefined")
    public WebElement buttonRegister;

    public void preencherUserName(String userName) {
        this.inputUserName.sendKeys(userName);
    }

    public void preencherEmail(String email) {
        this.inputEmail.sendKeys(email);
    }

    public void preencherPassword(String password) {
        this.inputPassword.sendKeys(password);
    }

    public void preencherConfirmPassword(String password) {
        this.inputConfirmPassword.sendKeys(password);
    }

    public void preencherFirstName(String firstName) {
        this.inputFirstName.sendKeys(firstName);
    }

    public void preencherLastName(String lastName) {
        this.inputLastName.sendKeys(lastName);
    }

    public void preencherPhone(String phone) {
        this.inputPhone.sendKeys(phone);
    }

    public void selectCountry(String country) {
        new Select(this.selectCountry).selectByVisibleText(country);
    }

    public void preencherCity(String city) {
        this.inputCity.sendKeys(city);
    }

    public void preencherAddress(String address) {
        this.inputAddress.sendKeys(address);
    }

    public void preencherState(String state) {
        this.inputState.sendKeys(state);
    }

    public void preencherPostalCode(String postalCode) {
        this.inputPostalCode.sendKeys(postalCode);
    }

    public void checkPromotions() {
        this.checkPromotions.click();
    }

    public void checkAgree() {
        this.checkAgree.click();
    }

    public void clicarBotaoRegistrar() {
        this.buttonRegister.click();
    }
}
