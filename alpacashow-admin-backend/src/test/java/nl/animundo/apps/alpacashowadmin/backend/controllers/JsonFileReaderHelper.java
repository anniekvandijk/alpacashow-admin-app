package nl.animundo.apps.alpacashowadmin.backend.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.Assert.assertTrue;

public class JsonFileReaderHelper {

    static final String workingDir = System.getProperty("user.dir");
    static final String testFileDir = "/src/test/resources/json/";

    public static String readJsonfile(String fileName) throws IOException {
        File file = new File(workingDir + testFileDir + fileName);
        assertTrue(file.isFile() && file.exists() && file.canRead());
        BufferedReader reader = new BufferedReader (new FileReader(file));
        StringBuilder builder = new StringBuilder();
        String result = "";
        String line = reader.readLine();
        while (line != null) {
            builder.append(line);
            line = reader.readLine();
        }
        return builder.toString();
    }
}
