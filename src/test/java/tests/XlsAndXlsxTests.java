package tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.HelperWithFiles.getTextXlsx;
import static utils.HelperWithFiles.getXls;

public class XlsAndXlsxTests {

    @Test
    void xlsTest() {
        String xlsFilePath = "src/test/resources/files/1.xls";
        String expectedText = "Можно кинуть разное число монет.";

        XLS xls = getXls(xlsFilePath);
        assertThat(xls, XLS.containsText(expectedText));
    }

    @Test
    void xlsCellTest() {
        String xlsFilePath = "src/test/resources/files/1.xls";
        String expectedText = "Можно кинуть разное число монет.";

        XLS xls = getXls(xlsFilePath);
        String actualText = xls.excel.getSheetAt(0).getRow(0).getCell(0).toString();
        assertThat(actualText, containsString(expectedText));
    }

    @Test
    void xlsxTest() throws IOException {
        String xlsxFilePath = "src/test/resources/files/1.xlsx";
        String expectedText = "Можно кинуть разное число монет.";

        String actualText = getTextXlsx(xlsxFilePath);
        assertThat(actualText, containsString(expectedText));
    }
}
