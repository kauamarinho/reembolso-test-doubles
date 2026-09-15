package spy;

import interfaces.Audit;
import model.Consultation;

public class AuditSpy implements Audit {

    private boolean wasCalled = false;

    @Override
    public void registerConsultation(Consultation consultation) {
        wasCalled = true;
    }

    public boolean wasCalled() {
        return wasCalled;
    }
}
