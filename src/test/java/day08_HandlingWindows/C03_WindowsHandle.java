package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowsHandle {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        // elemental selenium linkini tiklayin
        //Linke tıkladığımızda yeni sayfa açılacağından
        //click yapmadan önce ilk sayfanın WHD'ini alıp kaydedelim
        String ilkSayfaWHD= driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        // yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
        // ilk sayfaya geri donup sayfadaki yazinin
        // "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin

        Set<String> ikiSayfaninWHDegerleriSet = driver.getWindowHandles();
        String ikinciSayfaWhd="";
        for (String eachWhd : ikiSayfaninWHDegerleriSet)
        {
            if(!eachWhd.equals(ilkSayfaWHD))
            {
                ikinciSayfaWhd=eachWhd;
            }
        }

        driver.switchTo().window(ikinciSayfaWhd);

        String expectedIkinciSayfaYazisi="Elemental Selenium";
        String actualIkinciSayfaYazisi=driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedIkinciSayfaYazisi,actualIkinciSayfaYazisi);

        driver.switchTo().window(ilkSayfaWHD);

        String expectedIlkSayfaYazi="An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualIlkSayfaYazi=driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedIlkSayfaYazi,actualIlkSayfaYazi);

    }

}
