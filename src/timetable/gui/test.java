/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.gui;

import java.sql.Connection;
import java.sql.SQLException;
import timetable.connection.ConnectionBuilder;
import timetable.model.Account;
import timetable.model.Subject;

/**
 *
 * @author Thanapol
 */
public class test {
    public static void main(String[] args) throws SQLException {
        Account ac = Account.getAccount("57130500001", "12345");
        System.out.println(ac.getStdid());


    }
}
