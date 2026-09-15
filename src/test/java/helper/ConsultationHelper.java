package helper;

import model.Consultation;

public class ConsultationHelper {

    public static Consultation createDefaultConsultation() {
        return new Consultation("Clinical consultation", 200.0);
    }

    public static Consultation createConsultationWithValue(double value) {
        return new Consultation("Custom consultation", value);
    }
}
