package utils;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import net.datafaker.Faker;

public class UserGenerator {
    private static final Faker faker = new Faker();

    // Генерация пользователя с рандомными валидными данными и регистрация через API
    public static User createRandomUserThroughAPI(UserClient userClient) {
        User user = generateRandomUser();
        Response response = userClient.create(user);

        if (response.statusCode() != HttpStatus.SC_OK) {
            System.out.println("Ошибка создания пользователя: " + response.body().asString());
            throw new AssertionError("Не удалось создать пользователя через API. Статус: " + response.statusCode());
        }

        // Добавляем токен к пользователю
        String token = response.jsonPath().getString("accessToken");
        user.setToken(token);

        return user;
    }

    public static User getRandomUser() {
        return generateRandomUser();
    }

    // Генерация пользователя с уникальными email, паролем и именем
    private static User generateRandomUser() {
        return User.builder()
                .email(generateUniqueEmail())
                .password(generateSecurePassword())
                .name(generateValidName())
                .build();
    }

    // Генерация безопасного пароля
    private static String generateSecurePassword() {
        return faker.internet().password(10, 16, true, true, true);
    }

    // Генерация уникального email
    private static String generateUniqueEmail() {
        return faker.internet().emailAddress(faker.name().username().replace(".", "") + System.currentTimeMillis());
    }

    // Генерация валидного имени
    private static String generateValidName() {
        return faker.regexify("[A-Z][a-z]{3,8} [A-Z][a-z]{3,8}");
    }

    // Генерация пользователя с коротким паролем (для негативных тестов)
    public static User getUserWithShortPassword() {
        return User.builder()
                .email(generateUniqueEmail())
                .password("123") // Специально короткий пароль
                .name(generateValidName())
                .build();
    }
}