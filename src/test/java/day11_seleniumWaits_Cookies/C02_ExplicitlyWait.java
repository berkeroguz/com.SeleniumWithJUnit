package day11_seleniumWaits_Cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExplicitlyWait {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    // 1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWaitTest() , explicitWaitTest()
    //
    //	 Iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin
    @Test
    public void implicitWaitTest()
    {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*/button[text()='Remove']"));
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue("It's Gone Görüntülenmiyor. ",driver.findElement(By.xpath("//form/p")).getText().equals("It's gone!"));
        //6. Add buttonuna basin
        driver.findElement(By.linkText("Add")).click();
        //7. It’s back mesajinin gorundugunu test edin
        Assert.assertTrue("Back Görüntülenmiyor. ",driver.findElement(By.xpath("//form/p")).getText().equals("It's back!"));


    }
    @Test
    public void explicitWaitTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*/button[text()='Remove']")).click();

        //Explicity wait için bir wait objesi oluşturduk.
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));


        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        //istGoneElementi locate edilene kadar bekler.
        WebElement itsGoneElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        Assert.assertTrue("It's Gone Görüntülenmiyor. ",itsGoneElementi.getText().equals("It's gone!"));
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*/button[text()='Add']")).click();
        //7. It’s back mesajinin gorundugunu test edin

        WebElement isBackElementi= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue("Back Görüntülenmiyor. ",isBackElementi.getText().equals("It's back!"));


    }
}
