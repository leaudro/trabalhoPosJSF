package dto;

/*
 * @author Fábio Bito
 */
public class BoletimDTO {

    private AlunoDTO aluno;
    private MateriaDTO materia;
    private int nota1;
    private int nota2;
    private int nota3;
    private int nota4;

    public BoletimDTO() {

    }

    public BoletimDTO(AlunoDTO aluno, MateriaDTO materia) {
        this.aluno = aluno;
        this.materia = materia;
    }

    public BoletimDTO(AlunoDTO aluno, MateriaDTO materia, int nota1, int nota2, int nota3, int nota4) {
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

    public int getNota1() {
        return nota1;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }

    public int getNota3() {
        return nota3;
    }

    public void setNota3(int nota3) {
        this.nota3 = nota3;
    }

    public int getNota4() {
        return nota4;
    }

    public void setNota4(int nota4) {
        this.nota4 = nota4;
    }

    
    
}
