package Pages;


import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class AccountPage extends BasePage <AccountPage>{

    private SelenideElement accountName = $x("//lightning-formatted-name");
    private SelenideElement logACallButton = $(By.name("Account.OCE__LogACall"));


    public AccountPage openAccountPage(){ //Morita
        open("https://oce-pipeline-2--dcmb031521.sandbox.lightning.force.com/lightning/r/Account/0010k00001X6B4YAAV/view");
        return this;
    }

    public LogACallPage createCall(){
        logACallButton.click();
        return page(LogACallPage.class);
    }


}
