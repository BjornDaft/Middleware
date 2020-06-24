package com.lifeleft;



import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


@WebService(serviceName = "CheckFile")
public class CheckFileService {

    public CheckFileService(){

    }

    @WebMethod
    public String checkFile (boolean statutOp, String info, String operationName, String tokenApp, String tokenUser, String appVersion, String operationVersion) {
        Message message = new Message(statutOp, info, operationName, tokenApp, tokenUser, appVersion, operationVersion);

        //int percent = getPercent(message.info);
        /*if(percent>85){
            String pdfFile = generatorPDF();

            return "Response";
        }*/

        String test = generatorPDF();

        return test;
    }

    private String generatorPDF(){
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));
            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            Chunk chunk = new Chunk("Hello World", font);

            document.add(chunk);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
            return "error";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "error";
        }

        return "Response";
    }

    private int getPercent(String path) {

        try {
            String content = readFile(path,  Charset.defaultCharset());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 70;
    }

    private String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    private boolean verifApp(){

        return true;
    }


}
