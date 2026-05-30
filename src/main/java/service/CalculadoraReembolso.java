package service;

import exception.ConsultaNaoAutorizadaException;
import interfaces.Auditoria;
import interfaces.AutorizadorReembolso;
import interfaces.PlanoSaude;
import model.Consulta;
import model.Paciente;

public class CalculadoraReembolso {

    public double calcularReembolso(Consulta consulta, Paciente paciente, PlanoSaude planoSaude) {
        return consulta.getValor() * planoSaude.getPercentualCobertura();
    }

    public void registrarConsulta(Consulta consulta, Auditoria auditoria) {
        auditoria.registrarConsulta(consulta);
    }

    public double calcularReembolsoComAutorizacao(
            Consulta consulta,
            Paciente paciente,
            PlanoSaude planoSaude,
            AutorizadorReembolso autorizador
    ) {
        if (!autorizador.autorizar(consulta, paciente)) {
            throw new ConsultaNaoAutorizadaException("Consulta não autorizada para reembolso.");
        }

        return calcularReembolso(consulta, paciente, planoSaude);
    }
}
