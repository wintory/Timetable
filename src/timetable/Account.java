package timetable;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
  
 
  
 /* public static String addAccount(Account a)
  {
    String message = "";
    Connection con = ConnectionBuilder.getConnection();
    String sql = "INSERT INTO Account VALUE(?,?,?,?,?,?)";
    try
    {
      PreparedStatement pstm = con.prepareStatement(sql);
      pstm.setLong(1, a.getStdid());
      pstm.setString(2, a.getName());
      pstm.setString(3, a.getSurname());
      pstm.setString(4, a.getPassword());
      pstm.setInt(5, a.getSec());
      pstm.setInt(6, a.getSec());
      pstm.executeUpdate();
      message = "Success";
    }
    catch (SQLException e)
    {
      message = "Fail";
    }
    return message;
  }*/
  
  public static Account getAccount(String stdid,String password) throws SQLException
  {
    Account a = null;
    Connection con = ConnectionBuilder.getConnection();
    String sql = "SELECT * FROM Account WHERE stdId = ? and password = ?";
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
          System.out.println(a.getName());
          System.out.println(a.getPassword());
      }
    }
    catch (SQLException e)
    {
      System.out.println(e);
    }
    return a;
  }
}
