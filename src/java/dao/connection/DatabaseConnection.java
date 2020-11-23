package dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConn() {
        Connection conn = null;

  try {
       String url = "jdbc:mysql://localhost:3306/blog?useTimezone=true&serverTimezone=UTC&user=root&password=";
       Class.forName ("com.mysql.jdbc.Driver").newInstance();
       conn = DriverManager.getConnection (url);
       System.out.println ("Database connection established");
       return conn;
    } catch (SQLException e) {
       System.out.println("SQLException" + e.toString());
    } catch (ClassNotFoundException e) {
       e.printStackTrace();
    } catch (InstantiationException e) {
       e.printStackTrace();
    } catch (IllegalAccessException e) {
       e.printStackTrace();
    }
  return conn;
        
    }

}
