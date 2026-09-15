package dummy;

import helper.ConsultationHelper;
import interfaces.HealthPlan;
import model.Consultation;
import model.Patient;
import org.junit.jupiter.api.Test;
import service.ReimbursementCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyPatientTest {

    @Test
    void shouldUseDummyPatientOnlyToFillParameter() {
        ReimbursementCalculator calculator = new ReimbursementCalculator();
        Consultation consultation = ConsultationHelper.createDefaultConsultation();

        // Dummy: object created only because the method requires a Patient.
        // In this test, the patient's data is not used in the logic.
        Patient dummyPatient = new Patient();

        HealthPlan plan50 = () -> 0.5;

        double result = calculator.calculateReimbursement(consultation, dummyPatient, plan50);

        assertEquals(100.0, result);
    }
}
