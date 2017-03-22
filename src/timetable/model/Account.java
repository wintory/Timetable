package timetable.model;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import timetable.connection.ConnectionBuilder;

public class Account
{
  private String stdid;
  private String name;
  private String surname;
  private String password;
  private int sec;

  
  public String getStdid()
  {
    return this.stdid;
  }
  
  public void setStdid(String stdid)
  {
    this.stdid = stdid;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getSurname()
  {
    return this.surname;
  }
  
  public void setSurname(String surname)
  {
    this.surname = surname;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }
  
  
  public static Account getAccount(String stdid,String password) throws SQLException
  {
    Account a = null;
    Connection con = ConnectionBuilder.getConnection();
    String sql = "SELECT * FROM ACCOUNT WHERE stdId = ? and password = ?";
    try
    {
      PreparedStatement pstm = con.prepareStatement(sql);
      pstm.setString(1, stdid);
      pstm.setString(2, password);
      ResultSet rs = pstm.executeQuery();
      if (rs.next())
      {
        a = new Account();
        a.setStdid(rs.getString("stdId"));
        a.setName(rs.getString("stdName"));
        a.setSurname(rs.getString("stdSurname"));
        a.setPassword(rs.getString("password"));
        a.setSec(rs.getInt("sec"));
      }
    }
    catch (SQLException e)
    {
      System.out.println(e);
    }
    con.close();
    return a;
  }
  
  
  public static Account getAccount(String stdid) throws SQLException
  {
    Account a = null;
    Connection con = ConnectionBuilder.getConnection();
    String sql = "SELECT * FROM ACCOUNT WHERE stdId = ?";
    try
    {
      PreparedStatement pstm = con.prepareStatement(sql);
      pstm.setString(1, stdid);
      ResultSet rs = pstm.executeQuery();
      if (rs.next())
      {
        a = new Account();
        a.setStdid(rs.getString("stdId"));
        a.setName(rs.getString("stdName"));
        a.setSurname(rs.getString("stdSurname"));
        a.setPassword(rs.getString("password"));
        a.setSec(rs.getInt("sec"));
      }
    }
    catch (SQLException e)
    {
      System.out.println(e);
    }
    con.close();
    return a;
  }
}
