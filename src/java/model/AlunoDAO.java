
package model;

import dto.AlunoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Fábio Brito
 */
public class AlunoDAO extends DaoUtil {
    
    public boolean save(AlunoDTO dto) throws Exception {
        
        PreparedStatement ps;
        ps = getPreparedStatement("INSERT INTO SA.ALUNO VALUES(?,?,?)");
        
        ps.setString(1, dto.getNome_aluno());
        ps.setDate(2, new java.sql.Date(dto.getData_nasc().getTime()));
        ps.setInt(3, dto.getId_turma());
        boolean ret = ps.execute();
        ps.close();
        return ret;
    }
    
    public boolean update(AlunoDTO dto) throws Exception {
        PreparedStatement ps = getPreparedStatement("UPDATE SA.ALUNO SET NOME_ALUNO = ?, DATA_NASC = ?, ID_TURMA = ? WHERE ID=?");
        ps.setString(1, dto.getNome_aluno());
        ps.setDate(2, new java.sql.Date(dto.getData_nasc().getTime()));
        ps.setInt(3, dto.getId_turma());
        ps.setInt(4, dto.getId());
        int count = ps.executeUpdate();
        ps.close();
        return count > 0;
    }
    
    public boolean delete(AlunoDTO dto) throws Exception {
        PreparedStatement ps = getPreparedStatement("DELETE FROM SA.ALUNO WHERE ID=?");
        ps.setInt(1, dto.getId());
        int count = ps.executeUpdate();
        ps.close();
        return count > 0;
    }
    
     public AlunoDTO getById(int id, String nome_aluno, Date data_nasc, int id_turma) throws Exception {
        
         AlunoDTO ret = null;
        PreparedStatement ps = getPreparedStatement("SELECT NOME_ALUNO, DATA_NASC, ID_TURMA FROM SA.ALUNO WHERE ID=?");
        ps.setInt(1, id);
        ResultSet query = ps.executeQuery();
        if (query.next()) {
            ret = new AlunoDTO(id, query.getString(1), query.getDate(2), query.getInt(3));
        }
        query.close();
        ps.close();
        return ret;
        }
     
        public List<AlunoDTO> getAll() throws Exception {
        
        List<AlunoDTO> ret = new ArrayList<AlunoDTO>();
        PreparedStatement ps = getPreparedStatement("SELECT ID, NOME_ALUNO, DATA_NASC, ID_TURMA FROM SA.ALUNO");
        ResultSet query = ps.executeQuery();
        while (query.next()) {
            ret.add(new AlunoDTO(query.getInt(1), query.getString(2), query.getDate(3), query.getInt(4)));
        }
        query.close();
        ps.close();
        return ret;
        
         }
     
}
