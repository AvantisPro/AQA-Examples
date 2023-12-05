package Pages;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

public class CallPage extends BasePage <CallPage>{

    SelenideElement callHeader = $x("//div[@class='slds-media__body']//h1//div[text()='Call']");
    SelenideElement durationNumber = $x("//p[@class='fieldComponent slds-text-body--regular slds-show_inline-block slds-truncate']/slot/lightning-formatted-text[text()='15']");

    public CallPage checkIfCallIsCreated(String text){ //check if call page is open
        String call = callHeader.getText();
        Assert.assertEquals(call, text);
        return this;
    }

    public CallPage checkDuration(String durReq){ //check if call duration equals to set duration in previous test
        String dur1 = durationNumber.getText();
        Assert.assertEquals(dur1, durReq);
        return this;
    }
}
