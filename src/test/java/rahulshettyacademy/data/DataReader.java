package rahulshettyacademy.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

    public Object[][] getDocs() throws IOException {
        List<HashMap<String, String>> data = new ArrayList<>();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "//src//test//java//rahulshettyacademy//data//PurchaseOrder.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Data");

        // Get all rows
        Iterator<Row> rows = sheet.iterator();
        Row firstRow = rows.next(); // Header row
        int rowCount = sheet.getLastRowNum();
        int colCount = firstRow.getLastCellNum();

        Object[][] dataMap = new Object[rowCount][1];

        // Iterate through rows (skipping header)
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i + 1);
            HashMap<String, String> map = new HashMap<String, String>();

            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                String key = firstRow.getCell(j).getStringCellValue();
                String value = "";

                if (cell.getCellType() == CellType.STRING) {
                    value = cell.getStringCellValue();
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    value = String.valueOf(cell.getNumericCellValue());
                }
                map.put(key, value);
            }
            dataMap[i][0] = map;
        }
        workbook.close();
        return dataMap;
    }
}
