package timetable.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionBuilder {

    public static Connection getConnection() throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://ap-cdbr-azure-southeast-b.cloudapp.net:3306/preregis?zeroDateTimeBehavior=convertToNull", "b271179b96ae42", "08e9afdb");
        System.out.println("db connected");
        return con;

    }
    
  /*  public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://10.4.56.10:3306/mysql?zeroDateTimeBehavior=convertToNull", "new", "new");
        System.out.println("Connected");
    }*/
}
