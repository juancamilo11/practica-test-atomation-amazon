Feature: Buscar productos por termino de busqueda

  @Search
  Scenario:
    Given El usuario se encuentra en la pagina de inicio de Amazon
    When Ingresa un termino de busqueda
    And Presiona la tecla Enter
    Then El usuario deberá ver los resultados de la busqueda
