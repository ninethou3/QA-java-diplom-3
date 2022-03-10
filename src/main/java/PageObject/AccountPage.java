package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;

public class AccountPage {

    @FindBy(xpath = ".//button[@type='button']")
    public SelenideElement exitButton;

    @Step("Клик по кнопке выход")
    public AccountPage exitButtonClick(){
        exitButton.shouldBe(enabled);
        exitButton.click();
        return this;
    }
}
