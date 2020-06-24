package com.lifeleft;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Instant;

public class PDFCreator {

    String pathOutput = "C:\\GenerateFile\\";;
    String fileName = "Report";
    String fileText = "";
    String extension = ".pdf";

    public PDFCreator(){

    }

    public String createPDF()
    {
        Document document = new Document();
        String time = Instant.now().toEpochMilli() + "";
        String fullPath = this.pathOutput + this.fileName + time + extension;
        try {
            PdfWriter.getInstance(document, new FileOutputStream(fullPath));
            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            Chunk chunk = new Chunk(this.fileText, font);

            document.add(chunk);
            document.close();
        } catch (DocumentException e) {
            return "false";
        } catch (FileNotFoundException e) {
            return "false";
        }

        return fullPath;
    }
}
