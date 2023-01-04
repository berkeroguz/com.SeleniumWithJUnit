package day13_writeExcel_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_IstenenElementScreenshot extends TestBase {

    @Test
    public void test01() throws IOException {

        //amazon'a gidip
        // nutella aratin
        //Arama sonuclarinin Nutella icerdigini test edin
        // Arama sonuc elementinin ss'ni alın.

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

        String expectedWord="Nutella";
        WebElement searchResult = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue("İçermiyor .",searchResult.getText().contains(expectedWord));

        ReusableMethods.elementSSCek(searchResult);
    }

}
