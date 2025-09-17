# Projeto: Automação de Testes — Sauce Demo (Selenium + Java + Cucumber)

Automação E2E no site [Sauce Demo](https://www.saucedemo.com) usando **Java + Selenium WebDriver + JUnit + Cucumber** no padrão **Page Objects**.

![Java](https://img.shields.io/badge/Java-21%2B-red)
![Selenium](https://img.shields.io/badge/Selenium-4.x-brightgreen)
![JUnit](https://img.shields.io/badge/JUnit-5-blue)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-23a55a)
![Maven](https://img.shields.io/badge/Build-Maven-lightgrey)

## Funcionalidades cobertas
- **Login**: acessar a aplicação
- **Logout**: encerrar sessão
- **Carrinho**: adicionar e remover produtos
- **Ordenação de produtos**: validar Name (A→Z / Z→A) e Price (low→high / high→low)

## Pré-requisitos
- **Java JDK** 21+ (testado com 23.0.2)
- **Maven** 3.9+
- **Git**
- **Chrome** ou **Edge** instalados (Selenium Manager resolve o driver automaticamente)

## Estrutura do projeto
```text
.
├─ src
│  └─ test
│     ├─ java
│     │  ├─ drivers
│     │  │  ├─ DriverManager.java
│     │  │  └─ Drivers.java
│     │  ├─ elementos
│     │  │  └─ Elementos.java
│     │  ├─ hooks
│     │  │  └─ Hooks.java
│     │  ├─ metodos
│     │  │  └─ Metodos.java
│     │  ├─ pages
│     │  │  ├─ CarrinhoPage.java
│     │  │  ├─ HomePage.java
│     │  │  └─ LoginPage.java
│     │  ├─ runner
│     │  │  └─ RunCucumberTests.java
│     │  ├─ testes
│     │  │  ├─ CarrinhoTestes.java
│     │  │  ├─ LoginTestes.java
│     │  │  ├─ LogoutTestes.java
│     │  │  └─ OrdenacaoTestes.java
│     │  └─ utils
│     │     └─ ScreenShotUtil.java
│     └─ resources
│        └─ features
│           ├─ login.feature
│           ├─ logout.feature
│           ├─ carrinho.feature
│           └─ ordenacao.feature
├─ target
│  ├─ evidenciasLogin/
│  ├─ evidenciasLogout/
│  ├─ evidenciasCarrinho/
│  ├─ evidenciasOrdenacao/
│  └─ cucumber-report.html
├─ pom.xml
└─ README.md
```

## Como executar

Clonar o repositório e, na raiz do projeto:

### Todos os cenários
`mvn clean test`

### Por tag do Cucumber (exemplo)
`mvn clean test -Dcucumber.filter.tags="@Ordenacao"`

### Uma feature específica
`mvn clean test -Dcucumber.features=src/test/resources/features/ordenacao.feature`

### Pelo IntelliJ (Runner)
- Abrir `RunCucumberTests.java` → ícone **Run** ▶️

---

## Relatório & Evidências
- **Relatório HTML:** `target/cucumber-report.html`
- **Screenshots de falha:** `target/evidencias*`

---

## Dados de teste (Sauce Demo)
- **Usuário:** `standard_user`
- **Senha:** `secret_sauce`

---

## Troubleshooting
- Aviso CDP nos logs → atualize Selenium e o navegador.
- Popup “Mude sua senha” → rode com perfil limpo ou desative PasswordLeakDetection nas Options.

## Roadmap
- [ ] Allure report
- [ ] CI (GitHub Actions)

---

## Autor
**Renato Bello — QA Automation**  
LinkedIn: <https://www.linkedin.com/in/renato-bello>