package motobikeshop;


import entities.HoaDon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author dinhp
 */
public class CuaHangXeMayFrame extends javax.swing.JFrame {

    private QuanLiDanhMuc QuanLiDanhMucPanel = null;
    private QuanLiDonHang QuanLiDonHangPanel = null;
    private ThongKeBaoCao ThongKeBaoCaoPanel = null;
            
    public CuaHangXeMayFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        btnQuanLiDanhMuc = new javax.swing.JButton();
        btnQuanLiDonHang = new javax.swing.JButton();
        btnThongKeBaoCao = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý cửa hàng xe máy");

        jToolBar1.setRollover(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logo.png"))); // NOI18N
        jToolBar1.add(jLabel1);

        btnQuanLiDanhMuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Actions-view-choose-icon-24.png"))); // NOI18N
        btnQuanLiDanhMuc.setText("Quản lí danh mục ");
        btnQuanLiDanhMuc.setFocusable(false);
        btnQuanLiDanhMuc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQuanLiDanhMuc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnQuanLiDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLiDanhMucActionPerformed(evt);
            }
        });
        jToolBar1.add(btnQuanLiDanhMuc);

        btnQuanLiDonHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/quanlidonhang.png"))); // NOI18N
        btnQuanLiDonHang.setText("Quản lí đơn hàng");
        btnQuanLiDonHang.setFocusable(false);
        btnQuanLiDonHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQuanLiDonHang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnQuanLiDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLiDonHangActionPerformed(evt);
            }
        });
        jToolBar1.add(btnQuanLiDonHang);

        btnThongKeBaoCao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/thongkebaocao.png"))); // NOI18N
        btnThongKeBaoCao.setText("Thống kê báo cáo");
        btnThongKeBaoCao.setFocusable(false);
        btnThongKeBaoCao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThongKeBaoCao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThongKeBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeBaoCaoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnThongKeBaoCao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuanLiDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLiDanhMucActionPerformed
        if(QuanLiDanhMucPanel == null){
            QuanLiDanhMucPanel = new QuanLiDanhMuc();
            jTabbedPane1.add("Quản lí danh mục", QuanLiDanhMucPanel);
        }else {
            QuanLiDanhMucPanel.LoadDataHX();
            QuanLiDanhMucPanel.LoadDataXe("Tất cả");
        }
        jTabbedPane1.setSelectedComponent(QuanLiDanhMucPanel);
    }//GEN-LAST:event_btnQuanLiDanhMucActionPerformed

    private void btnQuanLiDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLiDonHangActionPerformed
        if(QuanLiDonHangPanel == null){
            QuanLiDonHangPanel = new QuanLiDonHang();
            jTabbedPane1.add("Quản lí đơn hàng", QuanLiDonHangPanel);
        }else{
            for(HoaDon hd: HoaDon.findAll())
        {
            HoaDon.updateGiaTri(hd.getMaHD());
        }
        }
        jTabbedPane1.setSelectedComponent(QuanLiDonHangPanel);
    }//GEN-LAST:event_btnQuanLiDonHangActionPerformed

    private void btnThongKeBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeBaoCaoActionPerformed
        if(ThongKeBaoCaoPanel == null){
            ThongKeBaoCaoPanel = new ThongKeBaoCao();
            jTabbedPane1.add("Thống kê báo cáo", ThongKeBaoCaoPanel);
        }else{
            ThongKeBaoCaoPanel.BaoCao1();
        }
        jTabbedPane1.setSelectedComponent(ThongKeBaoCaoPanel);
    }//GEN-LAST:event_btnThongKeBaoCaoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CuaHangXeMayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CuaHangXeMayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CuaHangXeMayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CuaHangXeMayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CuaHangXeMayFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuanLiDanhMuc;
    private javax.swing.JButton btnQuanLiDonHang;
    private javax.swing.JButton btnThongKeBaoCao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
