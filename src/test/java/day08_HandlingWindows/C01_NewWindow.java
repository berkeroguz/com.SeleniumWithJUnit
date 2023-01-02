package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NewWindow {
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
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");

        /*
                Testin ilerleyen aşamalarında yeniden amazon sayfasına dönmek gerekiyorsa
                amazon sayfasındayken bu window'un windows handle değerini alıp kaydetmeliyiz.

                Sayfalar arası geçiş yapmak için windowHandle değerini almamız gerekr.
                driver.switchTo().windows(istenensayfaninhandledegeri);
                kodu ile o sayfaya geçiş yapılabilir.

         */
        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        Thread.sleep(1000);

        //yeni bir tab' da wisequarter.com ' a gidin ve gittiğimizi test edin.

         driver.switchTo().newWindow(WindowType.TAB);

         driver.get("https://www.wisequarter.com");

         String actualUrl = driver.getCurrentUrl();
         String expectedUrl = "wisequarter";
        Assert.assertTrue("içermiyor",actualUrl.contains(expectedUrl));

        driver.switchTo().window(ilkSayfaHandleDegeri);

        actualUrl = driver.getCurrentUrl();
        expectedUrl = "amazon";
        Assert.assertTrue("içermiyor",actualUrl.contains(expectedUrl));

    }

}
