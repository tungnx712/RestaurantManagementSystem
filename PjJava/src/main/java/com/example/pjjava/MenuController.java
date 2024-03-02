package com.example.pjjava;

import dao.JDBCConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


public class MenuController implements Initializable {
    @FXML
    private TableView<ClientData> client_tableView;

    @FXML
    private Button clientsBtn;

    @FXML
    private AnchorPane clientsForm;

    @FXML
    private Button clients_addBtn;

    @FXML
    private Button clients_clearBtn;

    @FXML
    private TableColumn<ClientData, String> clients_col_customersId;

    @FXML
    private TableColumn<ClientData, String> clients_col_phone;

    @FXML
    private TableColumn<ClientData, String> clients_col_customers;

    @FXML
    private TableColumn<ClientData, String> clients_col_dob;

    @FXML
    private TextField clients_customers;

    @FXML
    private Button clients_deleteBtn;

    @FXML
    private TextField clients_email;

    @FXML
    private TextField clients_phonenumber;

    @FXML
    private TextField clients_dob;

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
    private AnchorPane abc;
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
    private Label statusLabel;
    @FXML
    private AnchorPane tableAnchorPane;
    @FXML
    private Button employees_addBtn;

    @FXML
    private Button employees_clearBtn;

    @FXML
    private TableColumn<EmployeesData, String> employees_col_department;

    @FXML
    private TableColumn<EmployeesData, String> employees_col_empId;

    @FXML
    private TableColumn<EmployeesData, String> employees_col_name;

    @FXML
    private TableColumn<EmployeesData, String> employees_col_position;

    @FXML
    private TableColumn<EmployeesData, String> employees_col_salary;

    @FXML
    private Button employees_deleteBtn;

    @FXML
    private ComboBox<?> employees_department;

    @FXML
    private ImageView employees_imageview;

    @FXML
    private Button employees_import;

    @FXML
    private TextField employees_name;

    @FXML
    private ComboBox<?> employees_pos;

    @FXML
    private TextField employees_salary;

    @FXML
    private TextField employees_search;

    @FXML
    private Button employees_updateBtn;

    @FXML
    private TableView<EmployeesData> employess_tableView;

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
    private Pagination menu_pagination;

    @FXML
    private Pagination emp_pagination;

    @FXML
    private Label orderTotal;

    @FXML
    private Button tablesBtn;

    @FXML
    private AnchorPane tablesForm;

    @FXML
    private Label username;

    @FXML
    private Button tablesAddBtn;

    @FXML
    private TableColumn<?, ?> tablesColAmount;

    @FXML
    private TableColumn<?, ?> tablesColDishName;

    @FXML
    private TableColumn<?, ?> tablesColQuantity;

    @FXML
    private Button tablesDeleteBtn;

    @FXML
    private ComboBox<String> tablesDishName;

    @FXML
    private Spinner<Integer> tablesQuantity;

    @FXML
    private ComboBox<?> tablesTypeDish;

    Alert alert;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private Image image;
    private Parent root;


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

                } else {
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

    public void menuDeleteBtn() {

        if (data.id == 0) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {
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

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
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


        FilteredList<DishData> filteredDish = new FilteredList<>(menuListData, b -> true);
        menuSearch.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredDish.setPredicate(dishData -> {

                if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
                    return true;
                }

                String searchKeyWord = newValue.toLowerCase();

                if (dishData.getDish_name().toLowerCase().indexOf(searchKeyWord) > -1){
                    return true;
                } else if (dishData.getType_name().toLowerCase().indexOf(searchKeyWord) > -1){
                    return true;
                } else if (dishData.getPrice().toString().indexOf(searchKeyWord) > -1) {
                    return true;
                } else if (dishData.getMade_price().toString().indexOf(searchKeyWord) > -1){
                    return true;
                } else if (dishData.getStock().toString().indexOf(searchKeyWord) > -1) {
                    return true;
                } else if (dishData.getAvailability().toString().indexOf(searchKeyWord) > -1) {
                    return true;
                } else
                    return false;

            });

        });

        SortedList<DishData> sortedList = new SortedList<>(filteredDish);
        sortedList.comparatorProperty().bind(menu_tableView.comparatorProperty());

        menu_tableView.setItems(sortedList);

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

