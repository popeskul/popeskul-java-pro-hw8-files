package org.example;

public class FileMaxSizeReachedException extends Throwable {
    private static final String message = "The file '%s' has reached the maximum size of %d bytes (current size: %d bytes)";
    private String filePath;
    private long maxSize;
    private long currentSize;


    public FileMaxSizeReachedException(String filePath, long maxSize, long currentSize) {
        super();
        this.filePath = filePath;
        this.maxSize = maxSize;
        this.currentSize = currentSize;
    }

    // This allows the message to be constructed only when it is needed,
    // rather than at the time the exception is constructed.
    @Override
    public String getMessage() {
        return String.format(message, filePath, maxSize, currentSize);
    }
}
