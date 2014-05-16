/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pcego
 */
public class ConnectionDb {

    private static Connection connection = null;
    private static final String URL = "jdbc:mysql://localhost:3306/datastore";
    private static final String USER = "root";
    private static final String PWD = "1234";

    private ConnectionDb() {

    }

    public static Connection getConnectionDs() {

        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PWD);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return connection;
    }
}
