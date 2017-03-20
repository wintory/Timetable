package timetable.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;
import timetable.model.Account;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

	private JFrame frame;
	private JPasswordField passwordField;
	private JLabel showStatus;
	private JTextField textField;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton3;
        private javax.swing.JLabel jLabel1;

	public static void main(String[] args) throws Exception {
		Login login = new Login();
	}

	public Login() {
		this.frame = new JFrame();
		this.frame.setVisible(true);

		this.frame.setTitle("PreRegis Timetable");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();

		JLabel labelUser = new JLabel("Input StudentId : ");
		panel1.add(labelUser);

		JLabel labelPass = new JLabel("Input Password : ");
		panel2.add(labelPass);

		this.textField = new JTextField(10);
                textField.setBackground(new java.awt.Color(204, 255, 204));
		panel1.add(this.textField);

		this.passwordField = new JPasswordField(10);  
                passwordField.setBackground(new java.awt.Color(204, 255, 204));
		panel2.add(this.passwordField);

		JButton btn = new JButton("Login");
		 btn.addActionListener(this);
		panel3.add(btn);

		this.showStatus = new JLabel("Status : ");
                this.showStatus.setVisible(false);
		panel4.add(this.showStatus);
             
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
                
		this.frame.add(panel);
		this.frame.setSize(500, 250);
	}
	
        
        

	@Override
	public void actionPerformed(ActionEvent e) {
		char[] pass = this.passwordField.getPassword();
		String userStr = this.textField.getText();
                String password = String.valueOf(pass);
		Account a = null;
            try {
                a = Account.getAccount(userStr, password);
            } catch (SQLException ex) {
                System.out.println("SQLException");
            }
		if(a!=null){        
			new Menu(a.getStdid(),a.getName(),a.getSurname(),a.getSec()).setVisible(true);
		}
		else{
                        this.showStatus.setVisible(true);
			this.showStatus.setText("Status :    id/password   incorrect");
		}
	}
}