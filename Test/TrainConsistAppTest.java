import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistAppTest {

    private List<Bogie> createBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        return bogies;
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = createBogieList();

        int totalSeats = bogies.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        assertEquals(222, totalSeats);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = createBogieList();

        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(72 + 56 + 24 + 70, totalSeats);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));

        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(72, totalSeats);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(0, totalSeats);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = createBogieList();

        List<Integer> capacities = bogies.stream()
                .map(Bogie::getCapacity)
                .toList();

        assertTrue(capacities.contains(72));
        assertTrue(capacities.contains(56));
        assertTrue(capacities.contains(24));
        assertTrue(capacities.contains(70));
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = createBogieList();

        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        int manualSum = 0;
        for (Bogie b : bogies) {
            manualSum += b.getCapacity();
        }

        assertEquals(manualSum, totalSeats);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = createBogieList();
        int originalSize = bogies.size();

        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(originalSize, bogies.size());
        assertEquals(222, totalSeats);
    }
}