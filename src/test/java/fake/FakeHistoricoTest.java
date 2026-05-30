package fake;

import helper.ConsultaHelper;
import model.Consulta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakeHistoricoTest {

    @Test
    void deveSalvarConsultasEmMemoriaSemBancoDeDados() {
        HistoricoConsultasFake historico = new HistoricoConsultasFake();

        Consulta consulta1 = ConsultaHelper.criarConsultaPadrao();
        Consulta consulta2 = ConsultaHelper.criarConsultaComValor(300.0);

        historico.salvar(consulta1);
        historico.salvar(consulta2);

        assertEquals(2, historico.listar().size());
        assertEquals(200.0, historico.listar().get(0).getValor());
        assertEquals(300.0, historico.listar().get(1).getValor());
    }
}
