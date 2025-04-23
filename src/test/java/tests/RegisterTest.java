package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;
import pages.RegisterPage;
import utils.UserGenerator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RegisterTest extends BaseTest {
    private RegisterPage registerPage;

    @Before
    @Description("Подготовка тестовых данных и открытие страницы регистрации")
    public void init() {
        // Генерация уникального пользователя для каждого теста
        registerPage = new RegisterPage(driver);
        registerPage.open();
    }

    @Test
    @DisplayName("Тест успешной регистрации пользователя")
    @Description("Проверка успешной регистрации нового пользователя с валидными данными")
    public void registerNewUserSuccess() {
        user = UserGenerator.getRandomUser();
        // Добавление данных в отчет Allure
        Allure.addAttachment("Тестовые данные",
                "Имя: " + user.getName() + "\n" +
                        "Email: " + user.getEmail() + "\n" +
                        "Пароль: " + user.getPassword());
        // Регистрация через UI
        registerPage.performRegistration(user);
        // Проверка авторизации через API
        userToken = userClient.login(user)
                .then()
                .statusCode(200)
                .extract()
                .path("accessToken");
        assertNotNull("Токен пользователя не получен", userToken);
    }

    @Test
    @DisplayName("Негативная регистрация с коротким паролем")
    @Description("Проверка отображения ошибки при попытке регистрации с паролем короче 6 символов")
    public void registerNewUserWithShortPasswordFail() {
        // Генерация пользователя с коротким паролем
        user = UserGenerator.getUserWithShortPassword();

        // Регистрация
        registerPage.fillRegistrationForm(user);
        registerPage.clickRegisterButton();

        // Проверка сообщения об ошибке
        assertEquals("Некорректный пароль", registerPage.getIncorrectPasswordMessageText());
    }
}