package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {
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
        // amazon sayfaya gidin
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri=driver.getWindowHandle();

        // nutella icin arma yaptirin

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        /*
        CDwindow-B766765642F7EC7C38D1194EF5D77A1E
        bu kod acilan sayfanin unique hash kodudur.
        Selenium sayfalar arasi geciste bu window handle degerini kullanir.

        eger sayfalar arsinda driver'imizi gezdiriyorsak ve herhangi bir sayfadan
        suanda bulndugumuz sayfaya gecmek istiyorsak
        driver.switchTo().window("CDwindow-B766765642F7EC7C38D1194EF5D77A1E");
        bu syfanin window handle degerini girerek bu sayfaya gecisi saglar
         */
        //3- ilk urunun resmini tiklayarak farkli bir tab olaral acin
        WebElement ilkUrunResmi=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        Bu komutu kullandigimizda driver otomatik olarak olusturulan
        new Tab'a gecer
        yeni tab'da gorevi gerceklestirmek icin
        adimlari bastan almamiz lazim
         */
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        //4- yeni bir tab'da acilan urunun title'ini yazdirin
        WebElement urunTitleElementi= driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitleElementi.getText());

        //5- ilk sayfaya gecip url'i yazdiralim

        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());


    }

}
