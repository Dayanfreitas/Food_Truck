package com.catolicasc.foodtruck.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;


import com.catolicasc.foodtruck.ConnectionFactory;
import com.catolicasc.foodtruck.models.Orders;


public class OrdersRepository {
	 	private Connection connection;
	    private static final String TABLE  = "ORDERS";
	    private static final String CREATE = "INSERT INTO "+TABLE+"(NAME, EMAIL) VALUES(?, ?)";
	    private static final String READ   = "SELECT ID,CUSTOMERID,SELLERID,ORDERDATE,PREPAREDDATE,DELIVERYDATE FROM "+TABLE;
	    private static final String UPDATE = "UPDATE "+TABLE+" SET NAME=?, EMAIL=? WHERE ID=?";
	    private static final String DELETE = "DELETE FROM "+TABLE+" WHERE ID=?";
	    private static final String GET_ID = "SELECT ID,NAME,EMAIL FROM "+TABLE+" WHERE id = ?";
	    
        public OrdersRepository() {
            connection = new ConnectionFactory().getConnection();
        }
        
        public ArrayList<Orders> getAllOrders(){
            try {
                ArrayList<Orders> orders = new ArrayList<>();
                
                String sql = READ;
                Statement selectStmt = connection.createStatement();
                ResultSet resultSet  = selectStmt.executeQuery(sql);
                
                while(resultSet.next()) {
                	int       id = resultSet.getInt("ID");
                    int  idCliente  = resultSet.getInt("CUSTOMERID");
                    int  idAtentente= resultSet.getInt("SELLERID");
                    Date dataPedido = resultSet.getDate("ORDERDATE");
                    Date prepared_date = resultSet.getDate("PREPAREDDATE");
                    Date delivery_date = resultSet.getDate("DELIVERYDATE");

                    Orders order = new Orders();
                    order.setId(id);
                    order.getCustomers().getCustomers().setId(idCliente);
                    order.getSeller().setId(idAtentente);
                    order.setOrder_date(dataPedido);
                    order.setPrepared_date(prepared_date);
                    order.setDelivery_date(delivery_date);
//                    
                    orders.add(order);
                }
                return orders;
            }catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        
}
