import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.domsnapshot.model.StringIndex;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Add_product_page extends Page_base {

    public Add_product_page(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#top-header-main > div > div > div.col-lg-9.col-md-7 > div.d-flex.align-items-center.float-right.h-100.parent-actions-top > div > div.dropdown.action-dropdown.user-actions > a > span")
    WebElement profile_pic;
    @FindBy(css="#top-header-main > div > div > div.col-lg-9.col-md-7 > div.d-flex.align-items-center.float-right.h-100.parent-actions-top > div > div.dropdown.action-dropdown.user-actions > div > ul > li:nth-child(5) > a")
    WebElement add_product_bt;

    @FindBy(xpath = "(//a[@href=\"https://staging.mazaady.com/add-product\"])[1]")
    WebElement Add_product_btn;

    public void open_add_product_page() {
        profile_pic.click();
        add_product_bt.click();
        //Add_product_btn.click();
    }

    @FindBy(xpath = " (//button[@type=\"button\"])[7]")
    WebElement Next_step1;

    public void step1() {
        Next_step1.click();
    }

    @FindBy(xpath = " //input[@name='title']")
    WebElement Auction_name;

    @FindBy(css = "#vs3__combobox > div.vs__selected-options > input")
    WebElement Category;

    @FindBy(css = "#vs4__combobox > div.vs__selected-options > input")
    WebElement Sub_category;

    @FindBy(css = "#vs10__combobox > div.vs__actions")
    WebElement Process_type;

    @FindBy(id = "vs10__listbox")
    List<WebElement> list_of_process_type;


    public void step2(String auction_name, String Main_Category, String Sub_Category, String Proces_typ) throws InterruptedException {
        Auction_name.sendKeys(auction_name);
        Category.click();
        Thread.sleep(1000);
        List<WebElement> items_of_category = d.findElements(By.cssSelector("#vs3__listbox li"));
        for (WebElement cat : items_of_category) {
            //System.out.println(cat.getText());
            if (cat.getText().contains(Main_Category)) {
                cat.click();
                break;
            }
        }


        Sub_category.click();
        List<WebElement> Subcats = d.findElements(By.cssSelector("#vs4__listbox li"));
        for (WebElement s : Subcats) {
            if (s.getText().contains(Sub_Category)) {
                s.click();
                break;
            }
        }
        Thread.sleep(5000);
        Process_type.click();

        for (WebElement p : list_of_process_type) {
            if (p.getText().contains(Proces_typ)) {
                p.click();
                break;
            }
        }

        //Quantity.sendKeys("4");

    }

    //@FindBy(css = "#vs11__combobox > div.vs__selected-options > input")
    @FindBy(css = "#vs11__combobox > div.vs__actions ")
    WebElement Class;
    @FindBy(css = "#vs11__listbox li")
    List<WebElement> class_items;

    @FindBy(css = "#vs12__combobox")
    WebElement type;
    @FindBy(css = "#vs12__listbox li")
    List<WebElement> list_of_types;

    @FindBy(css = "[name='222']")
    WebElement land_no;

    @FindBy(css = "[name=\"223\"]")
    WebElement land_area;

    @FindBy(css = "#vs13__combobox > div.vs__actions")
    WebElement unit;

    @FindBy(css = "#vs13__listbox li")
    List<WebElement> list_of_units;

    @FindBy(css = "[placeholder=\"Quantity\"]")
    WebElement quantity;


    public void follow1step2(String clas, String typ, String Land_num, String area, String Unit, String q) throws InterruptedException {

        Thread.sleep(9000);
        Class.click();
        for (WebElement c : class_items) {
            if (c.getText().contains(clas)) {
                c.click();
            }
        }

        type.click();

        for (WebElement t : list_of_types) {
            if (t.getText().equals(typ)) {
                t.click();
                break;
            }
        }
        land_no.sendKeys(Land_num);
        land_area.sendKeys(area);
        unit.click();
        for (WebElement u : list_of_units) {
            if (u.getText().contains(Unit)) {
                u.click();
                break;
            }
            // System.out.println(u.getText());
        }
        quantity.sendKeys(q);

    }

    @FindBy(css = "#tinymce_description_ifr")
    WebElement auction_details_frame;
    @FindBy(xpath = "//*[@id=\"tinymce\"]/p")
    WebElement auction_details_text;

    @FindBy(id = "tinymce_policy_ifr")
    WebElement Return_and_Exchange_policy_frame;
    @FindBy(css = "#tinymce > p")
    WebElement Return_and_Exchange_policy_text;

    @FindBy(xpath = "(//input[@type='file'])[1]")
    WebElement Main_image;

    @FindBy(xpath = "(//input[@type='file'])[3]")
    WebElement Product_image;

    @FindBy(xpath = "(//input[@type='file'])[5]")
    WebElement Product_video;


    @FindBy(xpath = "(//button[@type=\"button\"])[88]")
    WebElement next_step2;


    public void follow2step2(String auc_details, String Return_and_Exchange_policy) throws InterruptedException {

        String Project_path = System.getProperty("user.dir");

        Product_video.sendKeys(Project_path + "\\Images_video\\Nature3.mp4");

        d.switchTo().frame(auction_details_frame);

        auction_details_text.sendKeys(auc_details);
        d.switchTo().parentFrame();
        d.switchTo().frame(Return_and_Exchange_policy_frame);
        Return_and_Exchange_policy_text.sendKeys(Return_and_Exchange_policy);
        d.switchTo().parentFrame();
        Main_image.sendKeys(Project_path + "\\Images_video\\Nature1.jpg");
        Product_image.sendKeys(Project_path + "\\Images_video\\Nature2.jpg");

        Thread.sleep(20000);
        next_step2.click();

    }

    @FindBy(xpath = "(//input[@type=\"number\"])[3]")
    WebElement Buy_Now_Value;
    @FindBy(xpath = "(//input[@type=\"number\"])[4]")
    WebElement Starting_Bid_Value;
    @FindBy(xpath = "(//input[@type=\"number\"])[5]")
    WebElement Bid_Increment_Value;
    @FindBy(xpath = "(//button[@type='button'])[91]")
    WebElement Next_step3;

    public void step3(String buy_now_value, String starting_bid_value, String bid_increment_value) {
        Buy_Now_Value.sendKeys(buy_now_value);
        Starting_Bid_Value.sendKeys(starting_bid_value);
        Bid_Increment_Value.sendKeys(bid_increment_value);
        Next_step3.click();
    }

    @FindBy(css = "span > div > div:nth-child(2) > div > button")
    WebElement Add_btn;

    @FindBy(css = "button.btn.btn-secondary")
    WebElement close_btn;

    public void step4() throws InterruptedException {
        Thread.sleep(20000);
         close_btn.click();


        Add_btn.click();


    }


}
