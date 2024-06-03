package myaccountant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static myaccountant.Login.*;

public class Ipovoli_diloseon extends javax.swing.JFrame 
{
    private Blob arxeio_forologikis;
    private String onoma_epilegmenou_arxeiou_forologikis;
    private Blob arxeio_ekkatharistikou;
    private String onoma_epilegmenou_arxeiou_ekkatharistikou;
    
    public Ipovoli_diloseon() 
    {
        initComponents();
        load_idiotes();
    }
    
    private void load_idiotes()
    {
        String query = "SELECT onoma_idioti,eponimo_idioti,username_idioti,email_idioti FROM idiotis INNER JOIN logistis ON username_logisti = idiotis_username_logisti WHERE idiotis_username_logisti = ?";
            
        try 
        {
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setString(1, username); 
            
            ResultSet rs = pst.executeQuery();
            
            DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
            
            tblModel.setRowCount(0); 
            
            while(rs.next())
            {
                String onoma = rs.getString("onoma_idioti");
                String eponimo = rs.getString("eponimo_idioti");
                String uname_idioti = rs.getString("username_idioti");
                String email = String.valueOf(rs.getString("email_idioti"));
          
                String tbData[] = {onoma , eponimo, uname_idioti, email};
          
                tblModel.addRow(tbData); 
            }
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(this, "Σφάλμα ανάκτησης δεδομένων: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    private void load_forologikes(String uname_idioti)
    {
        String query = "SELECT for_dil_id,for_onoma_arxeiou FROM forologiki_dilosi WHERE for_dil_username_idioti = ?";
   
        try 
        {
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setString(1, uname_idioti); 
            
            ResultSet rs = pst.executeQuery();
            
            DefaultTableModel tblModel = (DefaultTableModel) jTable2.getModel();
            
            jLabel5.setText("Φορολογικές Δηλώσεις");
            
            tblModel.setRowCount(0); 
            
            while(rs.next())
            {
                String id = rs.getString("for_dil_id");
                String onoma_arxeiou = rs.getString("for_onoma_arxeiou");
          
                String tbData[] = {id, onoma_arxeiou};
          
                tblModel.addRow(tbData); 
            }
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(this, "Σφάλμα ανάκτησης δεδομένων: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    private void provoli_forologikes()
    {
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) 
        {
            JOptionPane.showMessageDialog(this, "Παρακαλώ επιλέξτε ένα ιδιώτη από τον πίνακα!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String uname_idioti = jTable1.getValueAt(selectedRow, 2).toString();
        
        String query = "SELECT for_dil_id,for_onoma_arxeiou FROM forologiki_dilosi WHERE for_dil_username_idioti = ?";
   
        try 
        {
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setString(1, uname_idioti); 
            
            ResultSet rs = pst.executeQuery();
            
            DefaultTableModel tblModel = (DefaultTableModel) jTable2.getModel();
            
            jLabel5.setText("Φορολογικές Δηλώσεις");
            
            tblModel.setRowCount(0); 
            
            while(rs.next())
            {
                String id = rs.getString("for_dil_id");
                String onoma_arxeiou = rs.getString("for_onoma_arxeiou");
          
                String tbData[] = {id, onoma_arxeiou};
          
                tblModel.addRow(tbData); 
            }
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(this, "Σφάλμα ανάκτησης δεδομένων: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    private void load_ekkatharistika(String uname_idioti)
    {
        String query = "SELECT ek_id,ek_onoma_arxeiou FROM ekkatharistiko WHERE ek_username_idioti = ?";
   
        try 
        {
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setString(1, uname_idioti); 
            
            ResultSet rs = pst.executeQuery();
            
            DefaultTableModel tblModel = (DefaultTableModel) jTable2.getModel();
            
            jLabel5.setText("Εκκαθαριστικά");
            
            tblModel.setRowCount(0); 
            
            while(rs.next())
            {
                String id = rs.getString("ek_id");
                String onoma_arxeiou = rs.getString("ek_onoma_arxeiou");
          
                String tbData[] = {id, onoma_arxeiou};
          
                tblModel.addRow(tbData); 
            }
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(this, "Σφάλμα ανάκτησης δεδομένων: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    private void provoli_ekkatharistika()
    {
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) 
        {
            JOptionPane.showMessageDialog(this, "Παρακαλώ επιλέξτε ένα ιδιώτη από τον πίνακα!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String uname_idioti = jTable1.getValueAt(selectedRow, 2).toString();
        
        String query = "SELECT ek_id,ek_onoma_arxeiou FROM ekkatharistiko WHERE ek_username_idioti = ?";
   
        try 
        {
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setString(1, uname_idioti); 
            
            ResultSet rs = pst.executeQuery();
            
            DefaultTableModel tblModel = (DefaultTableModel) jTable2.getModel();
            
            jLabel5.setText("Εκκαθαριστικά");
            
            tblModel.setRowCount(0); 
            
            while(rs.next())
            {
                String id = rs.getString("ek_id");
                String onoma_arxeiou = rs.getString("ek_onoma_arxeiou");
          
                String tbData[] = {id, onoma_arxeiou};
          
                tblModel.addRow(tbData); 
            }
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(this, "Σφάλμα ανάκτησης δεδομένων: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(51, 51, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 28)); // NOI18N
        jLabel1.setText("Υποβολή Δηλώσεων και Εκκαθαριστικών");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Όνομα", "Επώνυμο", "Username", "Email"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Όνομα αρχείου"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setText("Προβολή");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setText("Λήψη");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 153, 255));
        jButton3.setText("Προβολή");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 255));
        jButton4.setText("Λήψη");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 153, 255));
        jButton5.setText("Επιλέξτε Αρχείο");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 153, 255));
        jButton6.setText("Υποβολή");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Φορολογικές Δηλώσεις");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Εκκαθαριστικά");

        jButton7.setBackground(new java.awt.Color(0, 153, 255));
        jButton7.setText("Επιλέξτε Αρχείο");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 153, 255));
        jButton8.setText("Υποβολή");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 0, 0));
        jButton9.setText("Επιστροφή");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("ΙΔΙΩΤΕΣ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 267, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(73, 73, 73))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton3)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addGap(55, 55, 55)
                                                .addComponent(jButton2)))
                                        .addGap(42, 42, 42))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(85, 85, 85))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton6))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton7)
                                                .addGap(52, 52, 52)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jButton8)
                                                    .addComponent(jButton4))))
                                        .addGap(19, 19, 19))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton5)
                                    .addComponent(jButton6))
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton3)
                                    .addComponent(jButton4))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton7)
                                    .addComponent(jButton8)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        provoli_forologikes();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!"Φορολογικές Δηλώσεις".equals(jLabel5.getText())) 
        {
            JOptionPane.showMessageDialog(this, "Παρακαλώ κάντε προβολή φορολογικών δηλώσεων και επιλέξτε αρχείο πριν το κατέβασμά τους!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the selected row index
        int selectedRow = jTable2.getSelectedRow();

        // Check if a row is selected
        if (selectedRow == -1) 
        {
            JOptionPane.showMessageDialog(this, "Παρακαλώ επιλέξτε ένα αρχείο από τον πίνακα.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the ID from the selected row
        String id = jTable2.getValueAt(selectedRow, 0).toString();

        // Execute a query to retrieve the Blob data based on the selected ID
        String query = "SELECT forologiki_dilosi FROM forologiki_dilosi WHERE for_dil_id = ?";
        
        try 
        {
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, id);
            
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) 
            {
                // Get the Blob data from the result set
                Blob fileBlob = rs.getBlob("forologiki_dilosi");

                // Ask the user for the location to save the file
                JFileChooser fileChooser = new JFileChooser();
                
                int result = fileChooser.showSaveDialog(this);

                if (result == JFileChooser.APPROVE_OPTION) 
                {
                    File selectedFile = fileChooser.getSelectedFile();

                    try 
                    {
                        // Read the Blob data and save it to the selected location
                        InputStream inputStream = fileBlob.getBinaryStream();
                        FileOutputStream fileOutputStream = new FileOutputStream(selectedFile);

                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) 
                        {
                            fileOutputStream.write(buffer, 0, bytesRead);
                        }

                        fileOutputStream.close();
                        inputStream.close();

                        JOptionPane.showMessageDialog(this, "Το αρχείο κατέβηκε επιτυχώς.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } 
                    catch (IOException e) 
                    {
                        JOptionPane.showMessageDialog(this, "Σφάλμα κατά την κατέβαση του αρχείου: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } 
            else 
            {
                JOptionPane.showMessageDialog(this, "Δεν βρέθηκε αρχείο με το συγκεκριμένο ID!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch(SQLException e) 
        {
            JOptionPane.showMessageDialog(this, "Σφάλμα κατά την ανάκτηση του αρχείου: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        provoli_ekkatharistika();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (arxeio_ekkatharistikou == null) 
        {
            JOptionPane.showMessageDialog(this, "Δεν διαλέξατε αρχείο!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) 
        {
            JOptionPane.showMessageDialog(this, "Παρακαλώ επιλέξτε ένα ιδιώτη από τον πίνακα!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String uname_idioti = jTable1.getValueAt(selectedRow, 2).toString();

        String insertSQL = "INSERT INTO ekkatharistiko (ek_onoma_arxeiou , ekkatharistiko , ek_username_idioti ) VALUES (?, ?, ?)";
        
        try 
        {
            PreparedStatement pstmt = conn.prepareStatement(insertSQL); 
            
            pstmt.setString(1, onoma_epilegmenou_arxeiou_ekkatharistikou);
            pstmt.setBlob(2, arxeio_ekkatharistikou);
            pstmt.setString(3, uname_idioti);
            
            pstmt.executeUpdate();
            
            jButton7.setText("Επιλέξτε Αρχείο");
            load_ekkatharistika(uname_idioti);
            
            JOptionPane.showMessageDialog(this, "Το αρχείο ανέβηκε!", "Update", JOptionPane.INFORMATION_MESSAGE);  
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Σφάλμα κατά την εισαγωγή στη βάση δεδομένων: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (arxeio_forologikis == null) 
        {
            JOptionPane.showMessageDialog(this, "Δεν διαλέξατε αρχείο!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) 
        {
            JOptionPane.showMessageDialog(this, "Παρακαλώ επιλέξτε ένα ιδιώτη από τον πίνακα!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String uname_idioti = jTable1.getValueAt(selectedRow, 2).toString();

        String insertSQL = "INSERT INTO forologiki_dilosi (for_onoma_arxeiou, forologiki_dilosi, for_dil_username_idioti) VALUES (?, ?, ?)";
        
        try 
        {
            PreparedStatement pstmt = conn.prepareStatement(insertSQL); 
            
            pstmt.setString(1, onoma_epilegmenou_arxeiou_forologikis);
            pstmt.setBlob(2, arxeio_forologikis);
            pstmt.setString(3, uname_idioti);
            
            pstmt.executeUpdate();
            
            jButton5.setText("Επιλέξτε Αρχείο");
            load_forologikes(uname_idioti);
            
            JOptionPane.showMessageDialog(this, "Το αρχείο ανέβηκε!", "Update", JOptionPane.INFORMATION_MESSAGE);  
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Σφάλμα κατά την εισαγωγή στη βάση δεδομένων: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
            this.dispose();
            
            Logistis logistis = new Logistis();
            
            logistis.setLocationRelativeTo(null);
            
            logistis.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Create a file chooser
        JFileChooser fileChooser = new JFileChooser();

        // Show the file chooser dialog
        int result = fileChooser.showOpenDialog(this);

        // If the user selects a file
        if (result == JFileChooser.APPROVE_OPTION) 
        {
            // Get the selected file
            File selectedFile = fileChooser.getSelectedFile();
            
            onoma_epilegmenou_arxeiou_forologikis = selectedFile.getName();
            
            // Read the file into a byte array
            byte[] fileContent;
            
            try
            {
                FileInputStream fis = new FileInputStream(selectedFile);
                fileContent = new byte[(int) selectedFile.length()];
                fis.read(fileContent);
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Σφάλμα διαβάσματος αρχείου: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Convert byte array to Blob
            try 
            {
                arxeio_forologikis = new javax.sql.rowset.serial.SerialBlob(fileContent);
            } 
            catch(SQLException e) 
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Σφάλμα ανάθεσης αρχείου: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            jButton5.setText(onoma_epilegmenou_arxeiou_forologikis);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // Create a file chooser
        JFileChooser fileChooser = new JFileChooser();

        // Show the file chooser dialog
        int result = fileChooser.showOpenDialog(this);

        // If the user selects a file
        if (result == JFileChooser.APPROVE_OPTION) 
        {
            // Get the selected file
            File selectedFile = fileChooser.getSelectedFile();
            
            onoma_epilegmenou_arxeiou_ekkatharistikou = selectedFile.getName();
            
            // Read the file into a byte array
            byte[] fileContent;
            
            try
            {
                FileInputStream fis = new FileInputStream(selectedFile);
                fileContent = new byte[(int) selectedFile.length()];
                fis.read(fileContent);
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Σφάλμα διαβάσματος αρχείου: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Convert byte array to Blob
            try 
            {
                arxeio_ekkatharistikou = new javax.sql.rowset.serial.SerialBlob(fileContent);
            } 
            catch(SQLException e) 
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Σφάλμα ανάθεσης αρχείου: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            jButton7.setText(onoma_epilegmenou_arxeiou_ekkatharistikou);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (!"Εκκαθαριστικά".equals(jLabel5.getText())) 
        {
            JOptionPane.showMessageDialog(this, "Παρακαλώ κάντε προβολή εκκαθαριστικών και επιλέξτε αρχείο πριν το κατέβασμά τους!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the selected row index
        int selectedRow = jTable2.getSelectedRow();

        // Check if a row is selected
        if (selectedRow == -1) 
        {
            JOptionPane.showMessageDialog(this, "Παρακαλώ επιλέξτε ένα αρχείο από τον πίνακα.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the ID from the selected row
        String id = jTable2.getValueAt(selectedRow, 0).toString();

        // Execute a query to retrieve the Blob data based on the selected ID
        String query = "SELECT ekkatharistiko FROM ekkatharistiko WHERE ek_id = ?";
        
        try
        {
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, id);
            
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) 
            {
                // Get the Blob data from the result set
                Blob fileBlob = rs.getBlob("ekkatharistiko");

                // Ask the user for the location to save the file
                JFileChooser fileChooser = new JFileChooser();
                
                int result = fileChooser.showSaveDialog(this);

                if (result == JFileChooser.APPROVE_OPTION) 
                {
                    File selectedFile = fileChooser.getSelectedFile();

                    try 
                    {
                        // Read the Blob data and save it to the selected location
                        InputStream inputStream = fileBlob.getBinaryStream();
                        FileOutputStream fileOutputStream = new FileOutputStream(selectedFile);

                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) 
                        {
                            fileOutputStream.write(buffer, 0, bytesRead);
                        }

                        fileOutputStream.close();
                        inputStream.close();

                        JOptionPane.showMessageDialog(this, "Το αρχείο κατέβηκε επιτυχώς.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } 
                    catch (IOException e) 
                    {
                        JOptionPane.showMessageDialog(this, "Σφάλμα κατά την κατέβαση του αρχείου: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } 
            else 
            {
                JOptionPane.showMessageDialog(this, "Δεν βρέθηκε αρχείο με το συγκεκριμένο ID!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch(SQLException e) 
        {
            JOptionPane.showMessageDialog(this, "Σφάλμα κατά την ανάκτηση του αρχείου: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Ipovoli_diloseon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ipovoli_diloseon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ipovoli_diloseon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ipovoli_diloseon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ipovoli_diloseon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
