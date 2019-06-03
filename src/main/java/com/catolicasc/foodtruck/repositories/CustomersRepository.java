package com.catolicasc.foodtruck.repositories;

import com.catolicasc.foodtruck.ConnectionFactory;
import com.catolicasc.foodtruck.models.Customers;
import com.catolicasc.foodtruck.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.print.attribute.standard.RequestingUserName;

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
    
    public Customers add(Customers customers) {
        try {
            String sql = CREATE;
        	PreparedStatement insertStmt = connection.prepareStatement(sql);
            insertStmt.setString(1, customers.getCustomers().getName());
            insertStmt.setString(2, customers.getCustomers().getEmail());
            insertStmt.setString(3, customers.getAddress());
            insertStmt.executeUpdate();
            insertStmt.close();
            
            sql = "SELECT LAST_INSERT_ID() AS ID";
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            while(resultSet.next()) {
                Integer id  = resultSet.getInt("ID");
                customers.getCustomers().setId(id);
            }
            selectStmt.close();
            
            return customers;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
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

	public Customers getUserById(Integer customersId) {
		try {
            String sql = GET_ID;
            PreparedStatement selectStmt = connection.prepareStatement(sql);
            selectStmt.setInt(1, customersId);
            ResultSet resultSet = selectStmt.executeQuery();
            
        	Customers customers = null;
            
            if(resultSet.first()){
            	customers = new Customers();

	             int id 		= resultSet.getInt("ID");
	             String name    = resultSet.getString("NAME");
	             String email   = resultSet.getString("EMAIL");
	             String address = resultSet.getString("ADDRESS");
	             customers.getCustomers().setId(id);
	             customers.getCustomers().setName(name);
	             customers.getCustomers().setEmail(email);
	             customers.setAddress(address);
            }
            
            selectStmt.close();
            return customers;            
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
	}

	public Customers edit(Customers customers) {
		try {
            String sql = UPDATE;
            PreparedStatement updateStmt = connection.prepareStatement(sql);
            updateStmt.setString(1, customers.getCustomers().getName());
            updateStmt.setString(2, customers.getCustomers().getEmail());
            updateStmt.setString(3, customers.getAddress());
            updateStmt.setInt(4, customers.getCustomers().getId());
            updateStmt.executeUpdate();
            updateStmt.close();
          
            return customers;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
		
	}
    
}
