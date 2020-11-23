package dao;

import dao.connection.DatabaseConnection;
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
    
    public abstract Optional<Usuario> login(String cpf, String password);


    public Optional<Usuario> login(String cpf, String password, Integer Papel) {
        String query = "SELECT id, nome,email, senha, papel FROM " + tableName + " WHERE cpf = ?";
        Connection conn = DatabaseConnection.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, cpf);
            rs = ps.executeQuery();

            //if (rs.next() && BCrypt.checkpw(password, rs.getString("senha"))) {
            if (rs.next()) {
                Usuario user = new Usuario();
                user.setId(rs.getLong("id"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setPapel(rs.getInt("papel"));
             

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
