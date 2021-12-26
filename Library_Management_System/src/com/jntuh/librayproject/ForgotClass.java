package com.jntuh.librayproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class ForgotClass {

	public  JFrame frameForgot;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JTextField textField_4;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblName;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotClass window = new ForgotClass();
					window.frameForgot.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ForgotClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameForgot = new JFrame();
		frameForgot.getContentPane().setBackground(new Color(152, 251, 152));
		frameForgot.getContentPane().setEnabled(false);
		frameForgot.getContentPane().setForeground(Color.WHITE);
		frameForgot.setBounds(100, 100, 450, 300);
		frameForgot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameForgot.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(190, 32, 96, 19);
		frameForgot.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(190, 75, 96, 19);
		frameForgot.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(190, 116, 96, 19);
		frameForgot.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(190, 158, 96, 19);
		frameForgot.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		btnNewButton = new JButton("Send OTP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OtpClass otpClass =new OtpClass();
				otpClass.sendSms(textField.getText(),textField_2.getText()); //default opt=98765
				
			}
		});
		btnNewButton.setBounds(296, 158, 130, 21);
		frameForgot.getContentPane().add(btnNewButton);
		
		textField_4 = new JTextField();
		textField_4.setBounds(190, 199, 96, 19);
		frameForgot.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectDb conn=new ConnectDb();
				int n=0;
				String query="UPDATE LOGINTABLE SET PASSWORD=? WHERE USRNAME=?";
				try {
					PreparedStatement ps=conn.con.prepareStatement(query);
					ps.setString(1, textField_4.getText());
					ps.setString(2, textField_1.getText());
					n=ps.executeUpdate();
					if(n>0) {
						JOptionPane.showMessageDialog(null,"Password Changed Successfully");
					}
					else {
						JOptionPane.showMessageDialog(null, "Unable to Change-Enter Valid Credentials");
					}
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
				}
				finally {
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
				}
			}
		});
		btnNewButton_1.setBounds(112, 228, 85, 21);
		frameForgot.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginClass().loginFrame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(251, 228, 85, 21);
		frameForgot.getContentPane().add(btnNewButton_2);
		
		lblName = new JLabel("Name");
		lblName.setBounds(95, 35, 45, 13);
		frameForgot.getContentPane().add(lblName);
		
		lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(95, 78, 60, 13);
		frameForgot.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Phonenumber");
		lblNewLabel_1.setBounds(95, 119, 73, 13);
		frameForgot.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("OTP");
		lblNewLabel_2.setBounds(95, 159, 45, 16);
		frameForgot.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("New Password");
		lblNewLabel_3.setBounds(95, 202, 85, 13);
		frameForgot.getContentPane().add(lblNewLabel_3);
	}

}
