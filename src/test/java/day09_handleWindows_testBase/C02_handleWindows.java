package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        //driver.quit();
    }
    @Test
    public void test01(){
        //1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaninHandleDegeri= driver.getWindowHandle();
        //2- url'in amazon icerdigini test edelim
        String istenenKelime="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(istenenKelime));
        //3- yeni bir pencere acip bestbuy anasayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.bestbuy.com");
        String ikinciSayfaHandleDegeri=driver.getWindowHandle();
        //4- title'in bestbuy icerdigini test edelim
        String arananKelime="Best Buy";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananKelime));
        //5- ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(ilkSayfaninHandleDegeri);
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java"+ Keys.ENTER);

        //6- arama sonuclarinin Java icerdigini test edelim
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisiStr=sonucYaziElementi.getText();
        String aradigimizKelime="Java";
        Assert.assertFalse(sonucYazisiStr.contains(aradigimizKelime));
        //7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        //8- logo'nun gorundugunu test edelim
        WebElement logo= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }
}
