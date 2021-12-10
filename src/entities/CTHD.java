/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author dinhp
 */
public class CTHD {
    private String maHD;
    private String maXe;
    private int soLuong;

    public CTHD() {
    }

    public CTHD(String maHD, String maXe, int soLuong) {
        this.maHD = maHD;
        this.maXe = maXe;
        this.soLuong = soLuong;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public static void insertCTHD(CTHD cthd){
        Connection conn = ConnectDB.createCon();
        String sqlString = "insert into CTHD values (?,?,?)";
        
        try {
        PreparedStatement pres = conn.prepareStatement(sqlString);
        pres.setString(1, cthd.getMaHD());
        pres.setString(2, cthd.getMaXe());
        pres.setInt(3, cthd.getSoLuong());
        
        pres.executeUpdate();
        
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void updateCTHD(CTHD cthd){
        Connection conn = ConnectDB.createCon();
        String sqlString = "update CTHD set SOLUONG =?"
                + "where MAHD=? and MAXE=?";
        try {
        PreparedStatement pres = conn.prepareStatement(sqlString);
        pres.setInt(1, cthd.getSoLuong());
        pres.setString(2, cthd.getMaHD());
        pres.setString(3, cthd.getMaXe());

        pres.executeUpdate();
        
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void deleteCTHD(String maHD, String maXe){
        Connection conn = ConnectDB.createCon();
        try {
        PreparedStatement pres = conn.prepareStatement("delete from CTHD where MAHD =? and MAXE=?");
        pres.setString(1, maHD);
        pres.setString(2, maXe);
        pres.executeUpdate();
        
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void deleteCTHD(String maHD){
        Connection conn = ConnectDB.createCon();
        try {
        PreparedStatement pres = conn.prepareStatement("delete from CTHD where MAHD =?");
        pres.setString(1, maHD);
        pres.executeUpdate();
        
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
