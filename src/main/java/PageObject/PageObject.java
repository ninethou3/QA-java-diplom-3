package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;

public class PageObject {

    public static String BASE_URL = "https://stellarburgers.nomoreparties.site";

    @FindBy(xpath = ".//p[text()='Личный Кабинет']")
    public SelenideElement personalAccount;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div/p[1]/a")
    public SelenideElement registrationLink;

    @FindBy(xpath = ".//input[@type='text']")
    public SelenideElement namePlace;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    public SelenideElement emailPlace;

    @FindBy(xpath = ".//input[@name='name']")
    public SelenideElement emailPlaceOnEnterPage;

    @FindBy(xpath = ".//input[@name='Пароль']")
    public SelenideElement password;

    @FindBy(xpath = ".//button[text()='Зарегистрироваться']")
    public SelenideElement registrationButton;

    @FindBy(xpath = ".//a[@href='/register']")
    public SelenideElement registrationButtonLink;

    @FindBy(xpath = ".//a[@href='/forgot-password']")
    public SelenideElement forgotPasswordLink;

    @FindBy(xpath = ".//button[text()='Войти']")
    public SelenideElement enterButton;

    @FindBy(xpath = ".//button[text()='Оформить заказ']")
    public SelenideElement orderButton;

    @FindBy(xpath = ".//p[@class='input__error text_type_main-default']")
    public SelenideElement registrationError;

    @FindBy(xpath = ".//button[text()='Войти в аккаунт']")
    public SelenideElement logInAccount;

    @FindBy(className = "Auth_link__1fOlj")
    public SelenideElement logInRegistrationForm;

    @FindBy(xpath = ".//p[text()='В этом разделе вы можете изменить свои персональные данные']")
    public SelenideElement accountText;

    @FindBy(xpath = ".//p[text()='Конструктор']")
    public SelenideElement constructor;

    @FindBy(xpath = ".//a[@href='/']")
    public SelenideElement stellar;

    @FindBy(xpath = ".//button[@type='button']")
    public SelenideElement exitButton;

    @FindBy(xpath = ".//span[text()='Булки']")
    public SelenideElement buns;

    @FindBy(xpath = ".//span[text()='Соусы']")
    public SelenideElement souses;

    @FindBy(xpath = ".//span[text()='Начинки']")
    public SelenideElement fills;

    @FindBy(xpath = ".//p[text()='Мясо бессмертных моллюсков Protostomia']")
    public SelenideElement fillsMeat;

    @Step("Клик на кнопку Личный кабинет")
    public PageObject clickPersonalAccount(){
        personalAccount.shouldBe(enabled).click();
        return this;
    }
    @Step("Ввод имени")
    public PageObject setName(String name){
        namePlace.setValue(name);
        return this;
    }
    @Step("Ввод емейла")
    public PageObject sendEmail(String email){
        emailPlace.setValue(email);
        return this;
    }
    @Step("Ввод емейла на стринце входа в аккаунт")
    public PageObject sendEmailOnEnterPage(String email){
        emailPlaceOnEnterPage.setValue(email);
        return this;
    }
    @Step("Ввод пароля")
    public PageObject sendPassword(String pass){
        password.setValue(pass);
        return this;
    }
    @Step("Нажать на кнопку регистрации")
    public PageObject clickRegister(){
        registrationButton.shouldBe(enabled).click();
        Selenide.sleep(5000);
        return this;
    }
    @Step("Проверка что кнопка входа видна")
    public boolean getEnter(){
        return enterButton.is(visible);
    }
    @Step("Нажать Ентер")
    public PageObject clickEnter(){
        enterButton.shouldBe(enabled);
        enterButton.click();
        return this;
    }
    @Step("Кнопка заказа видна")
    public boolean isOrderButtonVisible(){
        orderButton.shouldBe(enabled);
        return orderButton.is(visible);
    }
    @Step("Сообще об ошибке регстрации видна")
    public boolean registrationError(){
        return registrationError.is(visible);
    }
    @Step("Входа в аккаунт")
    public PageObject logInAccount(){
        logInAccount.shouldBe(enabled);
        logInAccount.click();
        return this;
    }
    @Step("Вход через форму регистрации")
    public PageObject logInRegistrationForm(){
        logInRegistrationForm.shouldBe(enabled);
        logInRegistrationForm.click();
        return this;
    }

    public PageObject logInRegistrationFormByLink(){
        registrationButtonLink.shouldBe(enabled);
        registrationButtonLink.click();
        return this;
    }
    @Step("Нажатие на ссылку Забыл пароль")
    public PageObject logInForgotPasswordLink(){
        forgotPasswordLink.shouldBe(enabled);
        forgotPasswordLink.click();
        return this;
    }
    public boolean accountText(){
        accountText.shouldHave(exactText("В этом разделе вы можете изменить свои персональные данные"));
        return accountText.is(visible);
    }
    public PageObject exitButtonClick(){
        exitButton.click();
        Selenide.sleep(5000);
        return this;
    }

    public PageObject transitToConstructor(){
        constructor.shouldBe(enabled);
        constructor.click();
        Selenide.sleep(5000);
        return this;
    }
    public PageObject transitToStellar(){
        stellar.shouldBe(enabled);
        stellar.click();
        Selenide.sleep(5000);
        return this;
    }
    public PageObject bunsClick(){
        buns.shouldBe(enabled);
        buns.click();
        return this;
    }
    public PageObject sousesClick(){
        souses.shouldBe(enabled);
        souses.click();
        return this;
    }
    public boolean fillsClick(){
        fills.shouldBe(enabled);
        fills.click();
        return fillsMeat.is(visible);
    }
}
