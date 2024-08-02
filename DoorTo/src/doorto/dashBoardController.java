/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doorto;

import doorto.serviceData; 
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class dashBoardController implements Initializable {

    @FXML
    private ComboBox<?> available_Area;

    @FXML
    private Button available_Btn;

    @FXML
    private Button available_ClearBtn;

    @FXML
    private AnchorPane available_Form;

    @FXML
    private Button available_InsertBtn;

    @FXML
    private TextField available_Price;

    @FXML
    private TextField available_RmSz;

    @FXML
    private TextField available_Search;

    @FXML
    private TextField available_Sid;

    @FXML
    private TextField available_Sname;

    @FXML
    private TableView<serviceData> available_Tableview;

    @FXML
    private Button available_UpdateBtn;

    @FXML
    private TableColumn<serviceData, String> available_col_Area;

    @FXML
    private TableColumn<serviceData, String> available_col_Price;

    @FXML
    private TableColumn<serviceData, String> available_col_RmSz;

    @FXML
    private TableColumn<serviceData, String> available_col_Sid;

    @FXML
    private TableColumn<serviceData, String> available_col_Sname;

    @FXML
    private Button available_deleteBtn;

    @FXML
    private ImageView available_imageView;

    @FXML
    private Button available_importBtn;

    @FXML
    private Button close;

    @FXML
    private BarChart<?, ?> home_BarChartIncome;

    @FXML
    private LineChart<?, ?> home_LineChartCustomer;

    @FXML
    private Label home_TotalCustomers;

    @FXML
    private Label home_TotalIncome;

    @FXML
    private Label home_availableService;

    @FXML
    private Button home_btn;

    @FXML
    private Button logoutBtn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button minimize;

    @FXML
    private ComboBox<?> rent_Area;

    @FXML
    private Button rentBtn;

    @FXML
    private DatePicker rentDate_back;

    @FXML
    private DatePicker rentDate_start;

    @FXML
    private Button rent_Btn;

    @FXML
    private ComboBox<?> rent_Gendar;

    @FXML
    private TextField rent_LastName;

    @FXML
    private ComboBox<?> rent_Sname;

    @FXML
    private TextField rent_amount;

    @FXML
    private Label rent_balance;
    
    @FXML
    private TableView<serviceData> rent_tablView;

    @FXML
    private TableColumn<serviceData, String> rent_col_Area;

    @FXML
    private TableColumn<serviceData, String> rent_col_Price;

    @FXML
    private TableColumn<serviceData, String> rent_col_RmSz;

    @FXML
    private TableColumn<serviceData, String> rent_col_Sid;

    @FXML
    private TableColumn<serviceData, String> rent_col_Sname;

    @FXML
    private TextField rent_firstName;

    @FXML
    private AnchorPane rent_form;
    
     @FXML
    private AnchorPane home_form;

    @FXML
    private ComboBox<?> rent_sId;


    @FXML
    private Label rent_total;

    @FXML
    private Label username;
    
    
    
     //Database Tools 
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;
    private Image image;
    /////////////////////////////////////////////////////
    
    
    //------------------------------------------------------------------------------------Home Dashboard part-----------------------------------------------------------------------------------------
    
    // Home - available Car
    public void homeAvailableService(){
       String sql = "SELECT COUNT(id) FROM servicesavail WHERE area = 'Available'";
        
          connect = Database.connectDb();
        int countAC = 0;
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                countAC = result.getInt("COUNT(id)");
            }
            
            home_availableService.setText(String.valueOf(countAC));
            
        }catch(Exception e){e.printStackTrace();}
    }
    
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    // home - total income
    
    public void homeTotalIncome(){
  String sql = "SELECT SUM(total) FROM customer";
        
        double sumIncome = 0;
        
        connect = Database.connectDb();
        
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                sumIncome = result.getDouble("SUM(total)");
            }
            home_TotalIncome.setText("$" + String.valueOf(sumIncome));
        }catch(Exception e){e.printStackTrace();}
      
    }
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    
    // home - Total Customer
    public void homeTotalCustomers(){
             String sql = "SELECT COUNT(id) FROM customer";
        
        int countTC = 0;
        
        connect = Database.connectDb();
        
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                countTC = result.getInt("COUNT(id)");
            }
            home_TotalCustomers.setText(String.valueOf(countTC));
        }catch(Exception e){e.printStackTrace();}
    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
