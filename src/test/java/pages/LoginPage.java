package pages;

import elementos.Elementos;
import metodos.Metodos;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private Metodos metodo;
    private Elementos el = new Elementos();

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.metodo = new Metodos(driver);
    }

    public void preencherDadosLogin(String usuario, String senha) {
        metodo.preencher(el.usuario, usuario);
        metodo.preencher(el.senha, senha);
    }

    public void clicarLogin() {
        metodo.clicar(el.buttonLogin);
    }

    public void urlDesejada(String url) {
        metodo.validarUrl(url);
    }

    public void validarMsgUsuarioEmBranco(String texto){
        metodo.validarTextoIncompleto(el.msgUsuarioEmBranco,texto);
    }

    public void validarMsgUsuarioIncorreto(String texto){
        metodo.validarTextoIncompleto(el.msgUsuarioInvalido,texto);
    }

    public void validarMsgSenhaEmBranco(String texto){
        metodo.validarTextoIncompleto(el.msgSenhaEmBranco,texto);
    }

}
