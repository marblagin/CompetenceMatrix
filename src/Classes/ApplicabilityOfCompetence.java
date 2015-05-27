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

    public ApplicabilityOfCompetence(int CompetenceReferenceNo, String CoreCareer, String Promotion, String SoftTechnical, String Degrees, String Grade) {
        competenceReferenceNo = CompetenceReferenceNo;
        coreCareer = CoreCareer;
        promotion = Promotion;
        softTechnical = SoftTechnical;
        degrees = Degrees;
        grade = Grade;
    }
    
    public String getCoreCareer() {
        return coreCareer;
    }

    public void setCoreCareer(String coreCareer) {
        this.coreCareer = coreCareer;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getSoftTechnical() {
        return softTechnical;
    }

    public void setSoftTechnical(String softTechnical) {
        this.softTechnical = softTechnical;
    }

    public String getDegrees() {
        return degrees;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
