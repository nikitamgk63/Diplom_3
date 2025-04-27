package pages;

import config.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static config.Constants.MAIN_PAGE_URL;

public class MainPage extends BasePage {

    private final By mainPageLogo = By.xpath("//a[@href='/']");
    private final By accountButton = By.xpath("//p[contains(text(),'Личный Кабинет')]");
    private final By orderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By saucesButton = By.xpath("//span[text()='Соусы']/parent::div");
    private final By fillingsButton = By.xpath("//span[text()='Начинки']/parent::div");
    private final By bunsHeader = By.xpath("//h2[text()='Булки']");
    private final By saucesHeader = By.xpath("//h2[text()='Соусы']");
    private final By fillingsHeader = By.xpath("//h2[text()='Начинки']");
    private final By constructorHeader = By.xpath(".//h1[text()='Соберите бургер']");
    private final By activeTab = By.xpath("//div[contains(@class, 'tab_tab_type_current__2BEPc')]");
    private final By bunsButton = By.xpath("//span[text()='Булки']/parent::div");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие главной страницы")
    public void open() {
        driver.get(MAIN_PAGE_URL);
    }

    @Step("Клик на кнопку «Личный кабинет» и переход на страницу авторизации")
    public LoginPage clickAccountButton() {
        clickElement(accountButton);
        return new LoginPage(driver);
    }

    @Step("Переход в Личный кабинет, ожидаем страницу профиля")
    public ProfilePage goToProfilePage() {
        waitForElement(accountButton);
        driver.findElement(accountButton).click();
        waitForUrl(Constants.PROFILE_PAGE_URL);
        return new ProfilePage(driver);
    }

    @Step("Кнопка 'Оформить заказ'")
    public boolean isOrderButtonVisible() {
        return isElementDisplayed(orderButton);
    }

    @Step("Ожидание отображения заголовка конструктора")
    public boolean waitConstructorHeader() {
        return isElementDisplayed(constructorHeader);
    }

    @Step("Клик на раздел 'Булки'")
    public void clickBunsSection() {
        waitForElement(bunsButton);
        clickElement(bunsButton);
    }

    @Step("Клик на раздел 'Соусы'")
    public void clickSaucesSection() {
        waitForElement(saucesButton);
        clickElement(saucesButton);
    }

    @Step("Клик на раздел 'Начинки'")
    public void clickFillingsSection() {
        waitForElement(fillingsButton);
        clickElement(fillingsButton);
    }

    @Step("Проверка отображения главной страницы")
    public boolean isMainPageDisplayed() {
        return isElementDisplayed(mainPageLogo);
    }

    @Step("Проверка отображения заголовка 'Булки'")
    public boolean isBunsHeaderDisplayed() {
        return isElementDisplayed(bunsHeader);
    }

    @Step("Проверка отображения заголовка 'Соусы'")
    public boolean isSaucesHeaderDisplayed() {
        return isElementDisplayed(saucesHeader);
    }

    @Step("Проверка отображения заголовка 'Начинки'")
    public boolean isFillingsHeaderDisplayed() {
        return isElementDisplayed(fillingsHeader);
    }

    @Step("Проверить, что активен раздел 'Булки'")
    public boolean isBunsTabActive() {
        WebElement activeTabElement = driver.findElement(activeTab);
        return activeTabElement.findElement(By.xpath(".//span")).getText().equals("Булки");
    }

    @Step("Проверить, что активен раздел 'Соусы'")
    public boolean isSaucesTabActive() {
        WebElement activeTabElement = driver.findElement(activeTab);
        return activeTabElement.findElement(By.xpath(".//span")).getText().equals("Соусы");
    }

    @Step("Проверить, что активен раздел 'Начинки'")
    public boolean isFillingsTabActive() {
        WebElement activeTabElement = driver.findElement(activeTab);
        return activeTabElement.findElement(By.xpath(".//span")).getText().equals("Начинки");
    }
}
