package com.catolicasc.foodtruck;

import javax.swing.JOptionPane;

public class Help {
	/**
	 * @author dayanfreitas
	 * @param evt
	 * @return 
	 */
	public boolean confirmCancel(java.awt.event.ActionEvent evt) {
		int sim = 0;
		int op  = JOptionPane.showConfirmDialog(null,
				"Informações poderão ser perdidas!", "Cancelar ?",JOptionPane.YES_NO_OPTION);
        return op == sim;
    }
	
}
