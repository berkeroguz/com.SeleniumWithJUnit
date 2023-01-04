package day12_webtables_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.manipulation.Ordering;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Map;
import java.util.TreeMap;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {

        // Ulkeler excel'indeki sayfa1'e gidecek şekilde ayarlari yapalim

        String dosyaYolu = "src/test/java/day12_webtables_excel/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

       /* Sheet sheet = workbook.getSheet("Sayfa1");

        Row row = sheet.getRow(0);
        Cell cell = row.getCell(1);
        System.out.println("1. Satır 2. Hücre = "+ cell);
        */


        // basit yolu
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));

        // 1.satirdaki 2. hücreyi bir string değişkenine atayalim ve yazdıralim.
        String istenenHucreStr= workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();


        // 2. satirdaki 4. cell'in afganistan'in başkenti olduğunu test edelim.
        String expectedWord ="Kabil";
        String actualWord = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();

        Assert.assertEquals(expectedWord,actualWord);

        // satır sayısını bulun.

        System.out.println("Satır sayısı = "+(workbook.getSheet("Sayfa1").getLastRowNum()+1));

        // fiziki olarak kullanılan satir sayisini bulun

                // Bunun için sayfa2 deki son satir index'ini ve fiziki kullanılan satır sayısını yazdıralm
        System.out.println("2. Sayfa son satir indexi  = "+workbook.getSheet("Sayfa2").getLastRowNum());

        System.out.println("2. sayfa fiziki kullanılan satır sayisi = " +workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());

        // - İngilizce ülke isimleri ve baskentleri bir map olarak kaydedelim.
        // ülke ismi ingilizce ==> key, geriye kalan 3 bilgi ise birlestirilerek value olsun.

        Map<String,String> ulkelerMap = new TreeMap<>();
        int sonSatirIndexi = workbook.getSheet("Sayfa1").getLastRowNum();

        String key="";
        String value="";

        for (int i=0;i<sonSatirIndexi;i++)
        {
            key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key,value);

        }

        System.out.println(ulkelerMap);
    }
}
