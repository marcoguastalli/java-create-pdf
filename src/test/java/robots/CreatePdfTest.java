package robots;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static robots.CreatePdfRun.XML_FILE;
import static robots.utils.LoadResourceUtils.loadResourceAsListOfString;
import static robots.utils.LoadResourceUtils.loadResourceAsString;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class CreatePdfTest {

    static final String PDF_FILE_CREATED_IN_THIS_TEST = "file.pdf";

    @Test
    void testCreatePdf() {
        final Path resourceDirectory = Paths.get("src", "test", "resources");
        final String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        final String path = absolutePath + FileSystems.getDefault().getSeparator() + PDF_FILE_CREATED_IN_THIS_TEST;
        final String content = loadResourceAsString(XML_FILE);
        assertThat(loadResourceAsListOfString(XML_FILE), notNullValue());
        assertThat(new CreatePdf(path, content), notNullValue());
    }

}