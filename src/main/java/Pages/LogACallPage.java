package Pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import static com.codeborne.selenide.Selenide.*;

public class LogACallPage extends BasePage <LogACallPage>{

    //calls tab
    private SelenideElement newCallButton = $x("//lightning-button//button[@name='Account.OCE__LogACall']");

    //RT pick
    private SelenideElement callModalHeader = $(By.id("modal-heading-01"));
    private SelenideElement recordTypeVisit = $x("//div[@class='slds-form-element__control']/span[@class='recordTypeOption'][5]");
    private SelenideElement nextButton = $x("//div[@class='slds-text-align_right']/button");

    //modal with fields
    private SelenideElement headerWithRT = $x("//h2[@class='slds-text-heading--medium slds-hyphenate']");
    private SelenideElement accountField = $(By.id("combobox-input-268"));
    private SelenideElement dateField = $(By.id("input-276"));
    private SelenideElement timeField = $(By.id("combobox-input-280"));
    private SelenideElement durationField = $(By.id("combobox-button-327"));
    private SelenideElement duration15 = $x("//span[@title='15']");
    private SelenideElement saveButton = $x("//lightning-button[@class='slds-m-around--xx-small'][2]/button");




    public  LogACallPage openAccountPage(){ //account page
        open("https://oce-pipeline-2--dcmb081145.sandbox.lightning.force.com/lightning/r/Account/0010k00001X6B4YAAV/view");
        return this;
    }

    public LogACallPage clickOnLogACallButton(){ //click on button LogACAll
        newCallButton.click();
        return this;
    }

    public LogACallPage callModalIsOpen(String header){ //check if modal is open
        String modalHeader = callModalHeader.getText();
        Assert.assertEquals(modalHeader, header);
        return this;
    }

    public LogACallPage chooseVisitRecordType(){ //choose record type for a call
        recordTypeVisit.click();
        recordTypeVisit.isSelected();
        return this;
    }

    public LogACallPage clickNextButton(){ //click next
        nextButton.click();
        return this;
    }

    public LogACallPage modalWIthRTisOpen(){ //check if next modal is open
        String header = headerWithRT.getText();
        Assert.assertEquals(header, "New Call: Visit");
        return this;
    }

    //fields
    public LogACallPage checkAccountField(String name){ //check if required account field is filled
        String account = accountField.getText();
        Assert.assertEquals(account, name);
        return this;
    }

    public LogACallPage chooseDate(){ //set date for a call
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        LocalDateTime ldt = LocalDateTime.now();
        dateField.setValue(dtf.format(ldt));
        return this;
    }

    public LogACallPage setDuration(){ //set duration of a call
        durationField.click();
        duration15.click();
        return this;
    }

    public CallPage saveCall(){ //click save and proceed to the call page
        saveButton.click();
        return page(CallPage.class);
    }




}
