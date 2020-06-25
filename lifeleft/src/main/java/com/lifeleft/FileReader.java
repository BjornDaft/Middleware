package com.lifeleft;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

    public String file;

    public FileReader(String path){
        this.file = path;
    }

    public String readFileContent(){

        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(this.file));
            return new String(encoded, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
