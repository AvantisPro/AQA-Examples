package Pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BasePage <HomePage>{

    private SelenideElement oceHeader = $x("//span[@title='OCE']");

    public  HomePage checkIfHomePageIsOpen(){
        String header = oceHeader.getText();
        Assert.assertEquals(header, "OCE");
        return this;
    }
}
