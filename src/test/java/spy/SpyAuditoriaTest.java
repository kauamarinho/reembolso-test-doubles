package spy;

import helper.ConsultaHelper;
import model.Consulta;
import org.junit.jupiter.api.Test;
import service.CalculadoraReembolso;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpyAuditoriaTest {

    @Test
    void deveVerificarSeAuditoriaFoiChamada() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        Consulta consulta = ConsultaHelper.criarConsultaPadrao();

        // Spy: registra se o método foi chamado durante o teste.
        AuditoriaSpy auditoriaSpy = new AuditoriaSpy();

        calculadora.registrarConsulta(consulta, auditoriaSpy);

        assertTrue(auditoriaSpy.foiChamado());
    }
}
