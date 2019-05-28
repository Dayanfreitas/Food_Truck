package com.catolicasc.foodtruck.repositories;

import com.catolicasc.foodtruck.ConnectionFactory;
import com.catolicasc.foodtruck.models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductRepository {
    
    private Connection connection;
    
    public ArrayList<Product> getAllProducts(){
        try {
            ArrayList<Product>  products = new ArrayList<>();
            
            String sql = "SELECT id, description, price FROM products";
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            
            while(resultSet.next()){
                int              id = resultSet.getInt("id");
                String  description = resultSet.getString("description");
                Double        price = resultSet.getDouble("price");
                
                Product product = new Product();
                product.setId(id);
                product.setDescription(description);
                product.setPrice(price);
                
                products.add(product);
            }
            
            
            
            return products;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        
        
    }
    
    public Product getProductById(Integer productId){
        try {
            String sql = "SELECT id, description, price FROM products WHERE id = ?";
            PreparedStatement selectStmt = connection.prepareStatement(sql);
            selectStmt.setInt(1, productId);
            ResultSet resultSet = selectStmt.executeQuery();
            
            
            Product product = new Product();
            
            if(resultSet.first()){
                product = new Product();

                int id = resultSet.getInt("id");
                String description = resultSet.getString("description");
                Double price = resultSet.getDouble("price");
                
                product.setId(id);
                product.setDescription(description);
                product.setPrice(price);
            }
            
            selectStmt.close();
            return product;

        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
    }
    
    public ProductRepository() {
        connection = new ConnectionFactory().getConnection();
    }
    
    public Product add(Product product) {
        try {
            String sql = "INSERT INTO PRODUCTS (DESCRIPTION, PRICE) VALUES (?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(sql);
            insertStmt.setString(1, product.getDescription());
            insertStmt.setDouble(2, product.getPrice());
            insertStmt.executeUpdate();
            insertStmt.close();
            
            sql = "SELECT LAST_INSERT_ID() AS ID";
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            while(resultSet.next()) {
                Integer id  = resultSet.getInt("ID");
                product.setId(id);
            }
            selectStmt.close();
            
            return product;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public Product edit(Product product) {
        try {
            String sql = "UPDATE PRODUCTS SET NAME=?, DESCRIPTION=? WHERE ID=?";
            PreparedStatement updateStmt = connection.prepareStatement(sql);
            updateStmt.setString(1, product.getDescription());
            updateStmt.setDouble(2, product.getPrice());
            updateStmt.setInt(3, product.getId());
            updateStmt.executeUpdate();
            updateStmt.close();
            
            return product;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public void delete(int productId)
    {
        try {
            String sql = "DELETE FROM PRODUCTS WHERE ID=?";
            PreparedStatement deleteStmt = connection.prepareStatement(sql);
            deleteStmt.setInt(1, productId);
            deleteStmt.executeUpdate();
            deleteStmt.close();
            
            return;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
    }
}
