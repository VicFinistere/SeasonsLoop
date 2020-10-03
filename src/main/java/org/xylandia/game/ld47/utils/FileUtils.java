package org.xylandia.game.ld47.utils;

import org.apache.commons.io.IOUtils;
import org.xylandia.game.ld47.SeasonLoopMain;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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

    public static String readFile(String filename) {
        return readFile(filename, true);
    }

    public static String readFile(String filename, boolean isResource) {
        // Text file extension by default
        final String filePath = filename + TXT_FILE_EXTENSION;
        try {
            if (isResource) {
                return readResourceContent(filePath);
            } else {
                return readFileContent(filePath);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading " + filename + ".");
        }
        return "";
    }

    private static String readResourceContent(String pResourcePath) throws IOException {
        final InputStream in = FileUtils.class.getClassLoader().getResourceAsStream(pResourcePath);
        if(in == null){
            throw new IOException(pResourcePath + " cannot be read.");
        }
        return IOUtils.toString(in, StandardCharsets.UTF_8);
    }

    private static String readFileContent(String pFilePath) throws FileNotFoundException {
        final File lFile = new File(pFilePath);
        final Scanner myReader = new Scanner(lFile);
        StringBuilder lTextBuilder = new StringBuilder();
        while (myReader.hasNextLine()) {
            lTextBuilder.append(myReader.nextLine());
        }
        myReader.close();
        return lTextBuilder.toString();
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
