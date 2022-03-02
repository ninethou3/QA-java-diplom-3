import PageObject.PageObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;


public class LoginTest {

//    @Before
//    public void setup(){
//        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
//    }

    @After
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void logInPersonalAccountTest(){
        final boolean isOrderButtonVisible = open(PageObject.BASE_URL, PageObject.class)
                .clickPersonalAccount()
                .sendEmailOnEnterPage("komiguy@yandex.ru")
                .sendPassword("12345678")
                .clickEnter()
                .isOrderButtonVisible();

        assertTrue(isOrderButtonVisible);
    }

    @Test
    public void logInAccountOnMainPageTest(){
        final boolean isOrderButtonVisible = open(PageObject.BASE_URL, PageObject.class)
                .logInAccount()
                .sendEmailOnEnterPage("komiguy@yandex.ru")
                .sendPassword("12345678")
                .clickEnter()
                .isOrderButtonVisible();

        assertTrue(isOrderButtonVisible);
    }

    @Test
    public void logInTroughRegistrationFormTest(){
        final boolean isOrderButtonVisible = open(PageObject.BASE_URL, PageObject.class)
                .logInAccount()
                .logInForgotPasswordLink()
                .logInRegistrationForm()
                .sendEmailOnEnterPage("komiguy@yandex.ru")
                .sendPassword("12345678")
                .clickEnter()
                .isOrderButtonVisible();

        assertTrue(isOrderButtonVisible);
    }




}