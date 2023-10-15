package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import utils.CountryNames;
import utils.Languages;

public class SubscriptionPage {

    private SHAFT.GUI.WebDriver driver;

    public SubscriptionPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    private final String URL = System.getProperty("URL");

    public static By changeCountryButton() {
        return By.id("country");
    }
    public static By changeLanguageButton() {
        return By.id("translation-btn");
    }


    public static By selectCountry(String country){
                return By.id(country);
    }

    public static By LITEPlanTitleEn(){
        return By.id("name-lite");
    }
    public static By CLASSICPlanTitleEn(){
        return By.id("name-classic");
    }
    public static By PREMIUMPlanTitleEn(){
        return By.id("name-lite");
    }
    public static By LITEPlanTitleAr(){
        return By.id("name-لايت");
    }
    public static By CLASSICPlanTitleAr(){
        return By.id("name-الأساسية");
    }
    public static By PREMIUMPlanTitleAr(){
        return By.id("name-بريميوم");
    }

    public static By LITEPlanPriceEn(){return By.id("currency-lite");}
    public static By CLASSICPlanPriceEn(){return By.id("currency-classic");}
    public static By PREMIUMPlanPriceEn(){return By.id("currency-premium");}
    public static By LITEPlanPriceAr(){return By.id("currency-لايت");}
    public static By CLASSICPlanPriceAr(){return By.id("currency-الأساسية");}
    public static By PREMIUMPlanPriceAr(){return By.id("currency-بريميوم");}

    public SubscriptionPage openPortal(){
        driver.browser().navigateToURL(URL);
        return this;
    }

    public SubscriptionPage switchMarket(String country){
        driver.element().click(changeCountryButton());
        switch (country) {
            case "Bahrain" -> {
                driver.element().click(selectCountry("bh"));
            }
            case "KSA" -> {
                driver.element().click(selectCountry("sa"));
            }
            case "Kuwait" -> {
                driver.element().click(selectCountry("kw"));
            }
        }
        return this;
    }

    public SubscriptionPage switchLanguage(Languages language){
        String currentLanguge = driver.element().getText(changeLanguageButton());
        switch (language){
            case Arabic:
                if (currentLanguge.equals("English")){
                    break;
                }else{
                    driver.element().click(changeLanguageButton());
                }
            case English:
                if (currentLanguge.equals("English")){
                    driver.element().click(changeLanguageButton());
                }else{
                    break;
                }
        }
        return this;
    }

}
