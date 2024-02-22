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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DashboardController implements Initializable {
    @FXML
    private Button availableFDAddBtn;

    @FXML
    private Button availableFDBtn;

    @FXML
    private Button availableFDClearBtn;

    @FXML
    private TableColumn<Categories, String> availableFDColProductID;

    @FXML
    private TableColumn<Categories, String> availableFDColProductName;

    @FXML
    private TableColumn<Categories, String> availableFDColProductPrice;

    @FXML
    private TableColumn<Categories, String> availableFDColProductAvailability;

    @FXML
    private TableColumn<Categories, String> availableFDColProductType;

    @FXML
    private Button availableFDDeleteBtn;

    @FXML
    private AnchorPane availableFDForm;

//    @FXML
//    private TextField availableFDProductID;

    @FXML
    private TextField availableFDProductName;

    @FXML
    private TextField availableFDProductPrice;

    @FXML
    private TextField availableFDProductAvailability;

    @FXML
    private ComboBox<String> availableFDProductStatus;

    @FXML
    private ComboBox<String> availableFDProductType;

    @FXML
    private TextField availableFDSearch;

    @FXML
    private TableView<Categories> availableFDTableView;

    @FXML
    private Button availableFDUpdateBtn;

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
    private Button logout;
    @FXML
    private Button minimize;

    @FXML
    private Button orderAddBtn;

    @FXML
    private TextField orderAmount;

    @FXML
    private Button orderBtn;

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
    private AnchorPane orderForm;

    @FXML
    private Button orderPayBtn;

    @FXML
    private ComboBox<?> orderProductID;

    @FXML
    private ComboBox<?> orderProductName;

    @FXML
    private Spinner<Integer> orderQuantity;

    @FXML
    private Button orderReceiptBtn;

    @FXML
    private Button orderRemoveBtn;

    @FXML
    private TableView<?> orderTableView;

    @FXML
    private Label orderTotal;

    @FXML
    private Label username;
    @FXML
    private AnchorPane mainForm;

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
    private DatePicker clients_dob;

    @FXML
    private TextField clients_phonenumber;

    @FXML
    private TextField clients_search;

    @FXML
    private Button clients_updateBtn;

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
            availableFDForm.setVisible(false);
            orderForm.setVisible(false);

            dashboardBtn.setStyle("-fx-background-color: #eaa649;\n" +
                    "    -fx-text-fill: #fff;\n" +
                    "    -fx-border-width: 0px;");
            availableFDBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
            orderBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");

        } else if (event.getSource() == availableFDBtn) {
            availableFDForm.setVisible(true);
            orderForm.setVisible(false);
            dashboardForm.setVisible(false);

            availableFDBtn.setStyle("-fx-background-color: #eaa649;\n" +
                    "    -fx-text-fill: #fff;\n" +
                    "    -fx-border-width: 0px;");
            dashboardBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
            orderBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");

            availableFDShowData();
            availableFDSearchData();

        } else if (event.getSource() == orderBtn) {
            orderForm.setVisible(true);
            dashboardForm.setVisible(false);
            availableFDForm.setVisible(false);

            orderBtn.setStyle("-fx-background-color: #eaa649;\n" +
                    "    -fx-text-fill: #fff;\n" +
                    "    -fx-border-width: 0px;");
            dashboardBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");
            availableFDBtn.setStyle("-fx-background-color: transparent;\n" +
                    "    -fx-text-fill: #000;\n" +
                    "    -fx-border-width: 1px;");

            orderProductName();
            orderSpinner();
            orderListData();

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
    private String[] categories = {"foods", "drinks"};

    public void availableFDType() {
        List<String> listType = new ArrayList<>();

        for (String data : categories) {
            listType.add(data);
        }

        ObservableList<String> listData = FXCollections.observableArrayList(listType);
        availableFDProductType.setItems(listData);
    }

    // CRUD MENU -------------------------------

    // ADD
    public void availableFDAdd() {
        String sql = "INSERT INTO categories (dish_name, price, availability, type)\n" +
                "VALUES (?, ?, ?, ?)";
        try (Connection connection = JDBCConnect.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, availableFDProductName.getText());
            preparedStatement.setString(2, availableFDProductPrice.getText());
            preparedStatement.setString(3, availableFDProductAvailability.getText());
            preparedStatement.setString(4, (String) availableFDProductType.getSelectionModel().getSelectedItem());

            Alert alert;
            if (availableFDProductName.getText().isEmpty()
                    || availableFDProductPrice.getText().isEmpty()
                    || availableFDProductAvailability.getText().isEmpty()
                    || availableFDProductType.getSelectionModel() == null
            ) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill fields");
                alert.showAndWait();
            } else {
                String checkData = "SELECT dish_name FROM categories WHERE dish_name = '" + availableFDProductName.getText() + "'";

                try (Connection connection1 = JDBCConnect.getJDBCConnection();
                     PreparedStatement preparedStatement1 = connection1.prepareStatement(checkData);
                     ResultSet rs = preparedStatement1.executeQuery()) {
                    if (rs.next()) {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Already exist!");
                        alert.showAndWait();
                    } else {
                        preparedStatement.executeUpdate();

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Success");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Added!");
                        alert.showAndWait();

                        // TO SHOW DATA
                        availableFDShowData();
                        // TO CLEAR THE FIELDS
                        availableFDClear();
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // LIST DATA FOODS/DRINKS
    public ObservableList<Categories> availableFDListData() {
        ObservableList<Categories> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM categories";

        try (Connection connection = JDBCConnect.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            Categories categories;

            while (rs.next()) {
                categories = new Categories(rs.getString("dish_ID"),
                        rs.getString("dish_name"), rs.getString("type"),
                        rs.getString("price"), rs.getString("availability"));

                listData.add(categories);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listData;
    }

    // SHOW LIST DATA FOODS/DRINKS
    private ObservableList<Categories> availableFDList;

    public void availableFDShowData() {
        availableFDList = availableFDListData();

        availableFDColProductID.setCellValueFactory(new PropertyValueFactory<>("dishID"));
        availableFDColProductName.setCellValueFactory(new PropertyValueFactory<>("dishName"));
        availableFDColProductPrice.setCellValueFactory(new PropertyValueFactory<>("availability"));
        availableFDColProductAvailability.setCellValueFactory(new PropertyValueFactory<>("type"));
        availableFDColProductType.setCellValueFactory(new PropertyValueFactory<>("price"));


        availableFDTableView.setItems(availableFDList);

    }

    // CLEAR AVAILABLE THE FIELDS
    public void availableFDClear() {

        availableFDProductName.setText("");
        availableFDProductPrice.setText("");
        availableFDProductAvailability.setText("");
        availableFDProductType.getSelectionModel().clearSelection();

    }

    // SELECT AVAILABLE THE FIELDS
    public void availableFDSelect() {
        Categories cateData = availableFDTableView.getSelectionModel().getSelectedItem();

        int num = availableFDTableView.getSelectionModel().getSelectedIndex();

        if (num < 0) {
            return;
        }

        availableFDProductName.setText(cateData.getDishName());
        availableFDProductPrice.setText(cateData.getAvailability());
        availableFDProductAvailability.setText(cateData.getType());
    }

    // UPDATE
    public void availableFDUpdate() {
        String sql = "UPDATE categories SET dish_name = '" + availableFDProductName.getText() + "', " +
                "price = '" + availableFDProductPrice.getText() + "', " +
                "availability = '" + availableFDProductAvailability.getText() + "', " +
                "type = '" + availableFDProductType.getSelectionModel().getSelectedItem() + "'" +
                "WHERE dish_name = '" + availableFDProductName.getText() + "'";

        try (Connection connection = JDBCConnect.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            Alert alert;

            if (availableFDProductName.getText().isEmpty()
                    || availableFDProductPrice.getText().isEmpty()
                    || availableFDProductAvailability.getText().isEmpty()
                    || availableFDProductType.getSelectionModel() == null
            ) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm");
                alert.setHeaderText(null);
                alert.setContentText("Update");
                Optional<ButtonType> optional = alert.showAndWait();

                if (optional.get().equals(ButtonType.OK)) {
                    preparedStatement.executeUpdate();

                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Update");
                    alert.setHeaderText(null);
                    alert.setContentText("Updated");
                    alert.showAndWait();

                    // TO SHOW DATA
                    availableFDShowData();
                    // TO CLEAR THE FIELDS
                    availableFDClear();
                } else {
                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Cancel");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled");
                    alert.showAndWait();
                }
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    // DELETE
    public void availableFDDelete() {
        String sql = "DELETE FROM categories WHERE dish_name = '" + availableFDProductName.getText() + "'";

        try (Connection connection = JDBCConnect.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            Alert alert;

            if (availableFDProductName.getText().isEmpty()
                    || availableFDProductPrice.getText().isEmpty()
                    || availableFDProductAvailability.getText().isEmpty()
                    || availableFDProductType.getSelectionModel() == null
            ) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm");
                alert.setHeaderText(null);
                alert.setContentText("Update");
                Optional<ButtonType> optional = alert.showAndWait();

                if (optional.get().equals(ButtonType.OK)) {
                    preparedStatement.executeUpdate();

                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Delete");
                    alert.setHeaderText(null);
                    alert.setContentText("Deleted");
                    alert.showAndWait();

                    // TO SHOW DATA
                    availableFDShowData();
                    // TO CLEAR THE FIELDS
                    availableFDClear();
                } else {
                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Cancel");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled");
                    alert.showAndWait();
                }
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // SEARCH
    public void availableFDSearchData() {
        FilteredList<Categories> filter = new FilteredList<>(availableFDList, e -> true);
        availableFDSearch.textProperty().addListener((observableValue, newValue, oldValue) -> {

            filter.setPredicate(predicateCatagories -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateCatagories.getDishName().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Categories> sortedList = new SortedList<>(filter);

        sortedList.comparatorProperty().bind(availableFDTableView.comparatorProperty());

        availableFDTableView.setItems(sortedList);

    }

    // ORDERS --------------------
    // ORDERS NAME
    public void orderProductName() {

        String sql = "SELECT dish_name FROM categories WHERE availability > 0";

        try (Connection connection = JDBCConnect.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            ObservableList listData = FXCollections.observableArrayList();

            while (rs.next()) {
                listData.add(rs.getString("dish_name"));
            }

            orderProductName.setItems(listData);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    // ORDERS QUANTITY
    private SpinnerValueFactory<Integer> spinner;

    public void orderSpinner() {
        spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50, 0);
        orderQuantity.setValueFactory(spinner);
    }

    private int qty;

    public void orderQuantity() {
        qty = orderQuantity.getValue();

        System.out.println(qty);
    }

    // ORDERS ADD
    // ORDERS LIST DATA
    public ObservableList<Bill> orderListData() {

        orderClientID();

        ObservableList<Bill> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM bill WHERE client_ID = " + clientID;

        try (Connection connection = JDBCConnect.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery())
        {
            Bill bill;

            while (rs.next()) {
                bill = new Bill(rs.getString("bill_ID"),
                        rs.getString("dish_name"),
                        rs.getString("type"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"));

                listData.add(bill);
            }

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return listData;
    }

    //
    private int clientID;

    public void orderClientID() {

        String sql = "SELECT client_ID FROM bill";

        try (Connection connection = JDBCConnect.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                clientID = rs.getInt("client_ID");

                String checkData = "SELECT client_ID FROM client";

                try (Connection connectionCheck = JDBCConnect.getJDBCConnection();
                     PreparedStatement preparedStatementCheck = connectionCheck.prepareStatement(checkData);
                     ResultSet rsCheck = preparedStatementCheck.executeQuery()) {

                    int clientInfoID = 0;

                    while (rsCheck.next()) {
                        clientInfoID = rsCheck.getInt("client_ID");
                    }

                    if (clientID == 0) {
                        clientID += 1;
                    } else if (clientID == clientInfoID) {
                        clientID += 1;
                    }

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }


            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // ORDERS ADD
    public void orderAdd() {
        orderClientID();

        String sql = "INSERT INTO bill (client_ID, dish_ID, dish_name, price, type, quantity)\n" +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = JDBCConnect.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setString(1, String.valueOf(clientID));
            preparedStatement.setString(2, (String) orderProductID.getSelectionModel().getSelectedItem());
            preparedStatement.setString(3, (String) orderProductName.getSelectionModel().getSelectedItem());





        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayUsername();

        availableFDType();
        availableFDShowData();

        orderProductName();
        orderSpinner();
        orderListData();
    }
}
