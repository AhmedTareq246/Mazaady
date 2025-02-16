import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Add_product_Test extends Testbase {
    Add_product_page add_product_page;

    @Test
    public void Step1() throws InterruptedException {


        d.get("https://staging.mazaady.com/home");
        Thread.sleep(5000);
        add_product_page=new Add_product_page(d);
        add_product_page.open_add_product_page();
        add_product_page.step1();

    }


    @DataProvider(name="step2_testdata")
    public static Object[][] step2_testdata()
    {
        Object[][] data =
                {
                        {
                                "Ahmed","REAL ESTATE , Trade Names","Lands","Rent",
                                "Commercial","Apartment","12","34","M2","5",
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.         " +
                                        "        Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took " +
                                        "a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but " +
                                        "also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s" +
                                        " with the release of Letraset sheets containing Lorem Ipsum passages," +
                                        " and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"


                                ,"Abudabi"

                }

                };
        return data;
    }

    @Test(dataProvider = "step2_testdata")
    public void Step2(String auc_nam,String main_cat,String sb_cat,String proces_type,String clas,String typ,String land_num, String area, String unit , String q, String auc__detail,String ret_and_excha_policy) throws InterruptedException {

        Thread.sleep(5000);


        add_product_page.step2(auc_nam,main_cat,sb_cat,proces_type);

       add_product_page.follow1step2(clas,typ,land_num,area,unit,q);
        add_product_page.follow2step2(auc__detail,ret_and_excha_policy);
    }
    @DataProvider(name = "step3_testdata")
    public static Object[][] step3_testdata(    )
    {
        Object[][] data= {
                { "70","56","34"}
        };
        return  data;
    }



    @Test(dataProvider = "step3_testdata")
    public void Step3(String buy_now_vlue , String starting_bid_vlue, String bid_inc_vlue) throws InterruptedException {
        add_product_page.step3(buy_now_vlue,starting_bid_vlue,bid_inc_vlue);

    }

    @Test
    public void Step4() throws InterruptedException {
        add_product_page.step4();
        Thread.sleep(5000);
        WebElement actual=d.findElement(By.cssSelector("div.swal-title"));
        String Expected ="Good job!";
        String Actual=actual.getText();
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(Actual.contains(Expected));
    }


    }
