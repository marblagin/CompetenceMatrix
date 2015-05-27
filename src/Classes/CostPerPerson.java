/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Llewellyn Craddock
 */
public class CostPerPerson {
    private int competenceReferenceNo;
    private int internal;
    private int cash;
    private int disbursement;
    private int opportunity;
    private int total;
    private String workBackApplicable;
    private String workBack;

    public CostPerPerson(int competenceReferenceNo, int internal, int cash, int disbursement, int opportunity, int total, String workBackApplicable, String workBack) {
        this.competenceReferenceNo = competenceReferenceNo;
        this.internal = internal;
        this.cash = cash;
        this.disbursement = disbursement;
        this.opportunity = opportunity;
        this.total = total;
        this.workBackApplicable = workBackApplicable;
        this.workBack = workBack;
    }

    public int getInternal() {
        return internal;
    }

    public void setInternal(int internal) {
        this.internal = internal;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getDisbursement() {
        return disbursement;
    }

    public void setDisbursement(int disbursement) {
        this.disbursement = disbursement;
    }

    public int getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(int opportunity) {
        this.opportunity = opportunity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getWorkBackApplicable() {
        return workBackApplicable;
    }

    public void setWorkBackApplicable(String workBackApplicable) {
        this.workBackApplicable = workBackApplicable;
    }

    public String getWorkBack() {
        return workBack;
    }

    public void setWorkBack(String workBack) {
        this.workBack = workBack;
    }
    
}
