package com.catolicasc.foodtruck.repositories;

import com.catolicasc.foodtruck.ConnectionFactory;
import com.catolicasc.foodtruck.models.Customers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomersRepository {
    private Connection connection;
    
    private static final String TABLE  = "CUSTOMERS";
    private static final String CREATE = "INSERT INTO "+TABLE+"(NAME, EMAIL,ADDRESS) VALUES(?, ?, ?)";
    private static final String READ   = "SELECT ID,NAME,EMAIL,ADDRESS FROM "+TABLE;
    private static final String UPDATE = "UPDATE "+TABLE+" SET NAME=?, EMAIL=?, ADDRESS=? WHERE ID=?";
    private static final String DELETE = "DELETE FROM "+TABLE+" WHERE ID=?";
    private static final String GET_ID = "SELECT ID, NAME, EMAIL, ADDRESS FROM "+TABLE+" WHERE ID = ?";
    
    public CustomersRepository() {
    	connection = new ConnectionFactory().getConnection();
	}
    
    public ArrayList<Customers> getAllCustomers(){
        try {
            ArrayList<Customers> customers = new ArrayList<>();
            
            String sql = READ;
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet  = selectStmt.executeQuery(sql);
            
            while(resultSet.next()){
                int       id = resultSet.getInt("ID");
                String  name = resultSet.getString("NAME");
                String email = resultSet.getString("EMAIL");
                String address = resultSet.getString("ADDRESS");


                Customers customer = new Customers();
                customer.getCustomers().setId(id);
                customer.getCustomers().setName(name);
                customer.getCustomers().setEmail(email);
                customer.setAddress(address);
                
                customers.add(customer);
            }
            return customers;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

	public void delete(Integer userId) {
		   try {
	            String sql = DELETE;
	            PreparedStatement deleteStmt = connection.prepareStatement(sql);
	            deleteStmt.setInt(1, userId);
	            deleteStmt.executeUpdate();
	            deleteStmt.close();
	            
	            return;
	        }catch (SQLException ex) {
	            throw new RuntimeException(ex);
	        }
	}
    
    
}
