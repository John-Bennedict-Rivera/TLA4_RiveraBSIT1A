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
 * This class adds user data to a JSON file.
 * 
 */
public class Add extends javax.swing.JFrame {

    private static String adname, adpass, type = "member", types; // Stores user details 

    private static String filepath2 = "src\\Data.json"; // ang JSON file path 
    private static JSONParser jsonParser2 = new JSONParser(); // Parser for reading JSON 
    private static JSONObject record = new JSONObject(); // Object to store all user records 
    private static JSONArray userlist = new JSONArray(); // Lists sa mga users 
    private static JSONObject user = new JSONObject(); // User object 

    /**
     * 
     * Constructor para i-initialize ang form.
     */
    public Add() {
        initComponents();
    }

    // Generated method for UI components 
    @SuppressWarnings("unchecked")
    private void initComponents() {

        username = new javax.swing.JTextField(); // Text field for username 
        password = new javax.swing.JTextField(); // Text field for password 
        Username = new javax.swing.JLabel(); // Label for username 
        Password = new javax.swing.JLabel(); // Label for password 
        jLabel1 = new javax.swing.JLabel(); // Title label 
        Clear = new javax.swing.JButton(); // Button to clear input fields 
        Add = new javax.swing.JButton(); // Button to add user 
        Back = new javax.swing.JButton(); // Button to go back 
        jLabel2 = new javax.swing.JLabel(); // Background image

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); // Uses to Close action 
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout()); // Layout settings 

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 75, 137, 36));
//font color
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 144, 137, 36));
//font color
        Username.setText("Username");
        getContentPane().add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 77, 96, 36));
//font color
        Password.setText("Password");
        getContentPane().add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 146, 96, 36));
//font color
        jLabel1.setText("Add Student");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 16, 84, 41));
//font color
        Clear.setText("Clear"); // Button to clear fields
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        getContentPane().add(Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, 33));

        Add.setText("Add"); // Button para maadd user 
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        getContentPane().add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 84, 33));

        Back.setText("Back"); // Button para mabalik sa previous screen
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 221, -1, 33));

        pack();
    }

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {                                      
        try {
            filecheck(); // iCheck  if ang file exists 
            adname = username.getText(); // to get username input 
            adpass = password.getText(); // to get password input 
            types = type;
            user.put("username", adname); // to store username in JSON object 
            user.put("password", adpass); // to store password in JSON object 
            user.put("type", types); // To store user type

            userlist.add(user); // iadd ang user to list 
            record.put("users", userlist); // Store list sa JSON record 

            save(); // Saving it to file
            JOptionPane.showMessageDialog(null, "Successfully Added into json file..."); // To show the success message
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.dispose(); // Closing the current window
        Dashboard r = new Dashboard(); // To open Dashboard 
        r.setVisible(true);
    }

    public static void filecheck() throws FileNotFoundException, IOException, ParseException {
        FileReader reader = new FileReader(filepath2); // To open JSON file 

        if (reader.ready()) {
            Scanner scan = new Scanner(reader);
            String line = "";

            while (scan.hasNext()) {
                line = line + scan.nextLine();
            }
            reader.close();
            if (!line.equals("")) {
                try (FileReader reader2 = new FileReader(filepath2)) {
                    record = (JSONObject) jsonParser2.parse(reader2); // I-parse ang JSON file
                    userlist = (JSONArray) record.get("users"); // ikuha ang user list 
                }
            }
        }
    }

    public static void save() throws IOException {
        FileWriter file = new FileWriter(filepath2); // Open file for writing
        file.write(record.toJSONString()); // iwrite niya ang JSON data to file
        file.close(); // Closing file
    }
}

    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
