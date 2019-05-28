package com.catolicasc.foodtruck;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class JUser extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JUser frame = new JUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JUser() {
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 11, 46, 14);
		getContentPane().add(lblId);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 47, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 83, 46, 14);
		getContentPane().add(lblEmail);

	}

}
