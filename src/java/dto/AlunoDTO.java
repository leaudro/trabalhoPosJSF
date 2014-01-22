
package dto;

import java.util.Date;

/*
 * @author Fábio Bito
 */

public class AlunoDTO {
    
    private int id;
    private int id_turma;
    private String nome_aluno;
    private Date data_nasc;
    
    
   public AlunoDTO(){
       
   } 
   
   public AlunoDTO(int id, String nome_aluno, Date data_nasc, int id_turma){
       
       this.id= id;
       this.nome_aluno= nome_aluno;
       this.data_nasc= data_nasc;
       this.id_turma= id_turma;
       
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_turma() {
        return id_turma;
    }

    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }
   
   
}
