Feature: Buscar productos por termino de busqueda

  @Search
  Scenario:
    Given El usuario se encuentra en la pagina de inicio
    When Ingresa el termino de busqueda en el buscador
    And Presiona Enter
    And Selecciona el primer resultado
    Then El usuario deberá ver la pagina del producto
