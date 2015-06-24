/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Util.Debug;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Llewellyn Craddock
 */
public class DataLoad {

    public static DataLoad data = new DataLoad();
    private static int numberOfRows;
    private static int[] CompetenceNumbers;

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public Applicability[] LoadApplicability() {
        CompetenceNumbers = new int[200];
        Applicability[] app = new Applicability[200];
        int counter = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Applicability of competence.txt"), 84600);
            String line = br.readLine();
            while (line != null) {
                Scanner scLine = new Scanner(line).useDelimiter("\t");
                int compNum = scLine.nextInt();
                String coreCareer = scLine.next();
                String promotion = scLine.next();
                String applicable = scLine.next();
                String softTechnical = scLine.next();
                String degrees = scLine.next();
                String grade = scLine.next();
                app[counter] = new Applicability(coreCareer, promotion, applicable, softTechnical, degrees, grade, compNum);
                CompetenceNumbers[counter] = compNum;
                counter++;
                line = br.readLine();
            }
            br.close();
            Debug.Log("File found and loaded");
        } catch (IOException e) {
            Debug.LogException(e);
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
        CompetenceNumbers = new int[200];
        CompetenceDetails[] det = new CompetenceDetails[200];
        int counter = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Competence Details.txt"), 84600);
            String line = br.readLine();
            while (line != null) {
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
                CompetenceNumbers[counter] = compNum;
                counter++;
                line = br.readLine();
            }
            br.close();
            Debug.Log("File found and loaded");
        } catch (IOException e) {
            Debug.LogException(e);
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
        CompetenceNumbers = new int[200];
        CompetenceOwnership[] own = new CompetenceOwnership[200];
        int counter = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Competence Ownership.txt"), 84600);
            String line = br.readLine();
            while (line != null) {
                Scanner scLine = new Scanner(line).useDelimiter("\t");
                int compNum = scLine.nextInt();
                String partner = scLine.next();
                String champion = scLine.next();
                String details = scLine.next();
                own[counter] = new CompetenceOwnership(partner, champion, details, compNum);
                CompetenceNumbers[counter] = compNum;
                counter++;
                line = br.readLine();
                //Debug.Log("Completed Competence Number is "+ (counter));
            }
            br.close();
            Debug.Log("File found and loaded");
        } catch (IOException e) {
            Debug.LogException(e);
        }
        numberOfRows = counter;

        return own;
    }

    public String[] LoadOwnershipHeadings() {
        String[] out = {
            "Competence Reference Number",
            "ITA Partner / AD (accountable)",
            "ITA Champion (responsible)",
            "Other contact details"
        };
        return out;
    }

    public CostPerPerson[] LoadCost() {
        CompetenceNumbers = new int[200];
        CostPerPerson[] cost = new CostPerPerson[200];
        int counter = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Cost per person.txt"), 84600);
            String line = br.readLine();
            while (line != null) {
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
                CompetenceNumbers[counter] = compNum;
                counter++;
                line = br.readLine();
                //Debug.Log("Counter is " + (counter));
            }
            br.close();
            Debug.Log("File found and loaded");
        } catch (IOException e) {
            Debug.LogException(e);
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
        CompetenceNumbers = new int[200];
        Timesheet[] time = new Timesheet[200];
        int counter = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Timesheet.txt"), 84600);
            String line = br.readLine();
            while (line != null) {
                Scanner scLine = new Scanner(line).useDelimiter("\t");
                int compNum = scLine.nextInt();
                String code = scLine.next();
                String hours = scLine.next();
                time[counter] = new Timesheet(code, hours, compNum);
                CompetenceNumbers[counter] = compNum;
                counter++;
                //Debug.Log("Counter is " + (counter));
                line = br.readLine();
            }
            br.close();
            Debug.Log("File found and loaded");
        } catch (IOException e) {
            Debug.LogException(e);
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

    public DefaultTableModel[] GenerateTableModel() {
        DefaultTableModel[] tableArr = new DefaultTableModel[5];

        DefaultTableModel det = new DefaultTableModel(this.LoadDetailsHeadings(), 1);
        tableArr[0] = det;
        DefaultTableModel own = new DefaultTableModel(this.LoadOwnershipHeadings(), 1);
        tableArr[1] = own;
        DefaultTableModel app = new DefaultTableModel(this.LoadApplicabilityHeadings(), 1);
        tableArr[2] = app;
        DefaultTableModel time = new DefaultTableModel(this.LoadTimesheetHeadings(), 1);
        tableArr[3] = time;
        DefaultTableModel cost = new DefaultTableModel(this.LoadCostHeadings(), 1);
        tableArr[4] = cost;

        return tableArr;
    }

    public void StoreData(String[] lines) {
        FileWriter fw;
        BufferedWriter bw;
        try {

            fw = new FileWriter("Competence Details.txt");
            bw = new BufferedWriter(fw);
            //bw.newLine();
            //bw.write(lines[0]);
            // pw = new PrintWriter(fw);
            //pw.println(lines[0]);

            //Debug.Log("Data stored in Competence Details.txt");
            //fw = new FileWriter("Competence Ownership.txt");
            //pw = new PrintWriter(fw);
            // pw.println(lines[1]);

            //Debug.Log("Data stored in Competence Ownership.txt");
            //fw = new FileWriter("Applicability of competence.txt");
            //pw = new PrintWriter(fw);
            //pw.println(lines[2]);

            //Debug.Log("Data stored in Applicability of competence.txt");
            //fw = new FileWriter("Timesheet.txt");
            // pw = new PrintWriter(fw);
            // pw.println(lines[3]);

            //Debug.Log("Data stored in Timesheet.txt");
            //fw = new FileWriter("Cost per person.txt");
            //pw = new PrintWriter(fw);
            // pw.println(lines[4]);

            //Debug.Log("Data stored in Cost per person.txt");
            //pw.close();

        } catch (IOException ex) {
            Debug.LogException(ex);
        }
    }

    public int getUniqueCompetenceNumber() {
        int result = 1;
        int counter = 0;
        while (result == CompetenceNumbers[counter]) {
            result++;
            counter++;
        }

        return result;
    }
}
