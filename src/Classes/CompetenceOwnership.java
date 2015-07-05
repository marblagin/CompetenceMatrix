
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
     *A constructor now follows with the parameters of: 
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
    
    // The next Get methods return its respective value 
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

    /**
     * 
     * @returns a string representing this classes group of data in a line, separate by tabs 
     */
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
