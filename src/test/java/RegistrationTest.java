import PageObject.PageObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

//    @Before
//    public void setup(){
//        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
//    }

    @After
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void registrationTest(){
        String email = RandomStringUtils.randomAlphabetic(8) + "@yandex.ru";

        final boolean isRegistered = open(PageObject.BASE_URL, PageObject.class)
                .clickPersonalAccount()
                .logInRegistrationFormByLink()
                .setName("Fedor")
                .sendEmail(email)
                .sendPassword("12345678")
                .clickRegister()
                .getEnter();

        assertTrue(isRegistered);
    }

    @Test
    public void registrationErrorTest(){
        final boolean isRegisteredError = open(PageObject.BASE_URL, PageObject.class)
                .clickPersonalAccount()
                .logInRegistrationFormByLink()
                .setName("Fedor")
                .sendEmail("komiguyyy666@yandex.ru")
                .sendPassword("123")
                .clickRegister()
                .registrationError();

        assertTrue(isRegisteredError);
    }
}
