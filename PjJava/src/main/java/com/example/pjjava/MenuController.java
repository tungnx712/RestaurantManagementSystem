package com.example.pjjava;

import dao.JDBCConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.*;


public class MenuController implements Initializable {
    @FXML
    private TableView<?> client_tableView;

    @FXML
    private Button clientsBtn;

    @FXML
    private AnchorPane clientsForm;

    @FXML
    private Button clients_addBtn;

    @FXML
    private Button clients_clearBtn;

    @FXML
    private TableColumn<?, ?> clients_col_customersId;

    @FXML
    private TableColumn<?, ?> clients_col_email;

    @FXML
    private TableColumn<?, ?> clients_col_phonenumber;

    @FXML
    private TextField clients_customers;

    @FXML
    private Button clients_deleteBtn;

    @FXML
    private TextField clients_email;

    @FXML
    private TextField clients_phonenumber;

    @FXML
    private TextField clients_search;

    @FXML
    private Button clients_updateBtn;

    @FXML
    private Button close;

    @FXML
    private Button dashboardBtn;

    @FXML
    private AnchorPane dashboardForm;

    @FXML
    private BarChart<?, ?> dashboardICChart;

    @FXML
    private Label dashboardNOC;

    @FXML
    private BarChart<?, ?> dashboardNOCChart;

    @FXML
    private Label dashboardTodayIncome;

    @FXML
    private Label dashboardTotalIncome;

    @FXML
    private Button employeesBtn;

    @FXML
    private AnchorPane employeesForm;

    @FXML
    private Button employees_addBtn;

    @FXML
    private Button employees_clearBtn;

    @FXML
    private TableColumn<?, ?> employees_col_department;

    @FXML
    private TableColumn<?, ?> employees_col_empId;

    @FXML
    private TableColumn<?, ?> employees_col_name;

    @FXML
    private TableColumn<?, ?> employees_col_position;

    @FXML
    private TableColumn<?, ?> employees_col_salary;

    @FXML
    private Button employees_deleteBtn;

    @FXML
    private TextField employees_epartment;

    @FXML
    private ImageView employees_imageview;

    @FXML
    private Button employees_import;

    @FXML
    private TextField employees_name;

    @FXML
    private TextField employees_position;

    @FXML
    private TextField employees_salary;

    @FXML
    private TextField employees_search;

    @FXML
    private Button employees_updateBtn;

    @FXML
    private TableView<?> employess_tableView;

    @FXML
    private AnchorPane inventory_form;

    @FXML
    private AnchorPane inventory_form1;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane mainForm;

    @FXML
    private TextField menuSearch;

    @FXML
    private TableColumn<DishData, String> menu_col_madePrice;

    @FXML
    private TableColumn<DishData, String> menu_col_dishId;

    @FXML
    private TableColumn<DishData, String> menu_col_dishName;

    @FXML
    private TableColumn<DishData, String> menu_col_price;

    @FXML
    private TableColumn<DishData, String> menu_col_status;

    @FXML
    private TableColumn<DishData, String> menu_col_stock;

    @FXML
    private TableColumn<DishData, String> menu_col_typeDish;

    @FXML
    private TableView<DishData> menu_tableView;

    @FXML
    private Button menuitemsBtn;

    @FXML
    private AnchorPane menuitemsForm;

    @FXML
    private Button menuitems_addBtn;

    @FXML
    private Button menuitems_clearBtn;

    @FXML
    private Button menuitems_deleteBtn;

    @FXML
    private TextField menuitems_dishName;

    @FXML
    private ImageView menuitems_imageview;

    @FXML
    private Button menuitems_import;

    @FXML
    private TextField menuitems_price;

    @FXML
    private ComboBox<?> menuitems_status;

    @FXML
    private TextField menuitems_stock;

    @FXML
    private ComboBox<?> menuitems_type;

    @FXML
    private TextField menuitems_madePrice;

    @FXML
    private Button menuitems_updateBtn;

    @FXML
    private Button minimize;

    @FXML
    private Button orderAddBtn;

    @FXML
    private TextField orderAmount;

    @FXML
    private TableColumn<?, ?> orderColPrice;

    @FXML
    private TableColumn<?, ?> orderColProductID;

    @FXML
    private TableColumn<?, ?> orderColProductName;

    @FXML
    private TableColumn<?, ?> orderColQuantity;

    @FXML
    private TableColumn<?, ?> orderColType;

    @FXML
    private Button orderPayBtn;

    @FXML
    private ComboBox<?> orderProductID;

    @FXML
    private ComboBox<?> orderProductName;

    @FXML
    private Spinner<?> orderQuantity;

    @FXML
    private Button orderReceiptBtn;

