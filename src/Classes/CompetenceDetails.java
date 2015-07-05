
package Classes;

/**
 *
 * @author Llewellyn Craddock
 */
public class CompetenceDetails extends CompetenceMatrix {

    private String shortName;
    private String objective;
    private String details;
    private String hyperlink;
    private String timing;
    private String whoProvides;
    private String type;
    private String dependencies;
    private String status;
    private String reviewActionNotes;

    /**
     *A constructor now follows with the parameters of: 
     * @param competenceReferenceNo
     * @param shortName
     * @param details 
     * @param objective
     * @param hyperlink
     * @param timing
     * @param whoProvides
     * @param type
     * @param dependencies
     * @param status
     * @param reviewActionNotes
     */
    public CompetenceDetails(String shortName, String objective, String details, String hyperlink, String timing, String whoProvides, String type, String dependencies, String status, String reviewActionNotes, int competenceReferenceNo) {
        super(competenceReferenceNo);
        this.shortName = shortName;
        this.objective = objective;
        this.details = details;
        this.hyperlink = hyperlink;
        this.timing = timing;
        this.whoProvides = whoProvides;
        this.type = type;
        this.dependencies = dependencies;
        this.status = status;
        this.reviewActionNotes = reviewActionNotes;
    }
    
    // The next Get methods return its respective value 
    /**
     *
     * @return
     */
    public String getDetails() {
        return details;
    }

    /**
     *
     * @return
     */
    public String getShortName() {
        return shortName;
    }

    /**
     *
     * @return
     */
    public String getObjective() {
        return objective;
    }

    /**
     *
     * @return
     */
    public String getHyperlink() {
        return hyperlink;
    }

    /**
     *
     * @return
     */
    public String getTiming() {
        return timing;
    }

    /**
     *
     * @return
     */
    public String getWhoProvides() {
        return whoProvides;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @return
     */
    public String getDependencies() {
        return dependencies;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @return
     */
    public String getReviewActionNotes() {
        return reviewActionNotes;
    }
    
    /**
     * 
     * @returns a string representing this classes group of data in a line, separate by tabs 
     */
    @Override
    public String toString() {
        String out = "";
        out += String.valueOf(super.getCompetenceReferenceNo()) + "\t"
                + shortName +"\t"
                + objective +"\t"
                + details +"\t"
                + hyperlink +"\t"
                + timing +"\t"
                + whoProvides +"\t"
                + type +"\t"
                + dependencies +"\t"
                + status +"\t"
                + reviewActionNotes;
        return out;
    }
}
