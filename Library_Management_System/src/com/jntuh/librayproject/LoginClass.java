package com.jntuh.librayproject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginClass {

	public JFrame loginFrame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginClass window = new LoginClass();
					window.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginClass() {
		loginFrame = new JFrame();
		loginFrame.getContentPane().setBackground(Color.PINK);
		loginFrame.setBounds(100, 100, 632, 430);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(286, 77, 148, 27);
		loginFrame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(206, 91, 70, 13);
		loginFrame.getContentPane().add(lblNewLabel);



		passwordField = new JPasswordField();
		passwordField.setBounds(286, 137, 148, 27);
		loginFrame.getContentPane().add(passwordField);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(206, 143, 70, 13);
		loginFrame.getContentPane().add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(255, 250, 205));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty() || passwordField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Required username,password");
				}
				else {
					ConnectDb conn=new ConnectDb();
					try {
						String query="select * from logintable where usrname=? and password=?";
						PreparedStatement ps=conn.con.prepareStatement(query);
						ps.setString(1, textField.getText());
						ps.setString(2, passwordField.getText());
						ResultSet rs=ps.executeQuery();
						if(rs.next()) {
							textField.setText("");
							passwordField.setText("");
							loginFrame.setVisible(false);
							new LoadingClass().frameLoading.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null,"Invalid Credentials");
							textField.setText("");
							passwordField.setText("");
						}
					} 
					catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnNewButton.setBounds(157, 205, 129, 33);
		loginFrame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("SignUp");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginFrame.setVisible(false);
				new SignupClass().frameSignUp.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 250, 205));
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnNewButton_1.setBounds(313, 205, 121, 33);
		loginFrame.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("Trouble in Login?");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(165, 288, 121, 13);
		loginFrame.getContentPane().add(lblNewLabel_3);

		JButton btnNewButton_2 = new JButton("Forgot Password");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginFrame.setVisible(false);
				new ForgotClass().frameForgot.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(255, 250, 240));
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnNewButton_2.setBounds(286, 277, 148, 33);
		loginFrame.getContentPane().add(btnNewButton_2);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

	}
}
