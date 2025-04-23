# Автоматизированные тесты для Stellar Burgers

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Selenium](https://img.shields.io/badge/-selenium-%43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![Allure](https://img.shields.io/badge/-allure-%23FF6A00?style=for-the-badge)

Автоматизированное тестирование веб-приложения Stellar Burgers. Включает тесты регистрации, авторизации, а также навигационные тесты.

## Тестируемая функциональность

### Авторизация
- Успешная регистрация
- Ошибка при некорректном пароле (<6 символов)
- Вход через:
    - Кнопку «Войти в аккаунт» на главной
    - Кнопку «Личный кабинет»
    - Форму регистрации
    - Форму восстановления пароля

### Личный кабинет
- Переход в личный кабинет
- Переход в конструктор:
    - Через кнопку «Конструктор»
    - Через логотип Stellar Burgers
- Выход из аккаунта

### Конструктор бургеров
- Переходы между разделами:
    - «Булки»
    - «Соусы»
    - «Начинки»

## Поддерживаемые браузеры
- Google Chrome
- Яндекс.Браузер

## Технологический стек

| Компонент               | Версия    | Назначение                     |
|-------------------------|-----------|--------------------------------|
| Java                    | 11        | Основной язык программирования |
| Selenium WebDriver      | 4.26.0    | Автоматизация браузера         |
| WebDriverManager        | 5.6.3     | Управление драйверами          |
| JUnit 4                 | 4.13.2    | Фреймворк для тестирования     |
| Allure Framework        | 2.15.0    | Генерация отчетов              |
| RestAssured             | 5.5.0     | Тестирование API               |
| Lombok                  | 1.18.34   | Упрощение boilerplate-кода     |

## Запуск тестов

```bash
mvn clean test