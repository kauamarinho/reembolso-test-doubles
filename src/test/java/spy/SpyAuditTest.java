package spy;

import helper.ConsultationHelper;
import model.Consultation;
import org.junit.jupiter.api.Test;
import service.ReimbursementCalculator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpyAuditTest {

    @Test
    void shouldVerifyThatAuditWasCalled() {
        ReimbursementCalculator calculator = new ReimbursementCalculator();
        Consultation consultation = ConsultationHelper.createDefaultConsultation();

        // Spy: records whether the method was called during the test.
        AuditSpy auditSpy = new AuditSpy();

        calculator.registerConsultation(consultation, auditSpy);

        assertTrue(auditSpy.wasCalled());
    }
}
