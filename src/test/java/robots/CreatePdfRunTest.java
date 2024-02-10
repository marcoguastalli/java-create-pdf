package robots;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class CreatePdfRunTest {

    @Test
    void testCreatePdf() {
        CreatePdf createPdf = new CreatePdf();
        assertNotNull(createPdf);
    }

}