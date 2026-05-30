package fake;

import interfaces.HistoricoConsultas;
import model.Consulta;

import java.util.ArrayList;
import java.util.List;

public class HistoricoConsultasFake implements HistoricoConsultas {

    private final List<Consulta> consultas = new ArrayList<>();

    @Override
    public void salvar(Consulta consulta) {
        consultas.add(consulta);
    }

    @Override
    public List<Consulta> listar() {
        return consultas;
    }
}
