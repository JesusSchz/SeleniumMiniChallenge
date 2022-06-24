import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Initialize {
    WebDriver driver;
    public Initialize(){

    }

    public WebDriver InitializeDriver(String page){
        System.out.println("Driver initialized");

        System.setProperty("webdriver.chrome.driver","C:\\Users\\js_\\IdeaProjects\\DriversChrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(page);
        driver.manage().window().maximize();
        return driver;
    }

    public void driverClose(){
        driver.quit();
    }
}
