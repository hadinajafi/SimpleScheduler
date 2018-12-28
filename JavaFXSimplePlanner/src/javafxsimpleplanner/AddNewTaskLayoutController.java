/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsimpleplanner;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author hadin
 */
public class AddNewTaskLayoutController implements Initializable {

    @FXML
    private GridPane gridView;

    @FXML
    private TextField titleTextField;

    @FXML
    private ProgressBar progressSlider;

    @FXML
    private ComboBox<String> priorityCombo;

    @FXML
    private Button increaseBtn;

    @FXML
    private Button decreaseBtn;

    @FXML
    private Button applyBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextArea detailsTextArea;
    
    @FXML
    private Label dateLabel;

    @FXML
    private DatePicker datePicker;

    @FXML
    void decreaseProgressBar(MouseEvent event) {
        double value = progressSlider.getProgress();
        value -= 0.2;
        System.out.println(value);
        progressSlider.setProgress(value);

        dynamicColorProgressBar(value);
    }

    @FXML
    void increaseProgressBar(MouseEvent event) {
        double value = progressSlider.getProgress();
        value += 0.2;
        System.out.println(value);
        progressSlider.setProgress(value);

        dynamicColorProgressBar(value);
    }

    private void dynamicColorProgressBar(double value) {
        if (value >= 0.19 && value < 0.4) {
            progressSlider.setStyle("-fx-accent: red");
        } else if (value >= 0.39 && value < 0.6) {
            progressSlider.setStyle("-fx-accent: orange;");
        } else if (value >= 0.59 && value < 0.8) {
            progressSlider.setStyle("-fx-accent: yellow");
        } else if (value >= 0.79 && value < 0.95) {
            progressSlider.setStyle("-fx-accent: #00BC23");
        } else if (value >= 0.95) {
            progressSlider.setStyle("-fx-accent: green");
        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TimeSpinner fromSpinner = new TimeSpinner(LocalTime.now());
        TimeSpinner toSpinner = new TimeSpinner(LocalTime.now());
        fromSpinner.setMaxWidth(gridView.getPrefWidth());
        toSpinner.setMaxWidth(gridView.getPrefWidth());
        gridView.add(fromSpinner, 1, 2);
        gridView.add(toSpinner, 1, 3);

        String[] str = {"Low Priority", "Medium Priority", "High Priority"};
        priorityCombo.getItems().addAll(str);
        ListCell<String> cell = new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    ImageView imageView;
                    if ("Medium Priority".equals(item)) {
                        imageView = new ImageView(new Image("/icons/yellow-star16.png"));
                    } else if (item.equals("Low Priority")) {
                        imageView = new ImageView(new Image("/icons/green-star16.png"));
                    } else {
                        imageView = new ImageView(new Image("/icons/red-star16.png"));
                    }
                    setGraphic(imageView);
                    setText(item);
                }
            }

        };
        Callback<ListView<String>, ListCell<String>> call = (ListView<String> param) -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    ImageView imageView;
                    if ("Medium Priority".equals(item)) {
                        imageView = new ImageView(new Image("/icons/yellow-star16.png"));
                    } else if (item.equals("Low Priority")) {
                        imageView = new ImageView(new Image("/icons/green-star16.png"));
                    } else {
                        imageView = new ImageView(new Image("/icons/red-star16.png"));
                    }
                    setGraphic(imageView);
                    setText(item);
                }
            }
        };
        priorityCombo.setButtonCell(cell);  //add imageView to the selected Item in Combo
        priorityCombo.setCellFactory(call); //addd imageView to the list of combo.
        //add date to the dateLabel in below format. add datePicker handler to change the label text dynamically.
        LocalDate date = LocalDate.now();
        datePicker.setValue(date);
        dateLabel.setText(datePicker.getValue().format(DateTimeFormatter.ofPattern("EEEE dd MMM")));
        datePicker.addEventHandler(EventType.ROOT, (Event event) -> {
            dateLabel.setText(datePicker.getValue().format(DateTimeFormatter.ofPattern("EEEE dd MMM")));
        });

//        priorityCombo.setCellFactory((ListView<String> param) -> new ListCell<String>(){
//            @Override
//            protected void updateItem(String item, boolean empty) {
//                super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
//                if(empty){
//                    setGraphic(null);
//                }
//                else{
//                    ImageView imageView;
//                    if("Medium".equals(item)){
//                        imageView = new ImageView(new Image("/icons/yellow-star16.png"));
//                    }
//                    else if (item.equals("Low"))
//                        imageView = new ImageView(new Image("/icons/green-star16.png"));
//                    else{
//                        imageView = new ImageView(new Image("/icons/red-star16.png"));
//                    }
//                    setGraphic(imageView);
//                    setText(item);
//                }
//            }
//        });
    }

}
