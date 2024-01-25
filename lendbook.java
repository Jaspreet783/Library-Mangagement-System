/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SLibrary;

//import java.lang.System.Logger;
//import java.lang.System.Logger.Level;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
// Replace com.example with the actual package of AuthorItem



/**
 *
 * @author aradhyagarg
 */
public class lendbook extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public lendbook() {
        initComponents();
        Connect();
        book();
        Issuebok_Load();
    }
    
    
    
    
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    public void Connect(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/SLibrary","root","");
        }catch (ClassNotFoundException ex){
            Logger.getLogger(lendbook.class.getName()).log(Level.SEVERE,null,ex);
        }
        catch(SQLException ex){
            Logger.getLogger(lendbook.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public class BookItem{
        int id;
        String name;
        
        public BookItem(int id, String name){
            this.id = id;
            this.name = name;
            
        }
        public String toString(){
            return name;
        }
    }
    
    public void book(){
    try{
            pst = con.prepareStatement("select * from book");
            rs = pst.executeQuery();
            txtbook.removeAllItems();
            
            while(rs.next()){
                txtbook.addItem(new BookItem(rs.getInt(1), rs.getString(2)));
            }
        }catch(SQLException ex){
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    
    public void Issuebok_Load() {
    int c;
    try {
        pst = con.prepareStatement("select l.id, m.name, b.bname, l.issuedate, l.returndate from lendbook l JOIN member m ON l.memberid = m.id JOIN book b ON l.bookid = b.id");
        rs = pst.executeQuery();
        ResultSetMetaData rsd = (ResultSetMetaData) rs.getMetaData();
        c = rsd.getColumnCount();
        DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
        d.setRowCount(0);
        while (rs.next()) {
            Vector v2 = new Vector();
            for (int i = 1; i <= c; i++) {
                v2.add(rs.getString("l.id"));
                v2.add(rs.getString("m.name"));
                v2.add(rs.getString("b.bname"));
                v2.add(rs.getString("l.issuedate"));
                v2.add(rs.getString("l.returndate"));
            }
            d.addRow(v2);
        }
    } catch (SQLException ex) {
        Logger.getLogger(lendbook.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    /*public void Book_Load() {
    try {
        pst = con.prepareStatement("SELECT b.id, b.bname, c.catname, a.name, p.name, b.contents, b.pages, b.edition FROM book b JOIN category c ON b.category = c.id JOIN author a ON b.author = a.id JOIN publisher p ON b.publisher = p.id");
        rs = pst.executeQuery();
        
        DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
        d.setRowCount(0);
        
        while (rs.next()) {
            Vector v2 = new Vector();
            v2.add(rs.getString("id"));
            v2.add(rs.getString("bname"));
            v2.add(rs.getString("catname"));
            v2.add(rs.getString("name"));
            v2.add(rs.getString("name"));
            v2.add(rs.getString("contents"));
            v2.add(rs.getString("pages"));
            v2.add(rs.getString("edition"));
            d.addRow(v2);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
    }
}*/
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtbook = new javax.swing.JComboBox();
        txtissuedate = new com.toedter.calendar.JDateChooser();
        txtmember = new javax.swing.JTextField();
        txtrdate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Issue Book");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel2.setText("Member ID");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setText("Member Name");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidKeyPressed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Member Name", "Book", "Date", "ReturnDate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel4.setText("Return Date");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel5.setText("Book");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel6.setText("Date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jButton3)
                        .addGap(142, 142, 142)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jButton2)))
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtbook, 0, 168, Short.MAX_VALUE)
                            .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(txtissuedate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmember)
                            .addComponent(txtrdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(txtmember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtbook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtissuedate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtrdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(140, 140, 140)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();

    // Check if a row is selected
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a book to update.");
        return;
    }

    // Get the book ID from the selected row
    String bookID = jTable1.getValueAt(selectedRow, 0).toString();

    // Get the updated values from the text fields and combo boxes
    String memberID = txtid.getText();
    BookItem bookItem = (BookItem) txtbook.getSelectedItem();
    SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
    String issueDate = date_format.format(txtissuedate.getDate());
    String returnDate = date_format.format(txtrdate.getDate());

    try {
        // Prepare an SQL update statement to update the book record
        pst = con.prepareStatement("UPDATE lendbook SET memberid=?, bookid=?, issuedate=?, returndate=? WHERE id=?");
        pst.setString(1, memberID);
        pst.setInt(2, bookItem.id);
        pst.setString(3, issueDate);
        pst.setString(4, returnDate);
        pst.setString(5, bookID);

        int updated = pst.executeUpdate();

        if (updated == 1) {
            JOptionPane.showMessageDialog(this, "Book record updated successfully.");

            // Update the JTable model with the new data
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setValueAt(memberID, selectedRow, 1);
            model.setValueAt(bookItem.name, selectedRow, 2);
            model.setValueAt(issueDate, selectedRow, 3);
            model.setValueAt(returnDate, selectedRow, 4);

            // Clear the text fields and combo boxes
            txtid.setText("");
            txtbook.setSelectedIndex(-1);
            txtmember.setText("");
            txtrdate.setDate(null);
            txtissuedate.setDate(null);
            jButton2.setEnabled(false); // Disable the Update button
        } else {
            JOptionPane.showMessageDialog(this, "Update failed. Please try again.");
        }
    } catch (SQLException ex) {
        Logger.getLogger(lendbook.class.getName()).log(Level.SEVERE, null, ex);
    }

        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String mid = txtid.getText();
        BookItem bitem = (BookItem) txtbook.getSelectedItem();
        
        SimpleDateFormat date_format = new SimpleDateFormat ("yyyy-MM-dd");
        String issuedate = date_format.format(txtissuedate.getDate());
        
        SimpleDateFormat date_format1 = new SimpleDateFormat("YYYY-MM-DD");
        String returndate = date_format.format(txtrdate.getDate());
        try{
            pst = con.prepareStatement("insert into lendbook(memberid, bookid, issuedate, returndate) values (?,?,?,?)");
            pst.setString (1, mid);
            pst.setInt (2, bitem.id);
            pst.setString (3, issuedate);
            pst.setString (4, returndate);
           
            int k = pst.executeUpdate();
            
            if (k== 1){
                JOptionPane.showMessageDialog(this,"Book Issued");
                txtid.setText("");
                txtbook.setSelectedIndex(-1);
                txtmember.setText("");
                Issuebok_Load();
                
        
            }else{
                JOptionPane.showMessageDialog(this,"Error");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(lendbook.class.getName()).log(Level. SEVERE, null, ex);
        }
        /*String mid = txtid.getText();
    BookItem bitem = (BookItem) txtbook.getSelectedItem();
    
    SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
    String issuedate = date_format.format(txtissuedate.getDate());
    String returndate = date_format.format(txtrdate.getDate());
    try {
        pst = con.prepareStatement("insert into lendbook(memberid, bookid, issuedate, returndate) values (?,?,?,?)");
        pst.setString(1, mid);
        pst.setInt(2, bitem.id);
        pst.setString(3, issuedate);
        pst.setString(4, returndate);

        int k = pst.executeUpdate();

        if (k == 1) {
            // Now, retrieve the member name from the database
            String memberName = getMemberName(mid);

            if (memberName != null) {
                txtmember.setText(memberName.trim());
            } else {
                JOptionPane.showMessageDialog(this, "Member ID not found");
            }

            JOptionPane.showMessageDialog(this, "Book Issued");
            txtid.setText("");
            txtbook.setSelectedIndex(-1);
            Issuebok_Load();
        } else {
            JOptionPane.showMessageDialog(this, "Error");
        }
    } catch (SQLException ex) {
        Logger.getLogger(lendbook.class.getName()).log(Level.SEVERE, null, ex);
    }*/
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        int selectedRow = jTable1.getSelectedRow();
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    // Check if a row is selected
    if (selectedRow != -1) {
        // Enable the Update and Delete buttons
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);

        // Get the data from the selected row
        String id = model.getValueAt(selectedRow, 0).toString();
        String memberName = model.getValueAt(selectedRow, 1).toString();
        String bookName = model.getValueAt(selectedRow, 2).toString();
        String issueDate = model.getValueAt(selectedRow, 3).toString();
        String returnDate = model.getValueAt(selectedRow, 4).toString();

        // Populate your text fields and date pickers with the selected data
        txtid.setText(id);
        txtmember.setText(memberName);
        // Set the selected book in the combo box
        for (int i = 0; i < txtbook.getItemCount(); i++) {
            BookItem bookItem = (BookItem) txtbook.getItemAt(i);
            if (bookItem.name.equals(bookName)) {
                txtbook.setSelectedIndex(i);
                break;
            }
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            txtissuedate.setDate(dateFormat.parse(issueDate));
            txtrdate.setDate(dateFormat.parse(returnDate));
        } catch (ParseException ex) {
            Logger.getLogger(lendbook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    jButton1.setEnabled(false); // Disable the Add button
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();

    // Check if a row is selected
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a book record to delete.");
        return;
    }

    // Get the book record ID from the selected row
    String bookRecordID = jTable1.getValueAt(selectedRow, 0).toString();

    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this book record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        try {
            // Prepare an SQL delete statement to delete the book record
            pst = con.prepareStatement("DELETE FROM lendbook WHERE id=?");
            pst.setString(1, bookRecordID);

            int deleted = pst.executeUpdate();

            if (deleted == 1) {
                JOptionPane.showMessageDialog(this, "Book record deleted successfully.");
                jButton3.setEnabled(false); // Disable the Delete button

                // Clear the text fields and combo boxes
                txtid.setText("");
                txtbook.setSelectedIndex(-1);
                txtmember.setText("");
                txtrdate.setDate(null);
                txtissuedate.setDate(null);

                Issuebok_Load(); // Reload the book records
            } else {
                JOptionPane.showMessageDialog(this, "Delete failed. Please try again.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(lendbook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    
    /*private String getMemberName(String memberId) {
        try {
            pst = con.prepareStatement("SELECT name FROM member WHERE id = ?");
            pst.setString(1, memberId);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(lendbook.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; // Return null if the member ID is not found
    }*/
    
    private void txtidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String mid = txtid.getText();
            try{
            pst = con.prepareStatement("select * from member where id = ?");
            pst.setString(1, mid);
            rs = pst.executeQuery();
            if(rs.next() == false){
                JOptionPane.showMessageDialog(this, "Member ID not Found");
            }else{
                String membername = rs.getString ("name");
                txtmember. setText (membername. trim ()) ;
            }
            }catch (SQLException ex){
                Logger.getLogger(lendbook.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_txtidKeyPressed

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
            java.util.logging.Logger.getLogger(lendbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lendbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lendbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lendbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lendbook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtbook;
    private javax.swing.JTextField txtid;
    private com.toedter.calendar.JDateChooser txtissuedate;
    private javax.swing.JTextField txtmember;
    private com.toedter.calendar.JDateChooser txtrdate;
    // End of variables declaration//GEN-END:variables
}