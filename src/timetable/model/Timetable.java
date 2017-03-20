/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    
    
    public static String addTimetable(String stdid, int subid) throws SQLException
  {    
    String message = "";
    Connection con = ConnectionBuilder.getConnection();
    String sql = "INSERT INTO timetable VALUE(?,?)";
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
      message = "add Fail";
    }
    return message;
    
  }
    
      
    public static String deleteTimetable(String stdid, String subid) throws SQLException
  {
    String message = "";
    Connection con = ConnectionBuilder.getConnection();
    String sql = "DELETE FROM timetable WHERE stdid = ? and subid = ?";
    try
    {
      PreparedStatement pstm = con.prepareStatement(sql);
      pstm.setString(1, stdid);
      pstm.setString(2, subid);
      pstm.executeUpdate();
      message = " delete Success";
    }
    catch (SQLException e)
    {
      message = "delete Fail";
    }
    return message;
  }
}
