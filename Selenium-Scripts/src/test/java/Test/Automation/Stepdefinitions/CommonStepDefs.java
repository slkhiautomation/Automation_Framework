package Test.Automation.Stepdefinitions;

import Test.Automation.Pages.CheckOutPage;
import Test.Automation.Pages.CommonPage;
import Test.Automation.Pages.ProductDetailPage;
import Test.Automation.Utils.DriverFactory;
import Test.Automation.Utils.PropertyReader;
import Test.Automation.Utils.UtilityMethods;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static Test.Automation.Utils.ExcelFileManager.readFromCell;

public class CommonStepDefs extends DriverFactory {

    private CommonPage commonPage;
    public static String DatafileName =(new PropertyReader().readProperty("appConfigFile"));

    public CommonStepDefs() throws Exception {
        commonPage = new CommonPage(driver);
    }

    @When("^user enter text \"([^\"]*)\" in \"([^\"]*)\" on \"([^\"]*)\"$")
    public void user_enter_text_in_on(String textKey,String keyName, String sheetName) throws Throwable {
        commonPage.enterText(sheetName,keyName,
                readFromCell(DatafileName,sheetName,1,textKey));
        UtilityMethods.TakeSnapShot();
    }

    @When("^user click on \"([^\"]*)\" button on \"([^\"]*)\"$")
    public void user_click_on_button_on(String keyName, String sheetName) throws Throwable {
        commonPage.Clickelemet(sheetName,keyName);
        UtilityMethods.TakeSnapShot();
    }

    @When("^user select \"([^\"]*)\" from \"([^\"]*)\" on \"([^\"]*)\"$")
    public void user_select_from_on(String textKey, String keyName, String sheetName) throws Throwable {
        commonPage.selectDDValue(sheetName,keyName,readFromCell(DatafileName,sheetName,1,textKey));
        UtilityMethods.TakeSnapShot();
    }

    @Then("^Assert that \"([^\"]*)\" appear on \"([^\"]*)\"$")
    public void assert_that_appear_on(String keyName, String sheetName) throws Throwable {
        commonPage.assertonPage(sheetName,keyName);
        UtilityMethods.TakeSnapShot();
    }
}
