package interfaces;

import model.Consultation;
import model.Patient;

public interface ReimbursementAuthorizer {
    boolean authorize(Consultation consultation, Patient patient);
}
