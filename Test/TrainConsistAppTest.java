import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainConsistAppTest {

    @Test
    void testSort_BasicSorting() {

        int[] arr = {72, 56, 24, 70, 60};
        TrainConsistApp.bubbleSort(arr);

        int[] expected = {24, 56, 60, 70, 72};

        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_AlreadySortedArray() {

        int[] arr = {24, 56, 60, 70, 72};
        TrainConsistApp.bubbleSort(arr);

        int[] expected = {24, 56, 60, 70, 72};

        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_DuplicateValues() {

        int[] arr = {72, 56, 56, 24};
        TrainConsistApp.bubbleSort(arr);

        int[] expected = {24, 56, 56, 72};

        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_SingleElementArray() {

        int[] arr = {50};
        TrainConsistApp.bubbleSort(arr);

        int[] expected = {50};

        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_AllEqualValues() {

        int[] arr = {40, 40, 40};
        TrainConsistApp.bubbleSort(arr);

        int[] expected = {40, 40, 40};

        assertArrayEquals(expected, arr);
    }
}