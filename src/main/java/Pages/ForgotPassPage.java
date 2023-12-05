package Pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ForgotPassPage extends BasePage <ForgotPassPage>{

    private SelenideElement forgotPassHeader = $(By.id("header"));

    public  ForgotPassPage checkIfForgotPassPageIsOpen(){
        String header = forgotPassHeader.getText();
        Assert.assertEquals(header, "Forgot Your Password");
        return this;
    }
}
