package Classes;

import Util.Debug;

/**
 *
 * @author Llewellyn Craddock
 */
public class SearchEngine {

    //This class provides methos of sorting data arrays in a specific way
    /**
     * This method returns a two-dimensional array that is sorting according to
     * the competence reference number, in ascending order
     *
     * @param det the array of the Competence Details records
     * @param own the array of the Competence Ownership records
     * @param app the array of the Applicability of competence records
     * @param cost the array of the Cost per person records
     * @param time the array of the Timesheet records
     * @return a sorted two-dimensional array
     */
    public static CompetenceMatrix[][] SortByCompNumASC(CompetenceDetails[] det, CompetenceOwnership[] own, Applicability[] app, CostPerPerson[] cost, Timesheet[] time) {
        CompetenceMatrix[][] arr = new CompetenceMatrix[5][200];
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    for (int x = 0; x < DataLoad.data.getNumberOfRows(); x++) {
                        for (int y = x + 1; y < DataLoad.data.getNumberOfRows(); y++) {
                            if (det[x].getCompetenceReferenceNo() > det[y].getCompetenceReferenceNo()) {
                                CompetenceDetails temp = det[x];
                                det[x] = det[y];
                                det[y] = temp;
                            }
                        }
                    }
                    arr[i] = det;
                    break;
                case 1:
                    for (int x = 0; x < DataLoad.data.getNumberOfRows(); x++) {
                        for (int y = x + 1; y < DataLoad.data.getNumberOfRows(); y++) {
                            if (own[x].getCompetenceReferenceNo() > own[y].getCompetenceReferenceNo()) {
                                CompetenceOwnership temp = own[x];
                                own[x] = own[y];
                                own[y] = temp;
                            }
                        }
                    }
                    arr[i] = own;
                    break;
                case 2:
                    for (int x = 0; x < DataLoad.data.getNumberOfRows(); x++) {
                        for (int y = x + 1; y < DataLoad.data.getNumberOfRows(); y++) {
                            if (app[x].getCompetenceReferenceNo() > app[y].getCompetenceReferenceNo()) {
                                Applicability temp = app[y];
                                app[x] = app[y];
                                app[y] = temp;
                            }
                        }
                    }
                    arr[i] = app;
                    break;
                case 3:
                    for (int x = 0; x < DataLoad.data.getNumberOfRows(); x++) {
                        for (int y = x + 1; y < DataLoad.data.getNumberOfRows(); y++) {
                            if (time[x].getCompetenceReferenceNo() > time[y].getCompetenceReferenceNo()) {
                                Timesheet temp = time[x];
                                time[x] = time[y];
                                time[y] = temp;
                            }
                        }
                    }
                    arr[i] = time;
                    break;
                case 4:
                    for (int x = 0; x < DataLoad.data.getNumberOfRows(); x++) {
                        for (int y = x + 1; y < DataLoad.data.getNumberOfRows(); y++) {
                            if (cost[x].getCompetenceReferenceNo() > cost[y].getCompetenceReferenceNo()) {
                                CostPerPerson temp = cost[x];
                                cost[x] = cost[y];
                                cost[y] = temp;
                            }
                        }
                    }
                    arr[i] = cost;
                    break;
            }
        }
        return arr;
    }

    /**
     * This method returns a two-dimensional array that is sorting according to
     * the competence reference number, in descending order
     *
     * @param det the array of the Competence Details records
     * @param own the array of the Competence Ownership records
     * @param app the array of the Applicability of competence records
     * @param cost the array of the Cost per person records
     * @param time the array of the Timesheet records
     * @return a sorted two-dimensional array
     */
    public static CompetenceMatrix[][] SortByCompNumDESC(CompetenceDetails[] det, CompetenceOwnership[] own, Applicability[] app, CostPerPerson[] cost, Timesheet[] time) {
        CompetenceMatrix[][] arr = new CompetenceMatrix[5][200];
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    for (int x = 0; x < DataLoad.data.getNumberOfRows(); x++) {
                        for (int y = x + 1; y < DataLoad.data.getNumberOfRows(); y++) {
                            if (det[x].getCompetenceReferenceNo() < det[y].getCompetenceReferenceNo()) {
                                CompetenceDetails temp = det[x];
                                det[x] = det[y];
                                det[y] = temp;
                            }
                        }
                    }
                    arr[i] = det;
                    break;
                case 1:
                    for (int x = 0; x < DataLoad.data.getNumberOfRows(); x++) {
                        for (int y = x + 1; y < DataLoad.data.getNumberOfRows(); y++) {
                            if (own[x].getCompetenceReferenceNo() < own[y].getCompetenceReferenceNo()) {
                                CompetenceOwnership temp = own[x];
                                own[x] = own[y];
                                own[y] = temp;
                            }
                        }
                    }
                    arr[i] = own;
                    break;
                case 2:
                    for (int x = 0; x < DataLoad.data.getNumberOfRows(); x++) {
                        for (int y = x + 1; y < DataLoad.data.getNumberOfRows(); y++) {
                            if (app[x].getCompetenceReferenceNo() < app[y].getCompetenceReferenceNo()) {
                                Applicability temp = app[x];
                                app[x] = app[y];
                                app[y] = temp;
                            }
                        }
                    }
                    arr[i] = app;
                    break;
                case 3:
                    for (int x = 0; x < DataLoad.data.getNumberOfRows(); x++) {
                        for (int y = x + 1; y < DataLoad.data.getNumberOfRows(); y++) {
                            if (time[x].getCompetenceReferenceNo() < time[y].getCompetenceReferenceNo()) {
                                Timesheet temp = time[x];
                                time[x] = time[y];
                                time[y] = temp;
                            }
                        }
                    }
                    arr[i] = time;
                    break;
                case 4:
                    for (int x = 0; x < DataLoad.data.getNumberOfRows(); x++) {
                        for (int y = x + 1; y < DataLoad.data.getNumberOfRows(); y++) {
                            if (cost[x].getCompetenceReferenceNo() < cost[y].getCompetenceReferenceNo()) {
                                CostPerPerson temp = cost[x];
                                cost[x] = cost[y];
                                cost[y] = temp;
                            }
                        }
                    }
                    arr[i] = cost;
                    break;
            }
        }
        return arr;
    }

    /**
     * This returns a two-dimensional array sorted according to the total cost
     * of the competence in ascending order
     *
     * @param det the array of the Competence Details records
     * @param own the array of the Competence Ownership records
     * @param app the array of the Applicability of competence records
     * @param cost the array of the Cost per person records
     * @param time the array of the Timesheet records
     * @return a sorted two-dimensional array
     */
    public static CompetenceMatrix[][] SortByTotalASC(CompetenceDetails[] det, CompetenceOwnership[] own, Applicability[] app, CostPerPerson[] cost, Timesheet[] time) {
        CompetenceMatrix[][] arr = new CompetenceMatrix[5][200];

        for (int x = 0; x < DataLoad.data.getNumberOfRows(); x++) {
            for (int y = x + 1; y < DataLoad.data.getNumberOfRows(); y++) {
                if (cost[x].getTotal() > cost[y].getTotal()) {

                    CompetenceDetails tempDET = det[x];
                    det[x] = det[y];
                    det[y] = tempDET;

                    CompetenceOwnership tempOWN = own[x];
                    own[x] = own[y];
                    own[y] = tempOWN;

                    Applicability tempAPP = app[x];
                    app[x] = app[y];
                    app[y] = tempAPP;

                    Timesheet tempTIME = time[x];
                    time[x] = time[y];
                    time[y] = tempTIME;

                    CostPerPerson tempCOST = cost[x];
                    cost[x] = cost[y];
                    cost[y] = tempCOST;

                }
            }
        }
        arr[0] = det;
        arr[1] = own;
        arr[2] = app;
        arr[3] = time;
        arr[4] = cost;

        return arr;
    }

    /**
     * This returns a two-dimensional array sorted according to the total cost
     * of the competence in descending order
     *
     * @param det the array of the Competence Details records
     * @param own the array of the Competence Ownership records
     * @param app the array of the Applicability of competence records
     * @param cost the array of the Cost per person records
     * @param time the array of the Timesheet records
     * @return a sorted two-dimensional array
     */
    public static CompetenceMatrix[][] SortByTotalDESC(CompetenceDetails[] det, CompetenceOwnership[] own, Applicability[] app, CostPerPerson[] cost, Timesheet[] time) {
        CompetenceMatrix[][] arr = new CompetenceMatrix[5][200];

        for (int x = 0; x < DataLoad.data.getNumberOfRows(); x++) {
            for (int y = x + 1; y < DataLoad.data.getNumberOfRows(); y++) {
                if (cost[x].getTotal() < cost[y].getTotal()) {

                    CompetenceDetails tempDET = det[x];
                    det[x] = det[y];
                    det[y] = tempDET;

                    CompetenceOwnership tempOWN = own[x];
                    own[x] = own[y];
                    own[y] = tempOWN;

                    Applicability tempAPP = app[x];
                    app[x] = app[y];
                    app[y] = tempAPP;

                    Timesheet tempTIME = time[x];
                    time[x] = time[y];
                    time[y] = tempTIME;

                    CostPerPerson tempCOST = cost[x];
                    cost[x] = cost[y];
                    cost[y] = tempCOST;

                }
            }
        }
        arr[0] = det;
        arr[1] = own;
        arr[2] = app;
        arr[3] = time;
        arr[4] = cost;

        return arr;
    }
    static int[] compNums = new int[200];
    static int compNumCounter = 0;

    /**
     * This method Searches the competence tables and filters them by a specific phrase
     * @param phrase the phrase used for the search method
     * @param det the array of the Competence Details records
     * @param own the array of the Competence Ownership records
     * @param app the array of the Applicability of competence records
     * @param cost the array of the Cost per person records
     * @param time the array of the Timesheet records
     * @return a two-dimensional array filtered by the search phrase
     */
    public static CompetenceMatrix[][] SearchPhrase(String phrase, CompetenceDetails[] det, CompetenceOwnership[] own, Applicability[] app, CostPerPerson[] cost, Timesheet[] time) {
        CompetenceMatrix[][] arr = new CompetenceMatrix[5][200];
        String[] line;
        compNums = new int[200];
        compNumCounter = 0;
        for (int i = 0; i < DataLoad.data.getNumberOfRows(); i++) {

            line = det[i].toString().split("\t");

            for (int x = 0; x < line.length; x++) {

                if (line[x].equals(phrase)) {
                    Debug.Log(line[x] + " equals the phrase: " + phrase);
                    addToArray(det[i].getCompetenceReferenceNo());
                }

            }

        }
        for (int i = 0; i < DataLoad.data.getNumberOfRows(); i++) {

            line = own[i].toString().split("\t");

            for (int x = 0; x < line.length; x++) {

                if (line[x].equals(phrase)) {
                    Debug.Log(line[x] + " equals the phrase: " + phrase);
                    addToArray(own[i].getCompetenceReferenceNo());
                }

            }

        }

        for (int i = 0; i < DataLoad.data.getNumberOfRows(); i++) {

            line = app[i].toString().split("\t");

            for (int x = 0; x < line.length; x++) {

                if (line[x].equals(phrase)) {
                    Debug.Log(line[x] + " equals the phrase: " + phrase);
                    addToArray(app[i].getCompetenceReferenceNo());
                }

            }

        }

        for (int i = 0; i < DataLoad.data.getNumberOfRows(); i++) {

            line = cost[i].toString().split("\t");

            for (int x = 0; x < line.length; x++) {

                if (line[x].equals(phrase)) {
                    Debug.Log(line[x] + " equals the phrase: " + phrase);
                    addToArray(cost[i].getCompetenceReferenceNo());
                }

            }

        }

        for (int i = 0; i < DataLoad.data.getNumberOfRows(); i++) {

            line = time[i].toString().split("\t");

            for (int x = 0; x < line.length; x++) {

                if (line[x].equals(phrase)) {
                    Debug.Log(line[x] + " equals the phrase: " + phrase);
                    addToArray(time[i].getCompetenceReferenceNo());
                }

            }

        }

        String textCompNum = "";
        for (int y = 0; y < compNumCounter; y++) {
            textCompNum += compNums[y] + ", ";
        }
        Debug.Log("The compNums array is: " + textCompNum);
        Debug.Log("The number of compNums is: " + compNumCounter);
        

        CompetenceDetails[] tempDet = new CompetenceDetails[DataLoad.data.getNumberOfRows()];
        CompetenceOwnership[] tempOwn = new CompetenceOwnership[DataLoad.data.getNumberOfRows()];
        Applicability[] tempApp = new Applicability[DataLoad.data.getNumberOfRows()];
        CostPerPerson[] tempCost = new CostPerPerson[DataLoad.data.getNumberOfRows()];
        Timesheet[] tempTime = new Timesheet[DataLoad.data.getNumberOfRows()];
        int compCounter;
        int arrayCounter;

        for (int i = 0; i < arr.length; i++) {
            switch (i) {
                case 0:
                    compCounter = 0;
                    arrayCounter = 0;
                    for (int x = 0; x < DataLoad.data.getNumberOfRows(); x++) {
                        if (det[x].getCompetenceReferenceNo()== compNums[compCounter]) {
                            tempDet [arrayCounter] = det[x];
                            arrayCounter++;
                            compCounter ++;
                        }
                    }
                    arr[0] = tempDet;
                    break;
                case 1:
                    compCounter = 0;
                    arrayCounter = 0;
                    for (int x = 0; x < DataLoad.data.getNumberOfRows(); x++) {
                        if (own[x].getCompetenceReferenceNo()== compNums[compCounter]) {
                            tempOwn [arrayCounter] = own[x];
                            arrayCounter++;
                            compCounter ++;
                        }
                    }
                    arr[1] = tempOwn;
                    break;
                case 2:
                    compCounter = 0;
                    arrayCounter = 0;
                    for (int x = 0; x < DataLoad.data.getNumberOfRows(); x++) {
                        if (app[x].getCompetenceReferenceNo()== compNums[compCounter]) {
                            tempApp [arrayCounter] = app[x];
                            arrayCounter++;
                            compCounter ++;
                        }
                    }
                    arr[2] = tempApp;
                    break;
                case 3:
                    compCounter = 0;
                    arrayCounter = 0;
                    for (int x = 0; x < DataLoad.data.getNumberOfRows(); x++) {
                        if (cost[x].getCompetenceReferenceNo()== compNums[compCounter]) {
                            tempCost [arrayCounter] = cost[x];
                            arrayCounter++;
                            compCounter ++;
                        }
                    }
                    arr[3] = tempCost;
                    break;
                case 4:
                    compCounter = 0;
                    arrayCounter = 0;
                    for (int x = 0; x < DataLoad.data.getNumberOfRows(); x++) {
                        if (time[x].getCompetenceReferenceNo()== compNums[compCounter]) {
                            tempTime [arrayCounter] = time[x];
                            arrayCounter++;
                            compCounter ++;
                        }
                    }
                    arr[4] = tempTime;
                    break;
            }
        }
        DataLoad.data.setNumberOfRows(compNumCounter);

        return arr;
    }

    private static void addToArray(int ref) {
        for (int i : compNums) {
            if (ref == i) {
                return;
            }
        }
        compNums[compNumCounter] = ref;
        Debug.Log(compNums[compNumCounter] + " added to array.");
        compNumCounter++;
    }
}
