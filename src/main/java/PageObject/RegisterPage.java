package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class RegisterPage {
    @FindBy(xpath = ".//input[@type='text']")
    public SelenideElement namePlace;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    public SelenideElement emailPlace;

    @FindBy(xpath = ".//input[@name='Пароль']")
    public SelenideElement password;

    @FindBy(xpath = ".//button[text()='Зарегистрироваться']")
    public SelenideElement registrationButton;

    @FindBy(xpath = ".//p[@class='input__error text_type_main-default']")
    public SelenideElement registrationError;

    @Step("Ввод имени")
    public RegisterPage setName(String name){
        namePlace.setValue(name);
        return this;
    }

    @Step("Ввод емейла")
    public RegisterPage sendEmail(String email){
        emailPlace.setValue(email);
        return this;
    }

    @Step("Ввод пароля")
    public RegisterPage sendPassword(String pass){
        password.setValue(pass);
        return this;
    }

    @Step("Нажать на кнопку регистрации")
    public RegisterPage clickRegister(){
        registrationButton.shouldBe(enabled).click();
        return this;
    }

    @Step("Сообще об ошибке регстрации видна")
    public boolean registrationError(){
        return registrationError.is(visible);
    }
}
