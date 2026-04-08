import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainConsistAppTest {

    @Test
    void testSearch_BogieFound() {

        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(TrainConsistApp.searchBogieId(arr, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {

        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(TrainConsistApp.searchBogieId(arr, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {

        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(TrainConsistApp.searchBogieId(arr, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {

        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(TrainConsistApp.searchBogieId(arr, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {

        String[] arr = {"BG101"};

        assertTrue(TrainConsistApp.searchBogieId(arr, "BG101"));
    }
}