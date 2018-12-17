/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsimpleplanner;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;

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
    private TableView<?> dayTableView;

    @FXML
    private TableColumn<?, ?> dayTimeColomun;

    @FXML
    private TableColumn<?, ?> dayTaskColumn;

    @FXML
    private TableColumn<?, ?> dayStateColumn;
    
    @FXML
    private DatePicker datePicker;
    
    @FXML
    private TextArea dayTextArea;
    
    @FXML
    private Label dayTodayLabel;
    
    
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
    }    
    
}
