package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_AssertionsBestBuyTest {
    /*
    1) Bir class oluşturun: BestBuyAssertions
    2) https://www.bestbuy.com/ Adresine gidin farkli test method'lari olusturarak
    asagidaki testleri yapin
    o Sayfa URL'inin https://www.bestbuy.com/ 'a esit oldugunu test edin
    o titleTest => Sayfa başlığının "Rest" içermediğini(contains) test edin
    o logoTest => BestBuy logosunun görüntülendigini test edin
    o FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */


    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void test01(){
        String expectedUrl ="https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("URL de sıkıntı var.",expectedUrl,actualUrl);


    }

    @Test
    public void test02(){
        // titleTest => Sayfa başlığının "Best" içermediğini(contains) test edin
        String actualTitle = driver.getTitle();
        String expectedTitle ="Best";
        Assert.assertTrue("",actualTitle.contains(expectedTitle));
    }

    @Test
    public void test03(){
        // logo gözüküyor mu testi
        Assert.assertTrue("Logo görüntülenmiyor",driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());

    }
    @Test
    public void test04(){
        //fransızca link gözüküyor mu?
        Assert.assertTrue("Link gözükmüyor",driver.findElement(By.xpath("//*[text()='Français']")).isDisplayed());

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}
