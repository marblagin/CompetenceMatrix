/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Llewellyn Craddock
 */
public class Applicability extends CompetenceMatrix{

    private String coreCareer;
    private String promotion;
    private String applicable;
    private String softTechnical;
    private String degrees;
    private String grade;

    /**
     *
     * @param coreCareer 
     * @param promotion 
     * @param applicable 
     * @param softTechnical 
     * @param grade
     * @param degrees 
     * @param competenceReferenceNo  
     */
    public Applicability(String coreCareer, String promotion, String applicable, String softTechnical, String degrees, String grade, int competenceReferenceNo) {
        super(competenceReferenceNo);
        this.coreCareer = coreCareer;
        this.promotion = promotion;
        this.applicable = applicable;
        this.softTechnical = softTechnical;
        this.degrees = degrees;
        this.grade = grade;
    }

    /**
     *
     * @return
     */
    public String getApplicable() {
        return applicable;
    }
   
    /**
     *
     * @return
     */
    public String getCoreCareer() {
        return coreCareer;
    }

    /**
     *
     * @return
     */
    public String getPromotion() {
        return promotion;
    }

    /**
     *
     * @return
     */
    public String getSoftTechnical() {
        return softTechnical;
    }

    /**
     *
     * @return
     */
    public String getDegrees() {
        return degrees;
    }

    /**
     *
     * @return
     */
    public String getGrade() {
        return grade;
    }
    @Override
    public String toString (){
        String out = "";
        out+= String.valueOf(super.getCompetenceReferenceNo())+"\t"
                 +coreCareer+"\t"
                 +promotion +"\t"
                 +applicable +"\t"
                 +softTechnical +"\t"
                 +degrees +"\t"
                 +grade ;
        return out;
    }
}
