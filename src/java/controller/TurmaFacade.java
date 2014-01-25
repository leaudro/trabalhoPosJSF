package controller;

import dto.TurmaDTO;
import java.util.List;
import model.TurmaDAO;

/**
 *
 * @author Leandro
 */
public class TurmaFacade {

    private static TurmaFacade instance;
    
    static TurmaFacade getInstance() {
        return instance;
    }
    
    private final TurmaDAO turmaDao = new TurmaDAO();
    
    private TurmaDTO turmaSelecionada;
    
    private List<TurmaDTO> listaTurmas;

    public TurmaFacade() {
        TurmaFacade.instance = this;
    }

    
    
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
        return "NovaTurma";
    }
    
    public String detalhaTurma() {
        try {
            //TODO puxar alunos pela turma
        } catch (Exception ex) {}
        listaTurmas = null;
        return "gotoDetail";
    }
    
    public String criaOuAlteraTurma() {
        if (turmaSelecionada == null || turmaSelecionada.getId() == 0) {
            return incluiTurma();
        } else {
            return alteraTurma();
        }
    }
    
    public String incluiTurma() {
        try {
            turmaDao.save(turmaSelecionada);
        } catch (Exception ex) {
            System.out.print(ex);
            ex.printStackTrace();
        }
        listaTurmas = null;
        return "Voltar";
    }
    
    public String alteraTurma() {
        try {
            turmaDao.update(turmaSelecionada);
        } catch (Exception ex) {}
        listaTurmas = null;
        return "Voltar";
    }
    
    public String deletaTurma() {
        try {
            turmaDao.delete(turmaSelecionada);
        } catch (Exception ex) {}
        listaTurmas = null;
        return "refresh";
    }
    
    public String nomeTelaNovaTurma() {
        if (turmaSelecionada == null || turmaSelecionada.getId() == 0) {
            return "Nova Turma";
        }
        return "Editar Turma";
    }
}