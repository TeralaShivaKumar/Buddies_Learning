package com.jntuh.librayproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SignupClass {

	public JFrame frameSignUp;
	private JTable table;
	public static JTextField nameField;
	private JTextField usrField;
	private JTextField passwordField;
	private JTextField otpField;
	public static JTextField phoneField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupClass window = new SignupClass();
					window.frameSignUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignupClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameSignUp = new JFrame();
		frameSignUp.setBounds(100, 100, 450, 300);
		frameSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSignUp.getContentPane().setLayout(null);

		table = new JTable();
		table.setBounds(163, 63, 1, 1);
		frameSignUp.getContentPane().add(table);

		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Lucida Sans Typewriter", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(144, 10, 155, 13);
		frameSignUp.getContentPane().add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(53, 21, -17, 25);
		frameSignUp.getContentPane().add(separator);

		nameField = new JTextField();
		nameField.setBounds(192, 33, 96, 19);
		frameSignUp.getContentPane().add(nameField);
		nameField.setColumns(10);

		usrField = new JTextField();
		usrField.setBounds(192, 74, 96, 19);
		frameSignUp.getContentPane().add(usrField);
		usrField.setColumns(10);

		passwordField = new JTextField();
		passwordField.setBounds(192, 114, 96, 19);
		frameSignUp.getContentPane().add(passwordField);
		passwordField.setColumns(10);

		otpField = new JTextField();
		otpField.setBounds(192, 198, 96, 19);
		frameSignUp.getContentPane().add(otpField);
		otpField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(94, 35, 45, 13);
		frameSignUp.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(94, 76, 57, 13);
		frameSignUp.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_3.setBounds(94, 116, 57, 13);
		frameSignUp.getContentPane().add(lblNewLabel_3);

		JButton sendButton = new JButton("Send OTP");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OtpClass otpClass =new OtpClass();
				otpClass.sendSms(nameField.getText(),phoneField.getText());
			}
		});
		sendButton.setBounds(316, 197, 110, 21);
		frameSignUp.getContentPane().add(sendButton);

		JButton createButton = new JButton("Create");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int n=0;
					ConnectDb conn=new ConnectDb();
					String query="INSERT INTO LOGINTABLE VALUES(?,?,?,?)";
					PreparedStatement ps=conn.con.prepareStatement(query);
					ps.setString(1, nameField.getText());
					ps.setString(2, usrField.getText());
					ps.setString(3, passwordField.getText());
					ps.setString(4, phoneField.getText());
					System.out.println(OtpClass.otp);
					if(OtpClass.otp==Integer.parseInt(otpField.getText())){
						n=ps.executeUpdate();
					}
					else {
						JOptionPane.showMessageDialog(null,"Incorrect OTP");
					}
					if(n>0) {
						JOptionPane.showMessageDialog(null, "Successfully Created");
					}
					else {
						JOptionPane.showMessageDialog(null, "Internal Error-Try Again");
					}
					nameField.setText("");
					usrField.setText("");
					passwordField.setText("");
					phoneField.setText("");
					otpField.setText("");
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		
		createButton.setBounds(94, 232, 85, 21);
		frameSignUp.getContentPane().add(createButton);

		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameSignUp.setVisible(false);
				new LoginClass().loginFrame.setVisible(true);
			}
		});
		backButton.setBounds(231, 232, 85, 21);
		frameSignUp.getContentPane().add(backButton);

		JLabel lblNewLabel_4 = new JLabel("OTP");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(94, 200, 45, 13);
		frameSignUp.getContentPane().add(lblNewLabel_4);

		phoneField = new JTextField();
		phoneField.setBounds(192, 155, 96, 19);
		frameSignUp.getContentPane().add(phoneField);
		phoneField.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Phone Number");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_5.setBounds(94, 157, 87, 13);
		frameSignUp.getContentPane().add(lblNewLabel_5);
	}
}
