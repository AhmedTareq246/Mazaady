import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Testbase {
    public static WebDriver d;
    @BeforeTest
    public void openbrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
        d.manage().window().maximize();
        Thread.sleep(5000);
    }

    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(5000);
        d.quit();

    }

}
