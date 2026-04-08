import java.util.Arrays;

public class TrainConsistApp {

    public static boolean binarySearchBogieId(String[] bogieIds, String key) {

        if (bogieIds == null || bogieIds.length == 0) {
            return false;
        }

        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int cmp = key.compareTo(bogieIds[mid]);

            if (cmp == 0) {
                return true;
            }
            else if (cmp < 0) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        String searchKey = "BG309";

        boolean found = binarySearchBogieId(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie ID " + searchKey + " found in consist.");
        } else {
            System.out.println("Bogie ID " + searchKey + " not found.");
        }

        System.out.println("Program continues...");
    }
}