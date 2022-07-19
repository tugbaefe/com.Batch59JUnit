package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
    amazon ana sayfaya gidin
    3 farkli test methodu olusturarak asagidaki yapin
    1- Url'in amazon icerdigini test edin
    2- Title'in facebook icermedigini test edin
    3- sol ust kosedeki amazon logosunun gorundugunu test edin
     */

    static WebDriver driver;


    @BeforeClass
    public static void setupMethodu(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void tearDown(){

        driver.close();
    }
    @Test
    public void test01(){
       // driver.get("https://www.amazon.com");butun testlerde calismasi icin before'in altina aldik
        //1- Url'in amazon icerdigini test edin
        String actualUrl=driver.getCurrentUrl();
        String arananKelime="amazon";
        Assert.assertTrue(actualUrl.contains(arananKelime));

    }
    @Test
    public void test02(){
       //2- Title'in facebook icermedigini test edin
        String actualUrl=driver.getTitle();
        String istenmeyenKelime="facebook";
        Assert.assertFalse(actualUrl.contains(istenmeyenKelime));

    }
    @Test
    public void test03(){
        //3- sol ust kosedeki amazon logosunun gorundugunu test edin
        WebElement amazonLogo=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(amazonLogo.isDisplayed());

    }


}
