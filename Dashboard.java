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
 *This class adds user data to a JSON file.
 * @author Students Account
 */
public class Dashboard extends javax.swing.JFrame {
    // Variables sa mga user data 
    private static String adname, adpass, type = "member", types;
    
    // File path sa JSON storage 
    private static String filepath2 = "src\\guiapp\\Data.json";
    private static JSONParser jsonParser2 = new JSONParser();
    private static JSONObject record = new JSONObject();
    private static JSONArray userlist = new JSONArray();
    private static JSONObject user = new JSONObject();
    
    /**
     * Creates new form Dashboard or paghimo ug new sa dashboard 
     */
    public Dashboard() {
        initComponents(); // Initializes UI components or pastart sa UI components
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Creating buttons and labels 
        DeleteStudent = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        AddStudent = new javax.swing.JButton();
        UpdateStudent = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        // para maset default ang close operation 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // Delete Student button settings 
        DeleteStudent.setFont(new java.awt.Font("Verdana", 0, 14));
        DeleteStudent.setForeground(new java.awt.Color(204, 0, 0));
        DeleteStudent.setText("Delete Student");
        DeleteStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteStudentActionPerformed(evt);
            }
        });
        getContentPane().add(DeleteStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 181, -1, 33));

        // Welcome label
        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24));
        jLabel1.setForeground(new java.awt.Color(255, 51, 255));
        jLabel1.setText("Welcome!");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 15, 115, 38));

        // To Add Student button sa settings 
        AddStudent.setFont(new java.awt.Font("Verdana", 0, 14));
        AddStudent.setForeground(new java.awt.Color(0, 255, 0));
        AddStudent.setText("Add Student");
        AddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddStudentActionPerformed(evt);
            }
        });
        getContentPane().add(AddStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 103, 136, 37));

        // Para maupdate ang Student button settings 
        UpdateStudent.setFont(new java.awt.Font("Verdana", 0, 14));
        UpdateStudent.setForeground(new java.awt.Color(255, 255, 102));
        UpdateStudent.setText("Update Student");
        UpdateStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateStudentActionPerformed(evt);
            }
        });
        getContentPane().add(UpdateStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 103, -1, 37));

        // Logout button settings 
        Logout.setFont(new java.awt.Font("Verdana", 0, 14));
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        getContentPane().add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 181, 142, 33));

        // Background image 
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Students Account\\Downloads\\UIC-Campus3_kIeAovs.jpg"));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 300));

        pack(); // iadjusts ang layout 
    }

    // Event handler for Delete Student button 
    private void DeleteStudentActionPerformed(java.awt.event.ActionEvent evt) {
        Delete a = new Delete();
        a.setVisible(true);
    }

    // Event handler para sa Update Student button 
    private void UpdateStudentActionPerformed(java.awt.event.ActionEvent evt) {
        Update b = new Update();
        b.setVisible(true);
    }

    // Event handler para sa Add Student button 
    private void AddStudentActionPerformed(java.awt.event.ActionEvent evt) {
        Add c = new Add();
        c.setVisible(true);
    }

    // Event handler para sa Logout button
    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {
        Login d = new Login();
        d.setVisible(true);
    }

    /**
     * // Main method para patakbuhin ang Dashboard
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration 
    private javax.swing.JButton AddStudent;
    private javax.swing.JButton DeleteStudent;
    private javax.swing.JButton Logout;
    private javax.swing.JButton UpdateStudent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
}

