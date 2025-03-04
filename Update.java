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
// import element sa code ug ibasa niya with this para mawork ang code

public class Update extends javax.swing.JFrame {

    private static String usname, pass, type = "admin"; // Stores user credentials
    private static String filepath = "src\\Data.json"; // File path sa json file
    private static JSONParser jsonParser = new JSONParser(); // JSON parser object 
    private static JSONObject record = new JSONObject(); // Stores ang JSON data
    private static JSONArray userlist = new JSONArray(); // istore ang user list 

    public Update() {
        initComponents(); // istart ang GUI components 
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // GUI components initialization or istart niya ang GUI components
    }

    private void updateActionPerformed(java.awt.event.ActionEvent evt) { 
        try {
            filecheck(); // iCheck ug iloads JSON file
            String currentUsername = usernameupdate.getText().trim(); // To get current username
            String newUsername = NewUser.getText().trim(); // To get new username
            String newPassword = Password.getText().trim(); // To get new password
            boolean found = false; // Flag to check if user exists 

            for (int i = 0; i < userlist.size(); i++) {
                JSONObject user = (JSONObject) userlist.get(i);
                if (user.get("username").equals(currentUsername)) { // Checks if ang username kay tama or mali
                    user.put("username", newUsername.isEmpty() ? currentUsername : newUsername); // To updates the username
                    user.put("password", newPassword.isEmpty() ? user.get("password") : newPassword); // To update the password
                    found = true;
                    break;
                }
            }
            if (found) {
                record.put("users", userlist); // Saves ug updated ang user list
                JOptionPane.showMessageDialog(this, "User updated successfully."); // Success message 
            } else {
                JOptionPane.showMessageDialog(this, "User not found."); // User not found warning message
            }
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex); // Logs error if naay mali 
            JOptionPane.showMessageDialog(this, "An error occurred."); // Error warning message if naay mali
        }

        this.dispose(); // Closes current window 
        Dashboard e = new Dashboard();
        e.setVisible(true); // Open or iabrihan ang dashboard
    }
    
    private void ClearupdateActionPerformed(java.awt.event.ActionEvent evt) {
        usernameupdate.setText(""); // Clears username field
        UpdatePassword.setText(""); // Clears password field or iclear niya ang password field
        NewUser.setText(""); // iClears niya ang new user field 
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Update().setVisible(true); // Runs the Update form
        });
    }
    
    public void filecheck() throws FileNotFoundException, IOException, ParseException {
        FileReader reader = new FileReader(filepath); // Reads JSON file 

        if (reader.ready()) {
            Scanner scan = new Scanner(reader);
            String line = "";
            while (scan.hasNext()) {
                line += scan.nextLine(); // Ibasa ang each line sa code or iscan
            }
            reader.close();

            if (!line.equals("")) {
                FileReader reader2 = new FileReader(filepath);
                record = (JSONObject) jsonParser.parse(reader2); //Ibasa ang JSON and iparse
                userlist = (JSONArray) record.get("users"); // Loads user list
                reader2.close();
            }
        }

        this.dispose(); // Closes current window 
        Dashboard e = new Dashboard();
        e.setVisible(true); // Opens dashboard
    }
}
