/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import timetable.connection.ConnectionBuilder;

/**
 *
 * @author Willy
 */
public class Timetable {
    private int key;
    private String stdId;
    private String subId;

    public Timetable(String stdId, String subId) {
        this.stdId = stdId;
        this.subId = subId;
    }

    public Timetable() {
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }  
    
    public static String checkTimetable(String stdid,int subid) throws SQLException{
       String msg = "";
       Connection con = ConnectionBuilder.getConnection();
       String sql = "SELECT COUNT(stdId) FROM timetable where stdId = ? and subId = ?";
    try
    {
      PreparedStatement pstm = con.prepareStatement(sql);
      pstm.setString(1, stdid);
      pstm.setInt(2, subid);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
          int a = rs.getInt("COUNT(stdId)");
          if(a==0){
               msg = "success";
          }else{
              msg = "fail";
          }
      }
    }
    catch (SQLException e)
    {
        System.out.println(e);
    }
    con.close();
        System.out.println("msg "+msg);
    return msg;   
    }
    
    public static String addTimetable(String stdid, int subid) throws SQLException
  {   
    String message = "";
    Connection con = ConnectionBuilder.getConnection();
    String sql = "INSERT INTO timetable VALUE(null,?,?)";
    String t = checkTimetable(stdid, subid); 
    System.out.println("chk : "+t);
    if(t=="success"){
        try
        {
         PreparedStatement pstm = con.prepareStatement(sql);
         pstm.setString(1, stdid);
         pstm.setInt(2, subid);
         pstm.executeUpdate();
           message = "add Success";
        }
         catch (SQLException e)
        {
            System.out.println(e);
            message = "add Fail Exception";
        }
    }else{
        message = "Subject is already added";
    }
    
    con.close();
    return message;
    
  }
    
      
    public static String deleteTimetable(String stdid, int subid) throws SQLException
  {
    String message = "";
    Connection con = ConnectionBuilder.getConnection();
    String sql = "DELETE FROM timetable WHERE stdid = ? and subid = ?";
    try
    {
      PreparedStatement pstm = con.prepareStatement(sql);
      pstm.setString(1, stdid);
      pstm.setInt(2, subid);
      pstm.executeUpdate();
      message = " delete Success";
    }
    catch (SQLException e)
    {
      message = "delete Fail";
    }
    con.close();
    return message;
  }
    
}
