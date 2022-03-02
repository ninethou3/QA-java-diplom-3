import PageObject.PageObject;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    public static final String EMAIL_POSTFIX = "@yandextest.ru";
    String email = RandomStringUtils.randomAlphabetic(10) + EMAIL_POSTFIX;
    String password = RandomStringUtils.randomAlphabetic(10);
    String name = RandomStringUtils.randomAlphabetic(10);

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
    }
    @After
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Тест регистрации нового пользователя")
    public void registrationTest(){

        final boolean isRegistered = open(PageObject.BASE_URL, PageObject.class)
                .clickPersonalAccount()
                .logInRegistrationFormByLink()
                .setName(name)
                .sendEmail(email)
                .sendPassword(password)
                .clickRegister()
                .getEnter();

        assertTrue(isRegistered);
    }

    @Test
    @DisplayName("Тест появления ошибки при некорректных регистрационных данных")
    public void registrationErrorTest(){
        final boolean isRegisteredError = open(PageObject.BASE_URL, PageObject.class)
                .clickPersonalAccount()
                .logInRegistrationFormByLink()
                .setName(name)
                .sendEmail(email)
                .sendPassword("123")
                .clickRegister()
                .registrationError();

        assertTrue(isRegisteredError);
    }
}
