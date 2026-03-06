package model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class LibraryLogger {
    private static final Path LOG_PATH = Paths.get("src/main/resources/logs.txt");

    public static void log(String message) {
        try {
            Path parent = LOG_PATH.getParent();
            if (parent != null) Files.createDirectories(parent);
            Files.write(LOG_PATH, (message + System.lineSeparator()).getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Log error: " + e.getMessage());
        }
    }
}