package model;

import dto.AlunoDTO;
import dto.BoletimDTO;
import dto.MateriaDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoletimDAO extends DaoUtil {
    
    public boolean save(BoletimDTO dto) throws Exception {
        
        PreparedStatement ps;
        ps = getPreparedStatement("INSERT INTO SA.BOLETIM (ID_ALUNO, ID_MATERIA, NOTA_UNI_1, NOTA_UNI_2, NOTA_UNI_3, NOTA_UNI_4) VALUES(?,?,?,?,?,?)");
        
        ps.setInt(1, dto.getAluno().getId());
        ps.setInt(2, dto.getMateria().getId());
        ps.setInt(3, dto.getNota1());
        ps.setInt(4, dto.getNota2());
        ps.setInt(5, dto.getNota3());
        ps.setInt(6, dto.getNota4());
        boolean ret = ps.execute();
        ps.close();
        return ret;
    }
    
    public boolean update(BoletimDTO dto) throws Exception {
        PreparedStatement ps = getPreparedStatement("UPDATE SA.BOLETIM SET NOTA_UNI_1 = ?, NOTA_UNI_2 = ?, NOTA_UNI_3 = ?, NOTA_UNI_4 = ? WHERE ID_ALUNO=? AND ID_MATERIA=?");
        ps.setInt(1, dto.getNota1());
        ps.setInt(2, dto.getNota2());
        ps.setInt(3, dto.getNota3());
        ps.setInt(4, dto.getNota4());
        ps.setInt(5, dto.getAluno().getId());
        ps.setInt(6, dto.getMateria().getId());
        int count = ps.executeUpdate();
        ps.close();
        return count > 0;
    }
    
    public boolean delete(BoletimDTO dto) throws Exception {
        PreparedStatement ps = getPreparedStatement("DELETE FROM SA.BOLETIM WHERE ID_ALUNO=?");
        ps.setInt(1, dto.getAluno().getId());
        int count = ps.executeUpdate();
        ps.close();
        return count > 0;
    }
    
    public List<BoletimDTO> getAll(AlunoDTO aluno) throws Exception {
        List<BoletimDTO> ret = new ArrayList<BoletimDTO>();
        PreparedStatement ps = getPreparedStatement("SELECT ID_MATERIA, NOME_MATERIA, NOTA_UNI_1, NOTA_UNI_2, NOTA_UNI_3, NOTA_UNI_4 FROM SA.BOLETIM INNER JOIN SA.MATERIA ON ID = ID_MATERIA WHERE ID_ALUNO = ?");
        ps.setInt(1, aluno.getId());
        ResultSet query = ps.executeQuery();
        while (query.next()) {
            ret.add(new BoletimDTO(aluno, new MateriaDTO(query.getInt(1), query.getString(2)), query.getInt(3), query.getInt(4), query.getInt(5), query.getInt(6)));
        }
        query.close();
        ps.close();
        return ret;
    }

    public void createBoletim(AlunoDTO aluno) {
        try {
            PreparedStatement ps = getPreparedStatement("SELECT ID FROM SA.MATERIA");
            ResultSet query = ps.executeQuery();
            while (query.next()) {
                save(new BoletimDTO(aluno, new MateriaDTO(query.getInt(1),"")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}