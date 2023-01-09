package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader {
    private static final String DOES_NOT_EXIST = "The file '%s' does not exist";
    public static FileLoggerConfiguration load(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists())
            throw new IOException(String.format(DOES_NOT_EXIST, filePath));

        LoggingLevel loggingLevel = null;
        int maxSize = 0;
        String format = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                String key = parts[0];
                String value = parts[1];

                switch (key) {
                    case "FILE" -> file = new File(value);
                    case "LEVEL" -> loggingLevel = loggingLevel.valueOf(value);
                    case "MAX-SIZE" -> maxSize = Integer.parseInt(value);
                    case "FORMAT" -> format = value;
                }
            }
        }

        return new FileLoggerConfiguration(file, maxSize, loggingLevel, format);
    }
}
