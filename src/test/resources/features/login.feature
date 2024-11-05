Feature: Login

  @login
  Scenario: login exitoso

    Given el usuario abre la pagina web
    When el usuario ingresa las credenciales
      | email                     | password   |
      | edwinjero1989@gmail.com   | Doris_1966 |
      | edwinjero1989@hotmail.com | 12346464   |
    Then el usuario podra ver su nombre