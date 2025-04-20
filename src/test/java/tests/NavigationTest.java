package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageObject.*;

import static org.junit.Assert.*;

public class NavigationTest extends BaseTest {

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    public void testNavigationFromProfileToConstructorViaLogo() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        // Переход на страницу логина
        LoginPage loginPage = mainPage.clickAccountButton();

        // Выполнение входа
        loginPage.loginFromLoginPage(user);

        // Переход в профиль
        ProfilePage profilePage = new MainPage(driver).goToProfilePage();

        // Возврат на главную через логотип
        mainPage = profilePage.clickLogoLink();

        assertTrue("Не удалось вернуться на главную страницу",
                mainPage.isOrderButtonVisible());
    }
}