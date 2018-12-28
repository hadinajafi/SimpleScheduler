/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsimpleplanner;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author hadin
 */
public class WeekViewBean {
    private SimpleStringProperty noname;
    private String[] mon;
    private SimpleStringProperty tue;
    private SimpleStringProperty wed;
    private SimpleStringProperty thu;
    private SimpleStringProperty fri;
    private SimpleStringProperty sat;
    private SimpleStringProperty sun;
    
    
    public WeekViewBean(String noname, String[] mon,String tue, String wed, String thu, String fri, String sat, String sun){
        this.noname = new SimpleStringProperty(noname);
        this.mon = mon;
        this.tue = new SimpleStringProperty(tue);
        this.wed = new SimpleStringProperty(wed);
        this.thu = new SimpleStringProperty(thu);
        this.fri = new SimpleStringProperty(fri);
        this.sat = new SimpleStringProperty(sat);
        this.sun = new SimpleStringProperty(sun);
    }

    public String getNoname() {
        return noname.get();
    }

    public String[] getMon() {
        return mon;
    }

    public String getTue() {
        return tue.get();
    }

    public String getWed() {
        return wed.get();
    }

    public String getThu() {
        return thu.get();
    }

    public String getFri() {
        return fri.get();
    }

    public String getSat() {
        return sat.get();
    }

    public String getSun() {
        return sun.get();
    }
    
    
}
