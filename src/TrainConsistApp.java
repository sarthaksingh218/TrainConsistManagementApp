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

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Luxury Coach", 80));

        System.out.println("Original Bogie List:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        List<Bogie> filteredBogies =
                bogies.stream()
                        .filter(b -> b.getCapacity() > 60)
                        .collect(Collectors.toList());

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        for (Bogie b : filteredBogies) {
            System.out.println(b);
        }

        System.out.println("\nOriginal List Size: " + bogies.size());
        System.out.println("Filtered List Size: " + filteredBogies.size());

        System.out.println("Program continues...");
    }
}