package interfaces;

import model.Consulta;
import java.util.List;

public interface HistoricoConsultas {
    void salvar(Consulta consulta);
    List<Consulta> listar();
}
