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

public class UseCase10CountTotalSeats {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        System.out.println("Bogie List:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        int totalSeats =
                bogies.stream()
                        .map(b -> b.getCapacity())
                        .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity: " + totalSeats);

        System.out.println("Program continues...");
    }
}