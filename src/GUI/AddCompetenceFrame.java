package GUI;

import Classes.DataLoad;
import Util.Debug;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Llewellyn Craddock
 */
public class AddCompetenceFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddCompetenceFrame
     */
    int unique;
    MainFrame mf;
    boolean canAdd = true;
    
    /**
     * Initializes the AddCompetenceFrame using the various methods
     */
    public AddCompetenceFrame() {
        initComponents();
        this.InitializeTables();
        mf = new MainFrame(0);
        mf.setExtendedState(MainFrame.MAXIMIZED_BOTH);
        mf.setEnabled(false);
        mf.setVisible(true);
    }

    /**
     * This method initializes the addCompetenceFrame's tables with the default
     * table headings, unique numbers and fills any blanks with a default value
     */
    public void InitializeTables() {

        DataLoad data = new DataLoad();
        DefaultTableModel[] Arr;
        Arr = data.GenerateTableModel();
        unique = data.getUniqueCompetenceNumber();
        Debug.Log("Unique number is " + unique);

        CompetenceDetailTable.setModel(Arr[0]);
        CompetenceDetailTable.setValueAt(unique, 0, 0);
        CompetenceDetailTable.getTableHeader().setReorderingAllowed(false);
        String defaultText = "NA";
        for (int i = 1; i < CompetenceDetailTable.getColumnCount(); i++) {
            CompetenceDetailTable.setValueAt(defaultText, 0, i);
        }

        CompetenceOwnershipTable.setModel(Arr[1]);
        CompetenceOwnershipTable.setValueAt(unique, 0, 0);
        CompetenceOwnershipTable.getTableHeader().setReorderingAllowed(false);
        for (int i = 1; i < CompetenceOwnershipTable.getColumnCount(); i++) {
            CompetenceOwnershipTable.setValueAt(defaultText, 0, i);
        }

        AppCompetenceTable.setModel(Arr[2]);
        AppCompetenceTable.setValueAt(unique, 0, 0);
        AppCompetenceTable.getTableHeader().setReorderingAllowed(false);
        for (int i = 1; i < AppCompetenceTable.getColumnCount(); i++) {
            AppCompetenceTable.setValueAt(defaultText, 0, i);
        }

        TimesheetTable.setModel(Arr[3]);
        TimesheetTable.setValueAt(unique, 0, 0);
        TimesheetTable.getTableHeader().setReorderingAllowed(false);
        for (int i = 1; i < TimesheetTable.getColumnCount(); i++) {
            TimesheetTable.setValueAt(defaultText, 0, i);
        }

        CostTable.setModel(Arr[4]);
        CostTable.setValueAt(unique, 0, 0);
        CostTable.getTableHeader().setReorderingAllowed(false);
        int defaultNum = 0;
        for (int i = 1; i < CostTable.getColumnCount() - 1; i++) {
            CostTable.setValueAt(defaultNum, 0, i);
        }
        CostTable.setValueAt("N/A", 0, CostTable.getColumnCount() - 1);

        UniqueNumberLabel.setText("Your Unique Competence Matrix Number is: " + unique);

    }

    private void showMessageDialogue(String message) {
        JOptionPane.showMessageDialog(null, message);
        canAdd = false;
    }

    /**
     * Parameter line is an array of strings with each value needing to be
     * placed into one line of string, separated by tabs
     *
     * @param line
     * @return a string of the line with tab delimeters
     */
    public String ConstructLine(String[] line) {
        String result = "";

        //to check if unique number still exists and is an integer
        if (this.isInteger(line[0])) {
            result += line[0] + "\t";
        } else {
            result += unique + "\t";
        }

        for (int i = 1; i < line.length - 1; i++) {
            if ("null".equals(line[i])) {
                result += "NA" + "\t";
            } else {
                result += line[i] + "\t";
            }
        }
        if ("null".equals(line[line.length - 1])) {
            result += "NA";
        } else {
            result += line[line.length - 1];
        }

        Debug.Log("Line to print: " + result);
        return result;
    }

    /**
     * This method constructs a line specifically for the cost per person table.
     * Due to the cost per person requiring integer values. Parameter line a
     * string of the line with tab delimeters
     *
     * @param line
     * @return a string of the line with tab delimeters
     */
    public String ConstructLineCost(String[] line) {
        String result = "";
        //to check if unique number still exists and is an integer
        if (this.isInteger(line[0])) {
            result += line[0] + "\t";
        } else {
            result += unique + "\t";
        }

        for (int i = 1; i < line.length - 1; i++) {
            if ("null".equals(line[i])) {
                result += "0" + "\t";
            } else {
                if (this.isInteger(line[i])) {
                    result += line[i] + "\t";
                } else {
                    this.showMessageDialogue("Some values in the Cost per Person table (excluding the last column) are not numbers");
                }
            }
        }
        if (line[line.length - 1] == null) {
            result += "N/A";
        } else {
            result += line[line.length - 1];
        }

        Debug.Log("Line to print: " + result);
        return result;
    }

    /**
     * This method returns an array of strings read from each of the four
     * tables. Parameter table is a defaultTableModel acquired from the
     * to-be-read table
     *
     * @param table
     * @return a string array of the data read
     */
    public String[] getTableData(JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int numCol = dtm.getColumnCount();
        String[] tableData = new String[numCol];
        for (int j = 0; j < numCol; j++) {
            tableData[j] = String.valueOf(dtm.getValueAt(0, j));
        }
        Debug.Log("Printing TableData:");
        return tableData;
    }

    /**
     * This method returns an array of strings read from the cost per person
     * table specifically. Parameter table is a defaultTableModel acquired from
     * the to-be-read table
     *
     * @param table is a defaultTableModel acquired from the to-be-read table
     * @return a string array of the data read
     */
    public String[] getTableDataCost(JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int numCol = dtm.getColumnCount();
        String[] tableData = new String[numCol];
        for (int j = 0; j < numCol; j++) {
            tableData[j] = String.valueOf(dtm.getValueAt(0, j));
        }
        Debug.Log("Printing TableData:");
        return tableData;
    }

    /**
     * a small method used to test if a string entered is an integer or not
     *
     * @param s
     * @return true if integer, false if not
     */
    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        Debug.Log("isInteger returns: true");
        return true;
    }

    /**
     * This method returns a string array of all the data read in from the
     * tables
     *
     * @return an array of all the lines
     */
    public String[] ConstructArray() {

        canAdd = true;
        
        String[] lineArr = new String[5];
        String[] line;

        line = this.getTableData(CompetenceDetailTable);
        lineArr[0] = this.ConstructLine(line);

        line = this.getTableData(CompetenceOwnershipTable);
        lineArr[1] = this.ConstructLine(line);

        line = this.getTableData(AppCompetenceTable);
        lineArr[2] = this.ConstructLine(line);

        line = this.getTableData(TimesheetTable);
        lineArr[3] = this.ConstructLine(line);

        line = this.getTableDataCost(CostTable);
        lineArr[4] = this.ConstructLineCost(line);

        return lineArr;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CompetenceDetailPanel = new javax.swing.JScrollPane();
        CompetenceDetailTable = new javax.swing.JTable();
        HeadLabel = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        CompetenceDetailLabel = new javax.swing.JLabel();
        CompetenceOwnershipLabel = new javax.swing.JLabel();
        CompetenceOwnershipPanel = new javax.swing.JScrollPane();
        CompetenceOwnershipTable = new javax.swing.JTable();
        AppCompetenceLabel = new javax.swing.JLabel();
        AppCompetencePanel = new javax.swing.JScrollPane();
        AppCompetenceTable = new javax.swing.JTable();
        TimesheetLabel = new javax.swing.JLabel();
        TimesheetPanel = new javax.swing.JScrollPane();
        TimesheetTable = new javax.swing.JTable();
        CostLabel = new javax.swing.JLabel();
        CostPanel = new javax.swing.JScrollPane();
        CostTable = new javax.swing.JTable();
        UniqueNumberLabel = new javax.swing.JLabel();
        MakeSure = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Add Competence Matrix");
        setType(java.awt.Window.Type.UTILITY);

        CompetenceDetailPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        CompetenceDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        CompetenceDetailTable.setEditingColumn(1);
        CompetenceDetailTable.setEditingRow(1);
        CompetenceDetailTable.setRowHeight(60);
        CompetenceDetailTable.setRowSelectionAllowed(false);
        CompetenceDetailTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CompetenceDetailTableKeyPressed(evt);
            }
        });
        CompetenceDetailPanel.setViewportView(CompetenceDetailTable);

        HeadLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        HeadLabel.setText("Add Competence:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnBack.setText("Back to Editor");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        CompetenceDetailLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CompetenceDetailLabel.setText("Competence Details");

        CompetenceOwnershipLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CompetenceOwnershipLabel.setText("Competence Ownership");

        CompetenceOwnershipPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        CompetenceOwnershipTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        CompetenceOwnershipTable.setEditingColumn(1);
        CompetenceOwnershipTable.setEditingRow(1);
        CompetenceOwnershipTable.setRowHeight(60);
        CompetenceOwnershipTable.setRowSelectionAllowed(false);
        CompetenceOwnershipPanel.setViewportView(CompetenceOwnershipTable);

        AppCompetenceLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AppCompetenceLabel.setText("Applicability of competence");

        AppCompetencePanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        AppCompetenceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        AppCompetenceTable.setEditingColumn(1);
        AppCompetenceTable.setEditingRow(1);
        AppCompetenceTable.setRowHeight(60);
        AppCompetenceTable.setRowSelectionAllowed(false);
        AppCompetencePanel.setViewportView(AppCompetenceTable);

        TimesheetLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TimesheetLabel.setText("Timesheet");

        TimesheetPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        TimesheetTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        TimesheetTable.setEditingColumn(1);
        TimesheetTable.setEditingRow(1);
        TimesheetTable.setRowHeight(60);
        TimesheetTable.setRowSelectionAllowed(false);
        TimesheetPanel.setViewportView(TimesheetTable);

        CostLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CostLabel.setText("Cost per person");

        CostPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        CostTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        CostTable.setEditingColumn(1);
        CostTable.setEditingRow(1);
        CostTable.setRowHeight(60);
        CostTable.setRowSelectionAllowed(false);
        CostPanel.setViewportView(CostTable);

        UniqueNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UniqueNumberLabel.setText("Your Unique Competence Matrix Number is: ");

        MakeSure.setText("Make sure to press enter to confirm your changes to the table!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HeadLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UniqueNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnBack)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(MakeSure)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnAdd))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CompetenceDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CompetenceOwnershipPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CompetenceOwnershipLabel)
                                    .addComponent(AppCompetencePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AppCompetenceLabel)
                                    .addComponent(TimesheetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TimesheetLabel)
                                    .addComponent(CostPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CostLabel)))
                            .addComponent(CompetenceDetailLabel))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HeadLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CompetenceDetailLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UniqueNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CompetenceDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CompetenceOwnershipLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CompetenceOwnershipPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AppCompetenceLabel)
                .addGap(18, 18, 18)
                .addComponent(AppCompetencePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TimesheetLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TimesheetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CostLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CostPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnBack)
                    .addComponent(MakeSure))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Initializes the main frame again and refreshes its tables, when btnBack is pressed
        this.setVisible(false);
        try {
            mf.RefreshTable(0);
        } catch (FileNotFoundException ex) {
            Debug.LogException(ex);
        }
        mf.setEnabled(true);
        mf.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Initializes the main frame again and refreshes its tables, when btnAdd is pressed
        String [] arr = this.ConstructArray();
        if (canAdd){
            DataLoad.StoreData(arr);
            mf.Sort(0);
        try {
            mf.RefreshTable(0);
        } catch (FileNotFoundException ex) {
            Debug.LogException(ex);
        }
        this.setVisible(false);
        mf.setEnabled(true);
        mf.setVisible(true);
        mf.setFocusable(true);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void CompetenceDetailTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CompetenceDetailTableKeyPressed
        // This method is redundant, yet I am unable to delete it
    }//GEN-LAST:event_CompetenceDetailTableKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AppCompetenceLabel;
    private javax.swing.JScrollPane AppCompetencePanel;
    private javax.swing.JTable AppCompetenceTable;
    private javax.swing.JLabel CompetenceDetailLabel;
    private javax.swing.JScrollPane CompetenceDetailPanel;
    private javax.swing.JTable CompetenceDetailTable;
    private javax.swing.JLabel CompetenceOwnershipLabel;
    private javax.swing.JScrollPane CompetenceOwnershipPanel;
    private javax.swing.JTable CompetenceOwnershipTable;
    private javax.swing.JLabel CostLabel;
    private javax.swing.JScrollPane CostPanel;
    private javax.swing.JTable CostTable;
    private javax.swing.JLabel HeadLabel;
    private javax.swing.JLabel MakeSure;
    private javax.swing.JLabel TimesheetLabel;
    private javax.swing.JScrollPane TimesheetPanel;
    private javax.swing.JTable TimesheetTable;
    private javax.swing.JLabel UniqueNumberLabel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    // End of variables declaration//GEN-END:variables
}
