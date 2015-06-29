/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
     *
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

    /**
     *
     * @return
     */
    public String getDetails() {
        return details;
    }

    /**
     *
     * @param details
     */
    public void setDetails(String details) {
        this.details = details;
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
     * @param shortName
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
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
     * @param objective
     */
    public void setObjective(String objective) {
        this.objective = objective;
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
     * @param hyperlink
     */
    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
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
     * @param timing
     */
    public void setTiming(String timing) {
        this.timing = timing;
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
     * @param whoProvides
     */
    public void setWhoProvides(String whoProvides) {
        this.whoProvides = whoProvides;
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
     * @param type
     */
    public void setType(String type) {
        this.type = type;
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
     * @param dependencies
     */
    public void setDependencies(String dependencies) {
        this.dependencies = dependencies;
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
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
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
     * @param reviewActionNotes
     */
    public void setReviewActionNotes(String reviewActionNotes) {
        this.reviewActionNotes = reviewActionNotes;
    }

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
