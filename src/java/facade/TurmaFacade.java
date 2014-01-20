package facade;

import dto.TurmaDTO;
import java.util.List;
import model.TurmaDAO;

/**
 *
 * @author Leandro
 */
public class TurmaFacade {

    private final TurmaDAO turmaDao = new TurmaDAO();
    
    private TurmaDTO turmaSelecionada;
    
    private List<TurmaDTO> listaTurmas;

    public TurmaDTO getTurmaSelecionada() {
        return turmaSelecionada;
    }

    public void setTurmaSelecionada(TurmaDTO turmaSelecionada) {
        this.turmaSelecionada = turmaSelecionada;
    }

    public List<TurmaDTO> getListaTurmas() {
        if (listaTurmas == null) {
            try {
                listaTurmas = turmaDao.getAll();
            } catch (Exception ex) {
            }
        }
        return listaTurmas;
    }
    
    public String preparaInclusao() {
        turmaSelecionada = new TurmaDTO();
        return "vaiParaInclusao";
    }
    
    public String incluiTurma() {
        try {
            turmaDao.save(turmaSelecionada);
        } catch (Exception ex) {}
        listaTurmas = null;
        return "voltaParaInicioTurma";
    }
    
    public String alteraTurma() {
        try {
            turmaDao.update(turmaSelecionada);
        } catch (Exception ex) {}
        listaTurmas = null;
        return "voltaParaInicioTurma";
    }
    
    public String deletaTurma() {
        try {
            turmaDao.delete(turmaSelecionada);
        } catch (Exception ex) {}
        listaTurmas = null;
        return "refresh";
    }
}