package dao;

import dao.connection.DatabaseConnection;
import model.Usuario;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UsuarioDAO extends LoginDAO<Usuario> {

    public UsuarioDAO() {
        super("usuario");
    }

    @Override
    public Optional<Usuario> login(String login, String password) {
        return this.login(login, password, 1);
    }

    @Override
    public boolean saveOrUpdate(Usuario entity) {
        String query;
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;

        if (entity.getId() == null) {
            query = "INSERT INTO" + tableName + "(email, senha, nome, cpf, papel) VALUES (?,?,?,?,?)";
        } else {
            query = "UPDATE " + tableName + " SET email = ?, senha = ?, nome = ?, cpf = ?, papel = ? WHERE id = ?";
        }

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, entity.getEmail());
            ps.setString(2, entity.getSenha());
            
            /*if (!entity.getSenha().contains("$2a$")) {
                ps.setString(2, entity.hashPassword());
            } else {
                ps.setString(2, entity.getSenha());
            }*/
            
            ps.setString(3, entity.getNome());
            ps.setString(4, entity.getCpf());
            ps.setInt(5, entity.getPapel());


            if (entity.getId() != null) {
                ps.setLong(6, entity.getId());
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
    public Optional<Usuario> findById(Long id) {
        String query = "SELECT * FROM " + tableName + " WHERE id = ?";
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario entity = new Usuario();

        try {
            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                entity.setId(id);
                entity.setNome(rs.getString("nome"));
                entity.setSenha(rs.getString("senha"));
                entity.setCpf(rs.getString("cpf"));
                entity.setEmail(rs.getString("email"));
           
                
                for (Aprovacao a : Aprovacao.values()) {
                    if (a.valor.equals(rs.getString("aprovado"))) {
                        entity.setAprovado(a);
                    }
                }

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
    public List<Usuario> findAll() {
        String query = "SELECT * FROM " + tableName;
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Usuario> list = new ArrayList<>();

        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            Usuario entity;

            while (rs.next()) {
                entity = new Usuario();
                entity.setId(rs.getLong("id"));
                entity.setNome(rs.getString("nome"));
                entity.setSenha(rs.getString("senha"));
                entity.setCpf(rs.getString("cpf"));
                entity.setEmail(rs.getString("email"));
             
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
        String query = "DELETE FROM" + tableName +  "WHERE id = ?";
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