// home - Total incom bar chart
    public void homeIncomeChart(){
            
        home_BarChartIncome.getData().clear();
        
        String sql = "SELECT date_rent, SUM(total) FROM customer GROUP BY date_rent ORDER BY TIMESTAMP(date_rent) ASC LIMIT 6";
        
        connect = Database.connectDb();
        
        try{
            XYChart.Series chart = new XYChart.Series();
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }
            
            home_BarChartIncome.getData().add(chart);
            
        }catch(Exception e){e.printStackTrace();}
    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  
    // home - Total Customer line chart
    public void homeCustomerChart(){
          home_LineChartCustomer.getData().clear();
       String sql = "SELECT date_rent, COUNT(id) FROM customer GROUP BY date_rent ORDER BY TIMESTAMP(date_rent) ASC LIMIT 4";
        
        connect = Database.connectDb();
        
        try{
            XYChart.Series chart = new XYChart.Series();
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }
            
            home_LineChartCustomer.getData().add(chart);
            
        }catch(Exception e){e.printStackTrace();}
    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    //------------------------------------------------------------------------------------Available part-----------------------------------------------------------------------------------------
    
    
    
     //For available Service Add
    public void availabeServiceAdd(){
        String sql= "INSERT INTO servicesavail(sid, sname, roomsz,price, area, image,date)" + "VALUES(?,?,?,?,?,?,?)";
         connect=Database.connectDb();
         
          try{
              Alert alert;
              
              if(available_Sid.getText().isEmpty()
                      || available_Sname.getText().isEmpty()
                      || available_RmSz.getText().isEmpty()
                      || available_Area.getSelectionModel().getSelectedItem() == null
                      || available_Price.getText().isEmpty()
                      || getData.path == null || getData.path == ""  )
              {
                  alert=new Alert(AlertType.ERROR);
                  alert.setTitle("Error message..");
                  alert.setHeaderText(null);
                  alert.setContentText("Please fill all blank fields....");
                  alert.showAndWait();
                  
              }else{
              
              prepare = connect.prepareStatement(sql);
              prepare.setString(1, available_Sid.getText());
              prepare.setString(2, available_Sname.getText());
              prepare.setString(3, available_RmSz.getText());
              prepare.setString(4, available_Price.getText());
               prepare.setString(5, (String)available_Area.getSelectionModel().getSelectedItem());
              
              String uri= getData.path;
              uri = uri.replace("\\", "\\\\");
              
              prepare.setString(6, uri);
              
              Date date=new Date();
              java.sql.Date sqlDate= new java.sql.Date(date.getTime());
              
              prepare.setString(7,String.valueOf(sqlDate));
              
              prepare.executeUpdate();
              
                  alert=new Alert(AlertType.INFORMATION);
                  alert.setTitle("Information message..");
                  alert.setHeaderText(null);
                  alert.setContentText("Successfully added......");
                  alert.showAndWait();
                  
                  availableShowListServiceListData();
                  availableServiceClear();
                  availableServiceSearch();
                  
              }       
          }catch(Exception e)
       {
           e.printStackTrace();
       }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    // Update - from available form
    public void availableServiceUpdate(){
        
       String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        String sql = "UPDATE servicesavail SET sname = '" + available_Sname.getText()+ "', roomsz = '"
                + available_RmSz.getText() + "', area ='"
                + available_Area.getSelectionModel().getSelectedItem() + "', price = '"
                + available_Price.getText() + "', image = '" + uri
                + "' WHERE sid = '" + available_Sid.getText() + "'";

        connect = Database.connectDb();

        try {
            Alert alert;

            if (available_Sid.getText().isEmpty()
                    || available_Sname.getText().isEmpty()
                    || available_RmSz.getText().isEmpty()
                    || available_Area.getSelectionModel().getSelectedItem() == null
                    || available_Price.getText().isEmpty()
                    || getData.path == null || getData.path == "") {
                
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Service ID: " + available_Sid.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    availableShowListServiceListData();
                    availableServiceClear();
                    availableServiceSearch();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //////////////////////////////////////////////////////////////////
    
    
    
     // Delete - from available form
    public void availableServiceDelete(){
        String sql=" DELETE  FROM servicesavail WHERE sid=  ' "+available_Sid.getText()+" ' ";
             
        connect=Database.connectDb();
          try{
               Alert alert;
              
               if(available_Sid.getText().isEmpty()
                      || available_Sname.getText().isEmpty()
                      || available_RmSz.getText().isEmpty()
                      || available_Area.getSelectionModel().getSelectedItem() == null
                      || available_Price.getText().isEmpty()
                      || getData.path == null || getData.path == "" )
              {
                  alert=new Alert(AlertType.ERROR);
                  alert.setTitle("Error message..");
                  alert.setHeaderText(null);
                  alert.setContentText("Please fill all blank fields....");
                  alert.showAndWait();
                  
              }else{
                  alert=new Alert(AlertType.CONFIRMATION);
                  alert.setTitle("Confirmation message..");
                  alert.setHeaderText(null);
                  alert.setContentText("Are you sure to DELETE  service sid:  " +available_Sid.getText()+"?" );
                       
           Optional<ButtonType> option= alert.showAndWait();
     
            if(option.get().equals(ButtonType.OK))
                  {
                    statement= connect.createStatement();
                    statement.executeUpdate(sql); // sql - from availableServiceUpdate()
                    
                  alert=new Alert(AlertType.INFORMATION);
                  alert.setTitle("Information message..");
                  alert.setHeaderText(null);
                  alert.setContentText("Successfully deleted......");
                  alert.showAndWait();
                  

                  availableShowListServiceListData();
                  availableServiceClear();
                  availableServiceSearch();
                  }     
               }
              
          }catch(Exception e)
       {
           e.printStackTrace();
       }
        
    }
    
    
    ////////////////////////////////////////////////////////////////////
    
    
    // Clear - from available form
    public void availableServiceClear(){
        available_Sid.setText("");
        available_Sname.setText("");
        available_RmSz.setText(""); // name change - area
        available_Area.getSelectionModel().clearSelection();   // name change - Status
        available_Price.setText("");
        
        getData.path = "";
        
       available_imageView.setImage(null);

    }
    ///////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    // Status area - available , not available
    private String[] listStatusArea ={"Available","Not Available"};
    
    public void availableServiceStatusAreaList(){
        List<String> listS = new ArrayList<>();
        
        for(String data: listStatusArea)
        {
            listS.add(data);
        }
        
        ObservableList listData=FXCollections.observableArrayList(listS);
        
        available_Area.setItems(listData);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    //For available import image
    public void availableServiceImportImage(){
        FileChooser open=new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File","*jpg","*png")) ;
       
        File file=open.showOpenDialog(main_form.getScene().getWindow());
       
       if(file !=null)
       {
           
           getData.path=file.getAbsolutePath();
           
           
           
           image=new Image(file.toURI().toString(),285,146, false, true );
           available_imageView.setImage(image);
       }
       
       
    }
    /////////////////////////////////////////////////////////////////////////////////
    
    //For available Service Data
    public ObservableList<serviceData> availableServiceListData(){
    
        ObservableList<serviceData> listdata= FXCollections.observableArrayList();
    
    String sql = "SELECT * FROM servicesavail"; // function for serviceData
    
     connect=Database.connectDb();
          try{
              prepare = connect.prepareStatement(sql);
               result= prepare.executeQuery();
               
               serviceData serviceData;
               
               while(result.next())
               {
                   serviceData=new serviceData(result.getInt("sid")
                                                      , result.getString("sname") 
                                                      , result.getString("roomsz")
                           
                                                      ,result.getDouble("price") 
                                                      ,result.getString("area")
                                                      ,result.getString("image")
                                                      ,result.getDate("date"));
                   
                   listdata.add(serviceData);
               }
              
          }catch(Exception e)
       {
           e.printStackTrace();
       }
          return listdata;
}   
 ///////////////////////////////////////////////////////////////////////////
    
    
    
 ////For available Service  Data Show List
     private ObservableList<serviceData> availableServiceList;
    
    public void availableShowListServiceListData(){
    availableServiceList=   availableServiceListData();
    
    available_col_Sid.setCellValueFactory(new PropertyValueFactory<>("sid"));
    available_col_Sname.setCellValueFactory(new PropertyValueFactory<>("sname"));
    available_col_RmSz.setCellValueFactory(new PropertyValueFactory<>("roomsz"));
    available_col_Price.setCellValueFactory(new PropertyValueFactory<>("price"));
    available_col_Area.setCellValueFactory(new PropertyValueFactory<>("area"));
    
    
    available_Tableview.setItems(availableServiceList);
}
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
// Search from service list
   public void availableServiceSearch() {

        FilteredList<serviceData> filter = new FilteredList<>(availableServiceList, e -> true);

        available_Search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateCarData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateCarData.getSid().toString().contains(searchKey)) {
                    return true;
                } else if (predicateCarData.getSname().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCarData.getRoomsz().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCarData.getPrice().toString().contains(searchKey)) {
                    return true;
                } else if (predicateCarData.getArea().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<serviceData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(available_Tableview.comparatorProperty());
        available_Tableview.setItems(sortList);

    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
       
    
    //Select all details available
    public void availableServiceSelect(){
        serviceData serviceData = available_Tableview.getSelectionModel().getSelectedItem();
        int num = available_Tableview.getSelectionModel().getSelectedIndex();
        
        
        if(num-1 < -1){return;}
        
        available_Sid.setText(String.valueOf(serviceData.getSid()));
        available_Sname.setText(serviceData.getSname());
        available_RmSz.setText(serviceData.getRoomsz());
        available_Price.setText(String.valueOf(serviceData.getPrice()));
        
        getData.path = serviceData.getImage();
        
        String uri="file:" + serviceData.getImage();

        image= new Image(uri, 285,146, false, true);
        available_imageView.setImage(image);

    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
 //------------------------------------------------------------------------------------Rent part-----------------------------------------------------------------------------------------
    
   
    
    // rent - pay
   
    public void rentPay(){
        rentCustomerId();
         String sql= "INSERT INTO customer"
                 +"( customer_id, customer_firstname, customer_lastname, gender, sid, sname"
                 + ", roomsz, total, date_rent, date_back)"
                 + "VALUES (?,?,?,?,?,?,?,?,?,?)";
         
          connect = Database.connectDb();

       try{
              Alert alert;
              
              if(rent_firstName.getText().isEmpty()
                      || rent_LastName.getText().isEmpty()
                      || rent_Gendar.getSelectionModel().getSelectedItem() == null
                      || rent_sId.getSelectionModel().getSelectedItem() == null
                      || rent_Sname.getSelectionModel().getSelectedItem() == null
                      || rent_Area.getSelectionModel().getSelectedItem() == null
                      || totalP == 0 || rent_amount.getText().isEmpty())
              {
                  alert=new Alert(AlertType.ERROR);
                  alert.setHeaderText(null);
                  alert.setContentText("Something wrong : 3 !!!");
                  alert.showAndWait();
                  
              }else{
                  
              alert = new Alert(AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)){    
              
              prepare = connect.prepareStatement(sql);
              prepare.setString(1, String.valueOf(customerId));
              prepare.setString(2, rent_firstName.getText());
              prepare.setString(3, rent_LastName.getText());
              prepare.setString(4, (String)rent_Gendar.getSelectionModel().getSelectedItem()); 
              prepare.setString(5, (String)rent_sId.getSelectionModel().getSelectedItem()); 
              prepare.setString(6, (String)rent_Sname.getSelectionModel().getSelectedItem()); 
              prepare.setString(7, (String)rent_Area.getSelectionModel().getSelectedItem()); 
              prepare.setString(8, String.valueOf(totalP));
              prepare.setString(9, String.valueOf(rentDate_start.getValue()));
              prepare.setString(10, String.valueOf(rentDate_back.getValue()));
              
              prepare.executeUpdate();
              
              // SET THE  STATUS OF CAR TO NOT AVAILABLE 
                    String updateService = "UPDATE servicesavail SET area = 'Not Available' WHERE sid = '"
                            +rent_sId.getSelectionModel().getSelectedItem()+"'";
                    
                    statement = connect.createStatement();
                    statement.executeUpdate(updateService);
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Successful!");
                    alert.showAndWait();
                    
                   rentServiceShowlistData(); 
                    rentClear();
                } // Now Let's proceed the DashBoard form
              } 
          }catch (Exception e) 
        {
            e.printStackTrace();
        }
    }      
 
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
    
    // rent - clear
      public void rentClear(){
        totalP = 0;
        rent_firstName.setText("");
        rent_LastName.setText("");
        rent_Gendar.getSelectionModel().clearSelection();
        amount = 0;
        balance = 0;
        rent_balance.setText("$0.0");
        rent_total.setText("$0.0");
        rent_amount.setText("");
        rent_sId.getSelectionModel().clearSelection();
        rent_Sname.getSelectionModel().clearSelection();
        rent_Area.getSelectionModel().clearSelection();
    }
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    
      
    // rent - pay
    
     private int customerId;
    public void rentCustomerId(){
         String sql= "SELECT id FROM customer";
         
         connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while(result.next())
            {
                customerId= result.getInt("id")+1;   // GET the last id and add + 1
            }    
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    private double amount;
    private double balance;
    
  // rent - pay
    public void rentAmount(){
        
        Alert alert;
        if(totalP == 0 || rent_amount.getText().isEmpty()){
             alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid :3");
                alert.showAndWait();
               
                rent_amount.setText("");
                
        }else{
            amount = Double.parseDouble(rent_amount.getText());
            
            if(amount >= totalP )
            {
                balance= (amount - totalP);
                
                 rent_balance.setText("$" + String.valueOf(balance));
                 
            }else{
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid :3");
                alert.showAndWait();
                
                rent_amount.setText("");
                
            }
        }
    }
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    //rent - data list
    public ObservableList<serviceData> rentServiceListdata(){
        
        ObservableList<serviceData> listData= FXCollections.observableArrayList();
        String sql= " SELECT * FROM servicesavail";
        
        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            serviceData servicedata;

            while (result.next()) {
                servicedata = new serviceData(result.getInt("sid"), result.getString("sname"),
                         result.getString("roomsz"), result.getDouble("price"),
                         result.getString("area"),
                         result.getString("image"),
                         result.getDate("date"));

                listData.add(servicedata);
            }

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return listData;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    // rent- Date
private int countDate;
    public void rentdate(){
        Alert alert;
        if(rent_sId.getSelectionModel().getSelectedItem() == null
                || rent_Sname.getSelectionModel().getSelectedItem() == null
                || rent_Area.getSelectionModel().getSelectedItem() == null){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Something wrong :3");
            alert.showAndWait();
            
            rentDate_start.setValue(null);
            rentDate_back.setValue(null);
            
        }else{
            
            if(rentDate_back.getValue().isAfter(rentDate_start.getValue())){
                // COUNT THE DAY
                countDate = rentDate_back.getValue().compareTo(rentDate_start.getValue());
            }else{
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Something wrong :3");
                alert.showAndWait();
                // INCREASE OF 1 DAY ONCE THE USER CLICKED THE SAME DAY 
                rentDate_back.setValue(rentDate_start.getValue().plusDays(1));
                
            }
        }
    }
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    // rent- Total Display
  private double totalP;
    public void rentDisplayTotal(){
        rentdate();
        double price = 0;
        String sql = "SELECT price, roomsz FROM servicesavail WHERE roomsz = '"
                +rent_Area.getSelectionModel().getSelectedItem()+"'";
        
        connect = Database.connectDb();
        
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            if(result.next()){
                price = result.getDouble("price");
            }
            // price * the count day you want to use the car
            totalP = (price * countDate);
            // DISPLAY TOTAL
            rent_total.setText("$" + String.valueOf(totalP));
            
        }catch(Exception e){e.printStackTrace();}
        
    }
        
  
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    //rent- Gender
    private String[] genderList={ "Male","Female","Others"};
    public void rentServiceGender(){
        List<String> listG= new ArrayList<>();
        for(String data:genderList )
        {
            listG.add(data);
        }
         ObservableList listData= FXCollections.observableArrayList(listG);
         
        rent_Gendar.setItems(listData);
        
        
    }    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    
    // rent - Service Id available in rent-form
    public void rentServiceServiceId(){
       
        String sql = "SELECT * FROM servicesavail WHERE area = 'Available'";
        connect=Database.connectDb();
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            
             ObservableList listData = FXCollections.observableArrayList();
             
             while(result.next())
             {
                 listData.add(result.getString("sid"));
                 
             }
             rent_sId.setItems(listData);
             
             rentServiceSname();
             
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
       
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    // rent - Service Sname
        public void rentServiceSname(){
            String sql=" SELECT * FROM servicesavail WHERE sid=  ' "+rent_sId.getSelectionModel().getSelectedItem()+" ' ";

        connect = Database.connectDb();
        
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            
             ObservableList listData = FXCollections.observableArrayList();
             
             while(result.next())
             {
                 listData.add(result.getString("sname"));
                 
             }
             rent_Sname.setItems(listData);
             rentServiceArea();
            
        } catch (Exception e) 
          {
            e.printStackTrace();
          }
     }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
        
        
      // rent - Service area
        public void rentServiceArea(){
            String sql=" SELECT * FROM servicesavail WHERE sid=  ' "+rent_sId.getSelectionModel().getSelectedItem()+" ' ";

        connect = Database.connectDb();
        
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            
             ObservableList listData = FXCollections.observableArrayList();
             
             while(result.next())
             {
                 listData.add(result.getString("roomsz"));
                 
             }
             rent_Area.setItems(listData);
             
        } catch (Exception e) 
          {
            e.printStackTrace();
          }
     }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
        
        
        
    // rent show list
    
    private ObservableList<serviceData> rentServiceList;
    
    public void rentServiceShowlistData(){
        rentServiceList = rentServiceListdata();
        
    rent_col_Sid.setCellValueFactory(new PropertyValueFactory<>("sid"));
    rent_col_Sname.setCellValueFactory(new PropertyValueFactory<>("sname"));
    rent_col_RmSz.setCellValueFactory(new PropertyValueFactory<>("roomsz"));
    rent_col_Price.setCellValueFactory(new PropertyValueFactory<>("price"));
    rent_col_Area.setCellValueFactory(new PropertyValueFactory<>("area"));
    
    
     rent_tablView.setItems(rentServiceList);
    }
    
  
    
    
       // for homapge show after welcome
          public void displayUsername(){
        
             String user= getData.username;
    
       //To set first letter to big letter
             username.setText(user.substring(0,1).toUpperCase() + user.substring(1));
          }
    
    
    
   // Confirmatiopn Alert LogOut 
    private double x=0;
    private double y=0;
    public void logout(){
                  Alert  alert=new Alert(Alert.AlertType.CONFIRMATION);
                  alert.setTitle("Confirmation message..");
                  alert.setHeaderText(null);
                  alert.setContentText("Are you sure,Do you want to logout?");
                  Optional<ButtonType> option=  alert.showAndWait();   
     try{        
       if(option.get().equals(ButtonType.OK))
        {
            
            
            //hide my dashboard form
            logoutBtn.getScene().getWindow().hide();
            //Link my login form
             Parent root = FXMLLoader.load(getClass().getResource("DemoFxml.fxml"));
        
        Stage stage= new Stage(); // for root solving new line
        Scene scene = new Scene(root);
        
        root.setOnMousePressed((MouseEvent event) -> {
        x= event.getSceneX();
        y=event.getSceneY();
    });
        
        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
            
            stage.setOpacity(.8);
                       
        });
        
        root.setOnMouseReleased((MouseEvent event) -> {
                stage.setOpacity(1);
            });
        
        stage.initStyle(StageStyle.TRANSPARENT);
        
        stage.setScene(scene);
        stage.show();
                  }
    }catch(Exception e)
       {
           e.printStackTrace();
       }
 }
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    // Home, Availabe,rent form action work and Visibility
    public void switchForm(ActionEvent event) {
        
            if(event.getSource() == home_btn)
            {
                home_form.setVisible(true);
                available_Form.setVisible(false);
                rent_form.setVisible(false);
                
                
            home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #686f86, #8e9296);");
            available_Form.setStyle("-fx-background-color:transparent");
            rent_form.setStyle("-fx-background-color:transparent");
            
            homeTotalIncome();
            homeTotalCustomers();
            homeAvailableService();
            homeIncomeChart();
            homeCustomerChart();
            }
            else if(event.getSource() == available_Btn)
            {
                home_form.setVisible(false);
                available_Form.setVisible(true);
                rent_form.setVisible(false);
                
                
            available_Form.setStyle("-fx-background-color:linear-gradient(to bottom right, #686f86, #8e9296);");
            home_btn.setStyle("-fx-background-color:transparent");
            rent_form.setStyle("-fx-background-color:transparent");
            
            
         //To update my tableviw once click the availabe nav button 
            availableShowListServiceListData();
            availableServiceStatusAreaList();
            availableServiceSearch();
                    
                    
            }
            else if(event.getSource() == rent_Btn)
            {
                home_form.setVisible(false);
                available_Form.setVisible(false);
                rent_form.setVisible(true);
                
            rent_form.setStyle("-fx-background-color:linear-gradient(to bottom right, #686f86, #8e9296);");
            home_btn.setStyle("-fx-background-color:transparent");
            available_Form.setStyle("-fx-background-color:transparent");
            
            rentServiceShowlistData();
            rentServiceServiceId();
            rentServiceSname();
            rentServiceArea();
            rentServiceGender();
            
            }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
     @FXML
     public void close(ActionEvent event) {
            System.exit(0);
    }

    @FXML
    public void minimize() {
      Stage stage=(Stage)main_form.getScene().getWindow();
      stage.setIconified(true);
      
    }
    
   @FXML
    public void maximize(ActionEvent event) {
      Stage stage=(Stage)main_form.getScene().getWindow();
      if(stage.isMaximized())
      {
          stage.setMaximized(false);
      }else{
           stage.setMaximized(true);
      }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();
     
  // Homepage - DashBoard Part
    homeTotalIncome();
    homeTotalCustomers();
    homeAvailableService();
    homeIncomeChart();
    homeCustomerChart();
        
   // Availabel part
        availableShowListServiceListData();
        availableServiceStatusAreaList();
        availableServiceSearch();
        
        
   //Rent part
        rentServiceShowlistData();
        rentServiceServiceId();
        rentServiceSname();
        rentServiceArea();
        rentServiceGender();
    }
    
}
