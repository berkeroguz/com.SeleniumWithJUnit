package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_radioButton {
    // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    // a. Verilen web sayfasına gidin.
    // https://facebook.com
    // b. Cookies'i kabul edin
    // c. Create an account buton'una basin.
    // d. Radio button elementlerini locate edin ve size uygun olani secin

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com");
    }

    @Test
    public void test01(){
        driver.findElement(By.xpath("//div/a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement radio1 = driver.findElement(By.xpath("(//*[@class='_8esa'])[2]"));
        radio1.click();

        Assert.assertTrue(radio1.isSelected());
    }

    @After
    public void tearDown(){
        //driver.close();
    }

}
