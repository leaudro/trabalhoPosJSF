
package controller;

import dto.AlunoDTO;
import java.util.List;
import model.AlunoDAO;
import model.BoletimDAO;

/**
 *
 * @author Fábio Brito
 */
public class AlunoFacade {
    private static AlunoFacade instance;

    static AlunoFacade getInstance() {
        return instance;
    }

    public AlunoFacade() {
        AlunoFacade.instance = this;
    }
    
    private final AlunoDAO alunoDao = new AlunoDAO();
    
    private AlunoDTO alunoSelecionado;
    
    private List<AlunoDTO> listaAlunos;

    public AlunoDTO getAlunoSelecionado() {
        return alunoSelecionado;
    }

    public void setAlunoSelecionado(AlunoDTO alunoSelecionado) {
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
        return "NovoAluno";
    }
    
    public String incluiAluno() {
        try {
            alunoSelecionado.setId_turma(TurmaFacade.getInstance().getTurmaSelecionada().getId());
            alunoDao.save(alunoSelecionado);
            BoletimDAO dao = new BoletimDAO();
            dao.createBoletim(alunoSelecionado);
        } catch (Exception ex) {}
        listaAlunos = null;
        return "Voltar";
    }
    
    public String alteraAluno() {
        try {
            alunoDao.update(alunoSelecionado);
        } catch (Exception ex) {}
        listaAlunos = null;
        return "Voltar";
    }

    public String criaOuAlteraAluno() {
        if (alunoSelecionado == null || alunoSelecionado.getId() == 0) {
            return incluiAluno();
        } else {
            return alteraAluno();
        }
    }
    
    public String deletaAluno() {
        try {
            alunoDao.delete(alunoSelecionado);
        } catch (Exception ex) {}
        listaAlunos = null;
        return "refresh";
    }
    
    public String nomeTelaAluno() {
        if (alunoSelecionado == null || alunoSelecionado.getId() == 0) {
            return "Novo Aluno";
        }
        return "Editar Aluno";
    }
}