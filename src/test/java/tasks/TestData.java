package tasks;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

public class TestData {

    public static Map getUserCredentials(){

        Map<String, String> credentials = new HashMap<String, String>() ;
        try {
            File file = new File("src/test/resources/userInfo.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            for (Row row : sheet) {
                credentials.put(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return credentials;
    }

}
