package helper;

import model.Consulta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelperConsultaTest {

    @Test
    void deveCriarConsultaPadrao() {
        Consulta consulta = ConsultaHelper.criarConsultaPadrao();

        assertEquals("Consulta clínica", consulta.getDescricao());
        assertEquals(200.0, consulta.getValor());
    }

    @Test
    void deveCriarConsultaComValorPersonalizado() {
        Consulta consulta = ConsultaHelper.criarConsultaComValor(350.0);

        assertEquals("Consulta personalizada", consulta.getDescricao());
        assertEquals(350.0, consulta.getValor());
    }
}
