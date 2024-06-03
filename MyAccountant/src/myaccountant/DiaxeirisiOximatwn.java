package myaccountant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static myaccountant.Login.conn;
import static myaccountant.Login.username;

public class DiaxeirisiOximatwn extends javax.swing.JFrame 
{
    public DiaxeirisiOximatwn() 
    {
        initComponents();
        loadOximata();
    }
    
    private void loadOximata() 
    {
        String id_query = "SELECT ox_onoma,pinakida,afm_idioti,username_idioti,katastasi,kostos_telon FROM oxima INNER JOIN idiotis ON ox_username_pelati = username_idioti WHERE idiotis_username_logisti = ?";
            
        try 
        {
            PreparedStatement pst = conn.prepareStatement(id_query);
            
            pst.setString(1, username); 
            
            ResultSet rs = pst.executeQuery();
            
            DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
            
            tblModel.setRowCount(0); 
            
            while(rs.next())
            {
                String id_ox_onoma = rs.getString("ox_onoma");
                String id_pinakida = rs.getString("pinakida");
                String id_afm = rs.getString("afm_idioti");
                String id_username = rs.getString("username_idioti");
                String id_katastasi = rs.getString("katastasi");
                String id_teli = rs.getString("kostos_telon");
          
                String tbData[] = {id_ox_onoma, id_pinakida, id_afm, id_username, id_katastasi, id_teli};
          
                tblModel.addRow(tbData); 
            }
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(this, "Σφάλμα ανάκτησης δεδομένων: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
        
        String epix_query = "SELECT ox_onoma,pinakida,afm_epixeirisis,username_epixeirisis,katastasi,kostos_telon FROM oxima INNER JOIN epixeirisi ON ox_username_pelati = username_epixeirisis WHERE epix_username_logisti = ?";
            
        try 
        {
            PreparedStatement pst = conn.prepareStatement(epix_query);
            
            pst.setString(1, username); 
            
            ResultSet rs = pst.executeQuery();
            
            DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
            
            while(rs.next())
            {
                String epix_ox_onoma = rs.getString("ox_onoma");
                String epix_pinakida = rs.getString("pinakida");
                String epix_afm = rs.getString("afm_epixeirisis");
                String epix_username = rs.getString("username_epixeirisis");
                String epix_katastasi = rs.getString("katastasi");
                String epix_teli = rs.getString("kostos_telon");
          
                String tbData[] = {epix_ox_onoma, epix_pinakida, epix_afm, epix_username, epix_katastasi, epix_teli};
          
                tblModel.addRow(tbData); 
            }
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(this, "Σφάλμα ανάκτησης δεδομένων: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void EnimerosiOximatos() 
    {
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) 
        {
            String oxima_onoma = jTextField2.getText();
            String ox_pinakida = jTextField3.getText();
            String username_pelati = jTextField4.getText();
            int ox_teli = Integer.parseInt(jTextField6.getText());
            
            String insertSQL = "INSERT INTO oxima VALUES (?, ?, ?, DEFAULT, ?)";
        
            try 
            {
                PreparedStatement pstmt = conn.prepareStatement(insertSQL); 
            
                pstmt.setString(1, oxima_onoma);
                pstmt.setString(2, ox_pinakida);
                pstmt.setInt(3, ox_teli);
                pstmt.setString(4, username_pelati);
            
                pstmt.executeUpdate();
                
                loadOximata();
            
                JOptionPane.showMessageDialog(this, "Το όχημα προσθέθηκε!", "Update", JOptionPane.INFORMATION_MESSAGE);  
            }
            catch (SQLException e) 
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Σφάλμα κατά την εισαγωγή στη βάση δεδομένων: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }            
            
            return;
        }
        
        String old_ox_pinakida = jTable1.getValueAt(selectedRow, 1).toString();
        
        String ox_onoma = jTextField2.getText();
        String ox_pinakida = jTextField3.getText();
        String ox_username_pelati = jTextField4.getText();
        int ox_kostos_telon = Integer.parseInt(jTextField6.getText());
         
        String update_query = "UPDATE oxima SET ox_onoma  = ?, pinakida = ?, kostos_telon = ?, ox_username_pelati = ? WHERE pinakida = ?";

        try
        {
             PreparedStatement pstmt = conn.prepareStatement(update_query);
          
            pstmt.setString(1, ox_onoma);
            pstmt.setString(2, ox_pinakida);
            pstmt.setInt(3, ox_kostos_telon);
            pstmt.setString(4, ox_username_pelati);
            pstmt.setString(5, old_ox_pinakida);
        
            pstmt.executeUpdate();
            
            loadOximata();
            
            JOptionPane.showMessageDialog(this, "Οι αλλαγές ήταν επιτυχής!");
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Σφάλμα κατά την ενημέρωση της βάσης δεδομένων: " + e.getMessage());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Όχημα", "Πινακίδα", "ΑΦΜ", "Username", "Κατάσταση", "Τέλη"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton8.setBackground(new java.awt.Color(255, 0, 0));
        jButton8.setText("Επιστροφή");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 51, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setText("Διαχείριση Οχημάτων");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton10.setBackground(new java.awt.Color(0, 204, 255));
        jButton10.setText("Αλλαγή Κατάστασης");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel2.setText("Όνομα Οχήματος:");

        jButton2.setBackground(new java.awt.Color(0, 255, 102));
        jButton2.setText("Ενημέρωση οχήματος");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Πινακίδα:");

        jLabel6.setText("Όνομα χρήστη:");

        jLabel8.setText("Τέλη:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jButton10))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(44, 44, 44)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(25, 25, 25))))
            .addGroup(layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(32, 32, 32)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.dispose();
        
        Logistis logistis = new Logistis();
        
        logistis.setLocationRelativeTo(null);
        
        logistis.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       EnimerosiOximatos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(DiaxeirisiOximatwn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiaxeirisiOximatwn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiaxeirisiOximatwn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiaxeirisiOximatwn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DiaxeirisiOximatwn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
