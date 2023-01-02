package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_handleDropdownMenu {

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
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        // ilgili ayarlari yapip
        // amazon anasayfaya gidin
        // arama kutusu yanindaki dropdown menuden book secin
        // arama kutusuna java yazdirip aramayi yapin
        // title'in java icerdigini test edin

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // arama kutusu yanindaki dropdown menuden book secin
        Select select = new Select(driver.findElement(By.xpath("//div/select[@aria-describedby='searchDropdownDescription']")));
        select.selectByVisibleText("Books");

        // arama kutusuna java yazdirip aramayi yapin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        // title'in java icerdigini test edin
        String expectedText="Java";
        String actualtext=driver.getTitle();
        Assert.assertTrue("Title Java içermiyor",actualtext.contains(expectedText));

        Thread.sleep(3000);

        // dropdown menuden Books seceneginin secildigini test edin
        /*
           Locate ettigimiz elementi bulamazsa NoSuchElementException
           sayfa yenilendigi icin var olan bir elementi kullanamazsa
           StaleElementException verir
           bu durumda locate ve secme islemini yeniden yaparsak kodumuz calisir
         */

        select = new Select(driver.findElement(By.xpath("//div/select[@aria-describedby='searchDropdownDescription']")));
        select.selectByVisibleText("Books");
        System.out.println(select.getFirstSelectedOption());
    }

}
