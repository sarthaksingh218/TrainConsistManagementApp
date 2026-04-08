import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class TrainConsistAppTest {

    @Test
    void testLoopFilteringLogic() {

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        List<Bogie> result = TrainConsistApp.filterWithLoop(bogies);

        assertEquals(1, result.size());
        assertTrue(result.get(0).getCapacity() > 60);
    }

    @Test
    void testStreamFilteringLogic() {

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        List<Bogie> result = TrainConsistApp.filterWithStream(bogies);

        assertEquals(1, result.size());
        assertTrue(result.get(0).getCapacity() > 60);
    }

    @Test
    void testLoopAndStreamResultsMatch() {

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Luxury Coach", 80));

        List<Bogie> loopResult = TrainConsistApp.filterWithLoop(bogies);
        List<Bogie> streamResult = TrainConsistApp.filterWithStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));

        long start = System.nanoTime();
        TrainConsistApp.filterWithLoop(bogies);
        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {

        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            bogies.add(new Bogie("Sleeper", 70));
            bogies.add(new Bogie("AC Chair", 50));
        }

        List<Bogie> result = TrainConsistApp.filterWithStream(bogies);

        assertTrue(result.size() > 0);
    }
}