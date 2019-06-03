package com.catolicasc.foodtruck;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;

import com.catolicasc.foodtruck.models.Address;
import com.catolicasc.foodtruck.models.Customers;
import com.catolicasc.foodtruck.models.Product;
import com.catolicasc.foodtruck.repositories.CustomersRepository;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddEditCustomers extends JInternalFrame {
	private CustomersRepository customersRepository = new CustomersRepository();
	private Customers customers;
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tFRua;
	private JTextField tFNumero;
	private JTextField tFBairro;

	public void setCustomer(Customers customers){
        this.customers = customers;
    }
	private void updateScreen(Product product){
        tfId.setText(customers.getCustomers().getId().toString());
        tfName.setText(customers.getCustomers().getName());
        tfEmail.setText(customers.getCustomers().getEmail());
        
        String endereco = customers.getAddress();
        
    }
	
	public AddEditCustomers() {
		setClosable(true);
		setBounds(100, 100, 450, 300);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblId = new JLabel("ID:");
		springLayout.putConstraint(SpringLayout.NORTH, lblId, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblId, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblId);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		springLayout.putConstraint(SpringLayout.WEST, tfId, 41, SpringLayout.EAST, lblId);
		springLayout.putConstraint(SpringLayout.SOUTH, tfId, 0, SpringLayout.SOUTH, lblId);
		springLayout.putConstraint(SpringLayout.EAST, tfId, -246, SpringLayout.EAST, getContentPane());
		getContentPane().add(tfId);
		tfId.setColumns(10);
		
		JLabel lblName = new JLabel("Nome:");
		springLayout.putConstraint(SpringLayout.WEST, lblName, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblName);
		
		tfName = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, tfName, 16, SpringLayout.EAST, lblName);
		springLayout.putConstraint(SpringLayout.EAST, tfName, -115, SpringLayout.EAST, getContentPane());
		getContentPane().add(tfName);
		tfName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		springLayout.putConstraint(SpringLayout.NORTH, lblEmail, 76, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblName, -6, SpringLayout.NORTH, lblEmail);
		springLayout.putConstraint(SpringLayout.WEST, lblEmail, 0, SpringLayout.WEST, lblId);
		getContentPane().add(lblEmail);
		
		tfEmail = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tfEmail, 74, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, tfName, -4, SpringLayout.NORTH, tfEmail);
		springLayout.putConstraint(SpringLayout.WEST, tfEmail, 18, SpringLayout.EAST, lblEmail);
		springLayout.putConstraint(SpringLayout.EAST, tfEmail, -115, SpringLayout.EAST, getContentPane());
		getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		springLayout.putConstraint(SpringLayout.NORTH, lblRua, 30, SpringLayout.SOUTH, lblEmail);
		springLayout.putConstraint(SpringLayout.WEST, lblRua, 0, SpringLayout.WEST, lblId);
		getContentPane().add(lblRua);
		
		tFRua = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tFRua, 6, SpringLayout.SOUTH, lblRua);
		springLayout.putConstraint(SpringLayout.WEST, tFRua, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tFRua, -208, SpringLayout.EAST, getContentPane());
		getContentPane().add(tFRua);
		tFRua.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Numero:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, lblRua);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -143, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblNewLabel);
		
		tFNumero = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tFNumero, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, tFNumero, 6, SpringLayout.EAST, tFRua);
		springLayout.putConstraint(SpringLayout.EAST, tFNumero, 71, SpringLayout.EAST, tFRua);
		getContentPane().add(tFNumero);
		tFNumero.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		springLayout.putConstraint(SpringLayout.NORTH, lblBairro, 0, SpringLayout.NORTH, lblRua);
		getContentPane().add(lblBairro);
		
		tFBairro = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, lblBairro, 0, SpringLayout.WEST, tFBairro);
		springLayout.putConstraint(SpringLayout.WEST, tFBairro, 6, SpringLayout.EAST, tFNumero);
		springLayout.putConstraint(SpringLayout.SOUTH, tFBairro, 0, SpringLayout.SOUTH, tFRua);
		getContentPane().add(tFBairro);
		tFBairro.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btSaveActionPerformed(e);
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnSalvar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnSalvar, 0, SpringLayout.EAST, tFBairro);
		getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btCancelActionPerformed(e);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnCancelar, 0, SpringLayout.NORTH, btnSalvar);
		springLayout.putConstraint(SpringLayout.EAST, btnCancelar, -6, SpringLayout.WEST, btnSalvar);
		getContentPane().add(btnCancelar);

	}
	
	private void btCancelActionPerformed(ActionEvent e) {
		if(new Help().confirmCancel(e))
			this.dispose();
	}
	
	private void btSaveActionPerformed(ActionEvent e){
		String msg  = "";
		try {
			String nome  = tfName.getText().toString();
			String email = tfEmail.getText().toString();
			String rua   = tFRua.getText().toString();
			String numero= tFNumero.getText().toString();
			String bairro= tFBairro.getText().toString();
		
        	if (customers ==  null){
        		Address endereco = new Address(rua,numero,bairro); 
        		customers = new Customers();
        		customers.getCustomers().setName(nome);
        		customers.getCustomers().setEmail(email);
        		customers.setAddress(endereco.toString());
        
                customersRepository.add(customers);        		
                msg = "Cliente cadastrado com sucesso";
            }
            else{
            /*    product.setDescription(description);
                product.setPrice(price);
                productRepository.edit(product);*/
                msg = "Cliente editado com sucesso";
            }
        this.dispose();
        }catch(Exception ex) {
        	msg = "Ocorreu um problema ao salvar";

        }
        JOptionPane.showMessageDialog(null, msg);	
	}
}
