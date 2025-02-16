import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login_Test extends Testbase {
    Login_page loginpage ;
    Add_product_page add_product_page;

    @DataProvider(name="Login_testdata")
    public static Object[][] login_testdata()
    {
     Object[][] data =
        {
            {"tester@task.com","1111111"}, // Valid Email and invalid pass
            {"tester@task.cm","11111111"},// invalid Email and valid pass
            {"tester@tas.om","111111"},// invalid email and invalid pass
             {"tester@task.com","11111111"} // happy Scenario
        };
     return data;
    }

    int i =1;

    @Test(dataProvider = "Login_testdata")
    public void login(String Email, String Pass)
    {
        d.get("https://staging.mazaady.com/login");


        loginpage =new Login_page(d);
        loginpage.login(Email,Pass);

        String Actual =d.findElement(By.xpath("( //span[@class='action-icons-text'])[1]")).getText();

        String expected;
         SoftAssert softAssert = new SoftAssert();
         //happy scenario
        if (i==4)
        {
           expected= "Mosta." ;
        }
        //Wrong Credentials
        else  {
            expected= "Login";
        }
        softAssert.assertEquals(expected,Actual);
        i++;

    }


}
