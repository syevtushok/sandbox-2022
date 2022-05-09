package examples.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ScannerExample {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("simple.text");
        if (Files.notExists(path)) {
            path = Files.createFile(path);
            Files.writeString(path, "t4s\n22\n13  53 4 3 ");
        }
        Scanner scanner = new Scanner(path.toFile());
        while (scanner.hasNext()) {
            String next = scanner.next();
            log.debug(next);
        }
        scanner.close();

        String input = "11 3 3 4 fr t 4tgt 5  g  r g gg   g gg g g g g g g   ggg  gggg ggg  gwww  lorem";
        Scanner secondScanner = new Scanner(input).useDelimiter(" {2}");
        while (secondScanner.hasNext()) {
            String next = secondScanner.next();
            log.debug(next);
        }
    }
}
