package dao;

import dao.connection.DatabaseConnection;
import model.Comentario;
import org.apache.commons.dbutils.DbUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComentarioDAO extends DAO<Comentario> {

    public ComentarioDAO() {
        super("comentario");
    }

    @Override
    public boolean saveOrUpdate(Comentario entity) {
        String query;
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;

        if (entity.getId() == null) {
            query = "INSERT INTO " + tableName + "(id_usuario, id_artigo, comentario) VALUES (?, ?, ?)";
        } else {
            query = "UPDATE " + tableName + " SET id_usuario = ?, id_artigo = ?, comentario = ? WHERE id = ?";
        }

        try {
            ps = conn.prepareStatement(query);
            ps.setLong(1, entity.getUsuario().getId());
            ps.setLong(2, entity.getArtigo().getId());
            ps.setString(3, entity.getComentario());

            if (entity.getId() != null) {
                ps.setLong(4, entity.getId());
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
    public Optional<Comentario> findById(Long id) {
        String query = "SELECT * FROM " + tableName + " WHERE id = ?";
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Comentario entity = new Comentario();

        try {
            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                ArtigoDAO artigoDAO = new ArtigoDAO();

                entity.setId(id);
                entity.setUsuario(usuarioDAO.findById(rs.getLong("id_usuario")).get());
                entity.setArtigo(artigoDAO.findById(rs.getLong("id_artigo")).get());
                entity.setComentario(rs.getString("comentario"));

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

    @Override
    public List<Comentario> findAll() {
        String query = "SELECT * FROM " + tableName;
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Comentario> list = new ArrayList<>();

        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            Comentario entity;
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            ArtigoDAO artigoDAO = new ArtigoDAO();

            while (rs.next()) {
                entity = new Comentario();

                entity.setId(rs.getLong("id"));
                entity.setUsuario(usuarioDAO.findById(rs.getLong("id_usuario")).get());
                entity.setArtigo(artigoDAO.findById(rs.getLong("id_artigo")).get());
                entity.setComentario(rs.getString("comentario"));

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

    public List<Comentario> findByUsuarioId(Long id) {
        String query = "SELECT * FROM " + tableName + " WHERE id_usuario = ?";
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Comentario> list = new ArrayList<>();

        try {
            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            Comentario entity;
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            ArtigoDAO artigoDAO = new ArtigoDAO();

            while (rs.next()) {
                entity = new Comentario();

                entity.setId(rs.getLong("id"));
                entity.setUsuario(usuarioDAO.findById(rs.getLong("id_usuario")).get());
                entity.setArtigo(artigoDAO.findById(rs.getLong("id_artigo")).get());
                entity.setComentario(rs.getString("comentario"));

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

    public List<Comentario> findByArtigoId(Long id) {
        String query = "SELECT * FROM " + tableName + " WHERE id_artigo = ?";
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Comentario> list = new ArrayList<>();

        try {
            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            Comentario entity;
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            ArtigoDAO artigoDAO = new ArtigoDAO();

            while (rs.next()) {
                entity = new Comentario();

                entity.setId(rs.getLong("id"));
                entity.setUsuario(usuarioDAO.findById(rs.getLong("id_usuario")).get());
                entity.setArtigo(artigoDAO.findById(rs.getLong("id_artigo")).get());
                entity.setComentario(rs.getString("comentario"));

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

}
