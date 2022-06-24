import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ElementsTest {


    public ElementsTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    Initialize driverInstance=new Initialize();
    WebDriver newDriver;
    @Test
    public void elementsDisplayed() {

        /*
            First attempt
            Validating with if statments and using isPresent Method
        */
        if(isPresent(newDriver.findElements(By.xpath("//h5[contains(text(),'Elements')]")))){
            System.out.println("Elements Exist");
        }
        if(isPresent(newDriver.findElements(By.xpath("//h5[contains(text(),'Forms')]")))){
            System.out.println("Forms Exist");
        }
        if(isPresent(newDriver.findElements(By.xpath("//h5[contains(text(),'Widgets')]")))){
            System.out.println("Widget Exist");
        }

        /*
            Second attempt
            Validating with SoftAssets using TestNG
        */
        String forsText = "Forms";
        String forms = newDriver.findElement(By.xpath("//h5[contains(text(),'Forms')]")).getText();

        String widgetsText = "Widgetssss";
        String widgets = newDriver.findElement(By.xpath("//h5[contains(text(),'Widgets')]")).getText();

        SoftAssert softassert = new SoftAssert();

        String elementText = "Elementos";
        String elements = newDriver.findElement(By.xpath("//h5[contains(text(),'Elements')]")).getText();
        softassert.assertEquals(elementText,elements, "Elements not found: ");

        softassert.assertEquals(forsText,forms,"Forms not found: ");

        softassert.assertEquals(widgetsText,widgets,"Widgets not found");
        softassert.assertAll();

    }


    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
        newDriver=driverInstance.InitializeDriver("https://demoqa.com");
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
        driverInstance.driverClose();
    }

    public static boolean isPresent(List<WebElement> element){
        return element.size() > 0;
    }
}
