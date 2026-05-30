package stub;

import helper.ConsultaHelper;
import interfaces.PlanoSaude;
import model.Consulta;
import model.Paciente;
import org.junit.jupiter.api.Test;
import service.CalculadoraReembolso;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StubPlanoSaudeTest {

    @Test
    void deveCalcularReembolsoComPlanoDe50PorCento() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        Consulta consulta = ConsultaHelper.criarConsultaPadrao();
        Paciente pacienteDummy = new Paciente();

        // Stub: retorna sempre um valor fixo para o teste.
        PlanoSaude plano50 = () -> 0.5;

        double resultado = calculadora.calcularReembolso(consulta, pacienteDummy, plano50);

        assertEquals(100.0, resultado);
    }

    @Test
    void deveCalcularReembolsoComPlanoDe80PorCento() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        Consulta consulta = ConsultaHelper.criarConsultaPadrao();
        Paciente pacienteDummy = new Paciente();

        // Stub: retorna sempre 80% de cobertura.
        PlanoSaude plano80 = () -> 0.8;

        double resultado = calculadora.calcularReembolso(consulta, pacienteDummy, plano80);

        assertEquals(160.0, resultado);
    }
}
