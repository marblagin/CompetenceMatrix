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
     *
     * @param competenceReferenceNo
     * @param code
     * @param hours
     */
    public Timesheet(String code, String hours, int competenceReferenceNo) {
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
     * @return
     */
    public String getHours() {
        return hours;
    }

    @Override
    public String toString() {
        String out = "";
        out += String.valueOf(super.getCompetenceReferenceNo())+"\t"
                 +code+ "\t"
                 +hours;
        return out;
    }
}
