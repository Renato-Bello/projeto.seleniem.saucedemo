@Regressivo
Feature: Efetuar login no site Sauce Demo
  Como um usuário da aplicação
  Quero realizar login utilizando meu usuario e senha
  Para que eu possa acessar as funcionalidades do site

  Background:
    Given que eu esteja na tela de login

  @Positivo @Login_Sucesso
  Scenario: Login realizado com sucesso
    When preencho os campos com usuario e senha válidos
    And clico no botão de login
    Then o login e realizado com sucesso redirecionado para a área logada do site

  @Negativo @Login_semUsuario
  Scenario: Não deve permitir login sem preencher o campo do usuario
    When deixo o campo do usuario vazio
    And clico no botão de login
    Then o login não deve ser realizado
    And devo visualizar uma mensagem de erro sobre obrigatoriedade do campo usuario

  @Negativo @Login_UsuarioInvalido
  Scenario: Não deve permitir login com usuario inválido
    When preencho o campo do usuario com um usuario inválido
    And clico no botão de login
    Then o login não deve ser realizado
    And devo visualizar uma mensagem de erro sobre usuario invalido

  @Negativo @Login_SenhaBranco
  Scenario: Não deve permitir login sem preencher o campo de senha
    When preencho o campo do usuario corretamente deixando a senha em branco
    And clico no botão de login
    Then o login não deve ser realizado
    And devo visualizar uma mensagem de erro sobre obrigatoriedade do campo senha

  @Negativo @Login_SenhaInvalida
  Scenario: Não deve permitir login com senha inválida
    When preencho o campo de e-mail corretamente e a senha incorreta
    And clico no botão de login
    Then o login não deve ser realizado
    And devo visualizar uma mensagem de erro sobre senha invalido

  @Negativo @Login_DadosEmBranco
  Scenario: Não deve permitir login com todos os dados em branco
    When nao preencho nenhum dado para login
    And clico no botão de login
    Then o login não deve ser realizado
    And devo visualizar uma mensagem de erro sobre obrigatoriedade do campo usuario
