package com.catolicasc.foodtruck.BO;

import com.catolicasc.foodtruck.models.User;

public class UserBO {
	public Boolean verificarUsuarioExite(User user) {
		if(user == null) {
			return false;
		}
		return true;
	}
	
	public Boolean verificarNomeExiste(User user) {
		if (user.getName().isEmpty() || user.getName().trim().equals("")){
			return false;
		}
		return true;
	}
	
	public Boolean verificarEmailExiste(User user) {
		if (user.getEmail().isEmpty() || user.getName().trim().equals("")){
			return false;
		}
		return true;
	}
	
}
