# popeskul-java-pro-hw8-files
HW8. Working with Files

### Java version
Java 17

### example
```java
public static void main(String[] args) {
    FileLoggerConfiguration configuration = new FileLoggerConfiguration.Builder(new File("log.txt"))
        .setLoggingLevel(LoggingLevel.DEBUG)
        .setMaxSize(1024)
        .setFormat("[%s][%s] Message: %s")
        .build();

    FileLogger logger = new FileLogger(configuration);

    for (int i = 0; i < 1; i++) { // Change this to 1000 to see the exception
        try {
            logger.log(LoggingLevel.DEBUG, "This is a debug message");
            logger.log(LoggingLevel.INFO, "This is an info message");
        } catch (FileMaxSizeReachedException e) {
            e.printStackTrace();
            break;
        }
    }
}
```