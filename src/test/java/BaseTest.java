import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.SubscriptionPage;

public class BaseTest {
    SHAFT.GUI.WebDriver driver;

    @BeforeMethod
    public void init(){
        driver = new SHAFT.GUI.WebDriver();
        new SubscriptionPage(driver).openPortal();
    }

    @AfterMethod
    public void flush(){
        driver.quit();
    }



}
