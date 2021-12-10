/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dinhp
 */
public class HoaDon {
    private String maHD;
    private Date ngayLap;
    private int giaTri;

    public HoaDon() {
    }

    public HoaDon(String maHD, Date ngayLap, int giaTri) {
        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.giaTri = giaTri;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }
    
     public static void insertHD(HoaDon hd){
        Connection conn = ConnectDB.createCon();
        String sqlString = "insert into HOADON values (?,?,?)";
        
        try {
        PreparedStatement pres = conn.prepareStatement(sqlString);
        pres.setString(1, hd.getMaHD());
        pres.setDate(2, (java.sql.Date) hd.getNgayLap());
        pres.setInt(3, hd.getGiaTri());
        
        pres.executeUpdate();
        
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void updateHD(HoaDon hd){
        Connection conn = ConnectDB.createCon();
        String sqlString = "update HOADON set MAHD=?,NGAYLAP=?,GIATRI=?"
                + "where MAHD=?";
        try {
        PreparedStatement pres = conn.prepareStatement(sqlString);
        pres.setString(1, hd.getMaHD());
        pres.setDate(2, (java.sql.Date) hd.getNgayLap());
        pres.setInt(3, hd.getGiaTri());
        pres.setString(4, hd.getMaHD());

        pres.executeUpdate();
        
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void deleteHD(String maHD){
        Connection conn = ConnectDB.createCon();
        try {
        PreparedStatement pres = conn.prepareStatement("delete from HOADON where MAHD =?");
        pres.setString(1, maHD);
        
        pres.executeUpdate();
        
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static List<HoaDon> findAll(){
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        List<HoaDon> hoaDonList = new ArrayList<>();
        
        Connection conn = ConnectDB.createCon();
        Statement statement = null;
        
        try{          
            String sql = "select * from HOADON";
            PreparedStatement pres = conn.prepareStatement(sql);
            
            ResultSet rs = pres.executeQuery();
            
            while(rs.next()){
                HoaDon hd = new HoaDon(rs.getString(1),  fm.parse(rs.getString(2)) ,rs.getInt(3));

                hoaDonList.add(hd);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                }
            }
        
        return hoaDonList;
    }
    
    public static List<HoaDon> findByMonth(String thang, String nam){
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        List<HoaDon> hoaDonList = new ArrayList<>();
        
        Connection conn = ConnectDB.createCon();
        Statement statement = null;
        
        try{          
            String sql = "select * from HOADON where cast(strftime('%m', NGAYLAP) as Integer) =?"
                    + " and cast(strftime('%Y', NGAYLAP) as Integer)=?";
            PreparedStatement pres = conn.prepareStatement(sql);
            pres.setString(1, thang);
            pres.setString(2, nam);
            
            ResultSet rs = pres.executeQuery();
            
            while(rs.next()){
                HoaDon hd = new HoaDon(rs.getString(1),  fm.parse(rs.getString(2)) ,rs.getInt(3));

                hoaDonList.add(hd);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                }
            }
        
        return hoaDonList;
    }
    public static void updateGiaTri(String maHD){
        Connection conn = ConnectDB.createCon();
        Statement statement = null;
        
        try{
            String sqlString = "update HOADON set GIATRI=(select sum((ct.SOLUONG)*(xe.GIABAN))\n" +
"      from HOADON as hd, CTHD as ct, XE as xe\n" +
"      where hd.MAHD = ct.MAHD and ct.MAXE = xe.MAXE and hd.MAHD =?\n" +
"      ) where MAHD=?";
            PreparedStatement pres = conn.prepareStatement(sqlString);
            pres.setString(1, maHD);
            pres.setString(2, maHD);
            
            pres.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                }
            }
    }
}
