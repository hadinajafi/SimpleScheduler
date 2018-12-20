/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsimpleplanner;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author hadin
 */
public class dayTaskBean {
    private SimpleStringProperty title;
    private SimpleIntegerProperty importance;
    private SimpleStringProperty fromTime;
    private SimpleDoubleProperty progress;
    private SimpleStringProperty toTime;

    //constructor
    public dayTaskBean(String title, Integer importance,String fromTime, String toTime, Double progress) {
        this.toTime = new SimpleStringProperty(toTime);
        this.fromTime = new SimpleStringProperty(fromTime);
        this.importance = new SimpleIntegerProperty(importance);
        this.title = new SimpleStringProperty(title);
        this.progress = new SimpleDoubleProperty(progress);
    }
    
    public String getFromTime(){
        return fromTime.get();
    }
    
    public String getToTime(){
        return toTime.get();
    }
    public String getTitle(){
        return title.get();
    }
    public Double getProgress(){
        return progress.get();
    }
    
    public Integer getImportance(){
        return importance.get();
    }
    
}
