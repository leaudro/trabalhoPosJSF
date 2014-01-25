package dto;

/**
 *
 * @author Leandro
 */
public class MateriaDTO {

    
    private int id;
    private String nomeMateria;

    public MateriaDTO() {
    }

    public MateriaDTO(int id, String nomeMateria) {
        this.id = id;
        this.nomeMateria = nomeMateria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }
}
