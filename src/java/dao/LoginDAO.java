package dao;

import dao.connection.DatabaseConnection;
import enums.TipoUsuario;
import model.Usuario;
import org.apache.commons.dbutils.DbUtils;
//import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public abstract class LoginDAO<T extends Usuario> extends DAO<T> {

    protected LoginDAO(String tableName) {
        super(tableName);
    }

    public Optional<Usuario> login(String cpf, String password) {
        String query = "SELECT * FROM " + tableName + " WHERE cpf = ? AND senha = ?";
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        TipoUsuario tipo = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, cpf);
            ps.setString(2, password);
            rs = ps.executeQuery();

            //if (rs.next() && BCrypt.checkpw(password, rs.getString("senha"))) {
            if (rs.next()) {
                Usuario user = new Usuario();
                user.setId(rs.getLong("id"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setPapel(rs.getInt("papel"));
                user.setCadastroAprovado(rs.getString("cadastro_aprovado"));

                if (user.getPapel() == 0) {
                    tipo = TipoUsuario.ADMIN;
                } else if (user.getPapel() == 1) {
                    tipo = TipoUsuario.AUTOR;
                } else if (user.getPapel() == 2) {
                    tipo = TipoUsuario.COMENTARISTA;
                }

                user.setTipo(tipo);

                return Optional.of(user);

            }

            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();

            return Optional.empty();
        } finally {
            DbUtils.closeQuietly(conn);
            DbUtils.closeQuietly(ps);
            DbUtils.closeQuietly(rs);
        }
    }

}
