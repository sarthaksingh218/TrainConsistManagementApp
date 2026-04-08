import java.util.*;
import java.util.stream.*;

class GoodsBogie {

    private String type;
    private String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    public String toString() {
        return type + " Bogie carrying " + cargo;
    }
}

public class TrainConsistApp {

    public static boolean checkSafetyCompliance(List<GoodsBogie> bogies) {

        return bogies.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical")
                                || b.getCargo().equalsIgnoreCase("Petroleum")
                );
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));

        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie b : bogies) {
            System.out.println(b);
        }

        boolean isSafe = checkSafetyCompliance(bogies);

        if (isSafe) {
            System.out.println("\nTrain formation is safety compliant.");
        } else {
            System.out.println("\nTrain formation is NOT safety compliant.");
        }

        System.out.println("Program continues...");
    }
}