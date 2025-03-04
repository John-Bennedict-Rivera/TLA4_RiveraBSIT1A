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
public class Delete extends javax.swing.JFrame {

    // Global variables for user credentials and file handling
    private static String usname, pass, type = "admin"; // Username, password, and user type

    private static String filepath = "src\\Data.json"; // File path para sa JSON data
    private static JSONParser jsonParser = new JSONParser(); // JSON parser para maread ang file
    private static JSONObject record = new JSONObject(); // JSON object para mastore ang user data
    private static JSONArray userlist = new JSONArray(); // JSON array to hold users

    /**
     * To create ug new na form Delete
     * 
     */
    public Delete() {
        initComponents(); // istart ang components or Initialize components (auto-generated UI code)
    }

    @SuppressWarnings("unchecked")
    // Auto-generated UI initialization code
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        Delete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Userdelete = new javax.swing.JTextField();
        Deletepassword = new javax.swing.JTextField();
        Clear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); 
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setText("Delete");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 21, 48, 36));

        // Delete button
        Delete.setForeground(new java.awt.Color(255, 51, 0));
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        getContentPane().add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 214, 69, -1));

        // Label para sa Username
        jLabel2.setForeground(new java.awt.Color(102, 255, 102));
        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 81, 103, 27));

        // Label para sa Password
        jLabel3.setForeground(new java.awt.Color(102, 255, 102));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 129, 86, 24));
        getContentPane().add(Userdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 83, 98, -1));

        // Password field
        Deletepassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletepasswordActionPerformed(evt);
            }
        });
        getContentPane().add(Deletepassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 130, 98, -1));

        // Clear button - resets the text fields or ierase any text nasa sa textbox
        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        getContentPane().add(Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 214, -1, -1));

        pack();
    }

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            filecheck(); // iload ang user data from file

            String usernameToDelete = Userdelete.getText(); // kuhaaon ang username from input
            boolean found = false; // Flag ug icheck if ang user exists

            // Loop through user list to find and delete user
            for (int i = 0; i < userlist.size(); i++) {
                JSONObject user = (JSONObject) userlist.get(i);
                if (user.get("username").equals(usernameToDelete)) {
                    userlist.remove(i);
                    found = true;
                    break;
                }
            }

            // ishow ang message if deleted or not found
            if (found) {
                record.put("users", userlist);
                JOptionPane.showMessageDialog(null, "Successfully deleted.");
            } else {
                JOptionPane.showMessageDialog(null, "User not found.");
            }
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.dispose(); // Closing the delete window
        Dashboard e = new Dashboard(); // Open the dashboard again
        e.setVisible(true);
    }    

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Userdelete.setText(""); // to clear username field
        Deletepassword.setText(""); // to clear password field
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
    }
}
