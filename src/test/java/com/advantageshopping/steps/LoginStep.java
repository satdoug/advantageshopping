package com.advantageshopping.steps;

import com.advantageshopping.data.UsuarioDataFactory;
import com.advantageshopping.model.Usuario;
import com.advantageshopping.pages.HomePage;
import com.advantageshopping.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStep {

    private Usuario novoUsuario;
    private LoginPage loginPage;
    private HomePage homePage;
    public static WebDriver driver;

    public LoginStep() {
        novoUsuario = new UsuarioDataFactory().criarUsuario();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Dado("que estou no site da loja")
    public void queEstouNoSiteDaLoja() {
        String textoAtual = homePage.pegarNomeIcone();
        Assert.assertEquals("dvantage", textoAtual);
    }

    @E("estou na tela de cadastrar novo usuario")
    public void estouNaTelaDeCadastrarNovoUsuario() {
        homePage.clicarBotaoUsuario();
        homePage.clicarBotaoCriarCadastro();
    }

    @Quando("clicar no botao register")
    public void clicarNoBotaoRegister() {
        loginPage.preencherUserName(novoUsuario.getUserName());
        loginPage.preencherEmail(novoUsuario.getEmail());
        loginPage.preencherPassword(novoUsuario.getPassword());
        loginPage.preencherConfirmPassword(novoUsuario.getPassword());
        loginPage.preencherFirstName(novoUsuario.getFisrtName());
        loginPage.preencherLastName(novoUsuario.getLastName());
        loginPage.preencherPhone(novoUsuario.getPhone());
        loginPage.selectCountry("Brazil");
        loginPage.preencherCity(novoUsuario.getCity());
        loginPage.preencherAddress(novoUsuario.getAddress());
        loginPage.preencherState(novoUsuario.getState());
        loginPage.preencherPostalCode(novoUsuario.getPostal());
        loginPage.checkPromotions();
        loginPage.checkAgree();
        loginPage.clicarBotaoRegistrar();
    }

    @Entao("devera ser redirecionado para tela home")
    public void deveraSerRedirecionadoParaTelaHome() {
    }
}
