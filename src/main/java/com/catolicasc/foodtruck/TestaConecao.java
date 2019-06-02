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
		System.out.println("Conexão aberta!");
		String sql = "SELECT id, NAME,EMAIL FROM USERS";
		Statement selectStmt = con.createStatement();
		ResultSet resultSet = selectStmt.executeQuery(sql);
		
		while(resultSet.next()){
	       int       id = resultSet.getInt("id");
		   String  name = resultSet.getString("name");
		   String email = resultSet.getString("email");
		   
		   System.out.println("ID   : "+id);
		   System.out.println("Nome : "+name);
		   System.out.println("Email: "+email);
		   System.out.println();
		}
		
		sql = "SELECT ID, DESCRIPTION,PRICE FROM PRODUCTS";
		resultSet = selectStmt.executeQuery(sql);
		
		while(resultSet.next()){
		       int       id = resultSet.getInt("ID");
			   String  name = resultSet.getString("DESCRIPTION");
			   String email = resultSet.getString("PRICE");
			   
			   System.out.println("ID          : "+id);
			   System.out.println("DESCRIPTION : "+name);
			   System.out.println("PRICE       : "+email);
			   System.out.println();
			}
			
		con.close();	
	}
}
