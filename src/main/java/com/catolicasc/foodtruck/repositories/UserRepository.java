package com.catolicasc.foodtruck.repositories;

import com.catolicasc.foodtruck.ConnectionFactory;
import com.catolicasc.foodtruck.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserRepository {
    private Connection connection;

    public UserRepository() {
        connection = new ConnectionFactory().getConnection();
    }
    
    public ArrayList<User> getAllUsers(){
        try {
            ArrayList<User>  users = new ArrayList<>();
            
            String sql = "SELECT id, name, email FROM users";
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            
            while(resultSet.next()){
                int       id = resultSet.getInt("id");
                String  name = resultSet.getString("name");
                String email = resultSet.getString("email");
                
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);
                
                users.add(user);
            }
            return users;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public User getUserById(Integer userId){
        try {
            String sql = "SELECT id, name, email FROM users WHERE id = ?";
            PreparedStatement selectStmt = connection.prepareStatement(sql);
            selectStmt.setInt(1, userId);
            ResultSet resultSet = selectStmt.executeQuery();
            
            User user = new User();
            if(resultSet.first()){
                user = new User();

                int id 		 = resultSet.getInt("id");
                String name  = resultSet.getString("name");
                String email = resultSet.getString("email");
                
                user.setId(id);
                user.setName(name);
                user.setEmail(email);
            }
            
            selectStmt.close();
            return user;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
    }
    
    public User add(User user) {
        try {
            String sql = "INSERT INTO users(NOME, EMAIL) VALUES(?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(sql);
            insertStmt.setString(1, user.getName());
            insertStmt.setString(2, user.getEmail());
            insertStmt.executeUpdate();
            insertStmt.close();
            
            sql = "SELECT LAST_INSERT_ID() AS ID";
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            while(resultSet.next()) {
                Integer id  = resultSet.getInt("ID");
                user.setId(id);
            }
            selectStmt.close();
            
            return user;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public User edit(User user) {
        try {
            String sql = "UPDATE USERS SET NAME=?, EMAIL=? WHERE ID=?";
            PreparedStatement updateStmt = connection.prepareStatement(sql);
            updateStmt.setString(1, user.getName());
            updateStmt.setString(2, user.getEmail());
            updateStmt.setInt(3, user.getId());
            updateStmt.executeUpdate();
            updateStmt.close();
            
            return user;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public void delete(int userId)
    {
        try {
            String sql = "DELETE FROM USERS WHERE ID=?";
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
