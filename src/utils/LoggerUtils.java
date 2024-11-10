package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtils {
     private static final String LOG_FILE = "system_log.txt";

    // Log message to a file with timestamp
    public static void log(String message) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write("[" + timestamp + "] " + message + "\n");
        } catch (IOException e) {
            System.out.println("Logging failed: " + e.getMessage());
        }
    }

    // Log an error message
    public static void logError(String errorMessage) {
        log("ERROR: " + errorMessage);
    }

    // Log an info message
    public static void logInfo(String infoMessage) {
        log("INFO: " + infoMessage);
    }
}
