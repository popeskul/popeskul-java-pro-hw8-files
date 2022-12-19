package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        FileLoggerConfiguration configuration = new FileLoggerConfiguration.Builder(new File("log.txt"))
                .setLoggingLevel(LoggingLevel.DEBUG)
                .setMaxSize(1024)
                .setFormat("[%s][%s] Message: %s")
                .build();

        FileLogger logger = new FileLogger(configuration);

        for (int i = 0; i < 100; i++) {
            try {
                logger.log(LoggingLevel.DEBUG, "This is a debug message");
                logger.log(LoggingLevel.INFO, "This is an info message");
            } catch (FileMaxSizeReachedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
