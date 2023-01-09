package org.example;

import java.io.File;

public class FileLoggerConfiguration {
    private File file;
    private LoggingLevel loggingLevel;
    private long maxSize;
    private String format;

    public FileLoggerConfiguration(File file, long maxSize, LoggingLevel loggingLevel, String format) {
        this.file = file;
        this.maxSize = maxSize;
        this.loggingLevel = loggingLevel;
        this.format = format;
    }

    public File getFile() {
        return file;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public static class Builder {
        private File file;
        private LoggingLevel loggingLevel;
        private long maxSize;
        private String format;

        public Builder(File file) {
            this.file = file;
        }

        public Builder setLoggingLevel(LoggingLevel loggingLevel) {
            this.loggingLevel = loggingLevel;
            return this;
        }

        public Builder setMaxSize(long maxSize) {
            this.maxSize = maxSize;
            return this;
        }

        public Builder setFormat(String format) {
            this.format = format;
            return this;
        }

        public FileLoggerConfiguration build() {
            return new FileLoggerConfiguration(file, maxSize, loggingLevel, format);
        }
    }
}
