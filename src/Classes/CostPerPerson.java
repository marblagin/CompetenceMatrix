/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Llewellyn Craddock
 */
public class CostPerPerson extends CompetenceMatrix{
    private String internal;
    private String cash;
    private String disbursement;
    private String opportunity;
    private String total;
    private String workBackApplicable;
    private String workBack;

    /**
     *
     * @param competenceReferenceNo
     * @param internal
     * @param cash
     * @param disbursement
     * @param opportunity
     * @param total
     * @param workBackApplicable
     * @param workBack
     */
    public CostPerPerson(String internal, String cash, String disbursement, String opportunity, String total, String workBackApplicable, String workBack, int competenceReferenceNo) {
        super(competenceReferenceNo);
        this.internal = internal;
        this.cash = cash;
        this.disbursement = disbursement;
        this.opportunity = opportunity;
        this.total = total;
        this.workBackApplicable = workBackApplicable;
        this.workBack = workBack;
    }

    
    /**
     *
     * @return
     */
    public String getInternal() {
        return internal;
    }

    public void setInternal(String internal) {
        this.internal = internal;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getDisbursement() {
        return disbursement;
    }

    public void setDisbursement(String disbursement) {
        this.disbursement = disbursement;
    }

    public String getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(String opportunity) {
        this.opportunity = opportunity;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

   

    /**
     *
     * @return
     */
    public String getWorkBackApplicable() {
        return workBackApplicable;
    }

    /**
     *
     * @param workBackApplicable
     */
    public void setWorkBackApplicable(String workBackApplicable) {
        this.workBackApplicable = workBackApplicable;
    }

    /**
     *
     * @return
     */
    public String getWorkBack() {
        return workBack;
    }

    /**
     *
     * @param workBack
     */
    public void setWorkBack(String workBack) {
        this.workBack = workBack;
    }
    
}
