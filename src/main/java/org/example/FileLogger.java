package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileLogger {
    private FileLoggerConfiguration configuration;
    private final String messageFormat = "[%s][%s] Message: %s";

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
    }

    public void log(LoggingLevel level, String message) throws FileMaxSizeReachedException {
        // Check if the logging level is enabled
        if (configuration.getLoggingLevel().ordinal() > level.ordinal()) {
            return;
        }

        // Check if the file size has reached the maximum size
        File file = configuration.getFile();
        if (file.length() + message.length() > configuration.getMaxSize()) {
            throw new FileMaxSizeReachedException(file.getPath(), configuration.getMaxSize(), file.length());
        }

        // Write the message to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            String logMessage = String.format(messageFormat, LocalDateTime.now(), level, message);
            writer.write(logMessage);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
