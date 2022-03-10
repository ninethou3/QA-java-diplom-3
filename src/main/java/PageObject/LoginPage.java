package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;

public class LoginPage {

    @FindBy(xpath = ".//a[@href='/register']")
    public SelenideElement registrationButtonLink;

    @FindBy(xpath = ".//input[@name='name']")
    public SelenideElement emailPlaceOnEnterPage;

    @FindBy(xpath = ".//input[@name='Пароль']")
    public SelenideElement password;

    @FindBy(xpath = ".//button[text()='Войти']")
    public SelenideElement enterButton;

    @FindBy(xpath = ".//a[@href='/forgot-password']")
    public SelenideElement forgotPasswordLink;

    @FindBy(className = "Auth_link__1fOlj")
    public SelenideElement logInRegistrationForm;

    public LoginPage logInRegistrationFormByLink(){
        registrationButtonLink.shouldBe(enabled);
        registrationButtonLink.click();
        return this;
    }
    @Step("Ввод емейла на стринце входа в аккаунт")
    public LoginPage sendEmailOnEnterPage(String email){
        emailPlaceOnEnterPage.setValue(email);
        return this;
    }
    @Step("Ввод пароля")
    public LoginPage sendPassword(String pass){
        password.setValue(pass);
        return this;
    }
    @Step("Нажать Ентер")
    public LoginPage clickEnter(){
        enterButton.shouldBe(enabled);
        enterButton.click();
        return this;
    }
    @Step("Нажатие на ссылку Забыл пароль")
    public LoginPage logInForgotPasswordLink(){
        forgotPasswordLink.shouldBe(enabled);
        forgotPasswordLink.click();
        return this;
    }
    @Step("Вход через форму регистрации")
    public LoginPage logInRegistrationForm(){
        logInRegistrationForm.shouldBe(enabled);
        logInRegistrationForm.click();
        return this;
    }
    @Step("Проверка что кнопка входа видна")
    public boolean getEnter(){
        enterButton.shouldBe(enabled);
        return enterButton.is(visible);
    }
}
