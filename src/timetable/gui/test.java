/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import timetable.model.Subject;

/**
 *
 * @author Thanapol
 */
public class test {
    public static void main(String[] args) throws SQLException {
        List<Subject> list = Subject.searchSubject("INT101");
        if(list!=null){
            Subject s = new Subject();
            System.out.println(s);
        }
    }
}
