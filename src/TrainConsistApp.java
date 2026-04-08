import java.util.*;

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        LinkedHashSet<String> trainFormation = new LinkedHashSet<>();

        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        trainFormation.add("Sleeper");

        System.out.println("Final Train Formation (Insertion Order Preserved):");
        System.out.println(trainFormation);

        System.out.println("Total Bogies in Formation: " + trainFormation.size());
    }
}
