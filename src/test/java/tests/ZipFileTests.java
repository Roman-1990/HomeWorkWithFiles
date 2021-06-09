package tests;

import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.HelperWithFiles.getTextTxt;
import static utils.ZipHelper.unZip;

public class ZipFileTests {

    @Test
    void zipPasswordTest() throws IOException, ZipException {
        String zipFilePath = "src/test/resources/files/1.zip";
        String unZipFilePath = "src/test/resources/files/unzip";
        String zipPassword = "password";
        String unzipTxtFilePath = "src/test/resources/files/unzip/1.txt";
        String expectedText = "Можно кинуть разное число монет.";

        unZip(zipFilePath, unZipFilePath, zipPassword);

        String actualText = getTextTxt(unzipTxtFilePath);
        assertThat(actualText, containsString(expectedText));
    }
}
