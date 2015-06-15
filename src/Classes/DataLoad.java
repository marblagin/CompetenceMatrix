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

    private int numberOfRows;

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public Applicability[] LoadApplicability() throws FileNotFoundException {

        Applicability[] app = new Applicability[200];
        int counter = 0;
        File file = new File("Applicability of Competence");
        try {
            Scanner scFile = new Scanner(file);
            while (scFile.hasNext()) {
                String line = scFile.nextLine();
                Scanner scLine = new Scanner(line).useDelimiter("/t");
                int compNum = scLine.nextInt();
                String coreCareer = scLine.next();
                String promotion = scLine.next();
                String softTechnical = scLine.next();
                String degrees = scLine.next();
                String grade = scLine.next();
                app[counter] = new Applicability(coreCareer, promotion, softTechnical, degrees, grade, counter);
                scFile.close();
            }
        } catch (FileNotFoundException e) {
            Debug.Log("The specified file was not found");
        }
        numberOfRows = counter;
        return app;
    }

    public CompetenceDetails[] LoadDetails() {
        CompetenceDetails[] det = new CompetenceDetails[200];
        int counter = 0;
        File file = new File("Competence Details");
        try {
            Scanner scFile = new Scanner(file);
            while (scFile.hasNext()) {
                String line = scFile.nextLine();
                Scanner scLine = new Scanner(line).useDelimiter("/t");
                int compNum = scLine.nextInt();
                String shortName = scLine.next();
                String objective = scLine.next();
                String hyperlink = scLine.next();
                String timing = scLine.next();
                String whoProvides = scLine.next();
                String type = scLine.next();
                String dependencies = scLine.next();
                String status = scLine.next();
                String reviewActionNotes = scLine.next();
                det[counter] = new CompetenceDetails(shortName, objective, hyperlink, timing, whoProvides, type, dependencies, status, reviewActionNotes, counter);
                scFile.close();
            }
        } catch (FileNotFoundException e) {
            Debug.Log("The specified file was not found");
        }
        numberOfRows = counter;

        return det;
    }

    public CompetenceOwnership[] LoadOwnership() {
        CompetenceOwnership[] own = new CompetenceOwnership[200];
        int counter = 0;
        File file = new File("Competence Ownership");
        try {
            Scanner scFile = new Scanner(file);
            while (scFile.hasNext()) {
                String line = scFile.nextLine();
                Scanner scLine = new Scanner(line).useDelimiter("/t");
                int compNum = scLine.nextInt();
                String partner = scLine.next();
                String champion = scLine.next();
                String details = scLine.next();
                own[counter] = new CompetenceOwnership(partner, champion, details, counter);
                scFile.close();
            }
        } catch (FileNotFoundException e) {
            Debug.Log("The specified file was not found");
        }
        numberOfRows = counter;

        return own;
    }

    public CostPerPerson[] LoadCost() {
        CostPerPerson[] cost = new CostPerPerson[200];
        int counter = 0;
        File file = new File("Applicability of Competence");
        try {
            Scanner scFile = new Scanner(file);
            while (scFile.hasNext()) {
                String line = scFile.nextLine();
                Scanner scLine = new Scanner(line).useDelimiter("/t");
                int compNum = scLine.nextInt();
                int internal = scLine.nextInt();
                int cash = scLine.nextInt();
                int disbursement = scLine.nextInt();
                int opportunity = scLine.nextInt();
                int total = scLine.nextInt();
                String workBackApplicable = scFile.next();
                String workBack = scLine.next();
                cost[counter] = new CostPerPerson(internal, cash, disbursement, opportunity, total, workBackApplicable, workBack, counter);
                scFile.close();
            }
        } catch (FileNotFoundException e) {
            Debug.Log("The specified file was not found");
        }
        numberOfRows = counter;

        return cost;
    }

    public Timesheet[] LoadTimesheet() {
        Timesheet[] time = new Timesheet[200];
        int counter = 0;
        File file = new File("Applicability of Competence");
        try {
            Scanner scFile = new Scanner(file);
            while (scFile.hasNext()) {
                String line = scFile.nextLine();
                Scanner scLine = new Scanner(line).useDelimiter("/t");
                int compNum = scLine.nextInt();
                String code = scLine.next();
                double hours = scLine.nextDouble();
                time [counter] = new Timesheet(code, hours, counter);
                scFile.close();
            }
        } catch (FileNotFoundException e) {
            Debug.Log("The specified file was not found");
        }
        numberOfRows = counter;

        return time;
    }
}
