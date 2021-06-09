package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.HelperWithFiles.getTextTxt;

public class TxtFileTests {

    @Test
    void txtTest() throws IOException {
        String txtFilePath = "src/test/resources/files/1.txt";
        String expectedText = "Можно кинуть разное число монет.";

        String actualText = getTextTxt(txtFilePath);
        assertThat(actualText, containsString(expectedText));
    }
}
