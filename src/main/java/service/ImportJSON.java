package service;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImportJSON {

    private String path;

    /**
    Read file with scanner
     */
    public String readFile(String path) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return content;
    }

}
