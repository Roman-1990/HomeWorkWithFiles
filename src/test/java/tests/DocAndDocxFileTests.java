package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.HelperWithFiles.getTextDoc;
import static utils.HelperWithFiles.getTextDocx;

public class DocAndDocxFileTests {

    @Test
    void docTest() throws IOException {
        String docFilePath = "src/test/resources/files/1.doc";
        String expectedText = "Можно кинуть разное число монет.";

        String actualText = getTextDoc(docFilePath);
        assertThat(actualText, containsString(expectedText));
    }

    @Test
    void docxTest() throws IOException {
        String docxFilePath = "src/test/resources/files/1.docx";
        String expectedText = "Можно кинуть разное число монет.";

        String actualText = getTextDocx(docxFilePath);
        assertThat(actualText, containsString(expectedText));
    }
}