import PageObject.AccountPage;
import PageObject.MainPage;
import PageObject.LoginPage;
import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class PersonalAccountTest {

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
    @DisplayName("Переход в конструктор из личного кабинета")
    public void transitionToConstructorTest(){

        open(MainPage.BASE_URL, MainPage.class)
                .logInAccount();
        page(LoginPage.class)
                .sendEmailOnEnterPage(data.get("email"))
                .sendPassword(data.get("password"))
                .clickEnter();
        final boolean isOrderButtonVisible = page(MainPage.class)
                .clickPersonalAccount()
                .transitToConstructor()
                .clickPersonalAccount()
                .transitToStellar()
                .isOrderButtonVisible();

        assertTrue(isOrderButtonVisible);
    }

    @Test
    @DisplayName("Выход из личного кабинета")
    public void exitFromPersonalAccountTest(){

        open(MainPage.BASE_URL, MainPage.class)
                .logInAccount();
        page(LoginPage.class)
                .sendEmailOnEnterPage(data.get("email"))
                .sendPassword(data.get("password"))
                .clickEnter();
        page(MainPage.class)
                .clickPersonalAccount();
        page(AccountPage.class)
                .exitButtonClick();
        final boolean exitFrom = page(LoginPage.class)
                .getEnter();

        assertTrue(exitFrom);
    }
}
