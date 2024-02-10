package robots;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreatePdfRun {

    private static final Logger logger = LogManager.getLogger(CreatePdfRun.class);
    private static final String XML_FILE = "just.an.xml";

    public static void main(String[] args) throws IOException {
        final String path = args[0];

        String content = "";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(XML_FILE);
        if (inputStream != null) {
            try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                 BufferedReader reader = new BufferedReader(inputStreamReader)) {
                content = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
            CreatePdf createPdf = new CreatePdf(path, content);
            logger.info("Pdf created at path: '{}'", createPdf.getPath());
        } else {
            logger.error("Error create Pdf");
        }
    }

}
