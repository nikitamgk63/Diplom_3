package tests;

import config.Constants;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;
import static org.junit.Assert.assertTrue;

public class LogoutTest extends BaseTest {

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете.")
    @Description("Проверка функционала выхода из системы через кнопку 'Выйти' в личном кабинете")
    public void logOutTestSuccess() {
        // Открываем страницу логина
        driver.get(Constants.LOGIN_PAGE_URL);
        LoginPage loginPage = new LoginPage(driver);

        // Добавляем ожидание загрузки страницы
        loginPage.waitLoginPage();

        // Логинимся через LoginPage
        loginPage.loginFromLoginPage(user);
        assertTrue("Пользователь не авторизован", new MainPage(driver).isOrderButtonVisible());

        // Переход в личный кабинет с явным ожиданием
        ProfilePage profilePage = new MainPage(driver).goToProfilePage();
        profilePage.waitProfilePage();

        // Выход и проверка
        loginPage = profilePage.clickExitButton();
        assertTrue("Не вернулись на страницу логина", loginPage.isLoginPage());
    }

}