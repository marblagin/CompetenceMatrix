/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Util.Debug;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public static String Detailstxt = "Competence Details.txt";
    public static String Ownershiptxt = "Competence Ownership.txt";
    public static String Applicablitytxt = "Applicability of competence.txt";
    public static String Timetxt = "Timesheet.txt";
    public static String Costtxt = "Cost per person.txt";

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public Applicability[] LoadApplicability() {
        CompetenceNumbers = new int[200];
        Applicability[] app = new Applicability[200];
        int counter = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(Applicablitytxt), 84600);
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
            Debug.Log("Applicability File found and loaded");
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
            BufferedReader br = new BufferedReader(new FileReader(Detailstxt), 84600);
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
                //Debug.Log("Completed Competence Number is "+ (counter));
                counter++;
                line = br.readLine();
            }
            br.close();
            Debug.Log("Details File found and loaded");
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
            BufferedReader br = new BufferedReader(new FileReader(Ownershiptxt), 84600);
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
            Debug.Log("Ownership File found and loaded");
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
            BufferedReader br = new BufferedReader(new FileReader(Costtxt), 84600);
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
            Debug.Log("Cost File found and loaded");
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
            try (BufferedReader br = new BufferedReader(new FileReader(Timetxt), 84600)) {
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
            }
            Debug.Log("Timesheet File found and loaded");
        }catch (IOException e) {
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

    public static void StoreData(String[] lines) {
        FileWriter fw;
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream(new File(Detailstxt), true));
            for (char c : lines[0].toCharArray()) {
                pw.append(c);
            }
            pw.append("\r\n");
            pw.flush();
            pw.close();
            pw = new PrintWriter(new FileOutputStream(new File(Ownershiptxt), true));
            for (char c : lines[1].toCharArray()) {
                pw.append(c);
            }
            pw.append("\r\n");
            pw.flush();
            pw.close();
            pw = new PrintWriter(new FileOutputStream(new File(Applicablitytxt), true));
            for (char c : lines[2].toCharArray()) {
                pw.append(c);
            }
            pw.append("\r\n");
            pw.flush();
            pw.close();
            pw = new PrintWriter(new FileOutputStream(new File(Timetxt), true));
            for (char c : lines[3].toCharArray()) {
                pw.append(c);
            }
            pw.append("\r\n");
            pw.flush();
            pw.close();
            pw = new PrintWriter(new FileOutputStream(new File(Costtxt), true));
            for (char c : lines[4].toCharArray()) {
                pw.append(c);
            }
            pw.append("\r\n");
            pw.flush();
            pw.close();
            Debug.Log("Data stored in Files");
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

    public void RemoveCompetence(int CompNum) {

        CompetenceDetails[] det = this.LoadDetails();
        CompetenceOwnership[] own = this.LoadOwnership();
        Applicability[] app = this.LoadApplicability();
        CostPerPerson[] cost = this.LoadCost();
        Timesheet[] time = this.LoadTimesheet();

        //Competence Details:
        String lineToRemove = "";
        for (int i = 0; i < numberOfRows; i++) {
            if (det[i].getCompetenceReferenceNo() == CompNum) {
                lineToRemove = det[i].toString();
                Debug.Log("lineToRemove is: " + lineToRemove);

            }
        }
        String currentLine;
        try {
            File tempFile = new File("myTempFile.txt");
            Debug.Log("Found files and beginning writing...");
            BufferedReader reader;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                reader = new BufferedReader(new FileReader(Detailstxt));
                while ((currentLine = reader.readLine()) != null) {
                    //Debug.Log("currentLine is: " + currentLine);
                    if (currentLine.equals(lineToRemove)) {
                        Debug.Log("lineToRemove and currentLine are equal...");
                    } else {
                        writer.write(currentLine + "\r\n");
                    }
                }
            }
            reader.close();
            File origanalFile = new File(Detailstxt);
            String txtpath = origanalFile.getPath();
            Path path = Paths.get(txtpath);
            try {
                Files.delete(path);
                Debug.Log("File was successfully deleted");
            } catch (Exception e) {
                Debug.Log("File failed to delete");
            }
            boolean successfulRename = tempFile.renameTo(new File (Detailstxt));
            if (successfulRename) {
                Debug.Log("Renaming successful...");
            }

        } catch (IOException ex) {
            Debug.LogException(ex);
        }
        
        //Competence Ownership:
        
        lineToRemove = "";
        for (int i = 0; i < numberOfRows; i++) {
            if (own[i].getCompetenceReferenceNo() == CompNum) {
                lineToRemove = own[i].toString();
                Debug.Log("lineToRemove is: " + lineToRemove);

            }
        }
        try {
            File tempFile = new File("myTempFile.txt");
            Debug.Log("Created temp file and beginning writing...");
            BufferedReader reader;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                reader = new BufferedReader(new FileReader(Ownershiptxt));
                while ((currentLine = reader.readLine()) != null) {
                    //Debug.Log("currentLine is: " + currentLine);
                    if (currentLine.equals(lineToRemove)) {
                        Debug.Log("lineToRemove and currentLine are equal...");
                    } else {
                        writer.write(currentLine + "\r\n");
                    }
                }
            }
            reader.close();
            File origanalFile = new File(Ownershiptxt);
            String txtpath = origanalFile.getPath();
            Path path = Paths.get(txtpath);
            try {
                Files.delete(path);
                Debug.Log("File was successfully deleted");
            } catch (Exception e) {
                Debug.Log("File failed to delete");
            }
            boolean successfulRename = tempFile.renameTo(new File (Ownershiptxt));
            if (successfulRename) {
                Debug.Log("Renaming successful...");
            }

        } catch (IOException ex) {
            Debug.LogException(ex);
        }
        
        //Applicabiity of Competence:
        
        lineToRemove = "";
        for (int i = 0; i < numberOfRows; i++) {
            if (app[i].getCompetenceReferenceNo() == CompNum) {
                lineToRemove = app[i].toString();
                Debug.Log("lineToRemove is: " + lineToRemove);

            }
        }
        try {
            File tempFile = new File("myTempFile.txt");
            Debug.Log("Created temp file and beginning writing...");
            BufferedReader reader;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                reader = new BufferedReader(new FileReader(Applicablitytxt));
                while ((currentLine = reader.readLine()) != null) {
                    //Debug.Log("currentLine is: " + currentLine);
                    if (currentLine.equals(lineToRemove)) {
                        Debug.Log("lineToRemove and currentLine are equal");
                    } else {
                        writer.write(currentLine + "\r\n");
                    }
                }
            }
            reader.close();
            File origanalFile = new File(Applicablitytxt);
            String txtpath = origanalFile.getPath();
            Path path = Paths.get(txtpath);
            try {
                Files.delete(path);
                Debug.Log("File was successfully deleted");
            } catch (Exception e) {
                Debug.Log("File failed to delete");
            }
            boolean successfulRename = tempFile.renameTo(new File (Applicablitytxt));
            if (successfulRename) {
                Debug.Log("Renaming successful...");
            }

        } catch (IOException ex) {
            Debug.LogException(ex);
        }
        
        //Timesheet:
        
        lineToRemove = "";
        for (int i = 0; i < numberOfRows; i++) {
            if (time[i].getCompetenceReferenceNo() == CompNum) {
                lineToRemove = time[i].toString();
                Debug.Log("lineToRemove is: " + lineToRemove);

            }
        }
        try {
            File tempFile = new File("myTempFile.txt");
            Debug.Log("Created temp file and beginning writing...");
            BufferedReader reader;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                reader = new BufferedReader(new FileReader(Timetxt));
                while ((currentLine = reader.readLine()) != null) {
                    //Debug.Log("currentLine is: " + currentLine);
                    if (currentLine.equals(lineToRemove)) {
                        Debug.Log("lineToRemove and currentLine are equal");
                    } else {
                        writer.write(currentLine + "\r\n");
                    }
                }
            }
            reader.close();
            File origanalFile = new File(Timetxt);
            String txtpath = origanalFile.getPath();
            Path path = Paths.get(txtpath);
            try {
                Files.delete(path);
                Debug.Log("File was successfully deleted");
            } catch (Exception e) {
                Debug.Log("File failed to delete");
            }
            boolean successfulRename = tempFile.renameTo(new File (Timetxt));
            if (successfulRename) {
                Debug.Log("Renaming successful...");
            }

        } catch (IOException ex) {
            Debug.LogException(ex);
        }
        
        //Cost:
        
        lineToRemove = "";
        for (int i = 0; i < numberOfRows; i++) {
            if (cost[i].getCompetenceReferenceNo() == CompNum) {
                lineToRemove = cost[i].toString();
                Debug.Log("lineToRemove is: " + lineToRemove);
            }
        }
        try {
            File tempFile = new File("myTempFile.txt");
            Debug.Log("Created temp file and beginning writing...");
            BufferedReader reader;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                reader = new BufferedReader(new FileReader(Costtxt));
                while ((currentLine = reader.readLine()) != null) {
                    //Debug.Log("currentLine is: " + currentLine);
                    if (currentLine.equals(lineToRemove)) {
                        Debug.Log("lineToRemove and currentLine are equal");
                    } else {
                        writer.write(currentLine + "\r\n");
                    }
                }
            }
            reader.close();
            File origanalFile = new File(Costtxt);
            String txtpath = origanalFile.getPath();
            Path path = Paths.get(txtpath);
            try {
                Files.delete(path);
                Debug.Log("File was successfully deleted");
            } catch (Exception e) {
                Debug.Log("File failed to delete");
            }
            boolean successfulRename = tempFile.renameTo(new File (Costtxt));
            if (successfulRename) {
                Debug.Log("Renaming successful...");
            }

        } catch (IOException ex) {
            Debug.LogException(ex);
        }
    }
}
