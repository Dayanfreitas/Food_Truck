package com.catolicasc.foodtruck;

import com.catolicasc.foodtruck.models.Product;
import com.catolicasc.foodtruck.repositories.ProductRepository;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;

public class AddEditProduct extends javax.swing.JInternalFrame {
    private ProductRepository productRepository = new ProductRepository();
    private Product product;
    
    public void setUser(Product product){
        this.product = product;
    }
    
    private void updateScreen(Product product){
        tfID.setText(product.getId().toString());
        tfDescricao.setText(product.getDescription());
        tfPreco.setText(Double.toString(product.getPrice()));
    }


    public AddEditProduct() {
    	setClosable(true);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        tfDescricao = new javax.swing.JTextField();
        tfPreco = new javax.swing.JTextField();
        btSave = new javax.swing.JButton();

        btCancel.setText("Cancelar");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        jLabel1.setText("Descrição:");
        jLabel2.setText("Preço:");
        jLabel3.setText("Código:");

        tfID.setEditable(false);
        tfID.setEnabled(false);

        btSave.setText("Salvar");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(10)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(btCancel)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btSave))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel1)
        						.addGroup(layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jLabel3))
        						.addGroup(layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addGap(27)))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(tfDescricao, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
        						.addComponent(tfPreco, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
        						.addComponent(tfID, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(8)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(tfID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel3))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(tfDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(tfPreco)
        				.addComponent(jLabel2))
        			.addGap(50)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btSave)
        				.addComponent(btCancel))
        			.addGap(23))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
    	String msg = "";
        try {
            String description = tfDescricao.getText();
            Double price = Double.parseDouble(tfPreco.getText());

        	if(product == null){
            	product = new Product();
                product.setDescription(description);
                product.setPrice(price);
                productRepository.add(product);
                msg = "Produto cadastrado com sucesso";
            }
            else{
                product.setDescription(description);
                product.setPrice(price);
                productRepository.edit(product);
                msg = "Produto editado com sucesso";
            }

            updateScreen(product);

            JOptionPane.showMessageDialog(null, msg);
            this.dispose();
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um problema ao salvar");
        }
    }//GEN-LAST:event_btSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfPreco;
    // End of variables declaration//GEN-END:variables
}
