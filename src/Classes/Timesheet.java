/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Llewellyn Craddock
 */
public class Timesheet extends CompetenceMatrix {

    private String code;
    private String hours;

    /**
     *A constructor of Timesheet 
     * @param competenceReferenceNo
     * @param code
     * @param hours
     */
    public Timesheet(String code, String hours, int competenceReferenceNo) {
        super(competenceReferenceNo);
        this.code = code;
        this.hours = hours;
    }

    // The next Get methods return its respective value 
    /**
     *
     * @return the requested value
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @return the requested value
     */
    public String getHours() {
        return hours;
    }

    /**
     * 
     * @return a string representing this classes group of data in a line, separate by tabs 
     */
    @Override
    public String toString() {
        String out = "";
        out += String.valueOf(super.getCompetenceReferenceNo())+"\t"
                 +code+ "\t"
                 +hours;
        return out;
    }
}
