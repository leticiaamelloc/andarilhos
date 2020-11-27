package dao;

import dao.connection.DatabaseConnection;
import model.Categoria;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaDAO extends DAO<Categoria> {

    public CategoriaDAO() {
        super("categoria");
    }

    @Override
    public boolean saveOrUpdate(Categoria entity) {
        String query;
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;

        if (entity.getId() == null) {
            query = "INSERT INTO " + tableName + " (descricao) VALUES (?)";
        } else {
            query = "UPDATE " + tableName + " SET descricao = ? WHERE id = ?";
        }

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, entity.getDescricao());

            if (entity.getId() != null) {
                ps.setLong(2, entity.getId());
                ps.executeUpdate();
            } else {
                ps.execute();
            }
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        } finally {
            DbUtils.closeQuietly(conn);
            DbUtils.closeQuietly(ps);
        }
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        String query = "SELECT * FROM " + tableName + " WHERE id = ?";
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Categoria entity = new Categoria();

        try {
            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                entity.setId(id);
                entity.setDescricao(rs.getString("descricao"));

                return Optional.of(entity);
            } else {
                return Optional.empty();
            }

        } catch (SQLException e) {
            e.printStackTrace();

            return Optional.empty();
        } finally {
            DbUtils.closeQuietly(conn);
            DbUtils.closeQuietly(ps);
            DbUtils.closeQuietly(rs);
        }
    }
    

    public Categoria findByDescricao(String descricao) {
        String query = "SELECT * FROM " + tableName + " WHERE descricao = ?";
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Categoria entity = new Categoria();

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, descricao);
            rs = ps.executeQuery();

            if (rs.next()) {
                entity.setId(rs.getLong("id"));
                entity.setDescricao(rs.getString("descricao"));

               
            } 
           
             return entity;

        } catch (SQLException e) {
            e.printStackTrace();
            return entity;
        } finally {
            DbUtils.closeQuietly(conn);
            DbUtils.closeQuietly(ps);
            DbUtils.closeQuietly(rs);
        }
    }


    @Override
    public List<Categoria> findAll() {
        String query = "SELECT * FROM " + tableName;
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Categoria> list = new ArrayList<>();

        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            Categoria entity;

            while (rs.next()) {
                entity = new Categoria();
                entity.setId(rs.getLong("id"));
                entity.setDescricao(rs.getString("descricao"));

                list.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
            DbUtils.closeQuietly(ps);
            DbUtils.closeQuietly(rs);
        }

        return list;
    }

    @Override
    public boolean delete(Long id) {
        String query = "DELETE FROM categoria WHERE id = ?";
        PreparedStatement ps = null;
        Connection conn = DatabaseConnection.getConn();

        try {
            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            ps.execute();

            return super.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        } finally {
            DbUtils.closeQuietly(conn);
            DbUtils.closeQuietly(ps);
        }
    }

}
