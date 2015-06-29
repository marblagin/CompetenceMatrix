/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.*;
import Util.Debug;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Llewellyn Craddock
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    CompetenceDetails[] det = DataLoad.data.LoadDetails();
    ;
    CompetenceOwnership[] own = DataLoad.data.LoadOwnership();
    Applicability[] app = DataLoad.data.LoadApplicability();
    CostPerPerson[] cost = DataLoad.data.LoadCost();
    Timesheet[] time = DataLoad.data.LoadTimesheet();
    DataLoad data = new DataLoad();
    int selectedRow;
    int selectedCompetence;
    int selectedSort;

    public MainFrame(int index) {
        initComponents();
        try {
            RefreshTable(index);
        } catch (IOException ex) {
            Debug.LogException(ex);
        }

    }

    public void RefreshTable(int Index) throws FileNotFoundException {
        Debug.Log("Tables refreshing");
        DefaultTableModel table;
        Debug.Log("Selected Index = " + String.valueOf(SelectTableCombo.getSelectedIndex()));
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

    private void Delete() {
        int index = SelectTableCombo.getSelectedIndex();
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
        SelectTableCombo.setSelectedIndex(index);
    }

    private void Sort(int index) {
        CompetenceMatrix[][] arr;
        switch (index) {
            case 0:
                det = DataLoad.data.LoadDetails();
                own = DataLoad.data.LoadOwnership();
                app = DataLoad.data.LoadApplicability();
                cost = DataLoad.data.LoadCost();
                time = DataLoad.data.LoadTimesheet();
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
        }
        try {
            this.RefreshTable(SelectTableCombo.getSelectedIndex());
        } catch (FileNotFoundException ex) {
            Debug.LogException(ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jLabel1 = new javax.swing.JLabel();
        SortCombo = new javax.swing.JComboBox();
        btnDelete1 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        NumberOfRows = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        MenuItemExit = new javax.swing.JMenuItem();
        MenuEdit = new javax.swing.JMenu();
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
        setPreferredSize(new java.awt.Dimension(1020, 700));

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Sort by:");

        SortCombo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SortCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Reference Number (Ascending)", "Reference Number (Descending)", "Total cost (Ascending)", "TotalCost (Descending)" }));
        SortCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortComboActionPerformed(evt);
            }
        });

        btnDelete1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDelete1.setText("Refresh Tables");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
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

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(btnPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(SortCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPanelLayout.createSequentialGroup()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SortCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        this.setFocusable(false);
        SearchFrame sf = new SearchFrame();
        sf.setVisible(true);
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

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        try {
            // TODO add your handling code here:
            this.RefreshTable(0);
        } catch (FileNotFoundException ex) {
            Debug.LogException(ex);
        }
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void SortComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortComboActionPerformed
        // TODO add your handling code here:
        selectedSort = SortCombo.getSelectedIndex();
        this.Sort(selectedSort);
    }//GEN-LAST:event_SortComboActionPerformed
    /**
     * @param args the command line arguments
     */
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
    private javax.swing.JMenu MenuTable;
    private javax.swing.JLabel NumberOfRows;
    private javax.swing.JLabel SelectTabelLabel;
    private javax.swing.JComboBox SelectTableCombo;
    private javax.swing.JComboBox SortCombo;
    private javax.swing.JTable Table;
    private javax.swing.JScrollPane TableScrollPane;
    private javax.swing.JMenuItem Time;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
