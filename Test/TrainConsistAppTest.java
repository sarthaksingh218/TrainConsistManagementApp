import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistAppTest {

    private List<Bogie> createBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 60));
        return bogies;
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = createBogieList();

        Map<String, List<Bogie>> result =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = createBogieList();

        Map<String, List<Bogie>> result =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = createBogieList();

        Map<String, List<Bogie>> result =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(3, result.keySet().size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        Map<String, List<Bogie>> result =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 68));

        Map<String, List<Bogie>> result =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(1, result.keySet().size());
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> bogies = createBogieList();

        Map<String, List<Bogie>> result =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(result.keySet().contains("Sleeper"));
        assertTrue(result.keySet().contains("AC Chair"));
        assertTrue(result.keySet().contains("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<Bogie> bogies = createBogieList();

        Map<String, List<Bogie>> result =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(2, result.get("AC Chair").size());
        assertEquals(1, result.get("First Class").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = createBogieList();
        int originalSize = bogies.size();

        Map<String, List<Bogie>> result =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(originalSize, bogies.size());
        assertNotNull(result);
    }
}