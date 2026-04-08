import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainConsistAppTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {

        String[] arr = {"Sleeper","AC Chair","First Class","General","Luxury"};

        TrainConsistApp.sortBogieNames(arr);

        String[] expected = {"AC Chair","First Class","General","Luxury","Sleeper"};

        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_UnsortedInput() {

        String[] arr = {"Luxury","General","Sleeper","AC Chair"};

        TrainConsistApp.sortBogieNames(arr);

        String[] expected = {"AC Chair","General","Luxury","Sleeper"};

        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_AlreadySortedArray() {

        String[] arr = {"AC Chair","First Class","General"};

        TrainConsistApp.sortBogieNames(arr);

        String[] expected = {"AC Chair","First Class","General"};

        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_DuplicateBogieNames() {

        String[] arr = {"Sleeper","AC Chair","Sleeper","General"};

        TrainConsistApp.sortBogieNames(arr);

        String[] expected = {"AC Chair","General","Sleeper","Sleeper"};

        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_SingleElementArray() {

        String[] arr = {"Sleeper"};

        TrainConsistApp.sortBogieNames(arr);

        String[] expected = {"Sleeper"};

        assertArrayEquals(expected, arr);
    }
}