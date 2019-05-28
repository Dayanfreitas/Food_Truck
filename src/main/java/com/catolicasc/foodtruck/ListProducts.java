package com.catolicasc.foodtruck;

import com.catolicasc.foodtruck.models.Product;
import com.catolicasc.foodtruck.repositories.ProductRepository;
import javax.swing.JOptionPane;

public class ListProducts extends javax.swing.JInternalFrame {
    
    private ProductRepository productRepository = new ProductRepository();


    public ListProducts() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbUpdate = new javax.swing.JButton();
        jbDelete = new javax.swing.JButton();
        jbAdd1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProducts = new javax.swing.JTable();
        jbAdd = new javax.swing.JButton();

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

        jbUpdate.setLabel("Editar");
        jbUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateActionPerformed(evt);
            }
        });

        jbDelete.setLabel("Deletar");
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
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Preço"
            }
        ) {
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

        jbAdd.setLabel("Adicionar");
        jbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(100, 100, 100)
                .addComponent(jbUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(147, 147, 147)
                .addComponent(jbAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(109, 109, 109)
                .addComponent(jbAdd1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jbDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAdd1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed
        if(jtProducts.getSelectedRowCount()==0)
        {
            JOptionPane.showMessageDialog(null,"Selecione um usuário");
            return;
        }

        Integer rowIndex = jtProducts.getSelectedRow();
        Integer productId   = (Integer) jtProducts.getModel().getValueAt(rowIndex,0);

        Product product = ProductRepository.getProductById(productId);

        AddEditProduct addEditProduct = new AddEditProduct();
        addEditProduct.setUser(product);
        this.getParent().add(addEditProduct);
        addEditProduct.setVisible(true);

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
        refreshProductList();
    }//GEN-LAST:event_jbAdd1ActionPerformed

    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddActionPerformed
        AddEditProduct addEditProduct = new AddEditProduct();
        this.getParent().add(addEditProduct);
        addEditProduct.setVisible(true);
    }//GEN-LAST:event_jbAddActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        refreshProductList();
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
