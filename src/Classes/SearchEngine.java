
package Classes;
/**
 *
 * @author Llewellyn Craddock
 */
public class SearchEngine {

    //This class provides methos of sorting data arrays in a specific way
    
    /**
     * This method returns a two-dimentional array that is sorting according to the competence reference number, in ascending order
     * @param det
     * @param own
     * @param app       The parameters are the arrays that are needed to be sorted
     * @param cost
     * @param time
     * @returns a sorted two-dimentional array
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
     * This method returns a two-dimentional array that is sorting according to the competence reference number, in descending order
     * @param det
     * @param own
     * @param app       The parameters are the arrays that are needed to be sorted
     * @param cost
     * @param time
     * @returns a sorted two-dimentional array 
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
     *  This returns a two-dimentional array sorted according to the total cost of the competence in ascending order
     * @param det
     * @param own
     * @param app       The parameters are the arrays that are needed to be sorted
     * @param cost
     * @param time
     * @return
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
     * This returns a two-dimentional array sorted according to the total cost of the competence in descending order
     * @param det
     * @param own
     * @param app       The parameters are the arrays that are needed to be sorted
     * @param cost
     * @param time
     * @return
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
}
