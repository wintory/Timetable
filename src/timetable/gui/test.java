/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.gui;

import java.sql.Connection;
import java.sql.SQLException;
<<<<<<< HEAD
import timetable.connection.ConnectionBuilder;
import timetable.model.Account;
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> origin/master
import timetable.model.Subject;

/**
 *
 * @author Thanapol
 */
public class test {
    public static void main(String[] args) throws SQLException {
<<<<<<< HEAD
        Account ac = Account.getAccount("57130500001", "12345");
        System.out.println(ac.getStdid());


=======
        List<Subject> list = Subject.searchSubject("INT101");
        if(list!=null){
            Subject s = new Subject();
            System.out.println(s);
        }
>>>>>>> origin/master
    }
}
