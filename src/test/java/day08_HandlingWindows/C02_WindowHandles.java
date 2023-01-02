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

public class C02_WindowHandles {
    // https://the-internet.herokuapp.com/windows adresine gidin.
// Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
// Sayfa başlığının (title) "The Internet" olduğunu doğrulayın.
// Click Here butonuna basın.
// Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.
// Sayfadaki textin "New Window" olduğunu doğrulayın.
// Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu doğrulayın.

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
// Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        String expectedPageText = "Opening a new window";
        String actualPageText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedPageText, actualPageText);

// Sayfa başlığının (title) "The Internet" olduğunu doğrulayın.
        String expectedPageTitle = "The Internet";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
        String ilkSayfaHandleDegeri = driver.getWindowHandle();

// Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        /*
                Kontrolsüz açılan tab'a geçiş yapmak için
                İlk sayfada iken o sayfanın WHD alip kaydedin
                2. sayfa açıldıktan sonra getWindowHandles() kullanarak
                açık olan tüm sayfaların WH Değerlerini bir Set olarak kaydedin.

                Şu anda elimizde 2 elementli bir Set var,
                Elemenlerden bir tanesi 1. sayfanın WHD'sine eşit.
                Eşit olmayan ise 2. sayfadır.
         */
        Set<String> allWHValues = driver.getWindowHandles();

        String ikinciSayfaWHD = null;
        for (String eachWhd : allWHValues) {
            if (!eachWhd.equals(ilkSayfaHandleDegeri)) {
                ikinciSayfaWHD = eachWhd;
            }
        }


// Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaWHD);
        String expectedNewPageTitle = "New Window";
        String actualNewPageTitle = driver.getTitle();

        Assert.assertEquals(expectedNewPageTitle, actualNewPageTitle);
// Sayfadaki textin "New Window" olduğunu doğrulayın.
        String expectedYeniSayfaTitle = "New Window";
        String actualYeniSayfaTitle = driver.getTitle();

        Assert.assertEquals(expectedYeniSayfaTitle, actualYeniSayfaTitle);
// Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandleDegeri);
        expectedPageTitle = "The Internet";
        actualPageTitle = driver.getTitle();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);

    }

}
