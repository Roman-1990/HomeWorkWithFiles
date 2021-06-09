package utils;


import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class HelperWithFiles {

    public static File getFile(String path) {
        return new File(path);
    }

    public static String getTextTxt(String path) throws IOException {
        File file = getFile(path);
        return FileUtils.readFileToString(file, "UTF-8");
    }

    public static PDF getPdf(String path) throws IOException {
        return new PDF(getFile(path));
    }

    public static XLS getXls(String path) {
        return new XLS(getFile(path));
    }

    public static String getTextXlsx(String path) throws IOException {
        StringBuilder result = new StringBuilder();
        File file = getFile(path);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        for (Row row : sheet) {
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                result.append(cell.getStringCellValue());
            }
        }
        return result.toString();
    }

    public static String getTextDoc(String path) throws IOException {
        FileInputStream fis = new FileInputStream(getFile(path));
        HWPFDocument doc = new HWPFDocument(fis);
        WordExtractor ext = new WordExtractor(doc);
        return ext.getText();
    }

    public static String getTextDocx(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        XWPFDocument docx = new XWPFDocument(fis);
        XWPFWordExtractor ext = new XWPFWordExtractor(docx);
        return ext.getText();
    }
}
