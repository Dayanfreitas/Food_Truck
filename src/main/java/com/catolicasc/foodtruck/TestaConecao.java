package com.catolicasc.foodtruck;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
*
* @author Dayan
*/
public class TestaConecao {
	
	public static void main(String[] args) throws SQLException{
		Connection con = new ConnectionFactory().getConnection();
		String sql = "SELECT id, NAME,email FROM USERS";
		Statement selectStmt = con.createStatement();
		ResultSet resultSet = selectStmt.executeQuery(sql);
		System.out.println("Conexão aberta!");
		
		while(resultSet.next()){
	       int       id = resultSet.getInt("id");
		   String  name = resultSet.getString("name");
		   String email = resultSet.getString("email");
		   
		   System.out.println("ID   : "+id);
		   System.out.println("Nome : "+name);
		   System.out.println("Email: "+email);
		   System.out.println();
		}
		con.close();
	}
}
