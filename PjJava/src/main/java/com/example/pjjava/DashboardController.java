package com.example.pjjava;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {@FXML
private Button availableFDAddBtn;

    @FXML
    private Button availableFDBtn;

    @FXML
    private Button availableFDClearBtn;

    @FXML
    private TableColumn<?, ?> availableFDColProductID;

    @FXML
    private TableColumn<?, ?> availableFDColProductName;

    @FXML
    private TableColumn<?, ?> availableFDColProductPrice;

    @FXML
    private TableColumn<?, ?> availableFDColProductStatus;

    @FXML
    private TableColumn<?, ?> availableFDColProductType;

    @FXML
    private Button availableFDDeleteBtn;

    @FXML
    private AnchorPane availableFDForm;

    @FXML
    private TextField availableFDProductID;

    @FXML
    private TextField availableFDProductName;

    @FXML
    private TextField availableFDProductPrice;

    @FXML
    private ComboBox<?> availableFDProductStatus;

    @FXML
    private ComboBox<?> availableFDProductType;

    @FXML
    private TextField availableFDSearch;

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
    private Label username;
    @FXML
    private AnchorPane mainForm;

    public void close() {
        System.exit(0);
    }
    public void minimize() {
        Stage stage = (Stage) mainForm.getScene().getWindow();
        stage.setIconified(true);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
