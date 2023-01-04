package day12_webtables_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        //Dosya yolunu oluşturduk
        String dosyaYolu ="src/test/java/day12_webtables_excel/ulkeler.xlsx";
        //File ınputStream objesi oluşturup parametresine dosya yolunu verdik.
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // Kod alanimizde excel'in ibr kopyasini oluşturup
        // Tüm bilgileri ona kopyalayacağız.

        Workbook worbook = WorkbookFactory.create(fis);

        //Workbook içerisinde birden fazla sayfa olabilir
        // istediğimi sayfaya gidelim

        Sheet sheet = worbook.getSheet("Sayfa1");

        // angola yazdırmak istediğimiz için 5. satıra gidelim

        Row row = sheet.getRow(5);

        // 5. satırda 2.index'deki datayi alalim.

        Cell cell = row.getCell(2);

        System.out.println(cell); // Angola



    }
}
