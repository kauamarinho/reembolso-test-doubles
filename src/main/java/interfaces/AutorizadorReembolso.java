package interfaces;

import model.Consulta;
import model.Paciente;

public interface AutorizadorReembolso {
    boolean autorizar(Consulta consulta, Paciente paciente);
}
