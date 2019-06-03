package com.catolicasc.foodtruck;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import com.catolicasc.foodtruck.models.Product;
import com.catolicasc.foodtruck.repositories.ProductRepository;

public class JProductList extends JInternalFrame {
	private ProductRepository productRepository = new ProductRepository();
	private JTable table;

	/**
	 * Busca todos os produtos e atualiza na tela 
	 * @author dayanfreitas
	 */
	public void refreshProductList() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		
		ArrayList<Product> products = productRepository.getAllProducts();
		
		for(Product product : products) {
			tableModel.addRow(new Object[] {
					product.getId(),
					product.getDescription(),
					product.getPrice()
			});
		}
	}
	
	/**
	 * Create the frame.
	 */
	public JProductList() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				refreshProductList();
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
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ID", "Descri\u00E7\u00E3o", "Pre\u00E7o"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);	
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				AddEditProduct addEditProduct = new AddEditProduct();
				getParent().add(addEditProduct);
				addEditProduct.setVisible(true);

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
				
			//	User user = userRepository.getUserById(userId);
				
			//	JUser jUser = new JUser();
				//jUser.setUser(user);
				//getParent().add(jUser);
				//jUser.setVisible(true);
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
				
				//userRepository.delete(userId);
				//refreshProductList();
			}
		});
		btnDeletar.setBounds(476, 160, 164, 46);
		getContentPane().add(btnDeletar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			refreshProductList();
			}
		});
		btnAtualizar.setBounds(476, 265, 164, 46);
		getContentPane().add(btnAtualizar);

	}

}