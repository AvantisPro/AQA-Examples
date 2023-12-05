import Pages.AccountPage;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;

public class AccountTest {

    AccountPage accountPage;
    @Before
    public void setUp(){
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
        Configuration.timeout = 5000;

        accountPage.openAccountPage();
    }


}
