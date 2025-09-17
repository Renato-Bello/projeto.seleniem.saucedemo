package elementos;

import org.openqa.selenium.By;

public class Elementos {

    public By usuario = By.id("user-name");
    public By senha = By.id("password");
    public By buttonLogin = By.id("login-button");
    public By msgUsuarioEmBranco = By.xpath("//h3[text()='Epic sadface: Username is required']");
    public By msgUsuarioInvalido = By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']");
    public By msgSenhaEmBranco = By.xpath("//h3[text()='Epic sadface: Password is required']");
    public By abrirMenu = By.xpath("//button[text()='Open Menu']");
    public By buttonLogout = By.id("logout_sidebar_link");
    public By buttonCarrinho = By.xpath("//a[@class='shopping_cart_link']");
    public By listaDoCarrinho = By.xpath("//div[@class='cart_list']");
    public By buttonAdicionarCarrinho = By.xpath("//button[contains(text(),'Add to cart')]");
    public By buttonRemoverDoCarrinho = By.xpath("//button[contains(text(),'Remove')]");
    public By buttonContinuarComprando = By.name("continue-shopping");
    public By buttonOrdenacao = By.xpath("//select[@data-test='product-sort-container']");
    public By nomeProdutos   = By.xpath("//div[@data-test='inventory-item-name']");
    public By precoProdutos   = By.xpath("//div[@data-test='inventory-item-price']");
}
