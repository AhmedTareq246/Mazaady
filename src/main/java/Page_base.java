import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page_base {
    protected WebDriver d;
    public Page_base(WebDriver driver)
    {
        this.d=driver;
        PageFactory.initElements(driver,this);
    }

}
