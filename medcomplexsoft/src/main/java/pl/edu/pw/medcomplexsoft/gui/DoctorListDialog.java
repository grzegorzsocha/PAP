/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package pl.edu.pw.medcomplexsoft.gui;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.Vector;
import pl.edu.pw.medcomplexsoft.database.Database;

import pl.edu.pw.medcomplexsoft.model.Doctor;
import pl.edu.pw.medcomplexsoft.model.Person;
import pl.edu.pw.medcomplexsoft.model.Patient;

/**
 *
 * @author kubix
 */
public class DoctorListDialog extends javax.swing.JDialog {
    private Person user;
    /**
     * Creates new form DoctorListDialog
     */

    public DoctorListDialog(java.awt.Frame parent, boolean modal, Person loggedUser) {
        super(parent, modal);
        initComponents();
        user = loggedUser;
        if(user != null && (user instanceof Doctor || user instanceof Patient))
        {
            newButton.setVisible(false);
            editButton.setVisible(false);
            deleteButton.setVisible(false);
            showDataButton.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DoctorList = new javax.swing.JList<>();
        editButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        showDataButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista lekarzy");

        DoctorList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(DoctorList);

        editButton.setText("Edytuj");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        newButton.setText("Nowy");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Usuń");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        showDataButton.setText("Pokaż dane");
        showDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showDataButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(okButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showDataButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(newButton)
                .addGap(18, 18, 18)
                .addComponent(editButton)
                .addGap(18, 18, 18)
                .addComponent(deleteButton)
                .addGap(153, 153, 153)
                .addComponent(showDataButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                .addComponent(okButton)
                .addGap(101, 101, 101))
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int selectedDoctorIndex = DoctorList.getSelectedIndex();
        if(selectedDoctorIndex != -1)
        {
            Doctor selectedDoctor = doctorObjectList.get(selectedDoctorIndex);
            NewDoctorDialog newDoctorDialog = new NewDoctorDialog(null, true, selectedDoctor);
            newDoctorDialog.setLocationRelativeTo(this.rootPane);
            newDoctorDialog.showDialog();
            loadData();
        } else {
            JOptionPane.showMessageDialog(this, "Nie wybrano żadnego lekarza z listy",
                "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        NewDoctorDialog newDoctor = new NewDoctorDialog(null, true);
        newDoctor.setLocationRelativeTo(this.rootPane);
        newDoctor.showDialog();
        loadData();
    }//GEN-LAST:event_newButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        EntityManager entityManager = Database.getEntityManager();
        int selectedDoctorIndex = DoctorList.getSelectedIndex();
        if(DoctorList.getSelectedIndex() != -1)
        {
            Doctor removingDoctor = doctorObjectList.get(selectedDoctorIndex);
            int selection = JOptionPane.showConfirmDialog(this, "Czy potwierdzasz usuniecie lekarza " + removingDoctor.getFullName()+"?",
                "Potwierdzenie",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(selection == JOptionPane.OK_OPTION)
            {
                if(removingDoctor.getAppointments().size() != 0) {
                    JOptionPane.showMessageDialog(this, "Nie można usunąć lekarza, który ma umówione wizyty.",
                        "Błąd", JOptionPane.ERROR_MESSAGE);
                }
                else if(removingDoctor.getPrescriptions().size() != 0 || removingDoctor.getAppointments().size() != 0)
                {
                    JOptionPane.showMessageDialog(this, "Nie można usunąć lekarza, który wystawił recepty.",
                        "Błąd", JOptionPane.ERROR_MESSAGE);
                } else {
                    var tx = entityManager.getTransaction();
                    tx.begin();
                    entityManager.remove(removingDoctor);
                    tx.commit();
                    loadData();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nie wybrano żadnego lekarza z listy",
                "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void showDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showDataButtonActionPerformed
        int selectedDoctorIndex = DoctorList.getSelectedIndex();
        if(selectedDoctorIndex != -1)
        {
            Doctor selectedDoctor = doctorObjectList.get(selectedDoctorIndex);
            DoctorDataViewDialog doctorDataViewDialog = new DoctorDataViewDialog(null, true, selectedDoctor);
            doctorDataViewDialog.setLocationRelativeTo(this.rootPane);
            doctorDataViewDialog.showDialog();
        } else {
            JOptionPane.showMessageDialog(this, "Nie wybrano żadnego lekarza z listy",
                "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_showDataButtonActionPerformed

    private void loadData(){
        EntityManager entityManager = Database.getEntityManager();
        TypedQuery<Doctor> typedQuery = entityManager.createQuery("SELECT p FROM Doctor p", Doctor.class);
        doctorObjectList = typedQuery.getResultList();
        Vector<String> listData = new Vector<String>();
        for(int i=1; i<=doctorObjectList.size(); ++i)
        {
            var doctor = doctorObjectList.get(i-1);
            listData.add(i + ". " + doctor.getFullName() + " | " + doctor.getSpecialization());
            // + " "+ doctor.getSpecialization()
        }
        DoctorList.setListData(listData);
    }

    public Doctor showDialog() {
        loadData();
        setVisible(true);
        int selectedIndex = DoctorList.getSelectedIndex();
        if(selectedIndex != -1)
            return doctorObjectList.get(DoctorList.getSelectedIndex());
        return null;
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
            java.util.logging.Logger.getLogger(DoctorListDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorListDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorListDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorListDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DoctorListDialog dialog = new DoctorListDialog(new javax.swing.JFrame(), true, null);

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
    private List<Doctor> doctorObjectList;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> DoctorList;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newButton;
    private javax.swing.JButton okButton;
    private javax.swing.JButton showDataButton;
    // End of variables declaration//GEN-END:variables
}
