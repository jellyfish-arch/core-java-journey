package Day07;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.List;

public class FileReadWriteNIO {
    public static void main(String[] args) {
        Path path = Paths.get("nio_example.txt");
        String content = "Hello NIO!\nThis is a sample text file.\nFile I/O in Java NIO is easy.";

        try {
            // Write to file
            Files.write(path, content.getBytes(StandardCharsets.UTF_8));
            System.out.println("File written successfully!");

            // Read from file
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            System.out.println("\nReading from file:");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
