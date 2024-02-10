package robots;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import exception.CreatePdfException;
import lombok.Getter;
import lombok.NonNull;

/** Create a PDF in the constructor, don't you like it? Do a PR :-P */
@Getter
public class CreatePdf {

    private final String path;

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

}
