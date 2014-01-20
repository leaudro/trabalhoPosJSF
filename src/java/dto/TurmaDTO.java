package dto;

/**
 *
 * @author Leandro
 */
public class TurmaDTO {
    
    private int id;
    private String nomeTurma;
    private String serie;

    public TurmaDTO() {
    
    }

    public TurmaDTO(int id, String nomeTurma, String serie) {
        this.id = id;
        this.nomeTurma = nomeTurma;
        this.serie = serie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
}
