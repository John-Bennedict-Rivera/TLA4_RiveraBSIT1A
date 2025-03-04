/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author Students Account
 */
public class Update extends javax.swing.JFrame {


private static String usname, pass, type = "admin";

    private static String filepath = "src\\Data.json";
    private static JSONParser jsonParser = new JSONParser();
    private static JSONObject record = new JSONObject();
    private static JSONArray userlist = new JSONArray();


    /**
     * Creates new form Update
     */
    public Update() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Update = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        userupdate = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        usernameupdate = new javax.swing.JTextField();
        UpdatePassword = new javax.swing.JTextField();
        Clearupdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        NewUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Update.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        Update.setForeground(new java.awt.Color(153, 255, 153));
        Update.setText("Update");
        getContentPane().add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 15, 56, 44));

        update.setForeground(new java.awt.Color(255, 102, 204));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 277, -1, -1));

        userupdate.setForeground(new java.awt.Color(51, 255, 255));
        userupdate.setText("Username");
        getContentPane().add(userupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 71, 78, 37));

        Password.setForeground(new java.awt.Color(51, 255, 255));
        Password.setText("Password");
        getContentPane().add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 126, 78, 30));
        getContentPane().add(usernameupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 74, 143, 30));

        UpdatePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatePasswordActionPerformed(evt);
            }
        });
        getContentPane().add(UpdatePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 126, 143, 30));

        Clearupdate.setForeground(new java.awt.Color(255, 102, 204));
        Clearupdate.setText("Clear");
        Clearupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearupdateActionPerformed(evt);
            }
        });
        getContentPane().add(Clearupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 277, -1, -1));

        jLabel1.setForeground(new java.awt.Color(51, 255, 255));
        jLabel1.setText("New User");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 174, 69, 28));

        NewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewUserActionPerformed(evt);
            }
        });
        getContentPane().add(NewUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 174, 143, 28));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Students Account\\Downloads\\UIC-Campus3_kIeAovs.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        try {
            filecheck();
            String currentUsername = usernameupdate.getText().trim();
            String newUsername = NewUser.getText().trim();
            String newPassword = Password.getText().trim();
            boolean found = false;

            for (int i = 0; i < userlist.size(); i++) {
                JSONObject user = (JSONObject) userlist.get(i);
                if (user.get("username").equals(currentUsername)) {
                    user.put("username", newUsername.isEmpty() ? currentUsername : newUsername);
                    user.put("password", newPassword.isEmpty() ? user.get("password") : newPassword);
                    found = true;
                    break;
                }
            }
            if (found) {
                record.put("users", userlist);
                JOptionPane.showMessageDialog(this, "User updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "User not found.");
            }
        } catch (IOException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "An error occurred.");
        } catch (ParseException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    this.dispose();
    Dashboard e = new Dashboard();
    e.setVisible (true);
        
    }//GEN-LAST:event_updateActionPerformed
   
    private void ClearupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearupdateActionPerformed
        usernameupdate.setText("");
        UpdatePassword.setText("");
        NewUser.setText("");
    }//GEN-LAST:event_ClearupdateActionPerformed

    private void NewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewUserActionPerformed
        
    }//GEN-LAST:event_NewUserActionPerformed

    private void UpdatePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatePasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdatePasswordActionPerformed

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
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>    }
            try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update().setVisible(true);
            }
        });
    }
    public void filecheck() throws FileNotFoundException, IOException, ParseException {
    FileReader reader = new FileReader(filepath);

    if (reader.ready()) {
        Scanner scan = new Scanner(reader);
        String line = "";
        while (scan.hasNext()) {
            line = line + scan.nextLine();
        }

        reader.close();

        if (!line.equals("")) {
            reader.close();
            FileReader reader2 = new FileReader(filepath);
            record = (JSONObject) jsonParser.parse(reader2);
            userlist = (JSONArray) record.get("users");
            reader2.close();
        }
    }

    this.dispose();
    Dashboard e = new Dashboard();
    e.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clearupdate;
    private javax.swing.JTextField NewUser;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel Update;
    private javax.swing.JTextField UpdatePassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton update;
    private javax.swing.JTextField usernameupdate;
    private javax.swing.JLabel userupdate;
    // End of variables declaration//GEN-END:variables
}
