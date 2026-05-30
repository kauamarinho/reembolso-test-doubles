package helper;

import model.Consulta;

public class ConsultaHelper {

    public static Consulta criarConsultaPadrao() {
        return new Consulta("Consulta clínica", 200.0);
    }

    public static Consulta criarConsultaComValor(double valor) {
        return new Consulta("Consulta personalizada", valor);
    }
}
