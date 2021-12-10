package entities;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dinhp
 */
public class ConnectDB {
    public ConnectDB() {
    }
    
    public static Connection createCon(){
        Connection conn = null;
        String url = "jdbc:sqlite:database/CuaHangXeMay.db";

        try {
            conn = DriverManager.getConnection(url);
            return conn;
        } catch (SQLException se) {
            System.out.println("." + se.getMessage());
        }
        return conn;
    }
}
