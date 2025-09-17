package pages;

import elementos.Elementos;
import metodos.Metodos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {

    private WebDriver driver;
    private Metodos metodo;
    private Elementos el = new Elementos();

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.metodo = new Metodos(driver);
    }

    public void clicarMenu() {
        metodo.clicar(el.abrirMenu);
    }

    public void realizarLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(el.buttonLogout));
        metodo.clicar(el.buttonLogout);
    }

    public void adicionarTodosProdutosCarrinho() {
        metodo.clicarEmElementoIguais(el.buttonAdicionarCarrinho);
    }

    public void irParaCarrinho() {
        metodo.clicar(el.buttonCarrinho);
    }

    public void selecionarOrdenacaoAZ(){
        metodo.selecionarPorTexto(el.buttonOrdenacao, "Name (A to Z)");
    }

    public void selecionarOrdenacaoZA(){
        metodo.selecionarPorTexto(el.buttonOrdenacao, "Name (Z to A)");
    }

    public void selecionarOrdenacaoPrecoMenorMaior(){
        metodo.selecionarPorTexto(el.buttonOrdenacao, "Price (low to high)");
    }

    public void selecionarOrdenacaoPrecoMaiorMenor(){
        metodo.selecionarPorTexto(el.buttonOrdenacao, "Price (high to low)");
    }

    public void validarProdutosAZ(){
        boolean ok = metodo.validarOrdenacaoPorNome(el.nomeProdutos, true);
        if (!ok) throw new AssertionError("Lista não está em ordem alfabética A→Z");
    }

    public void validarProdutosZA(){
        boolean ok = metodo.validarOrdenacaoPorNome(el.nomeProdutos, false);
        if (!ok) throw new AssertionError("Lista não está em ordem alfabética Z→A");
    }

    public void validarPrecoMenorParaMaior() {
        if (!metodo.validarOrdenacaoPorPreco(el.precoProdutos, true)) {
            throw new AssertionError("Lista não está em ordem de preço crescente");
        }
    }

    public void validarPrecoMaiorParaMenor() {
        if (!metodo.validarOrdenacaoPorPreco(el.precoProdutos, false)) {
            throw new AssertionError("Lista não está em ordem de preço decrescente");
        }
    }
}
