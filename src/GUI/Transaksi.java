/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Component;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ariff
 */
public class Transaksi extends javax.swing.JFrame {

    /**
     * Creates new form Transaksi
     */
    public Transaksi() {
        initComponents();
        load_data();
        IDOtomatis();
    }
    
    public void load_data() {
        try {
            Connection kon = koneksi.koneksiDb();
            Object header[] = {"ID TRANSAKSI", "ID PELANGGAN", "WAKTU MULAI", "WAKTU SELESAI"};
            DefaultTableModel data = new DefaultTableModel(null, header);
            jTable1.setModel(data);
            String sql_data = "SELECT * FROM transaksi";

            Statement st = kon.createStatement();
            ResultSet rs = st.executeQuery(sql_data);
            while (rs.next()) {
                String d1 = rs.getString(1);
                String d2 = rs.getString(2);
                String d3 = rs.getString(3);
                String d4 = rs.getString(4);

                String d[] = {d1, d2, d3, d4};
                data.addRow(d);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void IDOtomatis() {
        try {
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            String sql_id = "SELECT * FROM transaksi ORDER BY id_transaksi DESC LIMIT 1";
            ResultSet rs = st.executeQuery(sql_id);
            if (rs.next()) {
                String id_transaksi = rs.getString("id_transaksi");
                int counter = Integer.parseInt(id_transaksi.replaceAll("[^0-9]", "")) + 1;
                String AN = String.format("%05d", counter); // Format ID dengan 5 digit angka
                jTextField1.setText("A" + AN);
            } else {
                jTextField1.setText("A00001");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        btnKeluar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnTampil = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setPreferredSize(new java.awt.Dimension(705, 625));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("ID Pelanggan");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel4.setText("Waktu Mulai");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 121, -1));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 164, -1));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 121, -1));
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 164, -1));

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        jPanel2.add(btnKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, -1, -1));

        jLabel1.setText("ID Transaksi");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 650, 216));

        jLabel2.setText("Waktu Selesai");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/add.png"))); // NOI18N
        btnTambah.setText("Tambah Data");
        btnTambah.setMaximumSize(new java.awt.Dimension(187, 71));
        btnTambah.setPreferredSize(new java.awt.Dimension(177, 73));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnTampil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/eye.png"))); // NOI18N
        btnTampil.setText("Tampilkan Data");
        btnTampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTampilActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/refresh.png"))); // NOI18N
        btnUpdate.setText("Update Data");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/bin.png"))); // NOI18N
        btnHapus.setText("Hapus Data");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTampil)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnHapus)
                .addGap(86, 86, 86))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTampil)
                    .addComponent(btnUpdate)
                    .addComponent(btnHapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 670, -1));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 705, 446));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Transaksi.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 160));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();

        if (selectedRowIndex != -1) {
            String id_transaksi = model.getValueAt(selectedRowIndex, 0).toString(); // Ambil ID dari baris yang dipilih
            try {
                Connection kon = koneksi.koneksiDb();
                Statement st = kon.createStatement();
                String sql = "DELETE FROM transaksi WHERE id_transaksi='" + id_transaksi + "'";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                load_data(); // Setelah menghapus data, muat ulang tabel
                IDOtomatis(); // Perbarui ID otomatis
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // Ambil nilai dari JTextField
        String id_transaksi = jTextField1.getText();
        String id_pelanggan = jTextField2.getText();
        String waktu_mulai = jTextField3.getText();
        String waktu_selesai = jTextField4.getText();

        try {
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            String sql = "UPDATE transaksi SET id_pelanggan='" + id_pelanggan + "', waktu_mulai='" + waktu_mulai + "', waktu_selesai='" + waktu_selesai + "' WHERE id_transaksi='" + id_transaksi + "'";
            int rowsAffected = st.executeUpdate(sql);

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
                load_data(); // Muat ulang tabel setelah pembaruan
                btnUpdate.setEnabled(false); // Matikan kembali tombol Update setelah perubahan selesai
                clearFields(); // Panggil method clearFields untuk membersihkan JTextField
            } else {
                JOptionPane.showMessageDialog(null, "Gagal mengupdate data. Pastikan ID pelanggan yang dipilih benar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }

        private void clearFields() {
            jTextField1.setText(""); // Kosongkan ID transaksi
            jTextField2.setText(""); // Kosongkan ID pelanggan
            jTextField3.setText(""); // Kosongkan Waktu mulai
            jTextField4.setText(""); // Kosongkan Waktu selesai
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnTampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTampilActionPerformed
        // TODO add your handling code here:
        try {
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("Transaksi.jasper"), null, koneksi.getConnection());
            JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_btnTampilActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        String id_transaksi = jTextField1.getText();
        String id_pelanggan = jTextField2.getText();
        String waktu_mulai = jTextField3.getText();
        String waktu_selesai = jTextField4.getText();

        try {
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            String sql = "INSERT INTO transaksi (id_transaksi, id_pelanggan, waktu_mulai, waktu_selesai) VALUES ('" + id_transaksi+ "', '" + id_pelanggan + "', '" + waktu_mulai + "', '" + waktu_selesai + "')";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
            load_data(); // Setelah menambah data, muat ulang tabel
            IDOtomatis(); // Perbarui ID otomatis
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();

        // Cek jika baris telah dipilih
        if (selectedRowIndex >= 0) {
            // Aktifkan tombol Update jika baris dipilih
            btnUpdate.setEnabled(true);

            // Ambil data dari baris yang dipilih
            String id_transaksi = model.getValueAt(selectedRowIndex, 0).toString();
            String id_pelanggan = model.getValueAt(selectedRowIndex, 1).toString();
            String waktu_mulai = model.getValueAt(selectedRowIndex, 2).toString();
            String waktu_selesai = model.getValueAt(selectedRowIndex, 3).toString();

            // Masukkan data ke dalam JTextField
            jTextField1.setText(id_transaksi);
            jTextField2.setText(id_pelanggan);
            jTextField3.setText(waktu_mulai);
            jTextField4.setText(waktu_mulai);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // Kembali ke HalamanUtama
        HalamanUtama halamanUtama = new HalamanUtama();
        halamanUtama.setVisible(true);
        dispose(); // Menutup JFrame Pelanggan saat ini
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTampil;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
