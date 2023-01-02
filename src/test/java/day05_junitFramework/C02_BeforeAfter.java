package day05_junitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {
    // 3 Farkli test method'u oluşturun
    // her bir method'un basında driver'i oluşturup
    // 1- amazon.com , 2- wisequarter.com 3- youtube.com 'a gidip
    // title'lari yazdırın ve method'dan sonra driver'i kapatın.
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("setUp Method calisti");
    }
    @Test
    public void amazonTest() throws InterruptedException {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);

    }
    @Test
    public void wiseQuarterTest() throws InterruptedException {
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }
    @Test
    public void youtubeTest() throws InterruptedException {
        driver.get("https://www.youtube.com");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }

    @After
    public void tearDown(){
        System.out.println("tearDown method calisti");
        driver.close();

    }

}
