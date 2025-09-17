package testes;

import drivers.DriverManager;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.ScreenShotUtil;

public class LoginTestes {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        driver.manage().deleteAllCookies();
    }

    @AfterAll
    public static void fecharNoFim() {
        DriverManager.quitDriver();
    }

    @Given("que eu esteja na tela de login")
    public void que_eu_esteja_na_tela_de_login() {
        loginPage = new LoginPage(driver);
    }

    @When("preencho os campos com usuario e senha válidos")
    public void preencho_os_campos_com_usuario_e_senha_válidos() {
        loginPage.preencherDadosLogin("standard_user", "secret_sauce");

    }

    @When("clico no botão de login")
    public void clico_no_botão_de_login() {
        loginPage.clicarLogin();
    }

    @Then("o login e realizado com sucesso redirecionado para a área logada do site")
    public void o_login_e_realizado_com_sucesso_redirecionado_para_a_área_logada_do_site() {
        loginPage.urlDesejada("https://www.saucedemo.com/inventory.html");
        ScreenShotUtil.screenShot(driver, "Login", "LoginRealizado");
    }


    @When("deixo o campo do usuario vazio")
    public void deixo_o_campo_do_usuario_vazio() {
        loginPage.preencherDadosLogin("", "secret_sauce");
    }

    @Then("o login não deve ser realizado")
    public void o_login_não_deve_ser_realizado() {
        loginPage.urlDesejada("https://www.saucedemo.com/");
    }

    @Then("devo visualizar uma mensagem de erro sobre obrigatoriedade do campo usuario")
    public void devo_visualizar_uma_mensagem_de_erro_sobre_obrigatoriedade_do_campo_usuario() {
        loginPage.validarMsgUsuarioEmBranco("Epic sadface: Username is required");
        ScreenShotUtil.screenShot(driver, "Login", "LoginNegado");
    }


    @When("preencho o campo do usuario com um usuario inválido")
    public void preencho_o_campo_do_usuario_com_um_usuario_inválido() {
        loginPage.preencherDadosLogin("standarduser", "secret_sauce");
    }

    @Then("devo visualizar uma mensagem de erro sobre usuario invalido")
    public void devo_visualizar_uma_mensagem_de_erro_sobre_usuario_invalido() {
        loginPage.validarMsgUsuarioIncorreto("Epic sadface: Username and password do not match any user in this service");
        ScreenShotUtil.screenShot(driver, "Login", "LoginNegado");
    }


    @When("preencho o campo do usuario corretamente deixando a senha em branco")
    public void preencho_o_campo_do_usuario_corretamente_deixando_a_senha_em_branco() {
        loginPage.preencherDadosLogin("standard_user", "");
    }

    @Then("devo visualizar uma mensagem de erro sobre obrigatoriedade do campo senha")
    public void devo_visualizar_uma_mensagem_de_erro_sobre_obrigatoriedade_do_campo_senha() {
        loginPage.validarMsgSenhaEmBranco("Epic sadface: Password is required");
        ScreenShotUtil.screenShot(driver, "Login", "LoginNegado");
    }


    @When("preencho o campo de e-mail corretamente e a senha incorreta")
    public void preencho_o_campo_de_e_mail_corretamente_e_a_senha_incorreta() {
        loginPage.preencherDadosLogin("standard_user", "secret_sau");
    }

    @Then("devo visualizar uma mensagem de erro sobre senha invalido")
    public void devo_visualizar_uma_mensagem_de_erro_sobre_senha_invalido() {
        loginPage.validarMsgUsuarioIncorreto("Epic sadface: Username and password do not match any user in this service");
        ScreenShotUtil.screenShot(driver, "Login", "LoginNegado");
    }


    @When("nao preencho nenhum dado para login")
    public void nao_preencho_nenhum_dado_para_login() {
        loginPage.preencherDadosLogin("", "");
        ScreenShotUtil.screenShot(driver, "Login", "LoginNegado");
    }
}