    @FXML
    private Button orderRemoveBtn;

    @FXML
    private TableView<?> orderTableView;

    @FXML
    private Label orderTotal;

    @FXML
    private Button tablesBtn;

    @FXML
    private AnchorPane tablesForm;

    @FXML
    private Label username;


    Alert alert;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;

    private Image image;

    public void menuAddBtn() throws SQLException {
        if (menuitems_dishName.getText().isEmpty()
                || menuitems_type.getSelectionModel().getSelectedItem() == null
                || menuitems_status.getSelectionModel().getSelectedItem() == null
                || menuitems_price.getText().isEmpty()
                || menuitems_madePrice.getText().isEmpty()
                || menuitems_stock.getText().isEmpty()
                || data.path == null) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {
            String checkDishName = "SELECT dish_name FROM dish WHERE dish_name = '"
                    + menuitems_dishName.getText() + "'";
            connection = JDBCConnect.getJDBCConnection();
            try {
                statement = connection.createStatement();
                resultSet = preparedStatement.executeQuery(checkDishName);
                if (resultSet.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(menuitems_dishName.getText() + " is already taken");
                    alert.showAndWait();
                } else {
                    // INSERT TABLE DISH
                    String sqlDish = "INSERT INTO dish"
                            + "(dish_name, availability, price, made_price, stock, image_link )"
                            + "VALUES(?,?,?,?,?,?)";

                    PreparedStatement preparedStatementDish = connection.prepareStatement(sqlDish);
                    preparedStatementDish.setString(1, menuitems_dishName.getText());
                    preparedStatementDish.setString(2, (String) menuitems_status.getSelectionModel().getSelectedItem());
                    preparedStatementDish.setDouble(3, Double.parseDouble(menuitems_price.getText()));
                    preparedStatementDish.setDouble(4, Double.parseDouble(menuitems_madePrice.getText()));
                    preparedStatementDish.setString(5, menuitems_stock.getText());

                    String path = data.path;
                    path = path.replace("\\", "\\\\");

                    preparedStatementDish.setString(6, path);

                    preparedStatementDish.executeUpdate();
//            INSERT TYPE_ID

                    String sqltypeID = "SELECT type_ID FROM types WHERE type_name = ?";
                    PreparedStatement preparedStatementTypeId = connection.prepareStatement(sqltypeID);
                    preparedStatementTypeId.setString(1, (String) menuitems_type.getSelectionModel().getSelectedItem());
                    ResultSet resultSet = preparedStatementTypeId.executeQuery();
                    int type_ID = 0;
                    if (resultSet.next()) {
                        type_ID = resultSet.getInt("type_ID");
                    }

                    String sqlType = "INSERT INTO types_dish(type_ID) VALUES (?)";
                    PreparedStatement preparedStatementType = connection.prepareStatement(sqlType);
                    preparedStatementType.setInt(1, type_ID);
                    preparedStatementType.executeUpdate();
//            String sqlType = "INSERT INTO types_dish"
//                    + "(type_ID)"
//                    + "VALUES(?)";
//            PreparedStatement preparedStatementType = connection.prepareStatement(sqlType);
//            preparedStatementType.setString(1,(String) menuitems_type.getSelectionModel().getSelectedItem());
//
//            preparedStatementType.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    menuShowData();
                    menuClearBtn();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void menuUpdateBtn() throws SQLException {
        if (menuitems_dishName.getText().isEmpty()
                || menuitems_type.getSelectionModel().getSelectedItem() == null
                || menuitems_status.getSelectionModel().getSelectedItem() == null
                || menuitems_price.getText().isEmpty()
                || menuitems_madePrice.getText().isEmpty()
                || menuitems_stock.getText().isEmpty()
                || data.path == null
                || data.id == 0) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {

            String path = data.path;
            path = path.replace("\\", "\\\\");

            String updateDish = "UPDATE dish SET " +
                    "dish_name = '" + menuitems_dishName.getText() + "', " +
                    "availability = '" + menuitems_status.getSelectionModel().getSelectedItem() + "', " +
                    "price = '" + menuitems_price.getText() + "', " +
                    "made_price = '" + menuitems_madePrice.getText() + "', " +
                    "stock = '" + menuitems_stock.getText() + "', " +
                    "image_link = '" + path + "' " +
                    "WHERE dish_ID = " + data.id;

            String sqltypeID = "SELECT type_ID FROM types WHERE type_name = ?";
            PreparedStatement preparedStatementTypeId = connection.prepareStatement(sqltypeID);
            preparedStatementTypeId.setString(1, (String) menuitems_type.getSelectionModel().getSelectedItem());
            ResultSet resultSet = preparedStatementTypeId.executeQuery();
            int type_ID = 0;
            if (resultSet.next()) {
                type_ID = resultSet.getInt("type_ID");
            }

            String updateType = "UPDATE types_dish SET type_ID = ? WHERE dish_ID = " + data.id;

            connection = JDBCConnect.getJDBCConnection();

            try {

                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure want to Update Dish: " + menuitems_dishName.getText() + "?");
                Optional<ButtonType> optional = alert.showAndWait();
                if (optional.get().equals(ButtonType.OK)) {

                    PreparedStatement preparedStatementDish = connection.prepareStatement(updateDish);
                    preparedStatementDish.executeUpdate();
                    PreparedStatement preparedStatementType = connection.prepareStatement(updateType);
                    preparedStatementType.setInt(1, type_ID);
                    preparedStatementType.executeUpdate();



                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Update");
                    alert.showAndWait();

                    menuShowData();
                    menuClearBtn();

                }else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Updae Faile!");
                    alert.showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void menuDeleteBtn(){

        if (data.id == 0) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else{
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure want to Delete Dish: " + menuitems_dishName.getText() + "?");
            Optional<ButtonType> optional = alert.showAndWait();

            if (optional.get().equals(ButtonType.OK)) {
                String deleteType = "DELETE FROM types_dish WHERE dish_ID = " + data.id;
                String deleteDish = "DELETE FROM dish WHERE dish_ID = " + data.id;
                try {

                    PreparedStatement preparedDeleteType = connection.prepareStatement(deleteType);
                    preparedDeleteType.executeUpdate();
                    PreparedStatement preparedDeleteDish = connection.prepareStatement(deleteDish);
                    preparedDeleteDish.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    menuShowData();
                    menuClearBtn();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Delete Fail");
                alert.showAndWait();
            }
        }

    }

    public void menuClearBtn() {

        menuitems_dishName.setText("");
        menuitems_type.getSelectionModel().clearSelection();
        menuitems_status.getSelectionModel().clearSelection();
        menuitems_price.setText("");
        menuitems_madePrice.setText("");
        menuitems_stock.setText("");
        data.path = "";
        data.id = 0;
        menuitems_imageview.setImage(null);


    }

    public void menuImportBtn() {
        FileChooser openFile = new FileChooser();
        openFile.getExtensionFilters().add(new FileChooser.ExtensionFilter("Open image File", "*png", "*jpg"));

        File file = openFile.showOpenDialog(mainForm.getScene().getWindow());

        if (file != null) {

            data.path = file.getAbsolutePath();
            image = new Image(file.toURI().toString(), 120, 151, false, true);

            menuitems_imageview.setImage(image);
        }
    }

    public ObservableList<DishData> menuDataList() {
        ObservableList<DishData> listData = FXCollections.observableArrayList();
        String sql = "SELECT dish.dish_ID, dish.dish_name, dish.price, dish.made_price, dish.availability, dish.stock, dish.image_link, types.type_name " +
                "FROM dish " +
                "JOIN types_dish ON dish.dish_ID = types_dish.dish_ID " +
                "JOIN types ON types_dish.type_ID = types.type_ID";


        connection = JDBCConnect.getJDBCConnection();

        try {

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            DishData dData;

            while (resultSet.next()) {
                dData = new DishData(resultSet.getInt("dish_ID"),
                        resultSet.getString("dish_name"),
                        resultSet.getString("type_name"),
                        resultSet.getDouble("price"),
                        resultSet.getDouble("made_price"),
                        resultSet.getInt("stock"),
                        resultSet.getString("availability"),
                        resultSet.getString("image_link"));

                listData.add(dData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<DishData> menuListData;

    public void menuShowData() {
        menuListData = menuDataList();

        menu_col_dishId.setCellValueFactory(new PropertyValueFactory<>("dish_ID"));
        menu_col_dishName.setCellValueFactory(new PropertyValueFactory<>("dish_name"));
        menu_col_typeDish.setCellValueFactory(new PropertyValueFactory<>("type_name"));
        menu_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        menu_col_madePrice.setCellValueFactory(new PropertyValueFactory<>("made_price"));
        menu_col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        menu_col_status.setCellValueFactory(new PropertyValueFactory<>("availability"));

        menu_tableView.setItems(menuListData);
    }

    public void menuSelectData() {
        DishData dishData = menu_tableView.getSelectionModel().getSelectedItem();
        int num = menu_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) return;

        menuitems_dishName.setText(dishData.getDish_name());
        menuitems_stock.setText(String.valueOf(dishData.getStock()));
        menuitems_price.setText(String.valueOf(dishData.getPrice()));
        menuitems_madePrice.setText(String.valueOf(dishData.getMade_price()));
        data.id = dishData.getDish_ID();
        data.path = dishData.getImage_link();

        String path = "File:" + dishData.getImage_link();
        image = new Image(path, 120, 151, false, true);
        menuitems_imageview.setImage(image);
    }


    // SHOW TYPE FROM COMBOBOX
    private List<String> typeList() {
        List<String> typeL = new ArrayList<>();
        try {
            String sql = "SELECT type_name FROM types";
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String typename = resultSet.getString("type_name");
                typeL.add(typename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return typeL;
    }

    public void menuTypeList() {
        List<String> typeL = typeList();
        ObservableList listData = FXCollections.observableArrayList(typeL);
        menuitems_type.setItems(listData);
    }

    // SHOW STATUS FROM COMBOBOX
    private String[] statusList = {"Availability", "Unavailability"};

    public void menuStatusList() {
        List<String> statusL = new ArrayList<>();
        for (String data : statusList) {
            statusL.add(data);

        }
        ObservableList listData = FXCollections.observableArrayList(statusL);
        menuitems_status.setItems(listData);
    }

    private double x = 0;
    private double y = 0;

    public void close() {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) mainForm.getScene().getWindow();
        stage.setIconified(true);
    }

    // EVENT SWITCH FORM DASHBOARD, AVAILABLE FOODS/DRINKS, ORDER
    public void switchForm(ActionEvent event) {
        if (event.getSource() == dashboardBtn) {
            dashboardForm.setVisible(true);
            tablesForm.setVisible(false);
            menuitemsForm.setVisible(false);
            employeesForm.setVisible(false);
            clientsForm.setVisible(false);

            dashboardBtn.setStyle("-fx-background-color: #eaa649;\n" +
                    "    -fx-text-fill: #fff;\n" +
                    "    -fx-border-width: 0px;");
            tablesBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
            menuitemsBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
            employeesBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
            clientsBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");

        } else if (event.getSource() == tablesBtn) {
            tablesForm.setVisible(true);
            dashboardForm.setVisible(false);
            menuitemsForm.setVisible(false);
            employeesForm.setVisible(false);
            clientsForm.setVisible(false);

            tablesBtn.setStyle("-fx-background-color: #eaa649;\n" +
                    "    -fx-text-fill: #fff;\n" +
                    "    -fx-border-width: 0px;");
            dashboardBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
            menuitemsBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
            employeesBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
            clientsBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");

        } else if (event.getSource() == menuitemsBtn) {
            menuitemsForm.setVisible(true);
            dashboardForm.setVisible(false);
            tablesForm.setVisible(false);
            employeesForm.setVisible(false);
            clientsForm.setVisible(false);

            menuitemsBtn.setStyle("-fx-background-color: #eaa649;\n" +
                    "    -fx-text-fill: #fff;\n" +
                    "    -fx-border-width: 0px;");
            dashboardBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
            tablesBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
            employeesBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
            clientsBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");

        } else if (event.getSource() == employeesBtn) {
            employeesForm.setVisible(true);
            dashboardForm.setVisible(false);
            tablesForm.setVisible(false);
            menuitemsForm.setVisible(false);
            clientsForm.setVisible(false);

            employeesBtn.setStyle("-fx-background-color: #eaa649;\n" +
                    "    -fx-text-fill: #fff;\n" +
                    "    -fx-border-width: 0px;");
            dashboardBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
            tablesBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
            menuitemsBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
            clientsBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");

        } else if (event.getSource() == clientsBtn) {
            clientsForm.setVisible(true);
            employeesForm.setVisible(false);
            dashboardForm.setVisible(false);
            tablesForm.setVisible(false);
            menuitemsForm.setVisible(false);


            clientsBtn.setStyle("-fx-background-color: #eaa649;\n" +
                    "    -fx-text-fill: #fff;\n" +
                    "    -fx-border-width: 0px;");
            dashboardBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
            tablesBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
            menuitemsBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
            employeesBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
        }
    }

    // DISPLAY USERNAME TO WELCOME
    public void displayUsername() {
        String user = data.username;
        user = user.substring(0, 1).toUpperCase() + user.substring(1);

        username.setText(user);
    }

    // EVENT LOGOUT ACCOUNT
    public void logout() {

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure want to logout ?");
            Optional<ButtonType> optional = alert.showAndWait();

            if (optional.get().equals(ButtonType.OK)) {
                logout.getScene().getWindow().hide();

                // LINK YOUR LOGIN
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signIn.fxml")));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8f);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // AVAILABLE FOODS/DRINKS
    private String[] status = {"Available", "Not Available"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayUsername();
        menuTypeList();
        menuStatusList();
        menuShowData();


    }
}
