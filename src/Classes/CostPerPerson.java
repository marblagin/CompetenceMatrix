
package Classes;

/**
 *
 * @author Llewellyn Craddock
 */
public class CostPerPerson extends CompetenceMatrix {

    private int internal;
    private int cash;
    private int disbursement;
    private int opportunity;
    private int total;
    private String workBackApplicable;
    private String workBack;

    /**
     *A constructor of Cost per person 
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

    // The next Get methods return its respective value 
    /**
     *
     * @return  the requested value
     */
    public int getInternal() {
        return internal;
    }

    /**
     *
     * @return the requested value
     */
    public int getCash() {
        return cash;
    }

    /**
     *
     * @return the requested value
     */
    public int getDisbursement() {
        return disbursement;
    }

    /**
     *
     * @return the requested value
     */
    public int getOpportunity() {
        return opportunity;
    }

    /**
     *
     * @return the requested value
     */
    public int getTotal() {
        return total;
    }

    /**
     *
     * @return the requested value
     */
    public String getWorkBackApplicable() {
        return workBackApplicable;
    }

    /**
     *
     * @return the requested value
     */
    public String getWorkBack() {
        return workBack;
    }

    /**
     * 
     * @return string representing this classes group of data in a line, separate by tabs 
     */
    @Override
    public String toString() {
        String out = "";
        out += String.valueOf(super.getCompetenceReferenceNo()) + "\t"
                + String.valueOf(internal)+ "\t"
                + String.valueOf(cash)+ "\t"
                + String.valueOf(disbursement)+ "\t"
                + String.valueOf(opportunity)+ "\t"
                + String.valueOf(total)+ "\t"
                + workBackApplicable+ "\t"
                + workBack;

        return out;

    }
}
