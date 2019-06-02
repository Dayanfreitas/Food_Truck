package com.catolicasc.foodtruck;

import com.catolicasc.foodtruck.BO.UserBO;
import com.catolicasc.foodtruck.models.User;
import com.catolicasc.foodtruck.repositories.UserRepository;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 * <code>public class JUser</code><br>
 * JInternalFrame de usuário, cadastrado e edição
 * @author dayanfreitas
 */
public class JUser extends JInternalFrame {
	private UserRepository userRepository = new UserRepository();
	private UserBO userBO = new UserBO();
	private User user=null;
	
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JLabel lbDebug;
	
	/**
	 * Criação da tela
	 * @author dayanfreitas
	 */
	public JUser() {

		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				if (user != null){
					updateScreen(user);
				}
			}
			
		});
	
		lbDebug = new JLabel("-");
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
				String msg   = "";
				try {
					String name  = textFieldName.getText();
					String email = textFieldEmail.getText();
					
					if (userBO.verificarUsuarioExite(user) == false) {
						user = new User();
						user.setName(name);
						user.setEmail(email);
						
						if (userBO.verificarNomeExiste(user)) {
							userRepository.add(user);
							msg  = "Usuário cadastrado com sucesso!";
							JUser.this.dispose();
						}else {
							msg = "Nome é obrigatório!";
						}
					}else {
						user.setName(name);
						user.setEmail(email);
						userRepository.edit(user);
						msg = "Atualizado com sucesso!";
						JUser.this.dispose();
					}
					
				}catch (Exception ex) {
					msg = "Erro ao salvar usuário!";
				}
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JUser.this.dispose();
			}
		});
		btnCancel.setBounds(66, 119, 99, 23);
		getContentPane().add(btnCancel);
		
		lbDebug.setBounds(66, 265, 46, 14);
		getContentPane().add(lbDebug);
	}
	
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void updateScreen(User user) {
		textFieldID.setText(user.getId().toString());
		textFieldName.setText(user.getName());
		textFieldEmail.setText(user.getEmail());
	}
	
	/**
	 * Limpar os campos
	 * @author dayanfreitas
	 */
	public void cleanField() {
		textFieldID.setText("-");
		textFieldName.setText("");
		textFieldEmail.setText("");
	}
}
