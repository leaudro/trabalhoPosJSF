package model;

import dto.TurmaDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leandro
 */
public class TurmaDAO extends DaoUtil {

    public boolean save(TurmaDTO dto) throws Exception {
        PreparedStatement ps;
        ps = getPreparedStatement("INSERT INTO SA.TURMA (NOME_TURMA, SERIE) VALUES(?,?)");
        ps.setString(1, dto.getNomeTurma());
        ps.setString(2, dto.getSerie());
        boolean ret = ps.execute();
        ps.close();
        return ret;
    }

    public boolean update(TurmaDTO dto) throws Exception {
        PreparedStatement ps = getPreparedStatement("UPDATE SA.TURMA SET NOME_TURMA = ?, SERIE = ? WHERE ID=?");
        ps.setString(1, dto.getNomeTurma());
        ps.setString(2, dto.getSerie());
        ps.setInt(3, dto.getId());
        int count = ps.executeUpdate();
        ps.close();
        return count > 0;
    }

    public boolean delete(TurmaDTO dto) throws Exception {
        PreparedStatement ps = getPreparedStatement("DELETE FROM SA.TURMA WHERE ID=?");
        ps.setInt(1, dto.getId());
        int count = ps.executeUpdate();
        ps.close();
        return count > 0;
    }

    public TurmaDTO getById(int id) throws Exception {
        TurmaDTO ret = null;
        PreparedStatement ps = getPreparedStatement("SELECT NOME_TURMA, SERIE FROM SA.TURMA WHERE ID=?");
        ps.setInt(1, id);
        ResultSet query = ps.executeQuery();
        if (query.next()) {
            ret = new TurmaDTO(id, query.getString(1), query.getString(2));
        }
        query.close();
        ps.close();
        return ret;
    }

    public List<TurmaDTO> getAll() throws Exception {
        List<TurmaDTO> ret = new ArrayList<TurmaDTO>();
        PreparedStatement ps = getPreparedStatement("SELECT ID, NOME_TURMA, SERIE FROM SA.TURMA");
        ResultSet query = ps.executeQuery();
        while (query.next()) {
            ret.add(new TurmaDTO(query.getInt(1), query.getString(2), query.getString(3)));
        }
        query.close();
        ps.close();
        return ret;
    }
}