import PageObject.PageObject;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class SectionsTest {

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Тест перехода из одного раздела конструктора в другой")
    public void sectionsTest(){
        final boolean sections = open(PageObject.BASE_URL, PageObject.class)
                .logInAccount()
                .sendEmailOnEnterPage("komiguy@yandex.ru")
                .sendPassword("12345678")
                .clickEnter()
                .transitToStellar()
                .sousesClick()
                .bunsClick()
                .fillsClick();

        assertTrue(sections);
    }
}
