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

        final boolean isOrderButtonVisible = open(PageObject.BASE_URL, PageObject.class)
                .logInAccount()
                .sendEmailOnEnterPage(data.get("email"))
                .sendPassword(data.get("password"))
                .clickEnter()
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

        final boolean exitFrom = open(PageObject.BASE_URL, PageObject.class)
                .logInAccount()
                .sendEmailOnEnterPage(data.get("email"))
                .sendPassword(data.get("password"))
                .clickEnter()
                .clickPersonalAccount()
                .exitButtonClick()
                .getEnter();

        assertTrue(exitFrom);
    }
}
