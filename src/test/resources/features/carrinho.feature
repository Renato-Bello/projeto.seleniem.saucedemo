@Regressivo
Feature: Adicionar produtos ao carrinho
  Como um usuário autenticado na aplicação
  Quero adicionar os produtos no carrinho de compras
  Para que eu possa prosseguir com a compra

  Background:
    Given que eu estou autenticado

  @Positivo @Adicionar_Produtoscarrinho
  Scenario: Adicionar produtos ao carrinho
    When adiciono diferentes produtos do site no carrinho
    Then os produtos devem aparecer no meu carrinho de compras

  @Positivo @Remover_Produtoscarrinho
  Scenario: Remover produtos do carrinho
    When removo um ou mais produtos adicionados no carrinho
    Then o carrinho deve ficar vazio

  @Positivo @Continuar_comprando
  Scenario: Continuar comprando produtos
    When adiciono diferentes produtos do site no carrinho
    And clico para continuar comprando
    Then sou direcionado para a pagina de produtos