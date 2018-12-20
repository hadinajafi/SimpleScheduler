/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsimpleplanner;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author hadin
 */
public class dayTaskBean {
    private SimpleStringProperty title;
    private SimpleDoubleProperty progress;
    private SimpleStringProperty time;

    public dayTaskBean(String time, String title, Double progress) {
        this.time = new SimpleStringProperty(time);
        this.title = new SimpleStringProperty(title);
        this.progress = new SimpleDoubleProperty(progress);
    }
    
    public String getTime(){
        return time.get();
    }
    public String getTitle(){
        return title.get();
    }
    public Double getProgress(){
        return progress.get();
    }
    
}
