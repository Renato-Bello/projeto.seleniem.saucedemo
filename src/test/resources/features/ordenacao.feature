@Regressivo
Feature: Realizar ordenacao de produtos no site Sauce Demo
  Como um usuário autenticado na aplicação
  Quero ordenar os produtos do site por preco e nome
  Para reduzir o tempo de busca e comparar alternativas

  Background:
    Given que eu estou autenticado

  @Ordenacao_AZ
  Scenario: Ordenação por ordem alfabetica (A-Z)
    Then a ordenacao deve estar por padrao de A-Z

  @Ordenacao_ZA
  Scenario: Ordenação por ordem alfabetica (Z-A)
    When seleciono a opcao de ordenacao de Z-A
    Then valido se os produtos estao ordenados corretamente por nome

  @Ordenacao_menor-maior
  Scenario: Ordenação por preco de menor para o maior
    When seleciono a opcao de ordenacao por preco do menor para o maior
    Then valido se os produtos estao ordenados corretamente do menor para o maior

  @Ordenacao_maior-menor
  Scenario: Ordenação por preco de maior para o menor
    When seleciono a opcao de ordenacao por preco do maior para o menor
    Then valido se os produtos estao ordenados corretamente do maior para o menor

