package com.advantageshopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public final WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "menuUserLink")
    public WebElement botaoUsuario;

    @FindBy(className = "create-new-account")
    public WebElement botaoCriarCadastro;

    @FindBy(className = "roboto-medium")
    public WebElement homeIcone;

    public HomePage clicarBotaoUsuario(){
        this.botaoUsuario.click();
        return new HomePage(driver);
    }

    public void clicarBotaoCriarCadastro(){
        this.botaoCriarCadastro.click();
    }

    public String pegarNomeIcone(){
        return homeIcone.getText();
    }
}
