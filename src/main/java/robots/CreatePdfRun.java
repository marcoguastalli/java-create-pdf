package robots;

import static robots.utils.LoadResourceUtils.loadResourceAsString;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main class to create a PDF
 */
public class CreatePdfRun {

    static final String XML_FILE = "just.an.xml";
    private static final Logger logger = LogManager.getLogger(CreatePdfRun.class);

    public static void main(String[] args) {
        final String path = args[0];
        final String content = loadResourceAsString(XML_FILE);
        final CreatePdf createPdf = new CreatePdf(path, content);
        logger.info("Pdf created at path: '{}'", createPdf.getPath());
    }

}
