/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Llewellyn Craddock
 */
public class Timesheet {
    private int competenceReferenceNo;
    private String code;
    private double hours;

    public Timesheet(int competenceReferenceNo, String code, double hours) {
        this.competenceReferenceNo = competenceReferenceNo;
        this.code = code;
        this.hours = hours;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
    
}
