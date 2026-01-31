package rahulshettyacademy.data;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataGenerator {

    public static void main(String[] args) throws IOException {
        // Create a Workbook
        Workbook workbook = new XSSFWorkbook();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Data");

        // Create Header Row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("email");
        headerRow.createCell(1).setCellValue("password");
        headerRow.createCell(2).setCellValue("productName");

        // Create Data Row 1
        Row dataRow1 = sheet.createRow(1);
        dataRow1.createCell(0).setCellValue("postman4075@gmail.com");
        dataRow1.createCell(1).setCellValue("Hello123@");
        dataRow1.createCell(2).setCellValue("ZARA COAT 3");

        // Write to File
        String path = System.getProperty("user.dir")
                + "//src//test//java//rahulshettyacademy//data//PurchaseOrder.xlsx";
        FileOutputStream fileOut = new FileOutputStream(path);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();

        System.out.println("Excel file created at: " + path);
    }
}
