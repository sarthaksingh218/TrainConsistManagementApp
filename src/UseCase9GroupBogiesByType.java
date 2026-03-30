import java.util.*;
import java.util.stream.*;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String toString() {
        return name + " - Capacity: " + capacity;
    }
}

public class UseCase9GroupBogiesByType {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 60));

        System.out.println("Original Bogie List:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getName));

        System.out.println("\nGrouped Bogies By Type:");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nType: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println(b);
            }
        }

        System.out.println("\nOriginal List Size: " + bogies.size());
        System.out.println("Number of Groups: " + groupedBogies.size());

        System.out.println("Program continues...");
    }
}