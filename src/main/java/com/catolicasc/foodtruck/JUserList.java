package com.catolicasc.foodtruck;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

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
		setBounds(20, 20, 400, 355);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 200, 325);
		getContentPane().add(scrollPane);
		
		String [] colunas = {"ID","Nome","Email"};
		Object [][] dado = {{"1","Dayan","dayan@gmail"}};
		
		table = new JTable();
		table.setModel(new DefaultTableModel(dado,colunas));
		scrollPane.setViewportView(table);	
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(210, 11, 164, 46);
		getContentPane().add(btnAdicionar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(210, 68, 164, 46);
		getContentPane().add(btnEditar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(210, 125, 164, 46);
		getContentPane().add(btnDeletar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(210, 182, 164, 46);
		getContentPane().add(btnAtualizar);
	}
}
