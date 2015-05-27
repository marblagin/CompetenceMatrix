/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Llewellyn Craddock
 */
public class CompetenceDetails {
    private int competenceReferenceNo;
    private String shortName;
    private String objective;
    private String hyperlink;
    private String timing;
    private String whoProvides;
    private String type;
    private String dependencies;
    private String status;
    private String reviewActionNotes;

    public CompetenceDetails(int competenceReferenceNo, String shortName, String objective, String hyperlink, String timing, String whoProvides, String type, String dependencies, String status, String reviewActionNotes) {
        this.competenceReferenceNo = competenceReferenceNo;
        this.shortName = shortName;
        this.objective = objective;
        this.hyperlink = hyperlink;
        this.timing = timing;
        this.whoProvides = whoProvides;
        this.type = type;
        this.dependencies = dependencies;
        this.status = status;
        this.reviewActionNotes = reviewActionNotes;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getWhoProvides() {
        return whoProvides;
    }

    public void setWhoProvides(String whoProvides) {
        this.whoProvides = whoProvides;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDependencies() {
        return dependencies;
    }

    public void setDependencies(String dependencies) {
        this.dependencies = dependencies;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReviewActionNotes() {
        return reviewActionNotes;
    }

    public void setReviewActionNotes(String reviewActionNotes) {
        this.reviewActionNotes = reviewActionNotes;
    }
    
}
