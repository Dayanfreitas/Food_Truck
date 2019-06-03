package com.catolicasc.foodtruck;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import com.catolicasc.foodtruck.models.Customers;
import com.catolicasc.foodtruck.repositories.CustomersRepository;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCustomersList extends JInternalFrame {
	private CustomersRepository customersRepository = new CustomersRepository();
	private JTable table;
	
	public void refreshCustomesList() {
		DefaultTableModel tableModel =  (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
	
		ArrayList<Customers>  customers = customersRepository.getAllCustomers();
		
		for (Customers customer : customers) {
			tableModel.addRow(new Object[] {
					customer.getCustomers().getId(),
					customer.getCustomers().getName(),
					customer.getCustomers().getEmail(),
					customer.getAddress()
			});
		}
	}
	
	public JCustomersList() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				refreshCustomesList();
			}
		});
		
		setBounds(20, 20, 650, 300);
		setClosable(true);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 640, 220);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"ID", "Nome", "Email","Endereço"}){
				Class[] columnTypes = new Class[] {
					Integer.class, String.class, String.class,String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		scrollPane.setViewportView(table);	
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(10, 231, 114, 25);
		getContentPane().add(btnAdicionar);
		
		JButton btnEdit = new JButton("Editar");
		btnEdit.setBounds(136, 232, 114, 25);
		getContentPane().add(btnEdit);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um usuário");
					return;
				}
				
				int idColumn = 0;
				Integer rowIndex = table.getSelectedRow();
				Integer userId   = (Integer)table.getModel().getValueAt(rowIndex, idColumn);
				
				customersRepository.delete(userId);
				refreshCustomesList();
			}
		});
		btnDeletar.setBounds(262, 231, 114, 25);
		getContentPane().add(btnDeletar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshCustomesList();
			}
		});
		btnAtualizar.setBounds(514, 231, 114, 25);
		getContentPane().add(btnAtualizar);
		
	}
}
