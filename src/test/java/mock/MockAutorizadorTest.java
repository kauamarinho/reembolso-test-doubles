package mock;

import exception.ConsultaNaoAutorizadaException;
import helper.ConsultaHelper;
import interfaces.AutorizadorReembolso;
import interfaces.PlanoSaude;
import model.Consulta;
import model.Paciente;
import org.junit.jupiter.api.Test;
import service.CalculadoraReembolso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockAutorizadorTest {

    @Test
    void deveCalcularReembolsoQuandoConsultaForAutorizada() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        Consulta consulta = ConsultaHelper.criarConsultaPadrao();
        Paciente paciente = new Paciente("João", "12345678900");
        PlanoSaude plano50 = () -> 0.5;

        // Mock: simula o comportamento do autorizador.
        AutorizadorReembolso autorizadorMock = mock(AutorizadorReembolso.class);
        when(autorizadorMock.autorizar(consulta, paciente)).thenReturn(true);

        double resultado = calculadora.calcularReembolsoComAutorizacao(
                consulta,
                paciente,
                plano50,
                autorizadorMock
        );

        assertEquals(100.0, resultado);
    }

    @Test
    void deveLancarExcecaoQuandoConsultaNaoForAutorizada() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        Consulta consulta = ConsultaHelper.criarConsultaPadrao();
        Paciente paciente = new Paciente("Maria", "98765432100");
        PlanoSaude plano50 = () -> 0.5;

        AutorizadorReembolso autorizadorMock = mock(AutorizadorReembolso.class);
        when(autorizadorMock.autorizar(consulta, paciente)).thenReturn(false);

        assertThrows(ConsultaNaoAutorizadaException.class, () -> {
            calculadora.calcularReembolsoComAutorizacao(
                    consulta,
                    paciente,
                    plano50,
                    autorizadorMock
            );
        });
    }
}
