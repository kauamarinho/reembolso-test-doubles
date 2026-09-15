package mock;

import exception.ConsultationNotAuthorizedException;
import helper.ConsultationHelper;
import interfaces.ReimbursementAuthorizer;
import interfaces.HealthPlan;
import model.Consultation;
import model.Patient;
import org.junit.jupiter.api.Test;
import service.ReimbursementCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockAuthorizerTest {

    @Test
    void shouldCalculateReimbursementWhenConsultationIsAuthorized() {
        ReimbursementCalculator calculator = new ReimbursementCalculator();
        Consultation consultation = ConsultationHelper.createDefaultConsultation();
        Patient patient = new Patient("John", "12345678900");
        HealthPlan plan50 = () -> 0.5;

        // Mock: simulates the authorizer's behavior.
        ReimbursementAuthorizer authorizerMock = mock(ReimbursementAuthorizer.class);
        when(authorizerMock.authorize(consultation, patient)).thenReturn(true);

        double result = calculator.calculateReimbursementWithAuthorization(
                consultation,
                patient,
                plan50,
                authorizerMock
        );

        assertEquals(100.0, result);
    }

    @Test
    void shouldThrowExceptionWhenConsultationIsNotAuthorized() {
        ReimbursementCalculator calculator = new ReimbursementCalculator();
        Consultation consultation = ConsultationHelper.createDefaultConsultation();
        Patient patient = new Patient("Mary", "98765432100");
        HealthPlan plan50 = () -> 0.5;

        ReimbursementAuthorizer authorizerMock = mock(ReimbursementAuthorizer.class);
        when(authorizerMock.authorize(consultation, patient)).thenReturn(false);

        assertThrows(ConsultationNotAuthorizedException.class, () -> {
            calculator.calculateReimbursementWithAuthorization(
                    consultation,
                    patient,
                    plan50,
                    authorizerMock
            );
        });
    }
}
