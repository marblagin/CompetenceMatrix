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
     * @param CompetenceReferenceNo
     * @param CoreCareer
     * @param Promotion
     * @param SoftTechnical
     * @param Degrees
     * @param Grade
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

    public String getApplicable() {
        return applicable;
    }

    public void setApplicable(String applicable) {
        this.applicable = applicable;
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
     * @param coreCareer
     */
    public void setCoreCareer(String coreCareer) {
        this.coreCareer = coreCareer;
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
     * @param promotion
     */
    public void setPromotion(String promotion) {
        this.promotion = promotion;
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
     * @param softTechnical
     */
    public void setSoftTechnical(String softTechnical) {
        this.softTechnical = softTechnical;
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
     * @param degrees
     */
    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    /**
     *
     * @return
     */
    public String getGrade() {
        return grade;
    }

    /**
     *
     * @param grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
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
