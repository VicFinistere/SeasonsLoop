package org.xylandia.game.ld47.utils;

import org.xylandia.game.ld47.SeasonLoopMain;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class FileUtils {

    public static void readFile(String filename) {

        // Text file extension by default
        String fileExtension = ".txt";
        filename = filename + fileExtension;
        try {
            File myObj = new File(getUri(filename));
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static String getUri(String filename) {
        // get the file url, not working in JAR file.

        URL resource = SeasonLoopMain.class.getClassLoader().getResource(filename);
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {

            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());

            try {
                filename = String.valueOf(new File(resource.toURI()));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return filename;
    }
}
