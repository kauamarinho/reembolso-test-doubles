package stub;

import helper.ConsultationHelper;
import interfaces.HealthPlan;
import model.Consultation;
import model.Patient;
import org.junit.jupiter.api.Test;
import service.ReimbursementCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StubHealthPlanTest {

    @Test
    void shouldCalculateReimbursementWith50PercentPlan() {
        ReimbursementCalculator calculator = new ReimbursementCalculator();
        Consultation consultation = ConsultationHelper.createDefaultConsultation();
        Patient dummyPatient = new Patient();

        // Stub: always returns a fixed value for the test.
        HealthPlan plan50 = () -> 0.5;

        double result = calculator.calculateReimbursement(consultation, dummyPatient, plan50);

        assertEquals(100.0, result);
    }

    @Test
    void shouldCalculateReimbursementWith80PercentPlan() {
        ReimbursementCalculator calculator = new ReimbursementCalculator();
        Consultation consultation = ConsultationHelper.createDefaultConsultation();
        Patient dummyPatient = new Patient();

        // Stub: always returns 80% coverage.
        HealthPlan plan80 = () -> 0.8;

        double result = calculator.calculateReimbursement(consultation, dummyPatient, plan80);

        assertEquals(160.0, result);
    }
}
