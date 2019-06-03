package com.catolicasc.foodtruck;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import com.catolicasc.foodtruck.models.Customers;
import com.catolicasc.foodtruck.repositories.CustomersRepository;

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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 650, 325);
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
		
	}

}
