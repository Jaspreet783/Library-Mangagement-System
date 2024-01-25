/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SLibrary;

//import java.lang.System.Logger;
//import java.lang.System.Logger.Level;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
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

/**
 *
 * @author aradhyagarg
 */
public class Book extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public Book() {
        initComponents();
        Connect();
        Category();
        Author();
        Publisher();
        Book_Load();
    }
    
    
    
    public class CategoryItem{
        int id;
        String name;
        
        public CategoryItem(int id, String name){
            this.id = id;
            this.name = name;
        }
        
        public String toString()
        {
            return name;
        }

    }
    
    public class AuthorItem{
        int id;
        String name;
        
        public AuthorItem(int id, String name){
            this.id = id;
            this.name = name;
        }
        
        public String toString()
        {
            return name;
        }

    }
    
    public class PublisherItem{
        int id;
        String name;
        
        public PublisherItem(int id, String name){
            this.id = id;
            this.name = name;
        }
        
        public String toString()
        {
            return name;
        }

    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    public void Connect(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/SLibrary","root","");
        }catch (ClassNotFoundException ex){
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE,null,ex);
        }
        catch(SQLException ex){
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void Category(){
        try{
            pst = con.prepareStatement("select * from category");
            rs = pst.executeQuery();
            txtcategory.removeAllItems();
            
            while(rs.next()){
                txtcategory.addItem(new CategoryItem(rs.getInt(1), rs.getString(2)));
            }
        }catch(SQLException ex){
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Author(){
        try{
            pst = con.prepareStatement("select * from author");
            rs = pst.executeQuery();
            txtauthor.removeAllItems();
            
            while(rs.next()){
                txtauthor.addItem(new AuthorItem(rs.getInt(1), rs.getString(2)));
            }
        }catch(SQLException ex){
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Publisher(){
        try{
            pst = con.prepareStatement("select * from publisher");
            rs = pst.executeQuery();
            txtpublisher.removeAllItems();
            
            while(rs.next()){
                txtpublisher.addItem(new PublisherItem(rs.getInt(1), rs.getString(2)));
            }
        }catch(SQLException ex){
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Book_Load() {
    int c;
    try {
        pst = con.prepareStatement("select b.id, b.bname, c.catname, a.name, p.name, b.contents, b.pages, b.edition from book b JOIN category c On b.category = c.id JOIN author a On b.author = a.id JOIN publisher p On b.publisher = p.id;");
        rs = pst.executeQuery();
        ResultSetMetaData rsd = (ResultSetMetaData) rs.getMetaData();
        c = rsd.getColumnCount();
        DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
        d.setRowCount(0);
        while (rs.next()) {
            Vector v2 = new Vector();
            for (int i = 1; i <= c; i++) {
                v2.add(rs.getString("b.id"));
                v2.add(rs.getString("b.bname"));
                v2.add(rs.getString("c.catname"));
                v2.add(rs.getString("a.name"));
                v2.add(rs.getString("p.name"));
                v2.add(rs.getString("b.contents"));
                v2.add(rs.getString("b.pages"));
                v2.add(rs.getString("b.edition"));
            }
            d.addRow(v2);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
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
        txtname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtcontent = new javax.swing.JTextField();
        txtcategory = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtauthor = new javax.swing.JComboBox();
        txtpublisher = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtno = new javax.swing.JTextField();
        txtedition = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Book");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setText("Category");

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

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Book Name", "Category", "Author", "Publisher", "Contents", "No of Pages", "Edition"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
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
        jLabel4.setText("Contents");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel5.setText("Author");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel6.setText("Publisher");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel7.setText("No. Of Pages");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel8.setText("Edition");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(64, 64, 64)
                                .addComponent(txtauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jButton3)
                                .addGap(142, 142, 142)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4)
                                    .addComponent(jButton2)))
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtedition, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtpublisher, 0, 171, Short.MAX_VALUE)
                                        .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtcontent))))
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)))
                .addContainerGap())
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
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtcontent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtedition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
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
    String bname = txtname.getText();
    CategoryItem citem = (CategoryItem) txtcategory.getSelectedItem();
    AuthorItem aitem = (AuthorItem) txtauthor.getSelectedItem();
    PublisherItem pitem = (PublisherItem) txtpublisher.getSelectedItem();
    String contents = txtcontent.getText();
    String pages = txtno.getText();
    String edition = txtedition.getText();

    try {
        // Prepare an SQL update statement to update the book
        pst = con.prepareStatement("UPDATE book SET bname=?, author=?, category=?, publisher=?, contents=?, pages=?, edition=? WHERE id=?");
        pst.setString(1, bname);
        pst.setInt(2, aitem.id);
        pst.setInt(3, citem.id);
        pst.setInt(4, pitem.id);
        pst.setString(5, contents);
        pst.setString(6, pages);
        pst.setString(7, edition);
        pst.setString(8, bookID);

        int updated = pst.executeUpdate();

        if (updated == 1) {
            JOptionPane.showMessageDialog(this, "Book updated successfully.");
            // Clear the text fields and combo boxes
            txtname.setText("");
            txtcategory.setSelectedIndex(-1);
            txtauthor.setSelectedIndex(-1);
            txtpublisher.setSelectedIndex(-1);
            txtcontent.setText("");
            txtno.setText("");
            txtedition.setText("");
            jButton2.setEnabled(false); // Disable the Update button

            // Reload the book data
            Book_Load();
        } else {
            JOptionPane.showMessageDialog(this, "Update failed. Please try again.");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String bname = txtname.getText();
        CategoryItem citem = (CategoryItem)txtcategory.getSelectedItem();
        AuthorItem aitem = (AuthorItem)txtauthor.getSelectedItem();
        PublisherItem pitem = (PublisherItem)txtpublisher.getSelectedItem();
        String contents = txtcontent.getText();
        String pages = txtno.getText();
        String edition = txtedition.getText();
        try{
            pst = con.prepareStatement("insert into book(bname,author,category,publisher,contents,pages,edition)values(?,?,?,?,?,?,?)");
            pst.setString (1, bname);
            pst.setInt (2, citem.id);
            pst.setInt (3, aitem.id);
            pst.setInt (4, pitem.id);
            pst.setString (5, contents);
            pst.setString (6, pages);
            pst.setString (7, edition);
            int k = pst.executeUpdate();
            
            if (k== 1){
                JOptionPane.showMessageDialog(this,"Book Createdd");
                txtname.setText("");
                txtcategory.setSelectedIndex(-1);
                txtauthor.setSelectedIndex(-1);
                txtpublisher.setSelectedIndex(-1);
                txtcontent.setText("");
                txtno.setText("");
                txtedition.setText("");
                //Publisher_Load();
                Book_Load();
        
            }else{
                JOptionPane.showMessageDialog(this,"Error");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Book.class.getName()).log(Level. SEVERE, null, ex);
        }
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
        String bookName = model.getValueAt(selectedRow, 1).toString();
        String category = model.getValueAt(selectedRow, 2).toString();
        String author = model.getValueAt(selectedRow, 3).toString();
        String publisher = model.getValueAt(selectedRow, 4).toString();
        String contents = model.getValueAt(selectedRow, 5).toString();
        String pages = model.getValueAt(selectedRow, 6).toString();
        String edition = model.getValueAt(selectedRow, 7).toString();

        // Populate your text fields or update UI components with the selected data
        txtname.setText(bookName);
        // Set the selected category, author, and publisher in their respective combo boxes

        // Set the contents, pages, and edition
        txtcontent.setText(contents);
        txtno.setText(pages);
        txtedition.setText(edition);
    }
        
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();

    // Check if a row is selected
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a book to delete.");
        return;
    }

    // Get the book ID from the selected row
    String bookID = jTable1.getValueAt(selectedRow, 0).toString();

    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this book?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        try {
            // Prepare an SQL delete statement to delete the book
            pst = con.prepareStatement("DELETE FROM book WHERE id=?");
            pst.setString(1, bookID);

            int deleted = pst.executeUpdate();

            if (deleted == 1) {
                JOptionPane.showMessageDialog(this, "Book deleted successfully.");
                jButton3.setEnabled(false); // Disable the Delete button

                // Clear the text fields and combo boxes
                txtname.setText("");
                txtcategory.setSelectedIndex(-1);
                txtauthor.setSelectedIndex(-1);
                txtpublisher.setSelectedIndex(-1);
                txtcontent.setText("");
                txtno.setText("");
                txtedition.setText("");

                // Reload the book data
                Book_Load();
            } else {
                JOptionPane.showMessageDialog(this, "Delete failed. Please try again.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Book().setVisible(true);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtauthor;
    private javax.swing.JComboBox txtcategory;
    private javax.swing.JTextField txtcontent;
    private javax.swing.JTextField txtedition;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtno;
    private javax.swing.JComboBox txtpublisher;
    // End of variables declaration//GEN-END:variables
}
