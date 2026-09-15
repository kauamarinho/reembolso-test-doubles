package fake;

import interfaces.ConsultationHistory;
import model.Consultation;

import java.util.ArrayList;
import java.util.List;

public class ConsultationHistoryFake implements ConsultationHistory {

    private final List<Consultation> consultations = new ArrayList<>();

    @Override
    public void save(Consultation consultation) {
        consultations.add(consultation);
    }

    @Override
    public List<Consultation> list() {
        return consultations;
    }
}
