/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Llewellyn Craddock
 */
public class ApplicabilityOfCompetence {

    private int competenceReferenceNo;
    private String coreCareer;
    private String promotion;
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
    public ApplicabilityOfCompetence(int CompetenceReferenceNo, String CoreCareer, String Promotion, String SoftTechnical, String Degrees, String Grade) {
        competenceReferenceNo = CompetenceReferenceNo;
        coreCareer = CoreCareer;
        promotion = Promotion;
        softTechnical = SoftTechnical;
        degrees = Degrees;
        grade = Grade;
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
}
