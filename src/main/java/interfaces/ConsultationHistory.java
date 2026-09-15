package interfaces;

import model.Consultation;
import java.util.List;

public interface ConsultationHistory {
    void save(Consultation consultation);
    List<Consultation> list();
}
