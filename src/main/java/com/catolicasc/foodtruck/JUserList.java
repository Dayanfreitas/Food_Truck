package com.catolicasc.foodtruck;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.catolicasc.foodtruck.models.User;
import com.catolicasc.foodtruck.repositories.UserRepository;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class JUserList extends JInternalFrame {
	private UserRepository userRepository = new UserRepository();
	private JUser jUser = new JUser();
	private JTable table;

	
	/**
	 * Busca os dados atualizados do banco de dados
	 * @author dayanfreitas
	 */
	public void refreshUserList() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		
		ArrayList<User> users = userRepository.getAllUsers();
		
		for(User user : users) {
			tableModel.addRow(new Object[] {
					user.getId(),
					user.getName(),
					user.getEmail()
			});
		}
	}
	
	public JUserList() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				refreshUserList();
			}
		});
		
		setClosable(true);
		setBounds(20, 20, 650, 355);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 450, 325);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"ID", "Nome", "Email"}){
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);	
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
					JUser jUser = new JUser();
					getParent().add(jUser);
					jUser.setVisible(true);
			}
		});
		
		btnAdicionar.setBounds(476, 44, 164, 46);
		getContentPane().add(btnAdicionar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (table.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um usuário");
					return;
				}
				
				int idColumn = 0;
				Integer rowIndex = table.getSelectedRow();
				Integer userId   = (Integer)table.getModel().getValueAt(rowIndex, idColumn);
				
				User user = userRepository.getUserById(userId);

				JUser jUser = new JUser();
				jUser.setUser(user);
				getParent().add(jUser);
				jUser.setVisible(true);
			}
		});
		
		btnEditar.setBounds(476, 102, 164, 46);
		getContentPane().add(btnEditar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um usuário");
					return;
				}
				int idColumn = 0;
				Integer rowIndex = table.getSelectedRow();
				Integer userId   = (Integer)table.getModel().getValueAt(rowIndex, idColumn);
				
				userRepository.delete(userId);
				refreshUserList();
			}
		});
		btnDeletar.setBounds(476, 160, 164, 46);
		getContentPane().add(btnDeletar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshUserList();
			}
		});
		btnAtualizar.setBounds(476, 265, 164, 46);
		getContentPane().add(btnAtualizar);
	}
	/**
	 * Pega o id o usuário selecionado na tabela
	 * @author dayanfreitas
	 * @return user id 
	 */

}
