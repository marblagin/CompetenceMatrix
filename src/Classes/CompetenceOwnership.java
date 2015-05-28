/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Llewellyn Craddock
 */
public class CompetenceOwnership {
    private int competenceReferenceNo;
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
    public CompetenceOwnership(int competenceReferenceNo, String partner, String champion, String details) {
        this.competenceReferenceNo = competenceReferenceNo;
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
     * @param partner
     */
    public void setPartner(String partner) {
        this.partner = partner;
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
     * @param champion
     */
    public void setChampion(String champion) {
        this.champion = champion;
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
    
}
