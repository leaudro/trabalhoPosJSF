package dto;

/*
 * @author Fábio Bito
 */
public class BoletimDTO {

    private AlunoDTO aluno;
    private MateriaDTO materia;
    private Integer nota1;
    private Integer nota2;
    private Integer nota3;
    private Integer nota4;
    
    private String status;

    public BoletimDTO() {

    }

    public BoletimDTO(AlunoDTO aluno, MateriaDTO materia) {
        this.aluno = aluno;
        this.materia = materia;
    }

    public BoletimDTO(AlunoDTO aluno, MateriaDTO materia, Integer nota1, Integer nota2, Integer nota3, Integer nota4) {
        this.aluno = aluno;
        this.materia = materia;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
    }

    public AlunoDTO getAluno() {
        return aluno;
    }

    public void setAluno(AlunoDTO aluno) {
        this.aluno = aluno;
    }

    public MateriaDTO getMateria() {
        return materia;
    }

    public void setMateria(MateriaDTO materia) {
        this.materia = materia;
    }

    public Integer getNota1() {
        return nota1;
    }

    public void setNota1(Integer nota1) {
        this.nota1 = nota1;
    }

    public Integer getNota2() {
        return nota2;
    }

    public void setNota2(Integer nota2) {
        this.nota2 = nota2;
    }

    public Integer getNota3() {
        return nota3;
    }

    public void setNota3(Integer nota3) {
        this.nota3 = nota3;
    }

    public Integer getNota4() {
        return nota4;
    }

    public void setNota4(Integer nota4) {
        this.nota4 = nota4;
    }

    public String getStatus() {
        try {
            return nota1 + nota2 + nota3 + nota4 / 4 >= 7 ? "Aprovado" : "Reprovado";
        } catch (Exception ex){
            return "";
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
