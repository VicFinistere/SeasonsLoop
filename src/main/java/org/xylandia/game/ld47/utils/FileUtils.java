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
    private static final String TXT_FILE_EXTENSION = ".txt";

    private static void writeInFile(String filename, String line) {
        final String filePath = filename + TXT_FILE_EXTENSION;
        try {
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(line);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing into " + filePath + ".");
        }
    }

    public static void readFile(String filename) {
        readFile(filename, true);
    }

    public static void readFile(String filename, boolean isResource) {
        // Text file extension by default
        final String filePath = filename + TXT_FILE_EXTENSION;
        try {
            File file;
            if (isResource) {
                file = new File(getUri(filePath));
            } else {
                file = new File(filePath);
            }
            readFileContent(file);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading " + filename + ".");
        }
    }

    private static void readFileContent(File file) throws FileNotFoundException {
        final Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            final String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
    }

    public static String getUri(String filename) {
        // get the file url, not working in JAR file.

        final URL resource = SeasonLoopMain.class.getClassLoader().getResource(filename);
        String fileUri = null;
        if (resource == null) {
            throw new IllegalArgumentException("Cannot find file " + filename + "!");
        } else {
            try {
                fileUri = String.valueOf(new File(resource.toURI()));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return fileUri;
    }

}
