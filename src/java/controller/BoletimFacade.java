package controller;

import dto.BoletimDTO;
import java.util.List;
import model.BoletimDAO;

/**
 *
 * @author Fábio Brito
 */
public class BoletimFacade {

    private final BoletimDAO boletimDao = new BoletimDAO();
    
    private BoletimDTO boletimSelecionado;
    
    private List<BoletimDTO> listaBoletins;

    public BoletimDTO getBoletimSelecionado() {
        return boletimSelecionado;
    }

    public void setBoletimSelecionado(BoletimDTO boletimSelecionado) {
        this.boletimSelecionado = boletimSelecionado;
    }

    public List<BoletimDTO> getListaBoletims() {
        try {
            listaBoletins = boletimDao.getAll(AlunoFacade.getInstance().getAlunoSelecionado());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listaBoletins;
    }
    
    public String preparaInclusao() {
        boletimSelecionado = new BoletimDTO();
        return "NovoBoletim";
    }
    
    public String incluiBoletim() {
        try {
            boletimDao.save(boletimSelecionado);
        } catch (Exception ex) {}
        listaBoletins = null;
        return "Voltar";
    }
    
    public String alteraBoletim() {
        try {
            boletimDao.update(boletimSelecionado);
        } catch (Exception ex) {}
        listaBoletins = null;
        return "voltaParaInicioBoletim";
    }
    
    public String deletaBoletim() {
        try {
            boletimDao.delete(boletimSelecionado);
        } catch (Exception ex) {}
        listaBoletins = null;
        return "refresh";
    }
}