
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samne
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    Connection myconObj=null;
    Statement mystatObj=null;
    ResultSet myresObj=null;
    
    public GUI() {
        initComponents();
        selectionall();
        Accounts1.setAutoCreateRowSorter(true);
        jLabel4.setText(" ");
        jLabel4.setForeground(Color.red);
        jLabel5.setText(" ");
        jLabel5.setForeground(Color.red);
        jLabel6.setText(" ");
        jLabel6.setForeground(Color.red);
        accountNoTxt.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
         e.consume();  // ignore event
         jLabel6.setText("Account number can only contain numbers");
      }
   }
});
        
}
    
public void selectionall(){
    try{
    myconObj=DriverManager.getConnection("jdbc:derby://localhost:1527/AccountsDB;create=true", "APP", "APP");
    mystatObj=myconObj.createStatement();
    myresObj=mystatObj.executeQuery("Select * from APP.Accounts");
    Accounts1.setModel(DbUtils.resultSetToTableModel(myresObj));
    Accounts1.getColumnModel().getColumn(0).setHeaderValue("Account Number");
    Accounts1.getColumnModel().getColumn(1).setHeaderValue("First Name");
    Accounts1.getColumnModel().getColumn(2).setHeaderValue("Surname");
    
    
}    
    catch(SQLException e){
    e.printStackTrace();
}
}
public void addaccount(){
     try{
           String accountNo = accountNoTxt.getText();
           String firstName = firstNameTxt.getText();
           String surname = surnameTxt.getText();
           PreparedStatement add = myconObj.prepareStatement("insert into APP.Accounts values (?,?,?)");
           add.setString(1, accountNo);
           add.setString(2, firstName);
           add.setString(3, surname);
           int row = add.executeUpdate();
           jLabel4.setText("Account Added");
       } 
       catch(SQLException E){
           E.printStackTrace();
           jLabel4.setText("Unable to Add Account:");
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
        Accounts1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        accountNoTxt = new javax.swing.JTextField();
        firstNameTxt = new javax.swing.JTextField();
        surnameTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        searchTxt = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Edit Accounts");

        Accounts1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Account Number", "First Name", "Surname"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Accounts1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Accounts1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Accounts1);
        if (Accounts1.getColumnModel().getColumnCount() > 0) {
            Accounts1.getColumnModel().getColumn(0).setHeaderValue("Account Number");
            Accounts1.getColumnModel().getColumn(1).setHeaderValue("First Name");
            Accounts1.getColumnModel().getColumn(2).setHeaderValue("Surname");
        }

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Account Number:");

        jLabel2.setText("First Name:");

        jLabel3.setText("Surname:");

        accountNoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountNoTxtActionPerformed(evt);
            }
        });
        accountNoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                accountNoTxtKeyPressed(evt);
            }
        });

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        searchTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTxtActionPerformed(evt);
            }
        });

        jButton4.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(accountNoTxt)
                            .addComponent(firstNameTxt)
                            .addComponent(surnameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabel1)
                            .addComponent(accountNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jLabel2)
                            .addComponent(firstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jLabel3)
                            .addComponent(surnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(0, 53, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accountNoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountNoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountNoTxtActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
           String sql="Delete from APP.Accounts where Account_Number = "+accountNoTxt.getText(); 
           Statement add=myconObj.createStatement();
           add.executeUpdate(sql);
           accountNoTxt.setText("");
           firstNameTxt.setText("");
           surnameTxt.setText("");
           jLabel4.setText("Account Deleted");
        }
        catch(SQLException E){
            E.printStackTrace();
            jLabel4.setText("Unable to Delete Account:");
        }
        selectionall();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            String sql="update APP.Accounts set First_Name = '"+firstNameTxt.getText()+"'"+",surname = '"+surnameTxt.getText()+"'"+"where Account_Number = "+accountNoTxt.getText();
            Statement update = myconObj.createStatement();
            update.executeUpdate(sql);
            jLabel4.setText("Account Updated");
        }
        catch(SQLException E){
            E.printStackTrace();
        }
        selectionall();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if (accountNoTxt.getText().length() == 4){ 
       addaccount();
       selectionall();
       }
       else{
       jLabel4.setText("Unable to Add Account:");
       jLabel5.setText("Account Number must be exactly 4 digits");
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Accounts1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Accounts1MouseClicked
       DefaultTableModel model = (DefaultTableModel) Accounts1.getModel();

       Long lTextField1;
       String textField1;
       lTextField1 = (Long) model.getValueAt(Accounts1.getSelectedRow(),0);
       String textField2 = (String) model.getValueAt(Accounts1.getSelectedRow(),1);
       String textField3 = (String) model.getValueAt(Accounts1.getSelectedRow(),2);
       textField1 = Long.toString(lTextField1);
       
       accountNoTxt.setText(textField1);
       firstNameTxt.setText(textField2);
       surnameTxt.setText(textField3);
       
    }//GEN-LAST:event_Accounts1MouseClicked

    private void accountNoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accountNoTxtKeyPressed
      if ((accountNoTxt.getText()).length() > 3){
          jLabel6.setText("Account number must be exactly 4 digits");
      }
    }//GEN-LAST:event_accountNoTxtKeyPressed

    private void searchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtActionPerformed
        
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(((DefaultTableModel) Accounts1.getModel())); 
            sorter.setRowFilter(RowFilter.regexFilter(searchTxt.getText()));

            Accounts1.setRowSorter(sorter);
            
        
    }//GEN-LAST:event_searchTxtActionPerformed

    
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Accounts1;
    private javax.swing.JTextField accountNoTxt;
    private javax.swing.JTextField firstNameTxt;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JTextField surnameTxt;
    // End of variables declaration//GEN-END:variables
}
