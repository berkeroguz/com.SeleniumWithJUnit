package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;

public class C03_AssertionMethods {
    //3 ayri test method'u olusturun
    //1. method'da amazon'a gidip amazona gittiğimizi test edin
    //2. method'da amazonda nutelle aratip sonucların nutella icerdiğini test edin
    //3. method'da nutella arama sonuc sayısının 50'den fazla oldugunu test edin.

    static WebDriver driver;
    @BeforeClass //BEFORCLASS VE AFTERCLASS Notasyonu kullanan methodlar
    //Statik olmak zorundadır.
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){

        //1.method'da amazon'a gidip amazona gittiğimizi test edin
        driver.get("https://www.amazon.com");

        String expectedWord ="Amazon";
        String acutalTitle = driver.getTitle();

        Assert.assertTrue(acutalTitle.contains(expectedWord));
    }
    @Test
    public void test02(){

        //amazon'a gidip nutella yazın sonucların nutella icerdiğini test edin.
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+ ENTER);

        String expectedWord ="Nutella";
        WebElement resultTextElement = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String resultText = resultTextElement.getText();

        Assert.assertTrue(resultText.contains(expectedWord));
    }

    @Test
    public void test03(){

        //3. method'da nutella arama sonuc sayısının 50'den fazla oldugunu test edin.
        WebElement resultTextElement = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String resultText = resultTextElement.getText();

        String[] sonucYazisiArr=resultText.split(" ");
        String sonucAdediStr=sonucYazisiArr[2];
        int actualSonucAdediInt=Integer.parseInt(sonucAdediStr);
        int expectedResult = 50;

        Assert.assertTrue("Title Amazon içermiyor.", actualSonucAdediInt>expectedResult);
    }

}
