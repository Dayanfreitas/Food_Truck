/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck;

import com.catolicasc.foodtruck.models.Customers;
import com.catolicasc.foodtruck.models.Orders;
import com.catolicasc.foodtruck.models.Product;
import com.catolicasc.foodtruck.models.User;
import com.catolicasc.foodtruck.repositories.CustomersRepository;
import com.catolicasc.foodtruck.repositories.OrdersRepository;
import com.catolicasc.foodtruck.repositories.ProductRepository;
import com.catolicasc.foodtruck.repositories.UserRepository;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 *
 * @author dayan.freitas
 */
public class JPedidoList extends javax.swing.JInternalFrame {
    private CustomersRepository customersRepository = new CustomersRepository();
    private OrdersRepository ordersRepository = new OrdersRepository();
    
    public void refreshOrdersList() {
		DefaultTableModel tableModel =  (DefaultTableModel) jTable1.getModel();
		tableModel.setRowCount(0);
	
		ArrayList<Orders> orders = ordersRepository.getAllOrders();
		
		
		for (Orders order: orders) {
			Customers customers = customersRepository.getUserById(order.getCustomers().getCustomers().getId());
			
			tableModel.addRow(new Object[] {
					order.getId(),
					customers.getCustomers().getName(),
					"",
					"",
					"",
					""
			});
		}
	}
	
    
    public JPedidoList() {
        initComponents();
    }
    
    private void initComponents() {
    	
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				refreshOrdersList();
			}
		});
		
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnAdicionar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código do pedido", "Nome do cliente", "Valor total do pedido", "Data e hora do pedido ", "Data e hora de término do preparo", "Data e hora da entrega"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnAdicionar.setText("Pedido");
        
        JButton btnAtualizar = new JButton();
        btnAtualizar.setText("Atualizar");
        
        btnEditar = new JButton();
        btnEditar.setText("Editar pedido");
        
        btnDeletar = new JButton("Deletar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(26)
        			.addComponent(btnAdicionar)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnEditar)
        			.addPreferredGap(ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
        			.addComponent(btnDeletar)
        			.addGap(18)
        			.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnAdicionar)
        				.addComponent(btnAtualizar)
        				.addComponent(btnEditar)
        				.addComponent(btnDeletar))
        			.addContainerGap(19, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private JButton btnEditar;
    private JButton btnDeletar;
}
