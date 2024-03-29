
package GUI;

import Util.Debug;

/**
 *
 * @author Llewellyn Craddock
 */
public class SearchFrame extends javax.swing.JFrame {

    /**
     * Creates new form SearchFrame
     */
    public SearchFrame() {
        initComponents();
    }
    
    /**
     * This method returns the phrase given by the user to search with
     * @return string value of the phrase entered
     */
    public String getPhrase (){
        String out;
        out = PhraseTextArea.getText();
        return out;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        HeadLabel = new javax.swing.JLabel();
        CriteriaPanel = new javax.swing.JPanel();
        ScrollTextPane = new javax.swing.JScrollPane();
        PhraseTextArea = new javax.swing.JTextArea();
        PhraseLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search Options");
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setText("Save");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        HeadLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        HeadLabel.setText("Search Options:");

        CriteriaPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ScrollTextPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ScrollTextPane.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        PhraseTextArea.setColumns(20);
        PhraseTextArea.setRows(5);
        ScrollTextPane.setViewportView(PhraseTextArea);

        PhraseLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PhraseLabel.setText("Search for word or phrase:");

        javax.swing.GroupLayout CriteriaPanelLayout = new javax.swing.GroupLayout(CriteriaPanel);
        CriteriaPanel.setLayout(CriteriaPanelLayout);
        CriteriaPanelLayout.setHorizontalGroup(
            CriteriaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CriteriaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CriteriaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PhraseLabel)
                    .addComponent(ScrollTextPane, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CriteriaPanelLayout.setVerticalGroup(
            CriteriaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CriteriaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PhraseLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScrollTextPane, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HeadLabel)
                    .addComponent(CriteriaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(HeadLabel)
                .addGap(18, 18, 18)
                .addComponent(CriteriaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        MainFrame mf = new MainFrame(0);
        mf.setFocusable(true);
        Debug.Log("The phrase is: "+this.getPhrase());
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CriteriaPanel;
    private javax.swing.JLabel HeadLabel;
    private javax.swing.JLabel PhraseLabel;
    private javax.swing.JTextArea PhraseTextArea;
    private javax.swing.JScrollPane ScrollTextPane;
    private javax.swing.JButton btnBack;
    // End of variables declaration//GEN-END:variables
}
