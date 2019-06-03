package com.catolicasc.foodtruck;

import com.catolicasc.foodtruck.BO.ProductBO;
import com.catolicasc.foodtruck.models.Product;
import com.catolicasc.foodtruck.repositories.ProductRepository;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;

public class AddEditProduct extends javax.swing.JInternalFrame {
    private ProductRepository productRepository = new ProductRepository();
    private ProductBO productBO = new ProductBO();
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

    private void initComponents() {
        btCancel     = new javax.swing.JButton();
        jlDescricao  = new javax.swing.JLabel();
        jlPreco      = new javax.swing.JLabel();
        jlCodigo     = new javax.swing.JLabel();
        tfID         = new javax.swing.JTextField();
        tfDescricao  = new javax.swing.JTextField();
        tfPreco      = new javax.swing.JTextField();
        btSave       = new javax.swing.JButton();

        btCancel.setText("Cancelar");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btCancelActionPerformed(evt);
            }
        });

        jlDescricao.setText("Descrição:");
        jlPreco.setText("Preço:");
        jlCodigo.setText("Código:");

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
        						.addComponent(jlDescricao)
        						.addGroup(layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jlCodigo))
        						.addGroup(layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jlPreco, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        				.addComponent(jlCodigo))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jlDescricao)
        				.addComponent(tfDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(tfPreco)
        				.addComponent(jlPreco))
        			.addGap(50)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btSave)
        				.addComponent(btCancel))
        			.addGap(23))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    /**
     * @author dayanfreitas
     * @param evt
     */
    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {
    	if(new Help().confirmCancel(evt)) 
    		this.dispose();
    }
    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {
    	String msg = "";
        try {
            String description = tfDescricao.getText();
            Double price       = Double.valueOf(tfPreco.getText());
            
        	if (productBO.verificarProdutoExiste(product) == false){
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
        this.dispose();
        }catch(Exception ex) {
        	msg = "Ocorreu um problema ao salvar";
        	product = null;
        }
        JOptionPane.showMessageDialog(null, msg);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btSave;
    private javax.swing.JLabel jlDescricao;
    private javax.swing.JLabel jlPreco;
    private javax.swing.JLabel jlCodigo;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfPreco;
    // End of variables declaration//GEN-END:variables
}
