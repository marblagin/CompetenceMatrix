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
    private int internal;
    private int cash;
    private int disbursement;
    private int opportunity;
    private int total;
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
    public CostPerPerson(int internal, int cash, int disbursement, int opportunity, int total, String workBackApplicable, String workBack, int competenceReferenceNo) {
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
    public int getInternal() {
        return internal;
    }

    /**
     *
     * @param internal
     */
    public void setInternal(int internal) {
        this.internal = internal;
    }

    /**
     *
     * @return
     */
    public int getCash() {
        return cash;
    }

    /**
     *
     * @param cash
     */
    public void setCash(int cash) {
        this.cash = cash;
    }

    /**
     *
     * @return
     */
    public int getDisbursement() {
        return disbursement;
    }

    /**
     *
     * @param disbursement
     */
    public void setDisbursement(int disbursement) {
        this.disbursement = disbursement;
    }

    /**
     *
     * @return
     */
    public int getOpportunity() {
        return opportunity;
    }

    /**
     *
     * @param opportunity
     */
    public void setOpportunity(int opportunity) {
        this.opportunity = opportunity;
    }

    /**
     *
     * @return
     */
    public int getTotal() {
        return total;
    }

    /**
     *
     * @param total
     */
    public void setTotal(int total) {
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
