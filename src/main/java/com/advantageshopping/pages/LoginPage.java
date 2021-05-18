package com.advantageshopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

//    private WebDriver driver;
//
//    public LoginPage(WebDriver driver) {
//        this.driver = driver;
//    }

    @FindBy(name = "usernameRegisterPage")
    private WebElement inputUserName;

    @FindBy(name = "emailRegisterPage")
    private WebElement inputEmail;

    @FindBy(name = "passwordRegisterPage")
    private WebElement inputPassword;

    @FindBy(name = "confirm_passwordRegisterPage")
    private WebElement inputConfirmPassword;

    @FindBy(name = "first_nameRegisterPage")
    private WebElement inputFirstName;

    @FindBy(name = "last_nameRegisterPage")
    private WebElement inputLastName;

    @FindBy(name = "phone_numberRegisterPage")
    private WebElement inputPhone;

    @FindBy(name = "countryListboxRegisterPage")
    private WebElement selectCountry;

    @FindBy(name = "cityRegisterPage")
    private WebElement inputCity;

    @FindBy(name = "addressRegisterPage")
    private WebElement inputAddress;

    @FindBy(name = "state_/_province_/_regionRegisterPage")
    private WebElement inputState;

    @FindBy(name = "postal_codeRegisterPage")
    private WebElement inputPostalCode;

    @FindBy(name = "allowOffersPromotion")
    private WebElement checkPromotions;

    @FindBy(className = "checkboxText")
    private WebElement checkAgree;

    @FindBy(id = "register_btnundefined")
    private WebElement buttonRegister;

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
