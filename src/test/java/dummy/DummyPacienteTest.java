package dummy;

import helper.ConsultaHelper;
import interfaces.PlanoSaude;
import model.Consulta;
import model.Paciente;
import org.junit.jupiter.api.Test;
import service.CalculadoraReembolso;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyPacienteTest {

    @Test
    void deveUsarPacienteDummyApenasParaPreencherParametro() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        Consulta consulta = ConsultaHelper.criarConsultaPadrao();

        // Dummy: objeto criado apenas porque o método exige um Paciente.
        // Neste teste, os dados do paciente não são usados na lógica.
        Paciente pacienteDummy = new Paciente();

        PlanoSaude plano50 = () -> 0.5;

        double resultado = calculadora.calcularReembolso(consulta, pacienteDummy, plano50);

        assertEquals(100.0, resultado);
    }
}
