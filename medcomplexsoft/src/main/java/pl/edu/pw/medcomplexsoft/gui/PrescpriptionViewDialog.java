/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package pl.edu.pw.medcomplexsoft.gui;

import java.util.Vector;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import pl.edu.pw.medcomplexsoft.database.Database;
import pl.edu.pw.medcomplexsoft.model.Patient;
import pl.edu.pw.medcomplexsoft.model.Person;
import pl.edu.pw.medcomplexsoft.model.Prescription;
import pl.edu.pw.medcomplexsoft.model.Status;

/**
 *
 * @author hubert
 */
public class PrescpriptionViewDialog extends javax.swing.JDialog {
    private Prescription prescription;
    private Person loggedUser = null;

    /**
     * Creates new form PrescpriptionViewDialog
     */
    public PrescpriptionViewDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public PrescpriptionViewDialog(java.awt.Frame parent, boolean modal, Prescription prescription, Person user) {
        super(parent, modal);
        this.prescription = prescription;
        loggedUser = user;
        initComponents();
        if(loggedUser != null && !(loggedUser instanceof Patient))
        {
            realisedButton.setVisible(false);
        }
        if(prescription.getStatus() != Status.ACTIVE)
        {
            realisedButton.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        patientNameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        prescribingDoctorLabel = new javax.swing.JLabel();
        realisedButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        issueDateLabel = new javax.swing.JLabel();
        expiryDateLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Podgląd recepty");

        jLabel1.setText("Pacjent");

        patientNameLabel.setText("jLabel2");

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        jLabel2.setText("RECEPTA");

        jLabel3.setText("Status");

        statusLabel.setText("jLabel4");

        jLabel4.setText("Wystawiona przez");

        prescribingDoctorLabel.setText("jLabel5");

        realisedButton.setText("Oznacz jako zrealizowana");
        realisedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realisedButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Data wystawienia");

        jLabel6.setText("Data ważności");

        issueDateLabel.setText("jLabel7");

        expiryDateLabel.setText("jLabel8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(31, 31, 31)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(patientNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prescribingDoctorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(issueDateLabel)
                    .addComponent(expiryDateLabel))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(realisedButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(patientNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(statusLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prescribingDoctorLabel)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(issueDateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(expiryDateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(realisedButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void realisedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realisedButtonActionPerformed
        int selection = JOptionPane.showConfirmDialog(this, "Czy oznaczyć receoptę jako zrealizowaną?", "Potwierdzenie",
                                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(selection == JOptionPane.OK_OPTION) {
            prescription.setStatus(Status.REALISED);
            statusLabel.setText("Zrealizowana");
            realisedButton.setVisible(false);
            EntityManager entityManager = Database.getEntityManager();
            var tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(prescription);
            tx.commit();
        }
    }//GEN-LAST:event_realisedButtonActionPerformed

    public void showDialog()
    {
        Vector<String> positionsList = new Vector<String>();
        for(var position : prescription.getPositions())
        {
            positionsList.add(position.getDosage() + " " + position.getMedicine().getName());
        }
        jList1.setListData(positionsList);
        patientNameLabel.setText(prescription.getReceivingPatient().getFullName());
        prescribingDoctorLabel.setText(prescription.getPrescribingDoctor().getFullName());
        String receiptStatus = "";
        switch (prescription.getStatus()) {
            case ACTIVE:
                receiptStatus = "Wystawiona";
                break;
            case CANCELLED:
                receiptStatus = "Anulowana";
                break;
            case REALISED:
                receiptStatus = "Zrealizowana";
                break;
        }
        statusLabel.setText(receiptStatus);
        expiryDateLabel.setText(prescription.getExpirationDate().toString());
        issueDateLabel.setText(prescription.getIssueDate().toString());
        setVisible(true);
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
            java.util.logging.Logger.getLogger(PrescpriptionViewDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrescpriptionViewDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrescpriptionViewDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrescpriptionViewDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PrescpriptionViewDialog dialog = new PrescpriptionViewDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel expiryDateLabel;
    private javax.swing.JLabel issueDateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel patientNameLabel;
    private javax.swing.JLabel prescribingDoctorLabel;
    private javax.swing.JButton realisedButton;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
