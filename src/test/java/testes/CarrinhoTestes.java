package testes;

import drivers.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CarrinhoPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ScreenShotUtil;

public class CarrinhoTestes {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private CarrinhoPage carrinhoPage;

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        driver.manage().deleteAllCookies();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        carrinhoPage = new CarrinhoPage(driver);

    }

    @When("adiciono diferentes produtos do site no carrinho")
    public void adiciono_diferentes_produtos_do_site_no_carrinho() {
        homePage.adicionarTodosProdutosCarrinho();
    }

    @Then("os produtos devem aparecer no meu carrinho de compras")
    public void os_produtos_devem_aparecer_no_meu_carrinho_de_compras() {
        homePage.irParaCarrinho();
        carrinhoPage.validarProdutosCarrinho("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt");
        ScreenShotUtil.screenShot(driver, "Carrinho", "ProdutosAdicionados");
    }

    @When("removo um ou mais produtos adicionados no carrinho")
    public void removo_um_ou_mais_produtos_adicionados_no_carrinho() {
        homePage.adicionarTodosProdutosCarrinho();
        homePage.irParaCarrinho();
        carrinhoPage.removerTodosProdutosCarrinho();
    }

    @Then("o carrinho deve ficar vazio")
    public void o_carrinho_deve_ficar_vazio() {
        carrinhoPage.validarCarrinhoVazio();
        ScreenShotUtil.screenShot(driver, "Carrinho", "ProdutosExcluidos");
    }

    @When("clico para continuar comprando")
    public void clico_para_continuar_comprando() {
        homePage.irParaCarrinho();
        carrinhoPage.continuarComprando();
    }

    @Then("sou direcionado para a pagina de produtos")
    public void sou_direcionado_para_a_pagina_de_produtos() {
        loginPage.urlDesejada("https://www.saucedemo.com/inventory.html");
        ScreenShotUtil.screenShot(driver, "Carrinho", "ContinuarComprando");
    }

}
