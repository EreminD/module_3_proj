# language: ru
Функция: поиск по сайту

  Структура сценария: успешный поиск
    * я на главной странице
    * я выполняю поиск по слову "<term>"
    * я вижу список товаров со словом "<result>"

    Примеры:
      | term   | result |
      | Java   | Java-1 |
      | Python | PYTHON |
      | Ruby   | Buby   |


  Сценарий: я могу посмотреть корзину
    * я на странице корзины