//    EMPLOYESS

    public void empAddBtn() throws SQLException {
        if (employees_name.getText().isEmpty()
                || employees_department.getSelectionModel().getSelectedItem() == null
                || employees_pos.getSelectionModel().getSelectedItem() == null
                || employees_salary.getText().isEmpty()
                || data.path == null) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {
            String sql = "INSERT INTO employee"
                    + "(emp_name, position, department, salary, image)"
                    + "VALUES(?,?,?,?,?)";
            connection = JDBCConnect.getJDBCConnection();
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, employees_name.getText());
                preparedStatement.setString(2, (String) employees_pos.getSelectionModel().getSelectedItem());
                preparedStatement.setString(3, (String) employees_department.getSelectionModel().getSelectedItem());
                preparedStatement.setDouble(4, Double.parseDouble(employees_salary.getText()));


                String path = data.path;
                path = path.replace("\\", "\\\\");

                preparedStatement.setString(5, path);

                preparedStatement.executeUpdate();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added!");
                alert.showAndWait();
                empShowData();
                empClearBtn();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void empUpdateBtn() throws SQLException {
        if (employees_name.getText().isEmpty()
                || employees_department.getSelectionModel().getSelectedItem() == null
                || employees_pos.getSelectionModel().getSelectedItem() == null
                || employees_salary.getText().isEmpty()
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

            String updateData = "UPDATE employee SET " +
                    "emp_name = '" + employees_name.getText() + "', " +
                    "position = '" + employees_pos.getSelectionModel().getSelectedItem() + "', " +
                    "department = '" + employees_department.getSelectionModel().getSelectedItem() + "', " +
                    "salary = '" + employees_salary.getText() + "', " +
                    "image = '" + path + "' " +
                    "WHERE emp_ID = " + data.id;

            connection = JDBCConnect.getJDBCConnection();

            try {

                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure want to Update Employees: " + employees_name.getText() + "?");
                Optional<ButtonType> optional = alert.showAndWait();

                if (optional.get().equals(ButtonType.OK)) {

                    preparedStatement = connection.prepareStatement(updateData);
                    preparedStatement.executeUpdate();


                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Update");
                    alert.showAndWait();

                    empShowData();
                    empClearBtn();

                } else {
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

    public void empDeleteBtn() {

        if (data.id == 0) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure want to Delete Dish: " + menuitems_dishName.getText() + "?");
            Optional<ButtonType> optional = alert.showAndWait();

            if (optional.get().equals(ButtonType.OK)) {
                String sql = "DELETE FROM employee WHERE emp_ID = " + data.id;

                try {

                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    empShowData();
                    empClearBtn();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Delete Fail");
                alert.showAndWait();
            }
        }

    }

    public void empImportBtn() {
        FileChooser openFile = new FileChooser();
        openFile.getExtensionFilters().add(new FileChooser.ExtensionFilter("Open image File", "*png", "*jpg"));

        File file = openFile.showOpenDialog(mainForm.getScene().getWindow());

        if (file != null) {

            data.path = file.getAbsolutePath();
            image = new Image(file.toURI().toString(), 120, 151, false, true);

            employees_imageview.setImage(image);
        }
    }

    public void empClearBtn() {

        employees_name.setText("");
        employees_department.getSelectionModel().clearSelection();
        employees_pos.getSelectionModel().clearSelection();
        employees_salary.setText("");
        data.path = "";
        data.id = 0;
        employees_imageview.setImage(null);


    }

    public ObservableList<EmployeesData> empDataList() {
        ObservableList<EmployeesData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM employee";


        connection = JDBCConnect.getJDBCConnection();

        try {

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            EmployeesData eData;

            while (resultSet.next()) {
                eData = new EmployeesData(resultSet.getInt("emp_ID"),
                        resultSet.getString("emp_name"),
                        resultSet.getString("position"),
                        resultSet.getString("department"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("image"));

                listData.add(eData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }

    private ObservableList<EmployeesData> empListData;

    public void empShowData() {

        empListData = empDataList();

        employees_col_empId.setCellValueFactory(new PropertyValueFactory<>("emp_ID"));
        employees_col_name.setCellValueFactory(new PropertyValueFactory<>("emp_name"));
        employees_col_department.setCellValueFactory(new PropertyValueFactory<>("department"));
        employees_col_position.setCellValueFactory(new PropertyValueFactory<>("position"));
        employees_col_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));


        employess_tableView.setItems(empListData);


        FilteredList<EmployeesData> filteredEmp = new FilteredList<>(empListData, b -> true);
        clients_search.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredEmp.setPredicate(employeesData -> {

                if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
                    return true;
                }

                String searchKeyWord = newValue.toLowerCase();

                if (employeesData.getEmp_name().toLowerCase().indexOf(searchKeyWord) > -1){
                    return true;
                } else if (employeesData.getPosition().toLowerCase().indexOf(searchKeyWord) > -1){
                    return true;
                } else if (employeesData.getDepartment().toLowerCase().indexOf(searchKeyWord) > -1) {
                    return true;
                } else if (employeesData.getSalary().toString().indexOf(searchKeyWord) > -1){
                    return true;
                } else
                    return false;

            });

        });

        SortedList<EmployeesData> sortedList = new SortedList<>(filteredEmp);
        sortedList.comparatorProperty().bind(employess_tableView.comparatorProperty());

        employess_tableView.setItems(sortedList);
    }

    public void empSelectData() {
        EmployeesData employeesData = employess_tableView.getSelectionModel().getSelectedItem();
        int num = employess_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) return;

        employees_name.setText(employeesData.getEmp_name());
        employees_salary.setText(String.valueOf(employeesData.getSalary()));

        data.id = employeesData.getEmp_ID();
        data.path = employeesData.getImage();

        String path = "File:" + employeesData.getImage();
        image = new Image(path, 120, 151, false, true);
        employees_imageview.setImage(image);
    }

//  CLIENT
public void clientAddBtn() throws SQLException {
    if (clients_customers.getText().isEmpty() || clients_phonenumber.getText().isEmpty()){

        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Please fill all blank fields");
        alert.showAndWait();

    } else {
        String insertClients = "INSERT INTO client"
                + "(client_name, phone,dob)"
                + "VALUES(?,?,?)";
        connection = JDBCConnect.getJDBCConnection();
        try {
            preparedStatement = connection.prepareStatement(insertClients);
            preparedStatement.setString(1, clients_customers.getText());
            preparedStatement.setString(2, clients_phonenumber.getText());

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date date = simpleDateFormat.parse(clients_dob.getText());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            preparedStatement.setString(3, String.valueOf(sqlDate));

            preparedStatement.executeUpdate();

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Added!");
            alert.showAndWait();
            clientShowData();
            clientClearBtn();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    public void clientUpdateBtn() throws SQLException {
        if (clients_customers.getText().isEmpty()
                || clients_phonenumber.getText().isEmpty()
                || data.id == 0) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {



            String updateClients = "UPDATE client SET client_name = ?, phone = ?, dob = ? WHERE client_ID = " + data.id;

            connection = JDBCConnect.getJDBCConnection();

            try {

                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure want to Update Employees: " + employees_name.getText() + "?");
                Optional<ButtonType> optional = alert.showAndWait();

                if (optional.get().equals(ButtonType.OK)) {

                    preparedStatement = connection.prepareStatement(updateClients);
                    preparedStatement.setString(1, clients_customers.getText());
                    preparedStatement.setString(2, clients_phonenumber.getText());

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    java.util.Date date = simpleDateFormat.parse(clients_dob.getText());
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    preparedStatement.setString(3, String.valueOf(sqlDate));

                    preparedStatement.executeUpdate();


                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Update");
                    alert.showAndWait();

                    clientShowData();
                    clientClearBtn();

                } else {
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

    public void clientDeleteBtn() {

        if (data.id == 0) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure want to Delete Client: " + menuitems_dishName.getText() + "?");
            Optional<ButtonType> optional = alert.showAndWait();

            if (optional.get().equals(ButtonType.OK)) {
                String sql = "DELETE FROM client WHERE client_ID = " + data.id;

                try {

                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    clientShowData();
                    clientClearBtn();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Delete Fail");
                alert.showAndWait();
            }
        }

    }

    public void clientClearBtn() {

        clients_customers.setText("");
        clients_phonenumber.setText("");
        clients_dob.setText("");
        clients_dob.setText("");
        data.id = 0;

    }

    public ObservableList<ClientData> clientDataList() {
        ObservableList<ClientData> clientData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM client";


        connection = JDBCConnect.getJDBCConnection();

        try {

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
//            resultSet.first();
//            count = resultSet.getInt(1);
            ClientData cData;

            while (resultSet.next()) {
                cData = new ClientData(resultSet.getInt("client_ID"),
                        resultSet.getString("client_name"),
                        resultSet.getString("phone"),
                        resultSet.getDate("dob"));

                clientData.add(cData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientData;
    }

    private ObservableList<ClientData> clientListData;

    public void clientShowData() {

        clientListData = clientDataList();

        clients_col_customersId.setCellValueFactory(new PropertyValueFactory<>("client_ID"));
        clients_col_customers.setCellValueFactory(new PropertyValueFactory<>("client_name"));
        clients_col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        clients_col_dob.setCellValueFactory(new PropertyValueFactory<>("dob"));

        client_tableView.setItems(clientListData);

        FilteredList<ClientData> filteredList = new FilteredList<>(clientListData, b -> true);
        clients_search.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredList.setPredicate(clientData -> {

                if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
                    return true;
                }

                String searchKeyWord = newValue.toLowerCase();

                if (clientData.getClient_name().toLowerCase().indexOf(searchKeyWord) > -1){
                    return true;
                } else if (clientData.getPhone().toLowerCase().indexOf(searchKeyWord) > -1){
                    return true;
                } else if (clientData.getDob().toString().indexOf(searchKeyWord) > -1) {
                    return true;
                } else
                    return false;

            });

        });

        SortedList<ClientData> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(client_tableView.comparatorProperty());

        client_tableView.setItems(sortedList);

    }

    public void clientSelectData() {
        ClientData clientData = client_tableView.getSelectionModel().getSelectedItem();
        int num = client_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) return;

        clients_customers.setText(clientData.getClient_name());
        clients_phonenumber.setText(clientData.getPhone());
        clients_dob.setText(String.valueOf(clientData.getDob()));

        data.id = clientData.getClient_ID();




    }

    // SHOW  COMBOBOX
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

    private String[] departmentList = {"Kitchen", "Protect", "Serve", "Reception", "Clean"};

    public void empDeparmentList() {
        List<String> deparmentL = new ArrayList<>();
        for (String data : departmentList) {
            deparmentL.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(deparmentL);
        employees_department.setItems(listData);
    }

    private String[] positionList = {"Staff", "Manage"};

    public void empPositionList() {
        List<String> positionL = new ArrayList<>();
        for (String data : positionList) {
            positionL.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(positionL);
        employees_pos.setItems(listData);
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

    // TABLES -------------------------------------------------------------------------------------------------------
    // SHOW TYPE DISH FROM COMBOBOX
    public void tablesTypeList() {
        List<String> typeL = typeList();
        ObservableList listData = FXCollections.observableArrayList(typeL);
        tablesTypeDish.setItems(listData);
    }

    // GET ALL DISH NAME FROM COMBOBOX
    public void tablesDishNameList(String selectedType) {
        String sql = "SELECT dish.dish_name FROM dish " +
                "JOIN types_dish ON dish.dish_ID = types_dish.dish_ID " +
                "JOIN types ON types_dish.type_ID = types.type_ID " +
                "WHERE types.type_name = ?";

        try (Connection connection = JDBCConnect.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, selectedType);

            List<String> dishNames = new ArrayList<>();

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    String dishName = rs.getString("dish_name");
                    dishNames.add(dishName);
                }
            }

            ObservableList<String> listData = FXCollections.observableArrayList(dishNames);
            tablesDishName.setItems(listData);
            System.out.println(selectedType);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // TABLES SPINNER
    private SpinnerValueFactory<Integer> spinner;
    public void tablesSpinner() {
        spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50, 0);
        tablesQuantity.setValueFactory(spinner);
    }

    // TABLES QUANTITY
    private int qty;
    public void tablesQuantity() {
        qty = tablesQuantity.getValue();

        System.out.println(qty);
    }

    // ORDERS LIST DATA
//    public ObservableList<Order> orderListData() {
//        ObservableList<Order> listData = FXCollections.observableArrayList();
//
//
//    }

    public void tableHandle(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String tableIdString = button.getId();
        if (tableIdString != null && !tableIdString.isEmpty()) {
            int tableId = Integer.parseInt(tableIdString);
            try (Connection conn = JDBCConnect.getJDBCConnection();
                 Statement stmt = conn.createStatement()) {
                String sql = "SELECT status FROM tables WHERE table_ID = " + tableId;
                ResultSet rs = stmt.executeQuery(sql);

                if (rs.next()) {
                    String status = rs.getString("status");
                    if (status.equalsIgnoreCase("available")) {
                        button.setStyle("-fx-background-color: green;");
                    } else if (status.equalsIgnoreCase("in-use")) {
                        button.setStyle("-fx-background-color: red;");
                    }
                } else {
                    System.out.println("Table with ID " + tableId + " not found.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Button ID is null or empty.");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayUsername();
        menuTypeList();
        menuStatusList();
        menuShowData();
        empDeparmentList();
        empPositionList();
        empShowData();
        clientShowData();
        tablesTypeList();
        tablesTypeDish.setOnAction(e -> {
            String selectedType = String.valueOf(tablesTypeDish.getValue());
            tablesDishNameList(selectedType);
        });
        tablesSpinner();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            loader.setController(this);
            root = loader.load();

            for (int i = 1; i <= 8; i++) {
                Button button = (Button) root.lookup("#" + i);
                button.setOnAction(this::tableHandle);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addToTable(ActionEvent actionEvent) {

    }

    public void deleteFromTable(ActionEvent actionEvent) {

    }
}
