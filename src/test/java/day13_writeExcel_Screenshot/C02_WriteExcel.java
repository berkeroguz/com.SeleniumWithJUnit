package day13_writeExcel_Screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void test01() throws IOException {

        // Excel dosyasina ulasalım.
        String dosyaYolu = "src/test/java/day12_webtables_excel/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        // 5. Sütun olarak Nüfus basligi ile bir sütun oluşturalım.

        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nüfus");

        // 3. Satırdaki nüfus bilgisini 1500000 yapalım.
        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("1500000");

        // 7. satirdaki nüfus bilgisini 3000000 yapalim
        workbook.getSheet("Sayfa1").getRow(6).createCell(4).setCellValue("3000000");

        // Yaptığımız değişiklikler kopya workbook üzerinde
        // Bu değişiklikleri excel dosyasina kaydetmek için
        // FileOutputStream class'ini kullanırız.

        FileOutputStream fos = new FileOutputStream(dosyaYolu);

        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();





    }
}
