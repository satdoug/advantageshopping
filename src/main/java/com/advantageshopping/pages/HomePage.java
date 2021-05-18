package com.advantageshopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(id = "menuUserLink")
    private WebElement botaoUsuario;

    @FindBy(className = "create-new-account")
    private WebElement botaoCriarCadastro;

    @FindBy(className = "roboto-medium")
    private WebElement homeIcone;

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
