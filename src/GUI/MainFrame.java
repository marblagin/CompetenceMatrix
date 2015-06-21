/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.*;
import Util.Debug;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Llewellyn Craddock
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    public void RefreshTable() throws FileNotFoundException {

        DataLoad data = new DataLoad();
        DefaultTableModel table;
        Debug.Log("Selected Index = " + String.valueOf(SelectTableCombo.getSelectedIndex()));
        switch (SelectTableCombo.getSelectedIndex()) {
            case 0:
                CompetenceDetails[] det;
                det = data.LoadDetails();
                table = new DefaultTableModel(data.LoadDetailsHeadings(), 0);
                for (int i = 0; i < data.getNumberOfRows(); i++) {
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
                NumberOfRows.setText("Number of Rows: " + String.valueOf(data.getNumberOfRows()));
                break;
            case 1:
                CompetenceOwnership[] own;
                own = data.LoadOwnership();
                table = new DefaultTableModel(data.LoadOwnershipHeadings(), 0);
                for (int i = 0; i < data.getNumberOfRows(); i++) {
                    String[] row = {
                        String.valueOf(own[i].getCompetenceReferenceNo()),
                        own[i].getPartner(),
                        own[i].getChampion(),
                        own[i].getDetails(),
                    };
                    table.addRow(row);
                }
                Table.setModel(table);
                NumberOfRows.setText("Number of Rows: " + String.valueOf(data.getNumberOfRows()));
                break;
            case 2:
                Applicability[] app;
                app = data.LoadApplicability();
                table = new DefaultTableModel(data.LoadApplicabilityHeadings(), 0);
                for (int i = 0; i < data.getNumberOfRows(); i++) {
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
                NumberOfRows.setText("Number of Rows: " + String.valueOf(data.getNumberOfRows()));
                break;
            case 3:
                Timesheet[] time;
                time = data.LoadTimesheet();
                table = new DefaultTableModel(data.LoadTimesheetHeadings(), 0);
                for (int i = 0; i < data.getNumberOfRows(); i++) {
                    String[] row = {
                        String.valueOf(time[i].getCompetenceReferenceNo()),
                        time[i].getCode(),
                        time[i].getHours(),
                    };
                    table.addRow(row);
                }
                Table.setModel(table);
                NumberOfRows.setText("Number of Rows: " + String.valueOf(data.getNumberOfRows()));
                break;
            case 4:
                CostPerPerson[] cost;
                cost = data.LoadCost();
                table = new DefaultTableModel(data.LoadCostHeadings(), 0);
                for (int i = 0; i < data.getNumberOfRows(); i++) {
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
                NumberOfRows.setText("Number of Rows: " + String.valueOf(data.getNumberOfRows()));
                break;

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
        NumberOfRows = new javax.swing.JLabel();
        EnableEditing = new javax.swing.JCheckBox();
        btnSearch = new javax.swing.JButton();
        ToolBar = new javax.swing.JToolBar();
        btnEdit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        EnableSearch = new javax.swing.JCheckBox();
        MenuBar = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        MenuItemExit = new javax.swing.JMenuItem();
        MenuEdit = new javax.swing.JMenu();
        MenuItemEdit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Competence Matrix Editor");
        setPreferredSize(new java.awt.Dimension(1230, 860));
        setResizable(false);

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
        Table.setRowHeight(50);
        Table.setSurrendersFocusOnKeystroke(true);
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

        NumberOfRows.setText("Number of Rows:");

        EnableEditing.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        EnableEditing.setText("Enable Table Editing");
        EnableEditing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnableEditingActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSearch.setText("Search Options");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        ToolBar.setRollover(true);

        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEdit.setText("Edit Selected Competence");
        btnEdit.setEnabled(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAdd.setText("Add Competence");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        EnableSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        EnableSearch.setText("Enable Search Criteria");
        EnableSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnableSearchActionPerformed(evt);
            }
        });

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

        MenuItemEdit.setText("Enable table editing");
        MenuEdit.add(MenuItemEdit);

        MenuBar.add(MenuEdit);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SelectTabelLabel)
                            .addComponent(SelectTableCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NumberOfRows))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EnableSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EnableEditing, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4))))
            .addComponent(ToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(ToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectTabelLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectTableCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EnableSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EnableEditing)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NumberOfRows)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MenuItemExitActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        this.setFocusableWindowState(false);
        SearchFrame sf = new SearchFrame();
        sf.setVisible(true);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

    private void EnableSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnableSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnableSearchActionPerformed

    private void EnableEditingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnableEditingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnableEditingActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        AddCompetenceFrame acf = new AddCompetenceFrame();
        acf.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void SelectTableComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectTableComboActionPerformed
        try {
            this.RefreshTable();
        } catch (FileNotFoundException ex) {
            Debug.Log("File was not found");
        }
    }//GEN-LAST:event_SelectTableComboActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox EnableEditing;
    private javax.swing.JCheckBox EnableSearch;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu MenuEdit;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenuItem MenuItemEdit;
    private javax.swing.JMenuItem MenuItemExit;
    private javax.swing.JLabel NumberOfRows;
    private javax.swing.JLabel SelectTabelLabel;
    private javax.swing.JComboBox SelectTableCombo;
    private javax.swing.JTable Table;
    private javax.swing.JScrollPane TableScrollPane;
    private javax.swing.JToolBar ToolBar;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    // End of variables declaration//GEN-END:variables
}
