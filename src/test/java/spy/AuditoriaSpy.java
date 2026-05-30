package spy;

import interfaces.Auditoria;
import model.Consulta;

public class AuditoriaSpy implements Auditoria {

    private boolean foiChamado = false;

    @Override
    public void registrarConsulta(Consulta consulta) {
        foiChamado = true;
    }

    public boolean foiChamado() {
        return foiChamado;
    }
}
