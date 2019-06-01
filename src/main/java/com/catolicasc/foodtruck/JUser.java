package com.catolicasc.foodtruck;

import com.catolicasc.foodtruck.BO.UserBO;
import com.catolicasc.foodtruck.models.User;
import com.catolicasc.foodtruck.repositories.UserRepository;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JUser extends JInternalFrame {
	private UserRepository userRepository = new UserRepository();
	private UserBO userBO = new UserBO();
	private User user;
	
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JLabel lbDebug;
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
		lbDebug = new JLabel("-");
		setMaximizable(true);
		setClosable(true);
		setBounds(20, 20, 400, 400);
		getContentPane().setLayout(null);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(10, 11, 46, 14);
		getContentPane().add(lblID);
		
		JLabel lblName = new JLabel("Nome*:");
		lblName.setBounds(10, 47, 50, 14);
		getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 83, 46, 14);
		getContentPane().add(lblEmail);
		
		textFieldID = new JTextField();
		textFieldID.setText("-");
		textFieldID.setEnabled(false);
		textFieldID.setBounds(66, 8, 86, 20);
		getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(66, 44, 200, 20);
		getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(66, 80, 200, 20);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JButton btnSave = new JButton("Salvar");
		btnSave.setBounds(177, 119, 89, 23);
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name  = textFieldName.getText();
				String email = textFieldEmail.getText();
				String msg   = "";
				
				try {
					user = new User();
					user.setName(name);
					user.setEmail(email);
					
					if (userBO.verificarNomeExiste(user)) {
						msg = "Nome existe!";
						user = userRepository.add(user);
						msg  = String.format("Usuário %s cadastrado com, sucesso!",user.getId());
					}else {
						msg = "Nome é obrigatório!";
					}
				}catch (Exception ex) {
					msg = "Erro ao salvar usuário!";
				}

				JOptionPane.showMessageDialog(null, msg);
//				lbDebug.setText(msg);
			}
		});
		getContentPane().add(btnSave);
		
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(66, 119, 89, 23);
		getContentPane().add(btnCancel);
		
		
		lbDebug.setBounds(66, 265, 46, 14);
		getContentPane().add(lbDebug);

	}
}
