import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class LoginPageTest {
    LoginPage loginPage = new LoginPage();

    @Before
    public void setUp(){
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
        Configuration.timeout = 5000;

        //open login page before each test
        loginPage.openLoginPage();
    }

    @Test
    public void wrongLoginCredsTest() throws InterruptedException {
        loginPage
                .inputLogin("123")
                .inputPassword("321")
                .Submit()
                .checkIfLoginErrorIsPresent("Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
    }

    @Test
    public void forgotPasswordCheck(){
        loginPage
                .clickOnForgotPassLink();
    }

    @Test
    public void correctLoginTest(){
        loginPage
                .inputLogin("salesrep_crm3@oce-pipeline-2.com.clnmobile")
                .inputPassword("crm1OCE1")
                .clickOnLoginButton()
                .checkIfHomePageIsOpen();
    }

    @After
    public void tearDown(){

    }
}
