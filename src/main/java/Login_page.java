import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_page extends Page_base{


    public Login_page(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement email;

    @FindBy(id="password")
    WebElement pass;

    @FindBy(xpath = "( //button[@type='submit'])[1]")
    WebElement login_btn;

    public void login( String Email,String Password )
    {

        email.sendKeys(Email);
        pass.sendKeys(Password);
        login_btn.click();
    }

}
