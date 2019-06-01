package com.catolicasc.foodtruck;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class JUserList extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JUserList frame = new JUserList();
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
	public JUserList() {
		setClosable(true);
		setBounds(20, 20, 650, 355);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 300, 325);
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
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);	
		
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAdicionar.setBounds(476, 44, 164, 46);
		getContentPane().add(btnAdicionar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(476, 102, 164, 46);
		getContentPane().add(btnEditar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(476, 160, 164, 46);
		getContentPane().add(btnDeletar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(476, 265, 164, 46);
		getContentPane().add(btnAtualizar);
	}
}
