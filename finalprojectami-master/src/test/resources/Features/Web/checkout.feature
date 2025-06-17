@web @priority4
Feature: Checkout in Demoblaze

  @negative
  Scenario Outline: User try to checkout with invalid data
    Given user open Demoblaze page
    When user add "Samsung galaxy s6" to cart
    And user go to cart page
    And user open checkout form
    And user fill checkout form with following data:
      | name   | country   | city    | card       | month | year  |
      | <name> | <country> | <city>  | <card>     | <month> | <year> |
    And User hit Purchase button based on data validity
    Then will show message "<expected_message>" based on <isSuccess>

    Examples:
      | name  | country   | city    | card       | month | year  | isSuccess | expected_message                    |
      |       | Indonesia | Jakarta | 123456789  | 12    | 2025  | false     | Please fill out Name and Creditcard. |
      | Indah | Indonesia | Jakarta |            | 12    | 2025  | false     | Please fill out Name and Creditcard. |
      | Indah | Indonesia | Jakarta | abcd1234   | 12    | 2025  | true      | Thank you for your purchase!         |
      | Indah | Indonesia | Jakarta | 1234       | 12    | 2025  | true      | Thank you for your purchase!         |
      | Indah | Indonesia | Jakarta | 123456789  | 15    | 2025  | true      | Thank you for your purchase!         |
      | Indah | Indonesia | Jakarta | 123456789  | 12    | 2020  | true      | Thank you for your purchase!         |

  @positive
  Scenario Outline: User successfully checkout with valid data
    Given user open Demoblaze page
    When user add "<produk>" to cart
    And user go to cart page
    And user open checkout form
    And user fill checkout form with following data:
      | name   | country   | city    | card       | month | year  |
      | <name> | <country> | <city>  | <card>     | <month> | <year> |
    And User hit Purchase button based on data validity
    Then Order on proccess and show success message "Thank you for your purchase!"
    And User closed purchase confirmation pop up

    Examples:
      | produk             | name  | country   | city    | card       | month | year  |
      | Samsung galaxy s6  | Indah | Indonesia | Jakarta | 123456789  | 12    | 2025  |
      | Sony xperia z5     | Raka  | Jepang    | Tokyo   | 987654321  | 11    | 2026  |