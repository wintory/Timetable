package timetable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionBuilder{
    
  public static Connection getConnection() throws SQLException
  {
 
      Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Timetable", "root", "root");
      return con;
   
}
}
