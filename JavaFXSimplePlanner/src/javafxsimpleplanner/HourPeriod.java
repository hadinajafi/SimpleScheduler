/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsimpleplanner;

/**
 *
 * @author hadin
 */
public enum HourPeriod {
    h0("00-01"), h1("01-02"), h2("02-03"), h3("03-04"), h4("04-05"), h5("05-06"), h6("06-07"), h7("07-08"), h8("08-09"), h9("09-10"), h10("10-11"), h11("11-12");
    private String period;
    public String getPeriod(){
        return period;
    }
    
    //constructor
    private HourPeriod(String period){
        this.period = period;
    }
}
