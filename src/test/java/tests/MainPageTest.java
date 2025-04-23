package tests;

import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.*;

public class MainPageTest extends BaseTest {

    @Test
    @DisplayName("Проверка раздела 'Булки' по умолчанию")
    @Description("При открытии главной страницы по умолчанию должен быть активен раздел 'Булки'")
    public void testBunsSectionIsActiveByDefault() {
        // Инициализация главной страницы
        MainPage mainPage = new MainPage(driver);
        // Открытие главной страницы
        mainPage.open();

        // Проверка что вкладка "Булки" активна по умолчанию
        assertTrue("Раздел 'Булки' не активен по умолчанию",
                mainPage.isBunsTabActive());
        // Проверка что заголовок раздела "Булки" отображается
        assertTrue("Заголовок 'Булки' не отображается",
                mainPage.isBunsHeaderDisplayed());
    }

    @Test
    @DisplayName("Проверка переключения на раздел 'Булки'")
    @Description("После переключения с другого раздела на 'Булки' должен отображаться корректный контент")
    public void testSwitchToBunsSection() {
        // Инициализация главной страницы
        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        // Шаг 1: Переключение на вкладку "Соусы" для изменения состояния
        mainPage.clickSaucesSection();
        // Проверка что вкладка "Соусы" стала активной
        assertTrue(mainPage.isSaucesTabActive());

        // Шаг 2: Возврат на вкладку "Булки"
        mainPage.clickBunsSection();
        // Проверка что вкладка "Булки" снова активна
        assertTrue("Раздел 'Булки' не стал активным после переключения",
                mainPage.isBunsTabActive());
        // Проверка что заголовок раздела "Булки" отображается
        assertTrue("Заголовок 'Булки' не отображается после переключения",
                mainPage.isBunsHeaderDisplayed());
    }

    @Test
    @DisplayName("Переход в раздел 'Соусы'")
    @Description("При клике на вкладку 'Соусы' должен активироваться соответствующий раздел")
    public void testNavigateToSaucesSection() {
        // Инициализация главной страницы
        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        // Клик по вкладке "Соусы"
        mainPage.clickSaucesSection();

        // Проверка что вкладка "Соусы" стала активной
        assertTrue("Раздел 'Соусы' не активен",
                mainPage.isSaucesTabActive());
        // Проверка что заголовок раздела "Соусы" отображается
        assertTrue("Заголовок 'Соусы' не отображается",
                mainPage.isSaucesHeaderDisplayed());
    }

    @Test
    @DisplayName("Переход в раздел 'Начинки'")
    @Description("При клике на вкладку 'Начинки' должен активироваться соответствующий раздел")
    public void testNavigateToFillingsSection() {
        // Инициализация главной страницы
        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        // Клик по вкладке "Начинки"
        mainPage.clickFillingsSection();

        // Проверка что вкладка "Начинки" стала активной
        assertTrue("Раздел 'Начинки' не активен",
                mainPage.isFillingsTabActive());
        // Проверка что заголовок раздела "Начинки" отображается
        assertTrue("Заголовок 'Начинки' не отображается",
                mainPage.isFillingsHeaderDisplayed());
    }
}