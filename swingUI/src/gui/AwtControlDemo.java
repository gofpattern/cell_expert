package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AwtControlDemo {

   private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;
   private Panel bookMarkPanel;

   public AwtControlDemo(){
      prepareGUI();
   }

   public static void main(String[] args){
      AwtControlDemo  awtControlDemo = new AwtControlDemo();
      awtControlDemo.showTextFieldDemo();
   }

   private void prepareGUI(){
      mainFrame = new Frame("Java AWT Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new Label();
      headerLabel.setAlignment(Label.CENTER);
      statusLabel = new Label();        
      statusLabel.setAlignment(Label.CENTER);
      statusLabel.setSize(350,100);

      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   private void showTextFieldDemo(){
      headerLabel.setText("Control in action: TextField"); 

      Label  namelabel= new Label("User ID: ", Label.RIGHT);
      Label  passwordLabel = new Label("Password: ", Label.CENTER);
      final TextField userText = new TextField(6);
      final TextField passwordText = new TextField(6);
      passwordText.setEchoChar('*');

      Button loginButton = new Button("Login");
      Button addBookMark = new Button("Add New Bookmark");
   
      //attache Listener to login button
      loginButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) { 
        	 String data = "Username: " + userText.getText();
             data += ", Password: " + passwordText.getText();
             statusLabel.setText(data); 
            System.out.println(e.getActionCommand());
            
            
         }
      }); 
      
      // attach listener to Bookmark button
      addBookMark.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {     
             System.out.println(e.getActionCommand());
             //build the Bookmark panel
             JTextField bookMarkName = new JTextField(5);
             JTextField bookMarkUrl = new JTextField(5);
             bookMarkPanel = new Panel();
             bookMarkPanel.add(new JLabel("Book Mark Name"));
             bookMarkPanel.add(bookMarkName);
             bookMarkPanel.add(new JLabel("Book Url"));
             bookMarkPanel.add(bookMarkUrl);
             int result = JOptionPane.showConfirmDialog(null, bookMarkPanel, 
                     "Please Enter bookmark and its URL", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
               System.out.println("BookMark: " + bookMarkName.getText());
               System.out.println(" URL: " + bookMarkUrl.getText());
               controlPanel.add(new Button(bookMarkName.getText()));
               controlPanel.add(new JTextField(bookMarkUrl.getText()));
               mainFrame.setVisible(true);
            }
          }
       }); 
      
      
     
      controlPanel.add(addBookMark);
      controlPanel.add(namelabel);
      controlPanel.add(userText);
      controlPanel.add(passwordLabel);       
      controlPanel.add(passwordText);
      controlPanel.add(loginButton);
      mainFrame.setVisible(true);  
   }
}
