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

public class C02_BestBuyAssertions {
    // 2) https://www.bestbuy.com/ Adresine gidin
    //    farkli test method’lari olusturarak asagidaki testleri yapin
    //      ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
    //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

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
        // // 2) https://www.bestbuy.com/ Adresine gidin
        driver.get("https://www.bestbuy.com/");
        //      ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
       String actualBestbuyUrl=driver.getCurrentUrl();
       String expectedBestbuyUrl="https://www.bestbuy.com/";
        Assert.assertEquals(expectedBestbuyUrl,actualBestbuyUrl);
    }
    @Test
    public void test02(){
        // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        Assert.assertFalse(driver.getTitle().contains("Rest"));

    }
    @Test
    public void test03(){
        // ○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoTest= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoTest.isDisplayed());

    }
    @Test
    public void test04(){
        // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francaisLinkTest= driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(francaisLinkTest.isDisplayed());

    }
}
