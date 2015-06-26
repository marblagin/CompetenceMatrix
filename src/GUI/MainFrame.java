/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.*;
import Util.Debug;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
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
        try {
            RefreshTable(0);
        } catch (IOException ex) {
            Debug.LogException(ex);
        }
        
    }

    public void RefreshTable(int Index) throws FileNotFoundException {
        DefaultTableModel table;
        Debug.Log("Selected Index = " + String.valueOf(SelectTableCombo.getSelectedIndex()));
        switch (Index) {
            case 0:
                CompetenceDetails[] det;
                det = DataLoad.data.LoadDetails();
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
                CompetenceOwnership[] own;
                own = DataLoad.data.LoadOwnership();
                table = new DefaultTableModel(DataLoad.data.LoadOwnershipHeadings(), 0);
                for (int i = 0; i < DataLoad.data.getNumberOfRows(); i++) {
                    String[] row = {
                        String.valueOf(own[i].getCompetenceReferenceNo()),
                        own[i].getPartner(),
                        own[i].getChampion(),
                        own[i].getDetails(),
                    };
                    table.addRow(row);
                }
                Table.setModel(table);
                NumberOfRows.setText("Number of Rows: " + String.valueOf(DataLoad.data.getNumberOfRows()));
                break;
            case 2:
                Applicability[] app;
                app = DataLoad.data.LoadApplicability();
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
                Timesheet[] time;
                time = DataLoad.data.LoadTimesheet();
                table = new DefaultTableModel(DataLoad.data.LoadTimesheetHeadings(), 0);
                for (int i = 0; i < DataLoad.data.getNumberOfRows(); i++) {
                    String[] row = {
                        String.valueOf(time[i].getCompetenceReferenceNo()),
                        time[i].getCode(),
                        time[i].getHours(),
                    };
                    table.addRow(row);
                }
                Table.setModel(table);
                NumberOfRows.setText("Number of Rows: " + String.valueOf(DataLoad.data.getNumberOfRows()));
                break;
            case 4:
                CostPerPerson[] cost;
                cost = DataLoad.data.LoadCost();
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
        ToolBar = new javax.swing.JToolBar();
        btnPanel = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        EnableSearch = new javax.swing.JCheckBox();
        EnableEditing = new javax.swing.JCheckBox();
        btnSearch = new javax.swing.JButton();
        NumberOfRows = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        MenuFileChooser = new javax.swing.JMenuItem();
        MenuItemExit = new javax.swing.JMenuItem();
        MenuEdit = new javax.swing.JMenu();
        MenuItemEdit = new javax.swing.JMenuItem();
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

        ToolBar.setRollover(true);

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAdd.setText("Add Competence");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
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

        EnableSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        EnableSearch.setText("Enable Search Criteria");
        EnableSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnableSearchActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EnableEditing, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(EnableSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(btnPanelLayout.createSequentialGroup()
                        .addComponent(btnDelete)
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPanelLayout.createSequentialGroup()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EnableEditing)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EnableSearch)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        NumberOfRows.setText("Number of Rows:");

        MenuFile.setText("File");

        MenuFileChooser.setText("Edit Table Files");
        MenuFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFileChooserActionPerformed(evt);
            }
        });
        MenuFile.add(MenuFileChooser);

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
                        .addComponent(TableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NumberOfRows)
                            .addComponent(btnPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addComponent(ToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(SelectTabelLabel)
                .addGap(6, 6, 6)
                .addComponent(SelectTableCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
                        .addComponent(NumberOfRows)))
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
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void EnableSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnableSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnableSearchActionPerformed

    private void EnableEditingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnableEditingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnableEditingActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_ComOwnActionPerformed

    private void ComDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComDetActionPerformed
        // TODO add your handling code here:
        try {
            this.RefreshTable(0);
        } catch (IOException ex) {
            Debug.LogException(ex);
        }
    }//GEN-LAST:event_ComDetActionPerformed

    private void AppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppActionPerformed
        // TODO add your handling code here:
        try {
            this.RefreshTable(2);
        } catch (IOException ex) {
            Debug.LogException(ex);
        }
    }//GEN-LAST:event_AppActionPerformed

    private void TimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeActionPerformed
        // TODO add your handling code here:
        try {
            this.RefreshTable(3);
        } catch (IOException ex) {
            Debug.LogException(ex);
        }
    }//GEN-LAST:event_TimeActionPerformed

    private void CostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CostActionPerformed
        // TODO add your handling code here:
        try {
            this.RefreshTable(4);
        } catch (IOException ex) {
            Debug.LogException(ex);
        }
    }//GEN-LAST:event_CostActionPerformed

    private void MenuFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFileChooserActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser(new File("/src/").getParent());
        jfc.setVisible(true);
        int ret = jfc.showOpenDialog(null);
    }//GEN-LAST:event_MenuFileChooserActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem App;
    private javax.swing.JMenuItem ComDet;
    private javax.swing.JMenuItem ComOwn;
    private javax.swing.JMenuItem Cost;
    private javax.swing.JCheckBox EnableEditing;
    private javax.swing.JCheckBox EnableSearch;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu MenuEdit;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenuItem MenuFileChooser;
    private javax.swing.JMenuItem MenuItemEdit;
    private javax.swing.JMenuItem MenuItemExit;
    private javax.swing.JMenu MenuTable;
    private javax.swing.JLabel NumberOfRows;
    private javax.swing.JLabel SelectTabelLabel;
    private javax.swing.JComboBox SelectTableCombo;
    private javax.swing.JTable Table;
    private javax.swing.JScrollPane TableScrollPane;
    private javax.swing.JMenuItem Time;
    private javax.swing.JToolBar ToolBar;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton btnSearch;
    // End of variables declaration//GEN-END:variables
}
