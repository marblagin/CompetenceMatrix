/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Llewellyn Craddock
 */
public class CompetenceOwnership extends CompetenceMatrix {

    private String partner;
    private String champion;
    private String details;

    /**
     *
     * @param competenceReferenceNo
     * @param partner
     * @param champion
     * @param details
     */
    public CompetenceOwnership(String partner, String champion, String details, int competenceReferenceNo) {
        super(competenceReferenceNo);
        this.partner = partner;
        this.champion = champion;
        this.details = details;
    }

    /**
     *
     * @return
     */
    public String getPartner() {
        return partner;
    }

    /**
     *
     * @return
     */
    public String getChampion() {
        return champion;
    }

    /**
     *
     * @return
     */
    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        String out = "";
        out += String.valueOf(super.getCompetenceReferenceNo()) + "\t"
                + partner +"\t"
                + champion + "\t"
                + details;
        return out;
    }
}
