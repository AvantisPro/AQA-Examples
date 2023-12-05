import Pages.LogACallPage;
import Pages.LoginPage;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;

public class LogACallTest {

    LogACallPage logACallPage = new LogACallPage();
    LoginPage loginPage = new LoginPage();
    @Before
    public void setUp(){
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
        Configuration.timeout = 5000;

        //open login page before each test
        loginPage
                .openLoginPage()
                .inputLogin("oceadmin_crm3@oce-pipeline-2.com.clnmobile.prev")
                .inputPassword("crm1OCE1")
                .clickOnLoginButton()
                .checkIfHomePageIsOpen();
    }

    @Test
    public void CreateACall(){
        logACallPage
                .openAccountPage()
                .clickOnLogACallButton()
                .callModalIsOpen("New Call")
                .chooseVisitRecordType()
                .clickNextButton()
                .modalWIthRTisOpen()
                .checkAccountField("AARON H MORITA")
                .chooseDate()
                .setDuration()
                .saveCall()

                .checkIfCallIsCreated("Call")
                .checkDuration("15");


    }
}
