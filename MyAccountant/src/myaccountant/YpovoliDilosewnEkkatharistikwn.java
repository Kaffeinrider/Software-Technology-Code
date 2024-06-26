package myaccountant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static myaccountant.Login.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Blob;
import javax.swing.JFileChooser;
import java.io.*;

public class YpovoliDilosewnEkkatharistikwn extends javax.swing.JFrame 
{
    private Blob arxeio_forologikis;
    private String onoma_epilegmenou_arxeiou_forologikis;
            
    public YpovoliDilosewnEkkatharistikwn() 
    {
        initComponents();
    }
    
    private void load_forologikes()
    {
        String query = "SELECT for_dil_id,for_onoma_arxeiou FROM forologiki_dilosi WHERE for_dil_username_idioti = ?";
   
        try 
        {
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setString(1, username); 
            
            ResultSet rs = pst.executeQuery();
            
            DefaultTableModel tblModel = (DefaultTableModel) jTable2.getModel();
            
            jLabel4.setText("Φορολογικές Δηλώσεις");
            
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
    
    private void load_ekkatharistika()
    {
        String query = "SELECT ek_id,ek_onoma_arxeiou FROM ekkatharistiko WHERE ek_username_idioti = ?";
   
        try 
        {
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setString(1, username); 
            
            ResultSet rs = pst.executeQuery();
            
            DefaultTableModel tblModel = (DefaultTableModel) jTable2.getModel();
            
            jLabel4.setText("Εκκαθαριστικά");
            
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
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(51, 51, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 28)); // NOI18N
        jLabel1.setText("Υποβολή Δηλώσεων και Εκκαθαριστικών");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Όνομα αρχείου"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        jButton1.setBackground(new java.awt.Color(0, 204, 255));
        jButton1.setText("Επιλέξτε Αρχείο");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 255));
        jButton2.setText("Προβολή");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 204, 255));
        jButton3.setText("Αίτημα Φορολογικής");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 204, 255));
        jButton4.setText("Αίτημα Εκκαθαριστικού");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Φορολογικές Δηλώσεις:");

        jButton6.setBackground(new java.awt.Color(0, 204, 255));
        jButton6.setText("Λήψη");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Εκκαθαριστικά:");

        jButton7.setBackground(new java.awt.Color(0, 204, 255));
        jButton7.setText("Λήψη");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 204, 255));
        jButton8.setText("Προβολή");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(0, 255, 102));
        jButton9.setText("Υποβολή");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 0, 0));
        jButton10.setText("Επιστροφή");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(jButton7)
                                                .addGap(116, 116, 116)))
                                        .addComponent(jButton4)))
                                .addGap(53, 53, 53))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton8)
                                    .addComponent(jButton7))
                                .addGap(90, 90, 90))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton6)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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

            jButton1.setText(onoma_epilegmenou_arxeiou_forologikis);
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        load_forologikes();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Θέλετε σίγουρα να στείλετε αίτημα φορολογικής δήλωσης?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(response == JOptionPane.YES_OPTION) 
        {
            String getlogisti = "SELECT idiotis_username_logisti FROM idiotis WHERE username_idioti = ?";
            
            String uname_logisti = null;
        
            try 
            {
                PreparedStatement checkStmt = conn.prepareStatement(getlogisti);
            
                checkStmt.setString(1, username);
            
                ResultSet rs = checkStmt.executeQuery();
            
                if (rs.next()) 
                {
                    uname_logisti = rs.getString("idiotis_username_logisti");
                }
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Σφάλμα κατά την ανάκτηση δεδομένων: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (uname_logisti == null) 
            {
                JOptionPane.showMessageDialog(this, "Πρέπει να έχει ανατεθεί ένας προσωπικός λογιστής σε εσάς για να στείλετε αίτημα!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        
            String username_pelati = username;
            String eidos_aitimatos = "AITIMA FOROLOGIKIS DILOSIS";
            int poso = 30;
            
            if(portofoli < poso)
            {
                JOptionPane.showMessageDialog(this, "Δεν έχετε αρκετό χρηματικό υπόλοιπο για την αποστολή αιτήματος!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String query = "INSERT INTO aitima VALUES (NULL, ?, ?, ?, NULL, ?)";
 
            try 
            {
                PreparedStatement pstmt = conn.prepareStatement(query);
            
                pstmt.setString(1, username_pelati);
                pstmt.setString(2, eidos_aitimatos);
                pstmt.setInt(3, poso);
                pstmt.setString(4, uname_logisti);
            
                pstmt.executeUpdate();
            
                JOptionPane.showMessageDialog(this, "Το αίτημα στάλθηκε!", "Update", JOptionPane.INFORMATION_MESSAGE);
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Σφάλμα κατά την εισαγωγή στη βάση δεδομένων: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Θέλετε σίγουρα να στείλετε αίτημα εκκαθαριστικού?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(response == JOptionPane.YES_OPTION) 
        {
            String getlogisti = "SELECT idiotis_username_logisti FROM idiotis WHERE username_idioti = ?";
            
            String uname_logisti = null;
        
            try 
            {
                PreparedStatement checkStmt = conn.prepareStatement(getlogisti);
            
                checkStmt.setString(1, username);
            
                ResultSet rs = checkStmt.executeQuery();
            
                if (rs.next()) 
                {
                    uname_logisti = rs.getString("idiotis_username_logisti");
                }
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Σφάλμα κατά την ανάκτηση δεδομένων: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (uname_logisti == null) 
            {
                JOptionPane.showMessageDialog(this, "Πρέπει να έχει ανατεθεί ένας προσωπικός λογιστής σε εσάς για να στείλετε αίτημα!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        
            String username_pelati = username;
            String eidos_aitimatos = "AITIMA EKKATHARISTIKOU";
            int poso = 30;
            
            if(portofoli < poso)
            {
                JOptionPane.showMessageDialog(this, "Δεν έχετε αρκετό χρηματικό υπόλοιπο για την αποστολή αιτήματος!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String query = "INSERT INTO aitima VALUES (NULL, ?, ?, ?, NULL, ?)";
 
            try 
            {
                PreparedStatement pstmt = conn.prepareStatement(query);
            
                pstmt.setString(1, username_pelati);
                pstmt.setString(2, eidos_aitimatos);
                pstmt.setInt(3, poso);
                pstmt.setString(4, uname_logisti);
            
                pstmt.executeUpdate();
            
                JOptionPane.showMessageDialog(this, "Το αίτημα στάλθηκε!", "Update", JOptionPane.INFORMATION_MESSAGE);
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Σφάλμα κατά την εισαγωγή στη βάση δεδομένων: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (!"Φορολογικές Δηλώσεις".equals(jLabel4.getText())) 
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
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (!"Εκκαθαριστικά".equals(jLabel4.getText())) 
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
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        load_ekkatharistika();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.dispose();
        
        Idiotis idiotis = new Idiotis();
        
        idiotis.setLocationRelativeTo(null); 
        
        idiotis.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (arxeio_forologikis == null) 
        {
            JOptionPane.showMessageDialog(this, "Δεν διαλέξατε αρχείο!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String insertSQL = "INSERT INTO forologiki_dilosi (for_onoma_arxeiou, forologiki_dilosi, for_dil_username_idioti) VALUES (?, ?, ?)";
        
        try 
        {
            PreparedStatement pstmt = conn.prepareStatement(insertSQL); 
            
            pstmt.setString(1, onoma_epilegmenou_arxeiou_forologikis);
            pstmt.setBlob(2, arxeio_forologikis);
            pstmt.setString(3, username);
            
            pstmt.executeUpdate();
            
            jButton1.setText("Επιλέξτε Αρχείο");
            load_forologikes();
            
            JOptionPane.showMessageDialog(this, "Το αρχείο ανέβηκε!", "Update", JOptionPane.INFORMATION_MESSAGE);  
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error inserting record: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(YpovoliDilosewnEkkatharistikwn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YpovoliDilosewnEkkatharistikwn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YpovoliDilosewnEkkatharistikwn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YpovoliDilosewnEkkatharistikwn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YpovoliDilosewnEkkatharistikwn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
