package org.xylandia.game.ld47.utils;

import org.xylandia.game.ld47.SeasonLoopMain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class FileUtils {

    private static void writeInFile(String filename, String line) {
        try {
            String fileExtension = ".txt";
            String filePath = filename + fileExtension;
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(line);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing into " + filename + ".");
        }
    }

    public static void readFile(String filename) {
        readFile(filename, true);
    }

    public static void readFile(String filename, boolean isResource) {

        // Text file extension by default
        String fileExtension = ".txt";
        String filePath = filename + fileExtension;
        try {
            if (isResource) {
                File file = new File(getUri(filePath));
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();

            } else {
                File file = new File(filePath);
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String getUri(String filename) {
        // get the file url, not working in JAR file.

        URL resource = SeasonLoopMain.class.getClassLoader().getResource(filename);
        String fileUri = null;
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {

            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());

            try {
                fileUri = String.valueOf(new File(resource.toURI()));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return fileUri;
    }

}
