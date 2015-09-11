package GUI;

import Classes.*;
import Util.Debug;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Llewellyn Craddock
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    CompetenceDetails[] det = DataLoad.data.LoadDetails();
    CompetenceOwnership[] own = DataLoad.data.LoadOwnership();
    Applicability[] app = DataLoad.data.LoadApplicability();
    CostPerPerson[] cost = DataLoad.data.LoadCost();
    Timesheet[] time = DataLoad.data.LoadTimesheet();
    DataLoad data = new DataLoad();
    static SearchFrame sf = new SearchFrame();
    int selectedRow;
    int selectedCompetence;
    int selectedSort;

    /**
     * This method initializes the MainFrame's tables and refreshes them
     *
     * @param index
     */
    public MainFrame(int index) {
        initComponents();
        try {
            RefreshTable(index);
        } catch (IOException ex) {
            Debug.LogException(ex);
        }
        TableModelListener n = new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                Debug.Log("Table Changed");
            }
        };
        Table.getModel().addTableModelListener(n);      
    }

    /**
     * This method refreshes the MainFrame's tables, depending on which tables
     * is selected. The default table to refresh is the Competence Details
     *
     * @param Index
     * @throws FileNotFoundException
     */
    public void RefreshTable(int Index) throws FileNotFoundException {
        Debug.Log("Tables refreshing");
        DefaultTableModel table;
        Debug.Log("Selected Index = " + String.valueOf(SelectTableCombo.getSelectedIndex()));
        Debug.Log("Number of rows = " + DataLoad.data.getNumberOfRows());
        MenuDelete.setEnabled(false);
        btnDelete.setEnabled(false);
        switch (Index) {
            case 0:
                table = new DefaultTableModel(DataLoad.data.LoadDetailsHeadings(), 0);
                for (int i = 0; i < DataLoad.data.getNumberOfRows(); i++) {
                    String[] row = {
                        String.valueOf(det[i].getCompetenceReferenceNo()),
                        det[i].getShortName(),
                        det[i].getObjective(),
                        det[i].getDetails(),
                        det[i].getHyperlink(),
                        det[i].getTiming(),
                        det[i].getWhoProvides(),
                        det[i].getType(),
                        det[i].getDependencies(),
                        det[i].getStatus(),
                        det[i].getReviewActionNotes()
                    };
                    table.addRow(row);
                }
                Table.setModel(table);
                NumberOfRows.setText("Number of Rows: " + String.valueOf(DataLoad.data.getNumberOfRows()));
                break;
            case 1:
                table = new DefaultTableModel(DataLoad.data.LoadOwnershipHeadings(), 0);
                for (int i = 0; i < DataLoad.data.getNumberOfRows(); i++) {
                    String[] row = {
                        String.valueOf(own[i].getCompetenceReferenceNo()),
                        own[i].getPartner(),
                        own[i].getChampion(),
                        own[i].getDetails(),};
                    table.addRow(row);
                }
                Table.setModel(table);
                NumberOfRows.setText("Number of Rows: " + String.valueOf(DataLoad.data.getNumberOfRows()));
                break;
            case 2:
                table = new DefaultTableModel(DataLoad.data.LoadApplicabilityHeadings(), 0);
                for (int i = 0; i < DataLoad.data.getNumberOfRows(); i++) {
                    String[] row = {
                        String.valueOf(app[i].getCompetenceReferenceNo()),
                        app[i].getCoreCareer(),
                        app[i].getPromotion(),
                        app[i].getApplicable(),
                        app[i].getSoftTechnical(),
                        app[i].getDegrees(),
                        app[i].getGrade()
                    };
                    table.addRow(row);
                }
                Table.setModel(table);
                NumberOfRows.setText("Number of Rows: " + String.valueOf(DataLoad.data.getNumberOfRows()));
                break;
            case 3:
                table = new DefaultTableModel(DataLoad.data.LoadTimesheetHeadings(), 0);
                for (int i = 0; i < DataLoad.data.getNumberOfRows(); i++) {
                    String[] row = {
                        String.valueOf(time[i].getCompetenceReferenceNo()),
                        time[i].getCode(),
                        time[i].getHours(),};
                    table.addRow(row);
                }
                Table.setModel(table);
                NumberOfRows.setText("Number of Rows: " + String.valueOf(DataLoad.data.getNumberOfRows()));
                break;
            case 4:
                table = new DefaultTableModel(DataLoad.data.LoadCostHeadings(), 0);
                for (int i = 0; i < DataLoad.data.getNumberOfRows(); i++) {
                    String[] row = {
                        String.valueOf(cost[i].getCompetenceReferenceNo()),
                        String.valueOf(cost[i].getInternal()),
                        String.valueOf(cost[i].getCash()),
                        String.valueOf(cost[i].getDisbursement()),
                        String.valueOf(cost[i].getOpportunity()),
                        String.valueOf(cost[i].getTotal()),
                        cost[i].getWorkBackApplicable(),
                        cost[i].getWorkBack()
                    };
                    table.addRow(row);
                }
                Table.setModel(table);
                NumberOfRows.setText("Number of Rows: " + String.valueOf(DataLoad.data.getNumberOfRows()));
                break;

        }

    }

    /**
     * This method displays an option pane to confirm a deletion
     */
    private void Delete() {
        int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the Competence Matrix: " + selectedCompetence + " from all five tables");
        if (i == 0) {
            Debug.Log("Deleting competence: " + selectedCompetence);
            data.RemoveCompetence(selectedCompetence);
        } else if (i == 1) {
            Debug.Log("Not deleting competence: " + selectedCompetence);
            //dont delete
        } else if (i == 2) {
            Debug.Log("Cancelling deletion of competence: " + selectedCompetence);
            //cancel
        }
        this.Sort(0);
    }

    private void Edit(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2 && !evt.isConsumed()) { //handles double click event.
            evt.consume();
            Debug.Log("Double click on Table");
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            int column = target.getSelectedColumn();
            Debug.Log("Row is " + row);
            Debug.Log("Column is " + column);
            Debug.Log("Entered value is " + Table.getModel().getValueAt(row, column));
        }
    }

    /**
     * This method applies the required sort to the table and refreshes it
     *
     * @param index the selected number on the combo box
     */
    public void Sort(int index) {
        CompetenceMatrix[][] arr;
        switch (index) {
            case 0:
                det = DataLoad.data.LoadDetails();
                own = DataLoad.data.LoadOwnership();
                app = DataLoad.data.LoadApplicability();
                cost = DataLoad.data.LoadCost();
                time = DataLoad.data.LoadTimesheet();
                searchCheckBox.setSelected(false);
                break;
            case 1:
                arr = SearchEngine.SortByCompNumASC(det, own, app, cost, time);
                det = (CompetenceDetails[]) arr[0];
                own = (CompetenceOwnership[]) arr[1];
                app = (Applicability[]) arr[2];
                time = (Timesheet[]) arr[3];
                cost = (CostPerPerson[]) arr[4];
                break;
            case 2:
                arr = SearchEngine.SortByCompNumDESC(det, own, app, cost, time);
                det = (CompetenceDetails[]) arr[0];
                own = (CompetenceOwnership[]) arr[1];
                app = (Applicability[]) arr[2];
                time = (Timesheet[]) arr[3];
                cost = (CostPerPerson[]) arr[4];
                break;
            case 3:
                arr = SearchEngine.SortByTotalASC(det, own, app, cost, time);
                det = (CompetenceDetails[]) arr[0];
                own = (CompetenceOwnership[]) arr[1];
                app = (Applicability[]) arr[2];
                time = (Timesheet[]) arr[3];
                cost = (CostPerPerson[]) arr[4];
                break;
            case 4:
                arr = SearchEngine.SortByTotalDESC(det, own, app, cost, time);
                det = (CompetenceDetails[]) arr[0];
                own = (CompetenceOwnership[]) arr[1];
                app = (Applicability[]) arr[2];
                time = (Timesheet[]) arr[3];
                cost = (CostPerPerson[]) arr[4];
                break;
            case 5:
                String Phrase = sf.getPhrase();
                if ("".equals(Phrase)) {
                    this.btnSearchActionPerformed(null);
                } else {
                    arr = SearchEngine.SearchPhrase(Phrase, det, own, app, cost, time);
                    det = (CompetenceDetails[]) arr[0];
                    own = (CompetenceOwnership[]) arr[1];
                    app = (Applicability[]) arr[2];
                    time = (Timesheet[]) arr[4];
                    cost = (CostPerPerson[]) arr[3];
                }
                break;
        }
        try {
            this.RefreshTable(SelectTableCombo.getSelectedIndex());
        } catch (FileNotFoundException ex) {
            Debug.LogException(ex);
        }
    }

    public void StartSearch() {
        this.setFocusable(false);
        this.Sort(0);
        SortCombo.setSelectedIndex(0);
        sf.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TableScrollPane = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        SelectTabelLabel = new javax.swing.JLabel();
        SelectTableCombo = new javax.swing.JComboBox();
        btnPanel = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        labelSort = new javax.swing.JLabel();
        SortCombo = new javax.swing.JComboBox();
        btnRefresh = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        labelFilter = new javax.swing.JLabel();
        searchCheckBox = new javax.swing.JCheckBox();
        NumberOfRows = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        MenuItemExit = new javax.swing.JMenuItem();
        MenuEdit = new javax.swing.JMenu();
        MenuSortBy = new javax.swing.JMenu();
        MenuRefASC = new javax.swing.JMenuItem();
        MenuRefDESC = new javax.swing.JMenuItem();
        MenuTotalASC = new javax.swing.JMenuItem();
        MenuTotalDESC = new javax.swing.JMenuItem();
        MenuAddComp = new javax.swing.JMenuItem();
        MenuDelete = new javax.swing.JMenuItem();
        MenuTable = new javax.swing.JMenu();
        ComDet = new javax.swing.JMenuItem();
        ComOwn = new javax.swing.JMenuItem();
        App = new javax.swing.JMenuItem();
        Time = new javax.swing.JMenuItem();
        Cost = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Competence Matrix Editor");
        setName("MainFrame"); // NOI18N
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        TableScrollPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableScrollPaneMouseClicked(evt);
            }
        });

        Table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Table.setRowHeight(50);
        Table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Table.setSurrendersFocusOnKeystroke(true);
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableMousePressed(evt);
            }
        });
        TableScrollPane.setViewportView(Table);

        SelectTabelLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SelectTabelLabel.setText("Select table:");

        SelectTableCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SelectTableCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Competence Details", "Comeptence Ownership", "Applicability of competence", "Timesheet", "Cost per person" }));
        SelectTableCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectTableComboActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAdd.setText("Add Competence");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSearch.setText("Search Options");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        labelSort.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelSort.setText("Sort by:");

        SortCombo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SortCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Reference Number (Ascending)", "Reference Number (Descending)", "Total Cost (Ascending)", "Total Cost (Descending)" }));
        SortCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortComboActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRefresh.setText("Refresh Tables");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDelete.setText("Delete Selected Competence");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        labelFilter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelFilter.setText("Filter by:");

        searchCheckBox.setText("Search Phrase");
        searchCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SortCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(btnPanelLayout.createSequentialGroup()
                        .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSort)
                            .addComponent(labelFilter)
                            .addComponent(searchCheckBox))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPanelLayout.createSequentialGroup()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(labelSort, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SortCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        NumberOfRows.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NumberOfRows.setText("Number of Rows:");

        MenuFile.setText("File");

        MenuItemExit.setText("Exit");
        MenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemExitActionPerformed(evt);
            }
        });
        MenuFile.add(MenuItemExit);

        MenuBar.add(MenuFile);

        MenuEdit.setText("Edit");

        MenuSortBy.setText("Sort Tables by");

        MenuRefASC.setText("Reference Number (Ascending)");
        MenuRefASC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuRefASCActionPerformed(evt);
            }
        });
        MenuSortBy.add(MenuRefASC);

        MenuRefDESC.setText("Reference Number (Descending)");
        MenuRefDESC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuRefDESCActionPerformed(evt);
            }
        });
        MenuSortBy.add(MenuRefDESC);

        MenuTotalASC.setText("Total Cost (Ascending)");
        MenuTotalASC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuTotalASCActionPerformed(evt);
            }
        });
        MenuSortBy.add(MenuTotalASC);

        MenuTotalDESC.setText("Total Cost (Descending)");
        MenuTotalDESC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuTotalDESCActionPerformed(evt);
            }
        });
        MenuSortBy.add(MenuTotalDESC);

        MenuEdit.add(MenuSortBy);

        MenuAddComp.setText("Add Competence");
        MenuAddComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAddCompActionPerformed(evt);
            }
        });
        MenuEdit.add(MenuAddComp);

        MenuDelete.setText("Delete Selected Competence");
        MenuDelete.setEnabled(false);
        MenuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuDeleteActionPerformed(evt);
            }
        });
        MenuEdit.add(MenuDelete);

        MenuBar.add(MenuEdit);

        MenuTable.setText("Tables");

        ComDet.setText("Competence Details");
        ComDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComDetActionPerformed(evt);
            }
        });
        MenuTable.add(ComDet);

        ComOwn.setText("Competence Ownership");
        ComOwn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComOwnActionPerformed(evt);
            }
        });
        MenuTable.add(ComOwn);

        App.setText("Applicability of Competence");
        App.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppActionPerformed(evt);
            }
        });
        MenuTable.add(App);

        Time.setText("Timesheet");
        Time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeActionPerformed(evt);
            }
        });
        MenuTable.add(Time);

        Cost.setText("Cost per person");
        Cost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CostActionPerformed(evt);
            }
        });
        MenuTable.add(Cost);

        MenuBar.add(MenuTable);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SelectTableCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectTabelLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NumberOfRows, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SelectTabelLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectTableCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NumberOfRows))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(TableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MenuItemExitActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        this.StartSearch();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        this.Delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        this.dispose();
        AddCompetenceFrame acf = new AddCompetenceFrame();
        acf.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void SelectTableComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectTableComboActionPerformed
        try {
            this.RefreshTable(SelectTableCombo.getSelectedIndex());
        } catch (IOException ex) {
            Debug.LogException(ex);
        }
    }//GEN-LAST:event_SelectTableComboActionPerformed

    private void ComOwnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComOwnActionPerformed
        // TODO add your handling code here:
        try {
            this.RefreshTable(1);
        } catch (IOException ex) {
            Debug.LogException(ex);
        }
        SelectTableCombo.setSelectedIndex(1);
    }//GEN-LAST:event_ComOwnActionPerformed

    private void ComDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComDetActionPerformed
        // TODO add your handling code here:
        try {
            this.RefreshTable(0);
        } catch (IOException ex) {
            Debug.LogException(ex);
        }
        SelectTableCombo.setSelectedIndex(0);
    }//GEN-LAST:event_ComDetActionPerformed

    private void AppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppActionPerformed
        // TODO add your handling code here:
        try {
            this.RefreshTable(2);
        } catch (IOException ex) {
            Debug.LogException(ex);
        }
        SelectTableCombo.setSelectedIndex(2);
    }//GEN-LAST:event_AppActionPerformed

    private void TimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeActionPerformed
        // TODO add your handling code here:
        try {
            this.RefreshTable(3);
        } catch (IOException ex) {
            Debug.LogException(ex);
        }
        SelectTableCombo.setSelectedIndex(3);
    }//GEN-LAST:event_TimeActionPerformed

    private void CostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CostActionPerformed
        // TODO add your handling code here:
        try {
            this.RefreshTable(4);
        } catch (IOException ex) {
            Debug.LogException(ex);
        }
        SelectTableCombo.setSelectedIndex(4);
    }//GEN-LAST:event_CostActionPerformed

    private void TableScrollPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableScrollPaneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TableScrollPaneMouseClicked

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TableMouseClicked

    private void TableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMousePressed
        // TODO add your handling code here:
        selectedRow = Table.getSelectedRow();
        selectedCompetence = det[selectedRow].getCompetenceReferenceNo();
        Debug.Log("Selected row is " + selectedRow + " and the competence num is " + selectedCompetence);
        this.Edit(evt);
        btnDelete.setEnabled(true);
        MenuDelete.setEnabled(true);
    }//GEN-LAST:event_TableMousePressed

    private void MenuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDeleteActionPerformed
        // TODO add your handling code here:
        this.Delete();
    }//GEN-LAST:event_MenuDeleteActionPerformed

    private void MenuAddCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAddCompActionPerformed
        // TODO add your handling code here:
        this.dispose();
        AddCompetenceFrame acf = new AddCompetenceFrame();
        acf.setVisible(true);
    }//GEN-LAST:event_MenuAddCompActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        try {
            // TODO add your handling code here:
            this.RefreshTable(0);
        } catch (FileNotFoundException ex) {
            Debug.LogException(ex);
        }
        SelectTableCombo.setSelectedIndex(0);
        this.Sort(0);
        SortCombo.setSelectedIndex(0);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void SortComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortComboActionPerformed
        // TODO add your handling code here:
        selectedSort = SortCombo.getSelectedIndex();
        this.Sort(selectedSort);
    }//GEN-LAST:event_SortComboActionPerformed

    private void MenuRefASCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuRefASCActionPerformed
        // TODO add your handling code here:
        this.Sort(1);
    }//GEN-LAST:event_MenuRefASCActionPerformed

    private void MenuRefDESCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuRefDESCActionPerformed
        // TODO add your handling code here:
        this.Sort(2);
    }//GEN-LAST:event_MenuRefDESCActionPerformed

    private void MenuTotalASCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTotalASCActionPerformed
        // TODO add your handling code here:
        this.Sort(3);
    }//GEN-LAST:event_MenuTotalASCActionPerformed

    private void MenuTotalDESCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTotalDESCActionPerformed
        // TODO add your handling code here:
        this.Sort(4);
    }//GEN-LAST:event_MenuTotalDESCActionPerformed

    private void searchCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCheckBoxActionPerformed
        // TODO add your handling code here:
        if (searchCheckBox.isSelected()) {
            this.Sort(5);
        } else {
            this.Sort(0);
            SortCombo.setSelectedIndex(0);
        }
    }//GEN-LAST:event_searchCheckBoxActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    }//GEN-LAST:event_formKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem App;
    private javax.swing.JMenuItem ComDet;
    private javax.swing.JMenuItem ComOwn;
    private javax.swing.JMenuItem Cost;
    private javax.swing.JMenuItem MenuAddComp;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem MenuDelete;
    private javax.swing.JMenu MenuEdit;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenuItem MenuItemExit;
    private javax.swing.JMenuItem MenuRefASC;
    private javax.swing.JMenuItem MenuRefDESC;
    private javax.swing.JMenu MenuSortBy;
    private javax.swing.JMenu MenuTable;
    private javax.swing.JMenuItem MenuTotalASC;
    private javax.swing.JMenuItem MenuTotalDESC;
    private javax.swing.JLabel NumberOfRows;
    private javax.swing.JLabel SelectTabelLabel;
    private javax.swing.JComboBox SelectTableCombo;
    private javax.swing.JComboBox SortCombo;
    private javax.swing.JTable Table;
    private javax.swing.JScrollPane TableScrollPane;
    private javax.swing.JMenuItem Time;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel labelFilter;
    private javax.swing.JLabel labelSort;
    private javax.swing.JCheckBox searchCheckBox;
    // End of variables declaration//GEN-END:variables
}
