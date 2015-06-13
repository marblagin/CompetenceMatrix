/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Llewellyn Craddock
 */
public class Timesheet  extends CompetenceMatrix{
    private String code;
    private double hours;

    /**
     *
     * @param competenceReferenceNo
     * @param code
     * @param hours
     */
    public Timesheet(String code, double hours, int competenceReferenceNo) {
        super(competenceReferenceNo);
        this.code = code;
        this.hours = hours;
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    public double getHours() {
        return hours;
    }

    /**
     *
     * @param hours
     */
    public void setHours(double hours) {
        this.hours = hours;
    }
    
}
