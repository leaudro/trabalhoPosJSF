
package controller;

import dto.AlunoDTO;
import java.util.List;
import model.AlunoDAO;

/**
 *
 * @author Fábio Brito
 */
public class AlunoFacade {

    private final AlunoDAO alunoDao = new AlunoDAO();
    
    private AlunoDTO alunoSelecionado;
    
    private List<AlunoDTO> listaAlunos;

    public AlunoDTO getAlunoSelecionado() {
        return alunoSelecionado;
    }

    public void setAlunoSelecionada(AlunoDTO alunoSelecionado) {
        this.alunoSelecionado = alunoSelecionado;
    }

    public List<AlunoDTO> getListaAlunos() {
        if (listaAlunos == null) {
            try {
                listaAlunos = alunoDao.getAll();
            } catch (Exception ex) {
            }
        }
        return listaAlunos;
    }
    
    public String preparaInclusao() {
        alunoSelecionado = new AlunoDTO();
        return "NovaAluno";
    }
    
    public String incluiAluno() {
        try {
            alunoDao.save(alunoSelecionado);
        } catch (Exception ex) {}
        listaAlunos = null;
        return "voltaParaInicioAluno";
    }
    
    public String alteraAluno() {
        try {
            alunoDao.update(alunoSelecionado);
        } catch (Exception ex) {}
        listaAlunos = null;
        return "voltaParaInicioAluno";
    }
    
    public String deletaAluno() {
        try {
            alunoDao.delete(alunoSelecionado);
        } catch (Exception ex) {}
        listaAlunos = null;
        return "refresh";
    }
}