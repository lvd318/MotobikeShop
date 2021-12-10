/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.sun.prism.PresentableState;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dinhp
 */
public class XeMay {
    private String maXe;
    private String tenXe;
    private String maHX;
    private int soLuong;
    private int giaNhap;
    private int giaBan;
    private String phanKhoi;

    public XeMay() {
    }

    public XeMay(String maXe, String tenXe, String maHX, int soLuong, int giaNhap, int giaBan, String phanKhoi) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.maHX = maHX;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.phanKhoi = phanKhoi;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getMaHX() {
        return maHX;
    }

    public void setMaHX(String maHX) {
        this.maHX = maHX;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public String getPhanKhoi() {
        return phanKhoi;
    }

    public void setPhanKhoi(String phanKhoi) {
        this.phanKhoi = phanKhoi;
    }
    
    public static void insertXe(XeMay xe){
        Connection conn = ConnectDB.createCon();
        String sqlString = "insert into XE values (?,?,?,?,?,?,?)";
        
        try {
        PreparedStatement pres = conn.prepareStatement(sqlString);
        pres.setString(1, xe.maXe);
        pres.setString(2, xe.tenXe);
        pres.setString(3, xe.maHX);
        pres.setInt(4, xe.soLuong);
        pres.setInt(5, xe.giaNhap);
        pres.setInt(6, xe.giaBan);
        pres.setString(7, xe.phanKhoi);
        
        pres.executeUpdate();
        
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void updateXe(XeMay xe){
        Connection conn = ConnectDB.createCon();
        String sqlString = "update XE set MAXE=?,TENXE=?,MAHX=?,SOLUONG=?,GIANHAP=?,GIABAN=?,PHANKHOI=? "
                + "where MAXE=?";
        try {
        PreparedStatement pres = conn.prepareStatement(sqlString);
        pres.setString(1, xe.maXe);
        pres.setString(2, xe.tenXe);
        pres.setString(3, xe.maHX);
        pres.setInt(4, xe.soLuong);
        pres.setInt(5, xe.giaNhap);
        pres.setInt(6, xe.giaBan);
        pres.setString(7, xe.phanKhoi);
        pres.setString(8, xe.maXe);
        
        pres.executeUpdate();
        
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void deleteXe(String maXe){
        Connection conn = ConnectDB.createCon();
        String sqlString = "delete from XE where MAXE =?" ;
        try {
        PreparedStatement pres = conn.prepareStatement(sqlString);
        pres.setString(1, maXe);
        
        pres.executeUpdate();
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static List<XeMay> findAll(){
        List<XeMay> xeList = new ArrayList<>();
        
        Connection conn = ConnectDB.createCon();
        Statement statement = null;
        
        try{          
            String sql = "select * from XE";
            statement = conn.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                XeMay xe = new XeMay(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4), rs.getInt(5),
                rs.getInt(6), rs.getString(7));
                
                xeList.add(xe);
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
        
        return xeList;
    }
    
    public static List<XeMay> findByHX(String maHX){
        List<XeMay> xeList = new ArrayList<>();
        
        Connection conn = ConnectDB.createCon();
        Statement statement = null;
        
        try{          
            String sql = "select * from XE where MAHX =?";
            PreparedStatement pres = conn.prepareStatement(sql);
            pres.setString(1, maHX);
            
            ResultSet rs = pres.executeQuery();
            
            while(rs.next()){
                XeMay xe = new XeMay(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4), rs.getInt(5),
                rs.getInt(6), rs.getString(7));
                
                xeList.add(xe);
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
        
        return xeList;
    }
    
    public static List<XeMay> findBySL(){
        List<XeMay> xeList = new ArrayList<>();
        
        Connection conn = ConnectDB.createCon();
        Statement statement = null;
        
        try{          
            String sql = "select * from XE where SOLUONG < 10"; // sap het 
            statement = conn.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                XeMay xe = new XeMay(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4), rs.getInt(5),
                rs.getInt(6), rs.getString(7));
                
                xeList.add(xe);
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
        
        return xeList;
    }
    
    
}
