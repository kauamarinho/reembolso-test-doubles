package service;

import exception.ConsultationNotAuthorizedException;
import interfaces.Audit;
import interfaces.ReimbursementAuthorizer;
import interfaces.HealthPlan;
import model.Consultation;
import model.Patient;

public class ReimbursementCalculator {

    public double calculateReimbursement(Consultation consultation, Patient patient, HealthPlan healthPlan) {
        return consultation.getValue() * healthPlan.getCoveragePercentage();
    }

    public void registerConsultation(Consultation consultation, Audit audit) {
        audit.registerConsultation(consultation);
    }

    public double calculateReimbursementWithAuthorization(
            Consultation consultation,
            Patient patient,
            HealthPlan healthPlan,
            ReimbursementAuthorizer authorizer
    ) {
        if (!authorizer.authorize(consultation, patient)) {
            throw new ConsultationNotAuthorizedException("Consultation not authorized for reimbursement.");
        }

        return calculateReimbursement(consultation, patient, healthPlan);
    }
}
