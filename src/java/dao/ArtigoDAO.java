package dao;

import dao.connection.DatabaseConnection;
import model.Artigo;
import org.apache.commons.dbutils.DbUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArtigoDAO extends DAO<Artigo> {

    public ArtigoDAO() {
        super("artigo");
    }

    @Override
    public boolean saveOrUpdate(Artigo entity) {
        String query;
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;

        if (entity.getId() == null) {
            query = "INSERT INTO " + tableName + " (id_usuario, id_categoria, titulo, conteudo, liberar, aprovado) VALUES (?, ?, ?, ?, ?, ?)";
        } else {
            query = "UPDATE " + tableName + " SET id_usuario = ?, id_categoria = ?, titulo = ?, conteudo = ?, liberar = ?, aprovado = ? WHERE id = ?";
        }

        try {
            ps = conn.prepareStatement(query);
            ps.setLong(1, entity.getUsuario().getId());
            ps.setLong(2, entity.getCategoria().getId());
            ps.setString(3, entity.getTitulo());
            ps.setString(4, entity.getConteudo());
            ps.setString(5, entity.getLiberar());
            ps.setString(6, entity.getAprovado());

            if (entity.getId() != null) {
                ps.setLong(7, entity.getId());
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
    public Optional<Artigo> findById(Long id) {
        String query = "SELECT * FROM " + tableName + " WHERE id = ?";
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Artigo entity = new Artigo();

        try {
            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                CategoriaDAO categoriaDAO = new CategoriaDAO();

                entity.setId(rs.getLong("id"));
                entity.setUsuario(usuarioDAO.findById(rs.getLong("id_usuario")).get());
                entity.setCategoria(categoriaDAO.findById(rs.getLong("id_categoria")).get());
                entity.setTitulo(rs.getString("titulo"));
                entity.setConteudo(rs.getString("conteudo"));
                entity.setLiberar(rs.getString("liberar"));
                entity.setAprovado(rs.getString("aprovado"));

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
    public List<Artigo> findAll() {
        String query = "SELECT * FROM " + tableName;
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Artigo> list = new ArrayList<>();

        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            Artigo entity;
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            CategoriaDAO categoriaDAO = new CategoriaDAO();

            while (rs.next()) {
                entity = new Artigo();

                entity.setId(rs.getLong("id"));
                entity.setUsuario(usuarioDAO.findById(rs.getLong("id_usuario")).get());
                entity.setCategoria(categoriaDAO.findById(rs.getLong("id_categoria")).get());
                entity.setTitulo(rs.getString("titulo"));
                entity.setConteudo(rs.getString("conteudo"));
                entity.setLiberar(rs.getString("liberar"));
                entity.setAprovado(rs.getString("aprovado"));

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

    public List<Artigo> findByUsuarioId(Long id) {
        String query = "SELECT * FROM " + tableName + " WHERE id_usuario = ?";
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Artigo> list = new ArrayList<>();

        try {
            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            Artigo entity;
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            CategoriaDAO categoriaDAO = new CategoriaDAO();

            while (rs.next()) {
                entity = new Artigo();

                entity.setId(rs.getLong("id"));
                entity.setUsuario(usuarioDAO.findById(rs.getLong("id_usuario")).get());
                entity.setCategoria(categoriaDAO.findById(rs.getLong("id_categoria")).get());
                entity.setTitulo(rs.getString("titulo"));
                entity.setConteudo(rs.getString("conteudo"));
                entity.setLiberar(rs.getString("liberar"));
                entity.setAprovado(rs.getString("aprovado"));

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

    public List<Artigo> findByLiberado() {
        String query = "SELECT * FROM " + tableName + " WHERE liberar = ?";
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Artigo> list = new ArrayList<>();

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, "S");
            rs = ps.executeQuery();
            Artigo entity;
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            CategoriaDAO categoriaDAO = new CategoriaDAO();

            while (rs.next()) {
                entity = new Artigo();

                entity.setId(rs.getLong("id"));
                entity.setUsuario(usuarioDAO.findById(rs.getLong("id_usuario")).get());
                entity.setCategoria(categoriaDAO.findById(rs.getLong("id_categoria")).get());
                entity.setTitulo(rs.getString("titulo"));
                entity.setConteudo(rs.getString("conteudo"));
                entity.setLiberar(rs.getString("liberar"));
                entity.setAprovado(rs.getString("aprovado"));

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

    public List<Artigo> findByAprovado() {
        String query = "SELECT * FROM " + tableName + " WHERE aprovado = ?";
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Artigo> list = new ArrayList<>();

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, "S");
            rs = ps.executeQuery();
            Artigo entity;
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            CategoriaDAO categoriaDAO = new CategoriaDAO();

            while (rs.next()) {
                entity = new Artigo();

                entity.setId(rs.getLong("id"));
                entity.setUsuario(usuarioDAO.findById(rs.getLong("id_usuario")).get());
                entity.setCategoria(categoriaDAO.findById(rs.getLong("id_categoria")).get());
                entity.setTitulo(rs.getString("titulo"));
                entity.setConteudo(rs.getString("conteudo"));
                entity.setLiberar(rs.getString("liberar"));
                entity.setAprovado(rs.getString("aprovado"));

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
        String query = "DELETE FROM artigo WHERE id = ?";
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
