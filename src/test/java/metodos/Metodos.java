package metodos;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Metodos {

    private WebDriver driver;
    private final WebDriverWait wait;

    public Metodos(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver = driver;
    }


    public void preencher(By locator, String texto) {
        try {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(texto);
        } catch (Exception e) {
            System.out.println("****** MSG DE ERRO ******" + e.getMessage());
            throw new NoSuchElementException("Elemento não encontrado" + locator);
        }
    }


    public void clicar(By locator) {
        try {
            driver.findElement(locator).click();
        } catch (Exception e) {
            System.out.println("****** MSG DE ERRO ******" + e.getMessage());
            throw new NoSuchElementException("Elemento não encontrado");
        }
    }


    public void validarUrl(String urlDesejada) {
        try {
            assertEquals(urlDesejada, driver.getCurrentUrl());
        } catch (Exception e) {
            System.out.println("****** MSG DE ERRO ******" + e.getMessage());
            throw new NoSuchElementException("Elemento não encontrado" + urlDesejada);
        }
    }

    public void validarTextoIncompleto(By elemento, String textoEsperado) {
        try {
            String textoEncontrado = driver.findElement(elemento).getText();

            if (!textoEncontrado.contains(textoEsperado)) {
                throw new AssertionError("Texto não encontrado. Esperado conter: '" + textoEsperado + "' mas foi: '" + textoEncontrado + "'");
            }

        } catch (Exception e) {
            System.out.println("****** MSG DE ERRO ****** " + e.getMessage());
            throw new NoSuchElementException("Elemento não encontrado ou texto inválido: " + textoEsperado);
        }
    }

    public void validarVariosTextoIncompletos(By elemento, String textoEsperado, String textoEsperado2, String textoEsperado3) {
        try {
            String textoEncontrado = driver.findElement(elemento).getText();

            if (!textoEncontrado.contains(textoEsperado)) {
                throw new AssertionError("Texto não encontrado. Esperado conter: '" + textoEsperado + "' mas foi: '" + textoEncontrado + "'");
            }

        } catch (Exception e) {
            System.out.println("****** MSG DE ERRO ****** " + e.getMessage());
            throw new NoSuchElementException("Elemento não encontrado ou texto inválido: " + textoEsperado);
        }
    }

    public void clicarEmElementoIguais(By elemento) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> botoes = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(elemento)
        );

        for (WebElement botao : botoes) {
            botao.click();
        }
    }

    public void selecionarPorTexto(By selectLocator, String visibleText) {
        WebElement combo = wait.until(ExpectedConditions.elementToBeClickable(selectLocator));
        new Select(combo).selectByVisibleText(visibleText);
    }

    public boolean validarOrdenacaoPorNome(By itemNameLocator, boolean asc) {
        List<WebElement> itens = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(itemNameLocator)
        );
        List<String> exibidos = itens.stream().map(e -> e.getText().trim()).collect(Collectors.toList());
        List<String> ordenados = new ArrayList<>(exibidos);

        Comparator<String> cmp = String.CASE_INSENSITIVE_ORDER;
        ordenados.sort(asc ? cmp : Collections.reverseOrder(cmp));

        if (!exibidos.equals(ordenados)) {
            System.out.println("Ordem na tela  : " + exibidos);
            System.out.println("Ordem esperada : " + ordenados);
        }
        return exibidos.equals(ordenados);
    }

    public boolean validarOrdenacaoPorPreco(By priceLocator, boolean asc) {
        List<WebElement> itens = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(priceLocator)
        );

        List<java.math.BigDecimal> exibidos = itens.stream()
                .map(e -> e.getText())
                .map(this::toBigDecimal)
                .collect(java.util.stream.Collectors.toList());

        List<java.math.BigDecimal> ordenados = new java.util.ArrayList<>(exibidos);
        ordenados.sort(asc ? java.util.Comparator.naturalOrder()
                : java.util.Comparator.reverseOrder());

        if (!exibidos.equals(ordenados)) {
            System.out.println("Ordem na tela   : " + exibidos);
            System.out.println("Ordem esperada  : " + ordenados);
        }
        return exibidos.equals(ordenados);
    }

    private java.math.BigDecimal toBigDecimal(String raw) {
        String cleaned = raw.replaceAll("[^\\d.,-]", "");
        cleaned = cleaned.replace(",", ".");
        return new java.math.BigDecimal(cleaned);
    }
}

