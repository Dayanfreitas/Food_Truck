package com.catolicasc.foodtruck;

import com.catolicasc.foodtruck.models.Product;
import com.catolicasc.foodtruck.repositories.ProductRepository;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ListProducts extends javax.swing.JInternalFrame {    
    private ProductRepository productRepository = new ProductRepository();

    public ListProducts() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jbUpdate 		= new javax.swing.JButton();
        jbDelete 		= new javax.swing.JButton();
        jbAdd1 			= new javax.swing.JButton();
        jScrollPane1 	= new javax.swing.JScrollPane();
        jtProducts 		= new javax.swing.JTable();
        jbAdd 			= new javax.swing.JButton();

        setClosable(true);
        
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
                
            }
        });
        
        jbUpdate.setText("Editar");
        jbUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateActionPerformed(evt);
            }
        });

        jbDelete.setText("Deletar");
        jbDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteActionPerformed(evt);
            }
        });

        jbAdd1.setText("Atualizar");
        jbAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdd1ActionPerformed(evt);
        
            }
        });

        jtProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"Código", "Descrição", "Preço"}) 
        	{
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtProducts);

        jbAdd.setText("Adicionar");
        jbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddActionPerformed(evt);
    
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(25)
        			.addComponent(jbUpdate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jbAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jbDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jbAdd1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(435))
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.CENTER)
        				.addComponent(jbUpdate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jbAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jbAdd1)
        				.addComponent(jbDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(65))
        );
        getContentPane().setLayout(layout);
        pack();
    }
    
    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed
        
    	if(jtProducts.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(null,"Selecione um usuário");
            return;
        }

        Integer rowIndex   = jtProducts.getSelectedRow();
        Integer productId  = (Integer) jtProducts.getModel().getValueAt(rowIndex,0);

//        Product product = ProductRepository.getProductById(productId);

        //        AddEditProduct addEditProduct = new AddEditProduct();
        // addEditProduct.setUser(product);
        //this.getParent().add(addEditProduct);
        //addEditProduct.setVisible(true);

    }//GEN-LAST:event_jbUpdateActionPerformed

    private void jbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteActionPerformed
        if(jtProducts.getSelectedRowCount()==0)
        {
            JOptionPane.showMessageDialog(null,"Selecione um usuário");
            return;
        }

        Integer rowIndex = jtProducts.getSelectedRow();
        Integer userId   = (Integer) jtProducts.getModel().getValueAt(rowIndex,0);

        try{
            productRepository.delete(userId);
            JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso");
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um problema ao deletar");
        }
    }//GEN-LAST:event_jbDeleteActionPerformed

    private void jbAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdd1ActionPerformed
        //refreshProductList();
    }//GEN-LAST:event_jbAdd1ActionPerformed

    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddActionPerformed
        AddEditProduct addEditProduct = new AddEditProduct();
        this.getParent().add(addEditProduct);
        addEditProduct.setVisible(true);
    }//GEN-LAST:event_jbAddActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        //refreshProductList();
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbAdd1;
    private javax.swing.JButton jbDelete;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JTable jtProducts;
    // End of variables declaration//GEN-END:variables
}
