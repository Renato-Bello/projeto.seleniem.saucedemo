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

public class CarrinhoPage {

    private WebDriver driver;
    private Metodos metodo;
    private Elementos el = new Elementos();

    public CarrinhoPage(WebDriver driver) {
        this.driver = driver;
        this.metodo = new Metodos(driver);
    }

    public void removerTodosProdutosCarrinho() {
        metodo.clicarEmElementoIguais(el.buttonRemoverDoCarrinho);
    }

    public void validarProdutosCarrinho(String produto1, String produto2, String produto3) {
        metodo.validarVariosTextoIncompletos(el.listaDoCarrinho, produto1, produto2, produto3);
    }

    public void validarCarrinhoVazio() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("/cart.html"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-test='cart-list']")));

        java.util.List<WebElement> itens =
                driver.findElements(By.cssSelector("div[data-test='cart-list'] [data-test='inventory-item']"));
        assertTrue(itens.isEmpty(), "Carrinho não está vazio. Quantidade de itens: " + itens.size());

        boolean temBadge = !driver.findElements(By.cssSelector("span[data-test='shopping-cart-badge']")).isEmpty();
        assertTrue(!temBadge, "Badge do carrinho indica itens, mas o carrinho deveria estar vazio.");
    }

    public void continuarComprando(){
        metodo.clicar(el.buttonContinuarComprando);
    }
}
