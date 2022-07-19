package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //amazon anasayfaya gidip
        // account menusunden create a list linkine tiklayin
        driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
        WebElement accountLinki= driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        actions.moveToElement(accountLinki).perform();

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        Thread.sleep(5000);

    }

}
