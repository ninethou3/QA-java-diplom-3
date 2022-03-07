import PageObject.PageObject;
import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    UserOperations user = new UserOperations();
    Map<String, String> data;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        data = user.register();
    }

    @After
    public void tearDown() {
        closeWebDriver();
        user.delete();
    }

    @Test
    @DisplayName("Тест входа через кнопку личный кабинет")
    public void logInPersonalAccountTest(){

        final boolean isOrderButtonVisible = open(PageObject.BASE_URL, PageObject.class)
                .clickPersonalAccount()
                .sendEmailOnEnterPage(data.get("email"))
                .sendPassword(data.get("password"))
                .clickEnter()
                .isOrderButtonVisible();

        assertTrue(isOrderButtonVisible);
    }

    @Test
    @DisplayName("Тест логина через кнопку Войти в аккаунт на главной странице")
    public void logInAccountOnMainPageTest(){

        final boolean isOrderButtonVisible = open(PageObject.BASE_URL, PageObject.class)
                .logInAccount()
                .sendEmailOnEnterPage(data.get("email"))
                .sendPassword(data.get("password"))
                .clickEnter()
                .isOrderButtonVisible();

        assertTrue(isOrderButtonVisible);
    }

    @Test
    @DisplayName("Тест входа через форму регстрации")
    public void logInTroughRegistrationFormTest(){



        final boolean isOrderButtonVisible = open(PageObject.BASE_URL, PageObject.class)
                .logInAccount()
                .logInForgotPasswordLink()
                .logInRegistrationForm()
                .sendEmailOnEnterPage(data.get("email"))
                .sendPassword(data.get("password"))
                .clickEnter()
                .isOrderButtonVisible();

        assertTrue(isOrderButtonVisible);
    }
}