/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Llewellyn Craddock
 */
public class DataLoad {
   
    public Applicability [] LoadApplicability (){
        Applicability [] app = new Applicability[200];
        
        return app;
    }
    public CompetenceDetails [] LoadDetails (){
        CompetenceDetails [] det = new CompetenceDetails[200];
        
        return det;
    }
    public CompetenceOwnership [] LoadOwnership (){
        CompetenceOwnership [] own = new CompetenceOwnership[200];
        
        return own;
    }
    public CostPerPerson [] LoadCost(){
        CostPerPerson [] cost = new CostPerPerson[200];
        
        return cost;
    }
    public Timesheet [] LoadTimesheet(){
        Timesheet [] time = new Timesheet[200];
        
        return time;
    }
}
