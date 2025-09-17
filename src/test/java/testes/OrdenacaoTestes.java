package testes;

import drivers.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.ScreenShotUtil;

public class OrdenacaoTestes {

    private WebDriver driver;
    private HomePage homePage;


    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        driver.manage().deleteAllCookies();
        homePage = new HomePage(driver);
    }

    @Then("a ordenacao deve estar por padrao de A-Z")
    public void a_ordenacao_deve_estar_por_padrao_de_a_z() {
        homePage.validarProdutosAZ();
        ScreenShotUtil.screenShot(driver, "Ordenacao", "Ordenacao(A-Z)");
    }


    @When("seleciono a opcao de ordenacao de Z-A")
    public void seleciono_a_opcao_de_ordenacao_de_z_a() {
       homePage.selecionarOrdenacaoZA();
    }
    @Then("valido se os produtos estao ordenados corretamente por nome")
    public void valido_se_os_produtos_estao_ordenados_corretamente_por_nome() {
       homePage.validarProdutosZA();
        ScreenShotUtil.screenShot(driver, "Ordenacao", "Ordenacao(Z-A)");
    }

    @When("seleciono a opcao de ordenacao por preco do menor para o maior")
    public void seleciono_a_opcao_de_ordenacao_por_preco_do_menor_para_o_maior() {
       homePage.selecionarOrdenacaoPrecoMenorMaior();
    }

    @Then("valido se os produtos estao ordenados corretamente do menor para o maior")
    public void valido_se_os_produtos_estao_ordenados_corretamente_do_menor_para_o_maior() {
        homePage.validarPrecoMenorParaMaior();
        ScreenShotUtil.screenShot(driver, "Ordenacao", "OrdenacaoPreco(Menor-Maior)");
    }

    @When("seleciono a opcao de ordenacao por preco do maior para o menor")
    public void seleciono_a_opcao_de_ordenacao_por_preco_do_maior_para_o_menor() {
        homePage.selecionarOrdenacaoPrecoMaiorMenor();
    }
    @Then("valido se os produtos estao ordenados corretamente do maior para o menor")
    public void valido_se_os_produtos_estao_ordenados_corretamente_do_maior_para_o_menor() {
        homePage.validarPrecoMaiorParaMenor();
        ScreenShotUtil.screenShot(driver, "Ordenacao", "OrdenacaoPreco(Maior-Menor)");
    }

}
