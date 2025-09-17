package testes;

import drivers.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utils.ScreenShotUtil;

public class LogoutTestes {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        driver.manage().deleteAllCookies();
    }

    @Given("que eu estou autenticado")
    public void que_eu_estou_autenticado() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.preencherDadosLogin("standard_user", "secret_sauce");
        loginPage.clicarLogin();
    }

    @When("clico no botão de logout")
    public void clico_no_botão_de_logout() {
        homePage.clicarMenu();
    }

    @Then("devo ser desconectado")
    public void devo_ser_desconectado() {
        homePage.realizarLogout();
    }

    @Then("sou redirecionado para a página inicial")
    public void sou_redirecionado_para_a_página_inicial() {
        loginPage.urlDesejada("https://www.saucedemo.com/");
        ScreenShotUtil.screenShot(driver, "Logout", "LogoutRealizado");
    }
}
