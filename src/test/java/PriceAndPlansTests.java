import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SubscriptionPage;
import utils.Languages;

public class PriceAndPlansTests extends BaseTest{


    private String country = System.getProperty("Country");
    private JSONFileManager data = new JSONFileManager("src/test/resources/TestDataFiles/testData.json");

    private String expectedLITEPlanPriceEn;
    private String expectedCLASSICPlanPriceEn;
    private String expectedPREMIUMPlanPriceEn;
    private String expectedLITEPlanPriceAr;
    private String expectedCLASSICPlanPriceAr;
    private String expectedPREMIUMPlanPriceAr;

    @BeforeClass
    public void setup(){

        expectedLITEPlanPriceEn = data.getTestData(country+".En.prices[0]");
        expectedCLASSICPlanPriceEn = data.getTestData(country+".En.prices[1]");
        expectedPREMIUMPlanPriceEn = data.getTestData(country+".En.prices[2]");
        expectedLITEPlanPriceAr = data.getTestData(country+".Ar.prices[0]");
        expectedCLASSICPlanPriceAr = data.getTestData(country+".Ar.prices[1]");
        expectedPREMIUMPlanPriceAr = data.getTestData(country+".Ar.prices[2]");
    }


    @Test(description = "validate the existence of 3 plans in both languages")
    public void validatePlansExist(){
        new SubscriptionPage(driver)
                .switchLanguage(Languages.English)
                .switchMarket(country);

        Validations.assertThat().element(SubscriptionPage.LITEPlanTitleEn()).exists().perform();
        Validations.assertThat().element(SubscriptionPage.CLASSICPlanTitleEn()).exists().perform();
        Validations.assertThat().element(SubscriptionPage.PREMIUMPlanTitleEn()).exists().perform();

        new SubscriptionPage(driver)
                .switchLanguage(Languages.Arabic);

        Validations.assertThat().element(SubscriptionPage.LITEPlanTitleAr()).exists().perform();
        Validations.assertThat().element(SubscriptionPage.CLASSICPlanTitleAr()).exists().perform();
        Validations.assertThat().element(SubscriptionPage.PREMIUMPlanTitleAr()).exists().perform();
    }

    @Test(description = "validate the  correct price of LITE plan in both languages")
    public void validatePriceOfLitePLan(){
        new SubscriptionPage(driver)
                .switchLanguage(Languages.English)
                .switchMarket(country);

        Validations.assertThat().element(SubscriptionPage.LITEPlanPriceEn()).text().isEqualTo(expectedLITEPlanPriceEn).perform();

        new SubscriptionPage(driver)
                .switchLanguage(Languages.Arabic);

        Validations.assertThat().element(SubscriptionPage.LITEPlanPriceAr()).text().isEqualTo(expectedLITEPlanPriceAr).perform();

    }

    @Test(description = "validate the  correct price of CLASSIC plan in both languages")
    public void validatePriceOfCLASSICPLan(){
        new SubscriptionPage(driver)
                .switchLanguage(Languages.English)
                .switchMarket(country);

        Validations.assertThat().element(SubscriptionPage.CLASSICPlanPriceEn()).text().isEqualTo(expectedCLASSICPlanPriceEn).perform();

        new SubscriptionPage(driver)
                .switchLanguage(Languages.Arabic);

        Validations.assertThat().element(SubscriptionPage.CLASSICPlanPriceAr()).text().isEqualTo(expectedCLASSICPlanPriceAr).perform();

    }

    @Test(description = "validate the  correct price of PREMIUM plan in both languages")
    public void validatePriceOfPREMIUMPLan(){
        new SubscriptionPage(driver)
                .switchLanguage(Languages.English)
                .switchMarket(country);

        Validations.assertThat().element(SubscriptionPage.PREMIUMPlanPriceEn()).text().isEqualTo(expectedPREMIUMPlanPriceEn).perform();

        new SubscriptionPage(driver)
                .switchLanguage(Languages.Arabic);

        Validations.assertThat().element(SubscriptionPage.PREMIUMPlanPriceAr()).text().isEqualTo(expectedPREMIUMPlanPriceAr).perform();

    }
}
