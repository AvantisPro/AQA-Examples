package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.*;


public class LoginPage extends BasePage <LoginPage>{


    private SelenideElement usernameField = $(By.id("username"));
    private SelenideElement passwordField = $(By.id("password"));
    private SelenideElement loginButton = $(By.name("Login"));

    private SelenideElement loginErrorText = $x("//*[@id=\"error\"]");

    private SelenideElement rememberMeCheckbox = $(By.id("rememberUn"));
    private SelenideElement forgotPassLink = $(By.id("forgot_password_link"));
    private SelenideElement customDomainLink = $(By.id("mydomainLink"));

    private SelenideElement privacyLink = $(By.id("privacy-link"));
    private SelenideElement regForDreamforce = $x("(//div[@class='btn-container  ']/a/span[1])[2]");


    public  LoginPage openLoginPage(){
        open("https://test.salesforce.com/");
        return this;
    }

    public LoginPage inputLogin(String login){
        usernameField.setValue(login);
        return this; //працюємо тільки на MainPage і повертаємо її
    }

    public LoginPage inputPassword(String password){
        passwordField.setValue(password); //введеня паролю
        return this;
    }

    public LoginPage checkCheckbox(){ //клік на чекбокс та перевірка чи він обраний
        rememberMeCheckbox.click();
        rememberMeCheckbox.isSelected();
        return this;
    }

    public LoginPage Submit() throws InterruptedException { //клікаємо на логін та переходимо на іншу сторінку
        loginButton.click();
        return this;
    }

    public HomePage clickOnLoginButton(){ //клікаємо на логін та переходимо на іншу сторінку
        loginButton.click();
        return page(HomePage.class);
    }

    public LoginPage checkIfLoginErrorIsPresent(String errorText){
        loginErrorText.shouldBe(Condition.visible);
        String error = loginErrorText.getText();
        Assert.assertEquals(error, errorText);
        return this;
    }

    public ForgotPassPage clickOnForgotPassLink(){
        forgotPassLink.click();
        return page(ForgotPassPage.class);
    }

}
