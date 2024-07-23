
package View;
import Model.User;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import View.ManagerView;


public class UserLogin extends javax.swing.JFrame {

    
    public UserLogin() {
        initComponents();
       
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_Name = new javax.swing.JTextField();
        txt_PassWord = new javax.swing.JPasswordField();
        btn_Login = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/IMG-20231209-WA0004.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("User Name     :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 132, 27));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Password        :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 142, 32));

        txt_Name.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txt_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 293, 38));

        txt_PassWord.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txt_PassWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 293, 39));

        btn_Login.setBackground(new java.awt.Color(204, 204, 204));
        btn_Login.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Login.setText("Login");
        btn_Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_LoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_LoginMouseExited(evt);
            }
        });
        btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 122, 40));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("....LOGIN FORM....");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 440, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 530, 520));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/virtual-class.png"))); // NOI18N
        jPanel3.add(jLabel5);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 190, 310, 520));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/bc.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LoginMouseEntered
        btn_Login.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_LoginMouseEntered

    private void btn_LoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LoginMouseExited
       btn_Login.setBackground(Color.GRAY);
    }//GEN-LAST:event_btn_LoginMouseExited

    private void btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginActionPerformed
       String name = txt_Name.getText();
        String pass = new String(txt_PassWord.getText());
        
        try {
            User user = new User(0,name,pass,null,null);
            
            if(user.authentication(name, pass)){
                
                String userRole = user.getUserRole();
                if(userRole != null){
                if(userRole.equals("manager")){
                
                JOptionPane.showMessageDialog(this, "manager");
                   new ManagerView().setVisible(true);
                     this.dispose();
                
                }
                else if(userRole.equals("cashier")){
                
                JOptionPane.showMessageDialog(this, "cashier");
                 new CashierView().setVisible(true);
                     this.dispose();
                }
                else if (userRole.equals("user")){
                
                JOptionPane.showMessageDialog(this, "user");
                }
                
                }
            
            }
             else{
                
                JOptionPane.showMessageDialog(this, "check");
                }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }//GEN-LAST:event_btn_LoginActionPerformed

    
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
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_Name;
    private javax.swing.JPasswordField txt_PassWord;
    // End of variables declaration//GEN-END:variables
}
