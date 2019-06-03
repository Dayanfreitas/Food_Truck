/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dayan Orlando de Freitas
 */

public class ConnectionFactory {

	/**
	 * <code> public Connection getConnection()</code>
	 * @return Retorna a conexão com a base de dados; 
	 */
	public Connection getConnection() {
        try {
            String host = "jdbc:mysql://localhost/food_truck?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(host, user, password);
            return connection;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}
