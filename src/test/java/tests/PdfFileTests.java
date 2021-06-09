package tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.HelperWithFiles.getPdf;

public class PdfFileTests {

    @Test
    void pdfTest() throws IOException {
        String pdfFilePath = "src/test/resources/files/1.pdf";
        String expectedText = "Можно кинуть разное число монет.";

        PDF pdf = getPdf(pdfFilePath);
        assertThat(pdf, PDF.containsText(expectedText));
    }
}
