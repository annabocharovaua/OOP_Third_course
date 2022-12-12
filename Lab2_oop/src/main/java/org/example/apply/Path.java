package org.example.apply;
import java.io.File;

public class Path {
    private Path() {}

    public static String getPath(String... path) {
        return String.join(File.separator, path);
    }
}
