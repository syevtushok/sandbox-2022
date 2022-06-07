package examples.activities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ActivitiesAnalyser {
    public static void main(String[] args) throws IOException {
        File file = new File("deployment-activities");
        String activities = Files.readString(Path.of("deployment-activities"));
        List<String> tickets = Files.readAllLines(Path.of("tickets.txt"));
        List<String> result = new ArrayList<>();

        for (String s : tickets) {
            if (activities.contains(s + " ") || activities.contains(s + ":")) {
                result.add(s);
            }
        }

        for (String s : result) {
            System.out.println(s);
        }
        System.out.println(result.size());
    }
}
