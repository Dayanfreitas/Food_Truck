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
    private static final String TABLE  = "USERS";
    private static final String CREATE = "INSERT INTO "+TABLE+"(NAME, EMAIL) VALUES(?, ?)";
    private static final String READ   = "SELECT ID,NAME,EMAIL FROM "+TABLE;
    private static final String UPDATE =  TABLE+" SET NAME=?, EMAIL=? WHERE ID=?";
    private static final String DELETE = "DELETE FROM "+TABLE+" WHERE ID=?";
    private static final String GET_ID = "SELECT ID,NAME,EMAIL FROM "+TABLE+" WHERE id = ?";
    public UserRepository() {
        connection = new ConnectionFactory().getConnection();
    }
    
    public ArrayList<User> getAllUsers(){
        try {
            ArrayList<User>  users = new ArrayList<>();
            
            String sql = READ;
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet  = selectStmt.executeQuery(sql);
            
            while(resultSet.next()){
                int       id = resultSet.getInt("ID");
                String  name = resultSet.getString("NAME");
                String email = resultSet.getString("EMAIL");
                
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
    
    /**
     * Busca um usuário pelo ID
     * @param userId  
     * @return 
     * {@link User} 
     */
    public User getUserById(Integer userId){
        try {
            String sql = GET_ID;
            PreparedStatement selectStmt = connection.prepareStatement(sql);
            selectStmt.setInt(1, userId);
            ResultSet resultSet = selectStmt.executeQuery();
            
            User user = null;
            
            if(resultSet.first()){
                user = new User();

                int id 		 = resultSet.getInt("ID");
                String name  = resultSet.getString("NAME");
                String email = resultSet.getString("EMAIL");
                
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
            String sql = CREATE;
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
            String sql = UPDATE;
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
