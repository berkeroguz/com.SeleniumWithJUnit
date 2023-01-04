package day13_writeExcel_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_TakeScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {
        //amazon'a gidip
        // nutella aratin
        //Arama sonuclarinin Nutella icerdigini test edin
        // Tüm sayfanın screenshot'ini alin.

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

        String expectedWord="Nutella";

        Assert.assertTrue("İçermiyor .",driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText().contains(expectedWord));

        ReusableMethods.tumSayfaScreenShotCek(driver,"yeniDeneme");



    }

}
