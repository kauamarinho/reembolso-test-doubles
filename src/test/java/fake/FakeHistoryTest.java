package fake;

import helper.ConsultationHelper;
import model.Consultation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakeHistoryTest {

    @Test
    void shouldSaveConsultationsInMemoryWithoutDatabase() {
        ConsultationHistoryFake history = new ConsultationHistoryFake();

        Consultation consultation1 = ConsultationHelper.createDefaultConsultation();
        Consultation consultation2 = ConsultationHelper.createConsultationWithValue(300.0);

        history.save(consultation1);
        history.save(consultation2);

        assertEquals(2, history.list().size());
        assertEquals(200.0, history.list().get(0).getValue());
        assertEquals(300.0, history.list().get(1).getValue());
    }
}
