/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsimpleplanner;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

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
    private ChoiceBox<?> choiceBox;
    
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
    
    private void dynamicColorProgressBar(double value){
        if(value >= 0.19 && value < 0.4){
            progressSlider.setStyle("-fx-accent: red");
        }
        else if(value >= 0.39 && value < 0.6){
           progressSlider.setStyle("-fx-accent: orange;");
        }
        else if (value >= 0.59 && value < 0.8){
            progressSlider.setStyle("-fx-accent: yellow");
        }
        else if (value >= 0.79 && value < 0.95){
            progressSlider.setStyle("-fx-accent: lightgreen");
        }
        else if(value >= 0.95){
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
        gridView.add(fromSpinner, 1, 1);
        gridView.add(toSpinner, 1, 2);
        
            double value = progressSlider.getProgress();
            if (value < 25) {
                progressSlider.setProgress(0);
            } else if (25 <= value && value < 50) {
                progressSlider.setProgress(25);
            } else if (50 <= value && value < 75) {
                progressSlider.setProgress(50);
            } else if (75 <= value && value < 100) {
                progressSlider.setProgress(75);
            } else if (value == 100) {
                progressSlider.setProgress(100);
            }
        
    }

}
