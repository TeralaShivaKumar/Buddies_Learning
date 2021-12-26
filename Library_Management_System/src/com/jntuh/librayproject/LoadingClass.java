package com.jntuh.librayproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoadingClass implements ActionListener {

	public JFrame frameLoading;
	int i=0;
	Timer t;
	JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadingClass window = new LoadingClass();
					window.frameLoading.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoadingClass() {
		t=new Timer(25,this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameLoading = new JFrame();
		frameLoading.getContentPane().setBackground(Color.DARK_GRAY);
		frameLoading.setBounds(100, 100, 450, 300);
		frameLoading.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLoading.getContentPane().setLayout(null);
		
		progressBar = new JProgressBar(0,100);
		progressBar.setBounds(124, 116, 206, 21);
		frameLoading.getContentPane().add(progressBar);
	
		
		JLabel lblNewLabel = new JLabel("Ujjwal Library");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(114, 74, 206, 32);
		frameLoading.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				t.start();
			}
		});
		btnNewButton.setBounds(175, 147, 85, 21);
		frameLoading.getContentPane().add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		progressBar.setValue(i);
		i++;
		if(i==100) {
			frameLoading.setVisible(false);
			//new Home.frameHome.setVisible(true);
		}
		
	}
}
