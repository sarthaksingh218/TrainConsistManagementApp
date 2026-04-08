import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainConsistAppTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {

        String[] arr = {};

        assertThrows(IllegalStateException.class, () -> {
            TrainConsistApp.searchBogieId(arr, "BG101");
        });
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {

        String[] arr = {"BG101","BG205"};

        assertDoesNotThrow(() -> {
            TrainConsistApp.searchBogieId(arr, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {

        String[] arr = {"BG101","BG205","BG309"};

        assertTrue(TrainConsistApp.searchBogieId(arr, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {

        String[] arr = {"BG101","BG205","BG309"};

        assertFalse(TrainConsistApp.searchBogieId(arr, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {

        String[] arr = {"BG101"};

        assertTrue(TrainConsistApp.searchBogieId(arr, "BG101"));
    }
}