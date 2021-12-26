package com.jntuh.librayproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Insets;

public class Home {

	private JFrame frameHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frameHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameHome = new JFrame();
		frameHome.setMinimumSize(new Dimension(800, 680));
		frameHome.setBounds(100, 100, 806, 683);
		frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameHome.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 792, 32);
		frameHome.getContentPane().add(menuBar);
		menuBar.setMargin(new Insets(2, 2, 2, 2));
		menuBar.setForeground(new Color(255, 228, 196));
		menuBar.setBackground(new Color(0, 255, 255));
		
		JMenu mnNewMenu = new JMenu("Record");
		mnNewMenu.setBackground(new Color(0, 0, 0));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_2 = new JMenu("New menu");
		menuBar.add(mnNewMenu_2);
	}
}
