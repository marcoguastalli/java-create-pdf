package robots;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreatePdfRun {

    private static final Logger logger = LogManager.getLogger(CreatePdfRun.class);

    public static void main(String[] args) {
        final String path = "~/temp";
        CreatePdf createPdf = new CreatePdf();
        createPdf.setPath(path);
        logger.debug("PDF created at path: '{}'", path);
    }

}
