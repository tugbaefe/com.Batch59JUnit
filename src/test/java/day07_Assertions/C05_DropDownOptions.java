package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C05_DropDownOptions {
    /*
    Amazon anasayfaya gidip dropdown menuden
    books'u secelim
    sectigimiz option'i yazdiralim

    dropdown'daki opsiyonlarin toplamsayisinin
    23 oldugunu test edin
     */
    static WebDriver driver;


    @BeforeClass
    public static void setupMethodu(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown(){

        // driver.close();
    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        WebElement dropDownmenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropDownmenu);
        select.selectByVisibleText("Books");
        System.out.println(select.getFirstSelectedOption().getText());
    }

}
