package robots;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import exception.CreatePdfException;
import lombok.NonNull;


public class CreatePdf {

    private String path;

    public CreatePdf(@NonNull String path, @NonNull String content) {
        this.path = path;
        try (OutputStream outputStream = new FileOutputStream(path)) {
            ITextRenderer renderer = new ITextRenderer();
            SharedContext sharedContext = renderer.getSharedContext();
            sharedContext.setPrint(true);
            sharedContext.setInteractive(false);
            renderer.setDocumentFromString(content);
            renderer.layout();
            renderer.createPDF(outputStream);
        } catch (IOException e) {
            throw new CreatePdfException("Invalid path" + path, e);
        }
    }

    public String getPath() {
        return path;
    }
}
