package com.lifeleft;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Motor1 extends Motor {



    public Motor1(Message message) {
        super(message);
    }


    @Override
    public String run() {
        //Check The percent of french word in the text
        int percent = getPercent(message.info);

        //If percent is higher than we want
        if(percent>70){
            PDFCreator pdf = new PDFCreator();//Init the PDFCreator
            pdf.fileText = "Le fichier est reconnu a  " + percent + "%";//Set the text of the PDF
            String pdfPath = pdf.createPDF();//Create the PDF on the disk, and get the full path of destination
            if(pdfPath != "false"){//If we have a real path
                return pdfPath;
            }
            else{//If the creation of pdf failed
                return pdfPath;
            }
        }

        //If the percent of French word is lower than we want
        return "Error";
    }

    //Get percent of French word in a text
    private int getPercent(String path) {

        try {
            //Get the content of the textfile in string
            String content = readFile(path,  Charset.defaultCharset());

            //Cut the string in a list of word

            //For each word check in the database if he's exist

        } catch (IOException e) {
            e.printStackTrace();
            return 75;
        }

        return 75;
    }

    //Get the content of file in one String
    private String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }



}
