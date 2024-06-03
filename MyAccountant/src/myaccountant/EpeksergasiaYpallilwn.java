/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package myaccountant;

import static myaccountant.Login.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JTable;
/**
 *
 * @author vasil
 */
public class EpeksergasiaYpallilwn extends javax.swing.JFrame {
    
    private String selectedEpixeirisi;
    private String selectedEmployee;
    private String selectedEmployeeAfm;
    /**
     * Creates new form EpeksergasiaYpallilwn
     */
    public EpeksergasiaYpallilwn() {
        initComponents();
        loadEpixeiriseis();
        
            jTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            
                @Override
                 public void valueChanged(ListSelectionEvent event) {
                    if (!event.getValueIsAdjusting()) {
                     // Όταν ο χρήστης επιλέξει μια επιχείρηση
                          int selectedRow = jTable2.getSelectedRow();
                           if (selectedRow != -1) {
                                selectedEpixeirisi = jTable2.getValueAt(selectedRow, 0).toString();
                                loadYpalliloi();
                           }
                    }
                 }
            });
            
            // Προσθήκη ακροατή για τον πίνακα jTable1 για την επιλογή υπαλλήλου
jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (!event.getValueIsAdjusting()) {
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow != -1) {
                // Όταν ο χρήστης επιλέξει έναν υπάλληλο
                selectedEmployee = jTable1.getValueAt(selectedRow, 0).toString();
                selectedEmployeeAfm = getYpallilosAfm(selectedEmployee);
                
            }
        }
    }
});
    }
    
    
  
    private void loadEpixeiriseis() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0); // Καθαρισμός του πίνακα

        try {
            // Εκτέλεση ερωτήματος στη βάση δεδομένων για να φορτωθούν οι επιχειρήσεις
            String query = "SELECT onoma_epixeirisis FROM epixeirisi WHERE epix_username_logisti = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            // Προσθήκη κάθε επιχείρησης στον πίνακα jTable2
            while (rs.next()) {
                String epixeirisi = rs.getString("onoma_epixeirisis"); // Υποθέτουμε ότι το όνομα της επιχείρησης είναι στη στήλη "Name"
                model.addRow(new Object[]{epixeirisi});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Σφάλμα κατά τη φόρτωση των επιχειρήσεων: " + e.getMessage());
        }
    }
    
    // Ορίζουμε τη μέθοδο loadYpalliloi για τη φόρτωση των υπαλλήλων της επιλεγμένης επιχείρησης
    private void loadYpalliloi() {
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Καθαρίζουμε τον πίνακα

        try {
            // Εκτέλεση ερωτήματος στη βάση δεδομένων για να φορτωθούν οι υπάλληλοι της επιλεγμένης επιχείρησης
            String query = "SELECT CONCAT(yp_onoma, ' ', yp_eponimo) AS fullname FROM ypallilos INNER JOIN epixeirisi ON ypallilos.yp_username_epixeirisis = epixeirisi.username_epixeirisis WHERE epixeirisi.onoma_epixeirisis = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, selectedEpixeirisi);
            ResultSet rs = pst.executeQuery();

            // Προσθήκη κάθε υπαλλήλου στον πίνακα jTable1
            while (rs.next()) {
                String fullname = rs.getString("fullname");
                model.addRow(new Object[]{fullname});
            }
        } 
        
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Σφάλμα κατά τη φόρτωση των υπαλλήλων");
        }
    }

    private String getYpallilosAfm(String fullname) {
        String afm = null;
        try {
            String[] parts = fullname.split(" ");
            if (parts.length >= 2) {
                String onoma = parts[0];
                String eponimo = parts[1];

                String query = "SELECT yp_afm FROM ypallilos WHERE yp_onoma = ? AND yp_eponimo = ?";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, onoma);
                pst.setString(2, eponimo);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    afm = rs.getString("yp_afm");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Σφάλμα κατά τη λήψη του AFM του υπαλλήλου: " + e.getMessage());
        }
        return afm;
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
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(51, 51, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 28)); // NOI18N
        jLabel1.setText("Επεξεργασία στοιχείων Υπάλληλου Επιχείρησης");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setText("Επώνυμο Υπαλλήλου");

        jLabel4.setText("Όνομα Υπαλλήλου");

        jLabel7.setText("Μεικτά");

        jLabel5.setText("Ασφάλιση");

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Υπάλληλοι"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Επιχειρήσεις"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(0, 54, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(37, 37, 37)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 32, Short.MAX_VALUE))))
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
        String name = jTextField2.getText();
    String surname = jTextField4.getText();
    String meikta = jTextField5.getText();
    String asfaleia = jTextField3.getText();
    


// Εμφάνιση της τιμής του selectedEmployee για έλεγχο
System.out.println("Selected Employee: " + selectedEmployee);


// Ενημέρωση των στοιχείων του υπαλλήλου στη βάση δεδομένων
try {
    String query = "UPDATE ypallilos SET yp_onoma = ?, yp_eponimo = ?, meikta = ?, asfalisi = ? WHERE yp_afm = ?";
    PreparedStatement pst = conn.prepareStatement(query);
    pst.setString(1, name);
    pst.setString(2, surname);
    pst.setString(3, meikta);
    pst.setString(4, asfaleia);
    pst.setString(5, selectedEmployeeAfm);
    pst.executeUpdate();
    
    JOptionPane.showMessageDialog(this, "Τα στοιχεία του υπαλλήλου ενημερώθηκαν επιτυχώς.");
} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Σφάλμα κατά την ενημέρωση των στοιχείων του υπαλλήλου: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(EpeksergasiaYpallilwn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EpeksergasiaYpallilwn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EpeksergasiaYpallilwn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EpeksergasiaYpallilwn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EpeksergasiaYpallilwn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
