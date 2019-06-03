package com.catolicasc.foodtruck.BO;

import com.catolicasc.foodtruck.models.Product;
import com.mysql.cj.util.StringUtils;

public class ProductBO {
	
	public Boolean verificarProdutoExiste(Product product) {
		if (product == null) {
			return false;
		}
		return true;
	}
	
	public Boolean verificarDescricaoExiste(Product product) {
		if (product.getDescription().trim().equals("")) {
			return false;
		}
		return true;
	}
	
/*	public Boolean verificarPrecoExiste(Product product) {
		String preco =  String.valueOf(product.getPrice());
		
		if (preco.trim().equals("") && StringUtils.isStrictlyNumeric(preco)) {
			return false;
		}
		return true;
	}
	*/
	
}
