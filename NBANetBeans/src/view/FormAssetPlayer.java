/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import model.AssetPlayer;
import model.dao.DAOAssetPlayer;
import model.dao.DAOFranchise;
import model.dao.DAOPlayer;
import model.domain.Franchise;
import model.domain.Player;

/**
 *
 * @author will
 */
public class FormAssetPlayer extends javax.swing.JDialog {

    /**
     * Creates new form FormAssetPlayer
     */
    public FormAssetPlayer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        DAOFranchise daoFranchise = new DAOFranchise();
        DAOPlayer daoPlayer = new DAOPlayer();
        
        franchiseList.clear();
        franchiseList.addAll(daoFranchise.getList());
        
        playerList.clear();
        playerList.addAll(daoPlayer.getList());
        
        updateList();
        updateUI();
    }
    
    public void updateList(){
        DAOAssetPlayer daoAS = new DAOAssetPlayer();
        assetPlayerList.clear();
        assetPlayerList.addAll(daoAS.getList());
        
        int index = assetPlayerList.size()-1;
        if(index >= 0){
            assetPlayerTable.setRowSelectionInterval(index, index);
            assetPlayerTable.getCellRect(index, index, true);
        }
        
    }
    
    public void updateUI(){
        int index = assetPlayerTable.getSelectedRow();
        
        if(index < 0){
            return;
        }
        
        AssetPlayer assetPlayer = assetPlayerList.get(index);
        
        for(int i = 0; i < playerList.size(); i++){
            Player player = playerList.get(i);
            if(player.equals(assetPlayer.getPlayer())){
                playerComboBox.setSelectedIndex(i);
                break;
            }
        }
        
        for(int i = 0; i < franchiseList.size(); i++){
            Franchise franch = franchiseList.get(i);
            if(franch.equals(assetPlayer.getFranchise())){
                franchiseComboBox.setSelectedIndex(i);
                break;
            }
        }
        
        idContractLabel.setText(assetPlayer.getIdContract().toString());
        startTextField.setText(assetPlayer.getStartC().toString());
        endTextField.setText(assetPlayer.getEndC().toString());
        salaryTextField.setText(assetPlayer.getFormattedSalary());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        franchiseList = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<model.domain.Franchise>())
        ;
        playerList = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<model.domain.Player>())
        ;
        assetPlayerList = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<model.AssetPlayer>())
        ;
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        assetPlayerTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        newButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        endTextField = new javax.swing.JTextField();
        startTextField = new javax.swing.JTextField();
        salaryTextField = new javax.swing.JTextField();
        franchiseComboBox = new javax.swing.JComboBox();
        playerComboBox = new javax.swing.JComboBox();
        idContractLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        firstButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        lastButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, assetPlayerList, assetPlayerTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idContract}"));
        columnBinding.setColumnName("id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${franchise}"));
        columnBinding.setColumnName("Franchise");
        columnBinding.setColumnClass(model.domain.Franchise.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${player}"));
        columnBinding.setColumnName("Player");
        columnBinding.setColumnClass(model.domain.Player.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${startC}"));
        columnBinding.setColumnName("Start C");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${endC}"));
        columnBinding.setColumnName("End C");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${formattedSalary}"));
        columnBinding.setColumnName("Salário");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(assetPlayerTable);
        if (assetPlayerTable.getColumnModel().getColumnCount() > 0) {
            assetPlayerTable.getColumnModel().getColumn(0).setResizable(false);
            assetPlayerTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            assetPlayerTable.getColumnModel().getColumn(2).setResizable(false);
            assetPlayerTable.getColumnModel().getColumn(2).setPreferredWidth(120);
            assetPlayerTable.getColumnModel().getColumn(5).setPreferredWidth(140);
        }

        jPanel1.add(jScrollPane1);

        jTabbedPane1.addTab("Jogadores ativos", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        newButton.setText("Novo");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        jPanel3.add(newButton);

        jButton1.setText("Editar");
        jPanel3.add(jButton1);

        jButton2.setText("Excluir");
        jPanel3.add(jButton2);

        jButton3.setText("Salvar");
        jPanel3.add(jButton3);

        jButton4.setText("Cancelar");
        jPanel3.add(jButton4);

        jPanel2.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Contrato"));

        jLabel1.setText("Contrato:");

        jLabel2.setText("Jogador:");

        jLabel3.setText("Time:");

        jLabel4.setText("Salário:");

        jLabel5.setText("Início:");

        jLabel6.setText("Término:");

        salaryTextField.setText("0");

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, franchiseList, franchiseComboBox);
        bindingGroup.addBinding(jComboBoxBinding);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, playerList, playerComboBox);
        bindingGroup.addBinding(jComboBoxBinding);

        idContractLabel.setText("###");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idContractLabel)
                    .addComponent(playerComboBox, 0, 246, Short.MAX_VALUE)
                    .addComponent(franchiseComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(endTextField)
                    .addComponent(startTextField)
                    .addComponent(salaryTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap(284, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idContractLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(playerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(franchiseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(salaryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(startTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(endTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Navegação"));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        firstButton.setText("Primeiro");
        firstButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstButtonActionPerformed(evt);
            }
        });
        jPanel5.add(firstButton);

        previousButton.setText("Anterior");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });
        jPanel5.add(previousButton);

        nextButton.setText("Próximo");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        jPanel5.add(nextButton);

        lastButton.setText("Último");
        lastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastButtonActionPerformed(evt);
            }
        });
        jPanel5.add(lastButton);

        jPanel2.add(jPanel5, java.awt.BorderLayout.SOUTH);

        jTabbedPane1.addTab("Detalhes", jPanel2);

        getContentPane().add(jTabbedPane1);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newButtonActionPerformed

    private void firstButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstButtonActionPerformed
        assetPlayerTable.setRowSelectionInterval(0, 0);
        assetPlayerTable.getCellRect(0, 0, true);
        updateUI();
    }//GEN-LAST:event_firstButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        int index = assetPlayerTable.getSelectedRow();
        
        if (index > 0){
            index--;
        }
        
        assetPlayerTable.setRowSelectionInterval(index, index);
        assetPlayerTable.getCellRect(index, index, true);
        updateUI();
    }//GEN-LAST:event_previousButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        int index = assetPlayerTable.getSelectedRow();
        
        if (index < assetPlayerList.size()-1){
            index++;
        }
        
        assetPlayerTable.setRowSelectionInterval(index, index);
        assetPlayerTable.getCellRect(index, index, true);
        updateUI();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void lastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastButtonActionPerformed
        int index = assetPlayerList.size()-1;
        if(index < 0){
            return;
        }
        assetPlayerTable.setRowSelectionInterval(index, index);
        assetPlayerTable.getCellRect(index, index, true);
        updateUI();
    }//GEN-LAST:event_lastButtonActionPerformed
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        AssetPlayer ap = new AssetPlayer();
        ap.setEndC(convertStringToDate(endTextField.getText()));
        ap.setStartC(convertStringToDate(endTextField.getText()));
        ap.setSalary(Double.parseDouble(salaryTextField.getText()));
        ap.setPlayer(getSelectedPlayer());
        ap.setFranchise(getSelectedFranchise());
        
        DAOAssetPlayer dao = new DAOAssetPlayer();
        dao.insert(ap);
        
        updateList();
        updateUI();
        
    } 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormAssetPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAssetPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAssetPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAssetPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormAssetPlayer dialog = new FormAssetPlayer(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<AssetPlayer> assetPlayerList;
    private javax.swing.JTable assetPlayerTable;
    private javax.swing.JTextField endTextField;
    private javax.swing.JButton firstButton;
    private javax.swing.JComboBox franchiseComboBox;
    private java.util.List<Franchise> franchiseList;
    private javax.swing.JLabel idContractLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton lastButton;
    private javax.swing.JButton newButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JComboBox playerComboBox;
    private java.util.List<Player> playerList;
    private javax.swing.JButton previousButton;
    private javax.swing.JTextField salaryTextField;
    private javax.swing.JTextField startTextField;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
