/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package doorto;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author Admin
 */
public class DemoFxmlController implements Initializable {
    
  
    @FXML
    private Button close;

    @FXML
    private Button loginbt;

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    //Database Tools 
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    
    private double x=0;
    private double y=0;
    
    public void loginAdmin(){
        
           String sql="SELECT * FROM doortable WHERE username = ? and password = ?"; //Table name of database: door totable
           
          connect=Database.connectDb();
          try{
              
              prepare = connect.prepareStatement(sql);
              prepare.setString(1,username.getText()); //Fxid: username
              prepare.setString(2,password.getText()); //Fxid: Password
              
              result= prepare.executeQuery();
              Alert alert;
              if(username.getText().isEmpty() || password.getText().isEmpty())
              {
                  alert=new Alert(AlertType.ERROR);
                  alert.setHeaderText(null);
                  alert.setContentText("Please fill all blank fields");
                  alert.showAndWait();           
              }else{
                  if(result.next())
                  {
                      
                  getData.username = username.getText();
                       
                  alert=new Alert(AlertType.INFORMATION);
                  alert.setHeaderText(null);
                  alert.setContentText("Successfully login..");
                  alert.showAndWait();    
                  
                  
                  //Hide my login form
                  loginbt.getScene().getWindow().hide();
                  
                  //Link my Dashbord Form
                  
                  Parent root  = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
                      
                  Stage stage=new Stage();
                  Scene scene=new Scene(root);
                  
                    root.setOnMousePressed((MouseEvent event) -> {
                           x= event.getSceneX();
                           y=event.getSceneY();
                    });
                  
                    root.setOnMouseDragged((MouseEvent event) -> {
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);                     
                   });
                    
                  stage.initStyle(StageStyle.TRANSPARENT);
                  
                  stage.setScene(scene);
                  stage.show();
                  }
                  else{
                  alert=new Alert(AlertType.ERROR);
                  alert.setHeaderText(null);
                  alert.setContentText("Invalid input ! Please give correct details");
                  alert.showAndWait();    
                  }
              }
              
          }catch(Exception e)
       {
           e.printStackTrace();
       }
    }
      
     @FXML
     public void close(ActionEvent event) {
            System.exit(0);
    }
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

 
    
}
