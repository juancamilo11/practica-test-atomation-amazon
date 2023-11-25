Feature: Buscar productos con envío gratis por termino de busqueda

  @Search
  Scenario:
    Given El usuario esta en la pagina de inicio de Amazon
    When Ingresa el termino de busqueda
    And Presiona el boton de buscar
    And El usuario da click en Elegible para envio gratis
    Then El usuario deberá ver los resultados de la busqueda con envio gratis
