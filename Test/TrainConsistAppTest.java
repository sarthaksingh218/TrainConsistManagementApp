import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainConsistAppTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainConsistApp.validateTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainConsistApp.validateTrainID("TRAIN12"));
        assertFalse(TrainConsistApp.validateTrainID("TRN12A"));
        assertFalse(TrainConsistApp.validateTrainID("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(TrainConsistApp.validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainConsistApp.validateCargoCode("PET-ab"));
        assertFalse(TrainConsistApp.validateCargoCode("PET123"));
        assertFalse(TrainConsistApp.validateCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainConsistApp.validateTrainID("TRN-123"));
        assertFalse(TrainConsistApp.validateTrainID("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainConsistApp.validateCargoCode("PET-Ab"));
        assertFalse(TrainConsistApp.validateCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(TrainConsistApp.validateTrainID(""));
        assertFalse(TrainConsistApp.validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(TrainConsistApp.validateTrainID("TRN-1234XYZ"));
        assertFalse(TrainConsistApp.validateCargoCode("PET-ABCD"));
    }
}