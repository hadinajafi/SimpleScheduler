/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsimpleplanner;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hadin
 */
public class TabbedLayoutController implements Initializable {

    @FXML
    private TabPane tabPane;

    @FXML
    private ToolBar toolbar;
    
    @FXML
    private TableView<dayTaskBean> dayTableView;

    @FXML
    private TableColumn<dayTaskBean, String> dayViewTitleCol;

    @FXML
    private TableColumn<dayTaskBean, Integer> dayViewImportanceCol;

    @FXML
    private TableColumn<dayTaskBean, LocalDate> dayViewFromTimeCol;

    @FXML
    private TableColumn<dayTaskBean, LocalTime> dayViewToTimeCol;

    @FXML
    private TableColumn<dayTaskBean, Double> dayViewProgressCol;
    
    @FXML
    private DatePicker datePicker;
    
    @FXML
    private TextArea dayTextArea;
    
    @FXML
    private Label dayTodayLabel;
    
    @FXML
    private Button addNewTaskButton;

    @FXML
    private Button addNewGoalButton;
    
    @FXML
    private TableView<?> goalViewTable;

    @FXML
    private TableColumn<?, ?> goalDescriptionColumn;

    @FXML
    private TableColumn<?, ?> goalTimeColumn;

    @FXML
    private TableColumn<dayTaskBean, Double> goalProgressColumn;
    
    @FXML
    private TableView<?> weekViewTable;

    @FXML
    private TableColumn<?, ?> day0WeekTableCol;

    @FXML
    private TableColumn<?, ?> day1WeekTableCol;

    @FXML
    private TableColumn<?, ?> day2WeekTableCol;

    @FXML
    private TableColumn<?, ?> day3WeekTableCol;

    @FXML
    private TableColumn<?, ?> day4WeekTableCol;

    @FXML
    private TableColumn<?, ?> day5WeekTableCol;

    @FXML
    private TableColumn<?, ?> day6WeekTableCol;

    @FXML
    private TableColumn<?, ?> day7WeekTableCol;

    @FXML
    private ListView<?> weekGoalsList;
    
    @FXML
    private TableView<?> monthViewTable;
    
     @FXML
    private TableColumn<?, ?> day0MonthViewColumn;

    @FXML
    private TableColumn<?, ?> day1MonthViewColumn;

    @FXML
    private TableColumn<?, ?> day2MonthViewColumn;

    @FXML
    private TableColumn<?, ?> day3MonthViewColumn;

    @FXML
    private TableColumn<?, ?> day4MonthViewColumn;

    @FXML
    private TableColumn<?, ?> day5MonthViewColumn;

    @FXML
    private TableColumn<?, ?> day6MonthViewColumn;

    @FXML
    private TableColumn<?, ?> day7MonthViewColumn;

    @FXML
    private ListView<?> monthViewGoalsList;
    
    @FXML
    private BarChart<?, ?> yearViewChart;

    @FXML
    private TableView<?> yearViewTasksTable;

    @FXML
    private TableColumn<?, ?> yearViewTaskNameCol;

    @FXML
    private TableColumn<?, ?> yearViewProgressCol;
    
    @FXML
    private Button editDayTaskBtn;

    @FXML
    private Button addNewDayTaskBtn;
    
    @FXML
    void addNewDayTaskBtn(MouseEvent event) {
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("AddNewTaskLayout.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("addnewtasklayout.css").toExternalForm());
        Stage stage = new Stage();
        stage.setTitle("Add New Task");
        stage.setResizable(false);
        stage.setMinWidth(566);
        stage.setMinHeight(353);
        stage.setScene(scene);
        stage.show();
    }

    //Add event for editing the selected column of table.
    //this is not finished, still need data handling to communicate data between windows
    @FXML
    void editDayTaskMouseClicked(MouseEvent event) {
        AnchorPane root = null;
        try {
            //using previous designed window for editing
            root = FXMLLoader.load(getClass().getResource("AddNewTaskLayout.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("addnewtasklayout.css").toExternalForm());
        Stage stage = new Stage();
        stage.setTitle("Edit Task");
        stage.setResizable(false);
        stage.setMinWidth(566);
        stage.setMinHeight(353);
        stage.setScene(scene);
        stage.show();
    }
    
    private ObservableList<dayTaskBean> dayViewData = FXCollections.observableArrayList(new dayTaskBean("title1", 1, "12", "2", 0.8));
    
    private void initializeTableCellValueFactory(){
        dayViewTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        dayViewFromTimeCol.setCellValueFactory(new PropertyValueFactory<>("fromTime"));
        dayViewToTimeCol.setCellValueFactory(new PropertyValueFactory<>("toTime"));
        dayViewImportanceCol.setCellValueFactory(new PropertyValueFactory<>("importance"));
        dayViewProgressCol.setCellValueFactory(new PropertyValueFactory<>("progress"));
        
        //adding progressbar to the column cell type:
        dayViewProgressCol.setCellFactory(ProgressBarTableCell.<dayTaskBean> forTableColumn());
        
        //minimize the size of 'from' and 'to' columns:
        dayViewFromTimeCol.setMaxWidth(1200);
        dayViewFromTimeCol.setStyle("-fx-alignment: CENTER;");
        dayViewToTimeCol.setMaxWidth(1200);
        dayViewToTimeCol.setStyle("-fx-alignment: CENTER;");
        
        //minimize the size of 'importance' column:
        dayViewImportanceCol.setMaxWidth(1500);
        dayViewImportanceCol.setStyle("-fx-alignment: CENTER");
        
        //adding comboBox to the column cells
        ObservableList<Integer> comboItems = FXCollections.observableArrayList(1, 2, 3);
        dayViewImportanceCol.setCellFactory(ComboBoxTableCell.forTableColumn(comboItems));
        
        editDayTaskBtn.setTooltip(new Tooltip("Edit current selected task from the table"));
    }
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LocalDate date = LocalDate.now();
        datePicker.setValue(date);
        dayTodayLabel.setText(datePicker.getValue().format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy")));
        
        datePicker.addEventHandler(EventType.ROOT, (Event event) -> {
            dayTodayLabel.setText(datePicker.getValue().format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy")));
        });
        //set the columns resizable to auto fit table size
        weekViewTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        dayTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        goalViewTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        monthViewTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        yearViewTasksTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //initialize the cell value factories for all tables:
        initializeTableCellValueFactory();
        dayTableView.setItems(dayViewData);
    }    
    
}
