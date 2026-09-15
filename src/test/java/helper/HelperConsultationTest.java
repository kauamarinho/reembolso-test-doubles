package helper;

import model.Consultation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelperConsultationTest {

    @Test
    void shouldCreateDefaultConsultation() {
        Consultation consultation = ConsultationHelper.createDefaultConsultation();

        assertEquals("Clinical consultation", consultation.getDescription());
        assertEquals(200.0, consultation.getValue());
    }

    @Test
    void shouldCreateConsultationWithCustomValue() {
        Consultation consultation = ConsultationHelper.createConsultationWithValue(350.0);

        assertEquals("Custom consultation", consultation.getDescription());
        assertEquals(350.0, consultation.getValue());
    }
}
