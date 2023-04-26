package test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import utility.DB_Utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DatabaseTest extends DB_Utility {

    @Test
    public void test1() throws SQLException, IOException {

        ResultSet rs = statement.executeQuery("select * from actor");
        ResultSetMetaData rsmd = rs.getMetaData();  // column başlıklarını ve sayısını almak için eklendi

        XSSFWorkbook workbook = new XSSFWorkbook();   // hafızada workbook oluşturmak için eklendi
        XSSFSheet sheet = workbook.createSheet("actor1"); // sheet oluşturmak için eklendi

        Row row = sheet.createRow(0);   // satırları creat ediyoruz

        // döngü actor tablosundaki sutun başlıklarını almak için eklendi
        int count = 0;
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.printf("%-20s", rsmd.getColumnName(i));
            row.createCell(count).setCellValue(rsmd.getColumnName(i));
            count++;
        }
        System.out.println();

        count = 1;   // count = 0; eşitlediğimde column başlıklarını aldı işlemlerin bir sonraki satırdan başlaması için count = 1;
        int countCell = 0;

        // while döngü varolan her satırdaki bilgileri almak için eklendi
        while (rs.next()){
            row = sheet.createRow(count);
            for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
                System.out.printf("%-20s", rs.getString(i));
                Cell cell = row.createCell(countCell);
                cell.setCellValue(rs.getString(i));
                countCell++;
            }
            countCell = 0;
            count++;
            System.out.println();
        }

        // hafızada oluşan excel tablosundaki bilgileri yazdırmak için aşağıdaki kod eklendi
        String path = "src/test/java/test/actor.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }


}
