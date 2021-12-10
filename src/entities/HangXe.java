/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dinhp
 */
public class HangXe {
    private String maHX;
    private String tenHX;

    public HangXe() {
    }

    
    public HangXe(String maHX, String tenHX) {
        this.maHX = maHX;
        this.tenHX = tenHX;
    }

    public String getMaHX() {
        return maHX;
    }

    public void setMaHX(String maHX) {
        this.maHX = maHX;
    }

    public String getTenHX() {
        return tenHX;
    }

    public void setTenHX(String tenHX) {
        this.tenHX = tenHX;
    }
    
    public static void insertHX(HangXe hx){
        Connection conn = ConnectDB.createCon();
        String sqlString = "insert into HANGXE values(?,?)";
        try {
        PreparedStatement pres = conn.prepareStatement(sqlString);
        pres.setString(1, hx.getMaHX());
        pres.setString(2,hx.getTenHX());
        
        pres.executeUpdate();
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void updateHX(HangXe hx){
        Connection conn = ConnectDB.createCon();
        String sqlString = "update HANGXE set TENHX =? where MAHX =?";
        try {
        PreparedStatement pres = conn.prepareStatement(sqlString);
        pres.setString(2, hx.getMaHX());
        pres.setString(1,hx.getTenHX());
        
        pres.executeUpdate();
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void deleteHX(String maHX){
        Connection conn = ConnectDB.createCon();
        String sqlString = "delete from HANGXE where MAHX =?";
        try {
        PreparedStatement pres = conn.prepareStatement(sqlString);
        pres.setString(1, maHX);
        pres.executeUpdate();
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static List<HangXe> findAll(){
        List<HangXe> hangxeList = new ArrayList<>();
        
        Connection conn = ConnectDB.createCon();
        Statement statement = null;
        
        try{          
            String sql = "select * from HANGXE";
            statement = conn.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                HangXe hx = new HangXe(rs.getString(1), rs.getString(2));
                
                hangxeList.add(hx);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                }
            }
        
        return hangxeList;
    }
}
