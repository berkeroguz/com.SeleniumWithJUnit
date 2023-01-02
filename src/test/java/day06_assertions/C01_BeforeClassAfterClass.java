package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;

public class C01_BeforeClassAfterClass {

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

        if (acutalTitle.contains(expectedWord)){
            System.out.println("Amazon gidis testi PASSED");
        }
        else System.out.println("Amazon gidis testi FAILED ");
    }
    @Test
    public void test02(){

        //amazon'a gidip nutella yazın sonucların nutella icerdiğini test edin.
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+ ENTER);

        String expectedWord ="Nutella";
        WebElement resultTextElement = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String resultText = resultTextElement.getText();

        if (resultText.contains(expectedWord)){
            System.out.println("nutella arama testi PASSED");
        }
        else System.out.println("nutella arama testi FAILED");
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
        if(actualSonucAdediInt>expectedResult)
        {
            System.out.println("nutella arama sonuc sayısı PASSED");
        }
        else System.out.println("nutella arama sonuc sayısı FAILED");
    }



}
