package Test.Automation.Pages;

import Test.Automation.Utils.DriverFactory;
import Test.Automation.Utils.PropertyReader;
import Test.Automation.Utils.UtilityMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.regex.Pattern;

import static Test.Automation.Utils.ExcelFileManager.readFromCell;

public class CommonPage extends DriverFactory {

    public static String fileName =(new PropertyReader().readProperty("appConfigFile"));
    public static String ConfigfileName;

    static {
        try {
            ConfigfileName = readFromCell(fileName,"SetUp",1,"fileName");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CommonPage(WebDriver driver) throws Exception {
        PageFactory.initElements(driver,this);
    }

    public void enterText(String Sheet, String rowMatch, String text) throws IOException {
        UtilityMethods.waitForPageLoadAndPageReady();
        UtilityMethods.waitForPageLoad();
        WebElement element = UtilityMethods.getElementByXpath(readFromCell(ConfigfileName,Sheet,1,rowMatch));
        UtilityMethods.waitForVisibility(element);
        element.sendKeys(text);
        System.out.println("Text enetered in element "+rowMatch+" "+ text);
    }

    public void Clickelemet(String Sheet, String rowMatch) throws IOException, InterruptedException {
        UtilityMethods.waitForPageLoadAndPageReady();
        UtilityMethods.waitForPageLoad();
        UtilityMethods.wait2Seconds();
        WebElement element = UtilityMethods.getElementByXpath(readFromCell(ConfigfileName,Sheet,1,rowMatch));
        System.out.println("Element found "+element.getText());
        UtilityMethods.waitForVisibility(element);
        UtilityMethods.scrollToWebElement(element);
        try{
            element.click();
            System.out.println("Clicked on Element "+rowMatch);

        }catch (Exception ex){
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().perform();
            System.out.println("Clicked on Element by Action "+rowMatch);
        }
    }

    public void selectDDValue(String Sheet, String rowMatch, String text) throws IOException {
        UtilityMethods.waitForPageLoadAndPageReady();
        WebElement element = UtilityMethods.getElementByXpath(readFromCell(ConfigfileName,Sheet,1,rowMatch));
        Select select = new Select(element);
        select.selectByVisibleText(text);
        UtilityMethods.waitForVisibility(element);
    }

    public void assertonPage(String Sheet, String rowMatch) throws IOException, InterruptedException {
        UtilityMethods.waitForPageLoadAndPageReady();
        UtilityMethods.wait2Seconds();
        WebElement element = UtilityMethods.getElementByXpath(readFromCell(ConfigfileName,Sheet,1,rowMatch));
        UtilityMethods.waitForVisibility(element);
        System.out.println("Element found and Value is "+element.getText());
        String result = readFromCell(fileName,Sheet,1,rowMatch);
        Pattern.compile(Pattern.quote(element.getText()), Pattern.CASE_INSENSITIVE).matcher(result).find();
        Object expected = Pattern.compile(Pattern.quote(result), Pattern.CASE_INSENSITIVE).matcher(result).find();
        Object actual = Pattern.compile(Pattern.quote(element.getText()), Pattern.CASE_INSENSITIVE).matcher(element.getText()).find();
        String expectedResult = expected.toString();
        String actualResult = actual.toString();
        if(actualResult.contains(expectedResult)){
            Assert.assertTrue(true);
            System.out.println("Searched in List");
        }else{
            Assert.fail();
            System.out.println("Searched in List");
        }
    }

}
