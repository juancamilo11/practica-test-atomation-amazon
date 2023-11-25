Feature: Agregar producto al carrito de compra

  @Search
  Scenario:
    Given El usuario esta en la vista de inicio
    When Encuentra el producto que desea comprar
    And Agrega el producto al carrito de compra
    Then El carrito de compra debe tener un elemento
