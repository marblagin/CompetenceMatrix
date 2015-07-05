
package Classes;

/**
 *
 * @author Llewellyn Craddock
 */
public class CompetenceMatrix {
    private int competenceReferenceNo;

    /**
     *A constructor now follows with the parameter of: 
     * @param competenceReferenceNo
     */
    public CompetenceMatrix(int competenceReferenceNo) {
        this.competenceReferenceNo = competenceReferenceNo;
    }

    /**
     *
     * @returns the competence Reference Number is this class
     */
    public int getCompetenceReferenceNo() {
        return competenceReferenceNo;
    }

    /**
     *
     * @param competenceReferenceNo
     */
    public void setCompetenceReferenceNo(int competenceReferenceNo) {
        this.competenceReferenceNo = competenceReferenceNo;
    }
    
}
