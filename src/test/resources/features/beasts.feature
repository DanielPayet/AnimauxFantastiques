Feature: API des beasts

  Scenario: le client fais une requete GET sur les beasts
    When le client appel /beasts
    Then le client reçoit le code HTTP 200
    And reçoit un certain nombre d'animaux