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
import java.util.ArrayList;
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
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

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
    private TableColumn<dayTaskBean, String> btnColumn;

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
    private TableView<WeekViewBean> weekViewTable;

    @FXML
    private TableColumn<WeekViewBean, String> day0WeekTableCol;

    @FXML
    private TableColumn<WeekViewBean, String> day1WeekTableCol;

    @FXML
    private TableColumn<WeekViewBean, String> day2WeekTableCol;

    @FXML
    private TableColumn<WeekViewBean, String> day3WeekTableCol;

    @FXML
    private TableColumn<WeekViewBean, String> day4WeekTableCol;

    @FXML
    private TableColumn<WeekViewBean, String> day5WeekTableCol;

    @FXML
    private TableColumn<WeekViewBean, String> day6WeekTableCol;

    @FXML
    private TableColumn<WeekViewBean, String> day7WeekTableCol;

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

    private void initializeTableCellValueFactory() {
        //dayview value factory
        dayViewTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        dayViewFromTimeCol.setCellValueFactory(new PropertyValueFactory<>("fromTime"));
        dayViewToTimeCol.setCellValueFactory(new PropertyValueFactory<>("toTime"));
        dayViewImportanceCol.setCellValueFactory(new PropertyValueFactory<>("importance"));
        dayViewProgressCol.setCellValueFactory(new PropertyValueFactory<>("progress"));
        //weekview value factory
        day0WeekTableCol.setCellValueFactory(new PropertyValueFactory<>("noname"));
        day2WeekTableCol.setCellValueFactory(new PropertyValueFactory<>("tue"));
        day3WeekTableCol.setCellValueFactory(new PropertyValueFactory<>("wed"));
        day4WeekTableCol.setCellValueFactory(new PropertyValueFactory<>("thu"));
        day5WeekTableCol.setCellValueFactory(new PropertyValueFactory<>("fri"));
        day6WeekTableCol.setCellValueFactory(new PropertyValueFactory<>("sat"));
        day7WeekTableCol.setCellValueFactory(new PropertyValueFactory<>("sun"));
        //adding progressbar to the column cell type:
        dayViewProgressCol.setCellFactory(ProgressBarTableCell.<dayTaskBean>forTableColumn());

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
        //add edit and delete buttons to this column
        btnColumn.setCellFactory((TableColumn<dayTaskBean, String> param) -> new TableCell<dayTaskBean, String>() {
            Button editBtn = new Button();
            Button deleteBtn = new Button();
            HBox box = new HBox(editBtn, deleteBtn);

            @Override
            public void updateItem(String Item, boolean empty) {
                super.updateItem(Item, empty);
                if (empty) {
                    setGraphic(null);
                    setText(null);
                } else {
                    editBtn.setGraphic(new ImageView(new Image("/icons/edit16.png")));
                    //set edit button action
                    editBtn.setOnAction(event -> {
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
                    });
                    deleteBtn.setGraphic(new ImageView(new Image("/icons/trash16.png")));
                    deleteBtn.setOnAction(event -> {
                        //TODO delete commands
                    });
                    box.setSpacing(5);
                    setGraphic(box);
                    setText(null);
                }
            }
        });
        btnColumn.setMaxWidth(2000);
        btnColumn.setPrefWidth(80);
        btnColumn.setStyle("-fx-alignment: CENTER");
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LocalDate date = LocalDate.now();
        datePicker.setValue(date);
        dayTodayLabel.setText(datePicker.getValue().format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy")));
        //change dayLable Date shower for dynamically change on select date.
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
        editDayTaskBtn.setTooltip(new Tooltip("Edit current selected task from the table"));
       
        
        //this is awesome work from me, now I can put every day task via list in each cell
        ListView<String> list = new ListView<>();
        String[] elements = {"Fight", "Fire"};
        list.getItems().addAll(elements);
        ObservableList<WeekViewBean> data = FXCollections.observableArrayList(new WeekViewBean("No Name", elements, "Tue", "Wed", "Thu", "Fir", "sat", "Sun"));
        weekViewTable.setItems(data);
        day1WeekTableCol.setCellFactory((TableColumn<WeekViewBean, String> param) -> {
            return new TableCell<WeekViewBean, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {

                    super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(list);
                        setPrefHeight(28 * list.getItems().size());
                        
                    }
                }
            };
        });
    }

}
