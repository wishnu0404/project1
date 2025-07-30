package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.ConstantsClass;

public class ExcelReadUtility {
    static FileInputStream f;
    static XSSFWorkbook w;
    static XSSFSheet s;

    public static String getStringData(int row, int col, String sheetName) throws IOException {
        Object user;
		f = new FileInputStream(ConstantsClass.excelfilepath);
        w = new XSSFWorkbook(f);
        s = w.getSheet(sheetName);
        XSSFRow r = s.getRow(row);
        XSSFCell c = r.getCell(col);
        return c.getStringCellValue();
    }

    public static String getIntegerData(int row, int col, String sheetName) throws IOException {
        f = new FileInputStream(ConstantsClass.excelfilepath); 
        w = new XSSFWorkbook(f);
        s = w.getSheet(sheetName);
        XSSFRow r = s.getRow(row);
        XSSFCell c = r.getCell(col);
        int y = (int) c.getNumericCellValue(); // Type casting double to int
        return String.valueOf(y);
    }
}
