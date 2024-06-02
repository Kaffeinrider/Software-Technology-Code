/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package myaccountant;
import static myaccountant.Login.conn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JTable;
import static myaccountant.Login.*;

/**
 *
 * @author vasil
 */
port static myaccountant.Login.conn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JTable;

public class EnimerosiEsodwnEksodwn extends javax.swing.JFrame {

    /**
     * Creates new form EnimerosiEsodwnEksodwn
     */
    public EnimerosiEsodwnEksodwn() {
        initComponents();
        loadEpixeiriseis();
    }
<<<<<<< Updated upstream
private void loadEpixeiriseis() {
        String query = "SELECT onoma_epixeirisis, poli, afm_epixeirisis FROM epixeirisi";

        try (
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
      DefaultTableModel tmodel1 = (DefaultTableModel)jTable2.getModel();
            while (rs.next()) {
                String onoma = rs.getString("onoma_epixeirisis");
                String poli = rs.getString("poli");
                String afm = rs.getString("afm_epixeirisis");
                
                tmodel1.addRow(new Object[]{onoma, poli, afm});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Σφάλμα κατά την φόρτωση δεδομένων: " + e.getMessage());
        }
    }
    private String getSelectedEpixeirisi() {
    int selectedRowIndex = jTable2.getSelectedRow();
    if (selectedRowIndex == -1) {
        return null;
    }
    DefaultTableModel tmodel1 = (DefaultTableModel) jTable2.getModel();
    return tmodel1.getValueAt(selectedRowIndex, 0).toString();
}
    private void ypovoliStoixeion() {
        // Παίρνουμε τις τιμές από τα πεδία κειμένου
      
        String esodaStr = jTextField3.getText();
        String exodaStr = jTextField2.getText();
       

    
        int esoda = Integer.parseInt(esodaStr);
        int exoda = Integer.parseInt(exodaStr);

        String insertQuery = "UPDATE INTO epixeirisi (esoda, exoda, username_epixeirisis) VALUES (?, ?, ?)";
=======
private void ypovoliStoixeion() {
        // Παίρνουμε τις τιμές από τα πεδία κειμένου
        String yp_afm = jTextField4.getText();
        String esodaStr = jTextField3.getText();
        String exodaStr = jTextField2.getText();
        String yp_username_epixeirisis = getSelectedEpixeirisi();

        int esoda = Integer.parseInt(esodaStr);
        int exoda = Integer.parseInt(exodaStr);
        

        String insertQuery = "INSERT INTO epixeirisi (yp_afm, esoda, exoda , yp_username_epixeirisis) VALUES (?, ?, ?, ?)";
>>>>>>> Stashed changes

        try (
             PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

<<<<<<< Updated upstream
           
            pstmt.setInt(1, esoda);
            pstmt.setInt(2, exoda);
         pstmt.setString(3, username);
=======
            pstmt.setString(1, yp_afm);
            pstmt.setInt(2, esoda);
            pstmt.setInt(3, exoda);            
         pstmt.setString(4, yp_username_epixeirisis);
>>>>>>> Stashed changes

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Η εισαγωγή ήταν επιτυχής!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Σφάλμα κατά την εισαγωγή στη βάση δεδομένων: " + e.getMessage());
        }
    }

    private void loadEpixeiriseis() {
        String query = "SELECT onoma_epixeirisis, poli, afm_epixeirisis FROM epixeirisi";

        try (
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String onoma = rs.getString("onoma_epixeirisis");
                String poli = rs.getString("poli");
                String afm = rs.getString("afm_epixeirisis");
                DefaultTableModel tmodel1 = (DefaultTableModel)jTable2.getModel();
                tmodel1.addRow(new Object[]{onoma, poli, afm});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Σφάλμα κατά την φόρτωση δεδομένων: " + e.getMessage());
        }
    }
    
    private String getSelectedEpixeirisi() {
    int selectedRowIndex = jTable2.getSelectedRow();
    if (selectedRowIndex == -1) {
        return null;
    }
    DefaultTableModel tmodel1 = (DefaultTableModel) jTable2.getModel();
    return tmodel1.getValueAt(selectedRowIndex, 0).toString();
} 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(51, 51, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 28)); // NOI18N
        jLabel1.setText("Ενημέρωση Εσόδων - Εξόδων Επιχείρησης");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Επιχειρήσεις"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        jLabel4.setText("Έξοδα:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Έσοδα:");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 255, 102));
        jButton2.setText("Υποβολή");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 0, 0));
        jButton8.setText("Ακύρωση");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.dispose();
            Logistis logistis = new Logistis();
            //center the window
            logistis.setLocationRelativeTo(null);
            // Show the login window
            logistis.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ypovoliStoixeion();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

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
            java.util.logging.Logger.getLogger(EnimerosiEsodwnEksodwn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnimerosiEsodwnEksodwn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnimerosiEsodwnEksodwn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnimerosiEsodwnEksodwn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnimerosiEsodwnEksodwn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
