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
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import timetable.connection.ConnectionBuilder;

/**
 *
 * @author Thanapol
 */
public class Subject {
    private int subId;
    private String subjectId;
    private String subjectName;
    private int sec;
    private String stdDay;
    private String strTime;
    private String enTime;

    public Subject() {
    }
    
    public Subject(String id,int sec) throws SQLException {
        searchSubject(id,sec);
    }
    

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public String getStdDay() {
        return stdDay;
    }

    public void setStdDay(String stdDay) {
        this.stdDay = stdDay;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public String getEnTime() {
        return enTime;
    }

    public void setEnTime(String enTime) {
        this.enTime = enTime;
    }
    
    public static List<Subject> searchSubject(String subid,int sec) throws SQLException{
        List<Subject> allsub = null;
        Connection con = ConnectionBuilder.getConnection();
        Subject s = null;
        String sql = "SELECT * FROM Subject WHERE subjectId = ? and sec = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,subid.toUpperCase());
            pstm.setInt(2,sec);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                s = new Subject();
                s.setSubId(rs.getInt("subId"));
                s.setSubjectId(rs.getString("subjectId"));
                s.setSubjectName(rs.getString("subjectName"));
                s.setSec(rs.getInt("sec"));
                s.setStdDay(rs.getString("stdDay"));
                s.setStrTime(rs.getString("strTime"));
                s.setEnTime(rs.getString("enTime"));  
                if(allsub==null){
                    allsub = new ArrayList();   
                }
                allsub.add(s);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return allsub;
    }
    
    

    @Override
    public String toString() {
        return "Subject{" + "subId=" + this.subId + ", subjectId=" + this.subjectId + ", subjectName=" + this.subjectName + ", sec=" + this.sec + ", stdDay=" + stdDay + ", strTime=" + strTime + ", enTime=" + enTime + '}';
    }
    
    
}
