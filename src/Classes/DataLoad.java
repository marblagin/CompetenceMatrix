/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Util.Debug;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Llewellyn Craddock
 */
public class DataLoad {

    private static int numberOfRows;

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public Applicability[] LoadApplicability() throws FileNotFoundException {

        Applicability[] app = new Applicability[200];
        int counter = 0;
        File file = new File("Applicability of Competence.txt");
        try (Scanner scFile = new Scanner(file)) {
            while (scFile.hasNext()) {
                String line = scFile.nextLine();
                Scanner scLine = new Scanner(line).useDelimiter("\t");
                int compNum = scLine.nextInt();
                String coreCareer = scLine.next();
                String promotion = scLine.next();
                String applicable = scLine.next();
                String softTechnical = scLine.next();
                String degrees = scLine.next();
                String grade = scLine.next();
                app[counter] = new Applicability(coreCareer, promotion, applicable, softTechnical, degrees, grade, compNum);
                counter++;
            }
            scFile.close();
            Debug.Log("File found and loaded");
        } catch (FileNotFoundException e) {
            Debug.Log("The specified file was not found");
        }

        numberOfRows = counter;

        return app;
    }

    public String[] LoadApplicabilityHeadings() {
        String[] out = {
            "Competence Reference Number",
            "Core / Career specific",
            "Pre requisite for promotion / suggested competence",
            "Applicable to KPMG/ ITA/ service line",
            "Soft/ Technical",
            "Competence applies to CA degree/ Non CA degrees/ Both",
            "Grade by when competence should have been achieved"
        };
        return out;
    }

    public CompetenceDetails[] LoadDetails() {
        CompetenceDetails[] det = new CompetenceDetails[200];
        int counter = 0;
        try {
            File file = new File("Competence Details.txt");
            Scanner scFile = new Scanner(file);
            while (scFile.hasNext()) {
                String line = scFile.nextLine();
                Scanner scLine = new Scanner(line).useDelimiter("\t");
                int compNum = scLine.nextInt();
                String shortName = scLine.next();
                String objective = scLine.next();
                String details = scLine.next();
                String hyperlink = scLine.next();
                String timing = scLine.next();
                String whoProvides = scLine.next();
                String type = scLine.next();
                String dependencies = scLine.next();
                String status = scLine.next();
                String reviewActionNotes = scLine.next();
                det[counter] = new CompetenceDetails(shortName, objective, details, hyperlink, timing, whoProvides, type, dependencies, status, reviewActionNotes, compNum);
                counter++;
            }
            scFile.close();
            Debug.Log("File found and loaded");
        } catch (FileNotFoundException e) {
            Debug.Log("The specified file was not found");
        }
        numberOfRows = counter;

        return det;
    }

    public String[] LoadDetailsHeadings() {
        String[] out = {
            "Competence Reference Number",
            "Competence short name",
            "Competence Objective",
            "Competence details",
            "Hyperlink to further details",
            "Timing",
            "Who provides the competence",
            "Competence Type",
            "Dependencies",
            "Competence Status",
            "Review / action notes",};
        return out;
    }

    public CompetenceOwnership[] LoadOwnership() {
        CompetenceOwnership[] own = new CompetenceOwnership[200];
        int counter = 0;
        try {
            File file = new File("Competence Ownership.txt");
            Scanner scFile = new Scanner(file);
            while (scFile.hasNext()) {
                String line = scFile.nextLine();
                Scanner scLine = new Scanner(line).useDelimiter("\t");
                int compNum = scLine.nextInt();
                String partner = scLine.next();
                String champion = scLine.next();
                String details = scLine.next();
                own[counter] = new CompetenceOwnership(partner, champion, details, compNum);
                counter++;
                //Debug.Log("Counter is "+ (counter+1));
            }
            scFile.close();
            Debug.Log("File found and loaded");
        } catch (FileNotFoundException e) {
            Debug.Log("The specified file was not found");
        }
        numberOfRows = counter;

        return own;
    }

    public String[] LoadOwnershipHeadings() {
        String[] out = {
            "ITA Partner / AD (accountable)",
            "ITA Champion (responsible)",
            "Other contact details"
        };
        return out;
    }

    public CostPerPerson[] LoadCost() {
        CostPerPerson[] cost = new CostPerPerson[200];
        int counter = 0;
        try {
            File file = new File("Cost per person.txt");
            Scanner scFile = new Scanner(file);
            while (scFile.hasNext()) {
                String line = scFile.nextLine();
                Scanner scLine = new Scanner(line).useDelimiter("\t");
                int compNum = scLine.nextInt();
                int internal = scLine.nextInt();
                int cash = scLine.nextInt();
                int disbursement = scLine.nextInt();
                int opportunity = scLine.nextInt();
                int total = scLine.nextInt();
                String workBackApplicable = scLine.next();
                String workBack = scLine.next();
                cost[counter] = new CostPerPerson(internal, cash, disbursement, opportunity, total, workBackApplicable, workBack, compNum);
                counter++;
                Debug.Log("Counter is " + (counter + 1));
            }
            scFile.close();
            Debug.Log("File found and loaded");
        } catch (FileNotFoundException e) {
            Debug.Log("The specified file was not found");
        }
        numberOfRows = counter;

        return cost;
    }

    public String[] LoadCostHeadings() {
        String[] out = {
            "Competence Reference Number",
            "Internal L&D costs",
            "Cash costs",
            "Disbursement costs",
            "Opportunity cost PP(hrs * scale)",
            "Total cost pp",
            "Work back period applicable?",
            "Work back period (month)",};
        return out;
    }

    public Timesheet[] LoadTimesheet() {
        Timesheet[] time = new Timesheet[200];
        int counter = 0;
        try {
            File file = new File("Timesheet.txt");
            Scanner scFile = new Scanner(file);
            while (scFile.hasNext()) {
                String line = scFile.nextLine();
                Scanner scLine = new Scanner(line).useDelimiter("\t");
                int compNum = scLine.nextInt();
                String code = scLine.next();
                String hours = scLine.next();
                time[counter] = new Timesheet(code, hours, compNum);
                counter++;
            }
            scFile.close();
            Debug.Log("File found and loaded");
        } catch (FileNotFoundException e) {
            Debug.Log("The specified file was not found");
        }
        numberOfRows = counter;

        return time;
    }

    public String[] LoadTimesheetHeadings() {
        String[] out = {
            "Competence Reference Number",
            "Timesheet code",
            "Timesheet hours allocated"
        };
        return out;
    }
}
