@Regressivo
Feature: Efetuar logout no site Sauce Demo
  Como um usuário autenticado na aplicação
  Quero encerrar minha sessão
  Para que minha conta permaneça segura e eu possa finalizar o uso do site

  Background:
    Given que eu estou autenticado

  @Positivo @Logout_Sucesso
  Scenario: Logout realizado com sucesso
    When clico no botão de logout
    Then devo ser desconectado
    And sou redirecionado para a página inicial