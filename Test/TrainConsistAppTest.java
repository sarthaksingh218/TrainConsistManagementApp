import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class TrainConsistAppTest {

    @Test
    void testSafety_AllBogiesValid() {

        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));

        assertTrue(TrainConsistApp.checkSafetyCompliance(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {

        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Coal"));

        assertFalse(TrainConsistApp.checkSafetyCompliance(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {

        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));

        assertTrue(TrainConsistApp.checkSafetyCompliance(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {

        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Cylindrical", "Coal"));

        assertFalse(TrainConsistApp.checkSafetyCompliance(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {

        List<GoodsBogie> bogies = new ArrayList<>();

        assertTrue(TrainConsistApp.checkSafetyCompliance(bogies));
    }
}