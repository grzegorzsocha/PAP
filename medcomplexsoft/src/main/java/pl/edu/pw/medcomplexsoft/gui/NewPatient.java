/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package pl.edu.pw.medcomplexsoft.gui;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

import org.apache.commons.validator.routines.EmailValidator;

import java.time.LocalDate;
import java.time.ZoneId;

import pl.edu.pw.medcomplexsoft.database.Database;
import pl.edu.pw.medcomplexsoft.model.*;
/**
 *
 * @author Grzesiek
 */
public class NewPatient extends javax.swing.JDialog {
    Patient changingPatient = null;

    /**
     * Creates new form NewPatient
     */
    public NewPatient(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public NewPatient(java.awt.Frame parent, boolean modal, Patient patient) {
        super(parent, modal);
        initComponents();
        changingPatient = patient;
        changingPatientId = patient.getId();
        nameField.setText(patient.getName());
        surnameField.setText(patient.getSurname());
        dateSpinner.setValue(java.sql.Date.valueOf(patient.getBirthDate()));
        peselField.setText(patient.getPesel());
        if(patient.getGender() == 'K')
            femaleRadioButton.setSelected(true);
        else
            maleRadioButton.setSelected(true);
        streetField.setText(patient.getAddress().getStreet());
        houseField.setText(String.valueOf(patient.getAddress().getHouseNumber()));
        if(patient.getAddress().getFlatNumber() != null)
            flatField.setText(String.valueOf(patient.getAddress().getFlatNumber()));
        cityField.setText(patient.getAddress().getCity());
        postalCodeField.setText(patient.getAddress().getPostalCode());
        countryField.setText(patient.getAddress().getCountry());
        emailField.setText(patient.getMailAddress());
        loginField.setText(patient.getUsername());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderButtonGroup = new javax.swing.ButtonGroup();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        surnameField = new javax.swing.JTextField();
        birthDateLabel = new javax.swing.JLabel();
        dateSpinner = new javax.swing.JSpinner();
        peselLabel = new javax.swing.JLabel();
        peselField = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        streetLabel = new javax.swing.JLabel();
        streetField = new javax.swing.JTextField();
        houseLabel = new javax.swing.JLabel();
        houseField = new javax.swing.JTextField();
        flatLabel = new javax.swing.JLabel();
        flatField = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        postalCodeLabel = new javax.swing.JLabel();
        postalCodeField = new javax.swing.JTextField();
        countryLabel = new javax.swing.JLabel();
        countryField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        loginLabel = new javax.swing.JLabel();
        loginField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        cancelButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        maleRadioButton = new javax.swing.JRadioButton();
        femaleRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nowy pacjent");
        setMaximumSize(new java.awt.Dimension(420, 600));
        setMinimumSize(new java.awt.Dimension(420, 600));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(420, 600));

        nameLabel.setText("Imię");

        surnameLabel.setText("Nazwisko");

        birthDateLabel.setText("Data urodzenia");

        dateSpinner.setModel(new javax.swing.SpinnerDateModel());
        dateSpinner.setOpaque(false);

        peselLabel.setText("PESEL");

        genderLabel.setText("Płeć");

        streetLabel.setText("Ulica");

        houseLabel.setText("Numer domu");

        flatLabel.setText("Numer mieszkania");

        cityLabel.setText("Miasto");

        postalCodeLabel.setText("Kod pocztowy");

        countryLabel.setText("Kraj");

        emailLabel.setText("E-mail");

        loginLabel.setText("Login");

        passwordLabel.setText("Hasło");

        cancelButton.setText("Anuluj");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        addButton.setText("Dodaj");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        genderButtonGroup.add(maleRadioButton);
        maleRadioButton.setSelected(true);
        maleRadioButton.setText("Mężczyna");

        genderButtonGroup.add(femaleRadioButton);
        femaleRadioButton.setText("Kobieta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(surnameLabel)
                    .addComponent(nameLabel)
                    .addComponent(birthDateLabel)
                    .addComponent(peselLabel)
                    .addComponent(genderLabel)
                    .addComponent(streetLabel)
                    .addComponent(houseLabel)
                    .addComponent(flatLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cityLabel)
                    .addComponent(postalCodeLabel)
                    .addComponent(countryLabel)
                    .addComponent(loginLabel)
                    .addComponent(emailLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginField)
                            .addComponent(countryField)
                            .addComponent(postalCodeField)
                            .addComponent(cityField)
                            .addComponent(flatField)
                            .addComponent(houseField)
                            .addComponent(streetField)
                            .addComponent(peselField)
                            .addComponent(nameField)
                            .addComponent(surnameField)
                            .addComponent(emailField)
                            .addComponent(passwordField)
                            .addComponent(dateSpinner)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(maleRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(femaleRadioButton)
                                .addGap(23, 23, 23)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameLabel)
                    .addComponent(surnameField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthDateLabel)
                    .addComponent(dateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(peselLabel)
                    .addComponent(peselField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLabel)
                    .addComponent(maleRadioButton)
                    .addComponent(femaleRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streetLabel)
                    .addComponent(streetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(houseLabel)
                    .addComponent(houseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(flatLabel)
                    .addComponent(flatField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityLabel)
                    .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postalCodeLabel)
                    .addComponent(postalCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countryLabel)
                    .addComponent(countryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLabel)
                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(cancelButton)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void showDialog() {
        setVisible(true);
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        boolean correct = true;
        EntityManager entityManager = Database.getEntityManager();

        //sprawdzanie loginu
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> personRoot = criteriaQuery.from(Person.class);

        Predicate predicateUserName = criteriaBuilder.equal(personRoot.get("username"), loginField.getText());

        criteriaQuery.where(predicateUserName);
        List<Person> result = entityManager.createQuery(criteriaQuery).getResultList();
        if (changingPatientId == -1 && result.size() != 0){
            correct = false;
            JOptionPane.showMessageDialog(this, "Login już w użyciu. Wybierz inny", "Błąd", JOptionPane.ERROR_MESSAGE);
        }

        //sprawdzanie peselu
        Predicate predicatePesel = criteriaBuilder.equal(personRoot.get("pesel"), peselField.getText());
        criteriaQuery.where(predicatePesel);
        result = entityManager.createQuery(criteriaQuery).getResultList();
        if (changingPatientId == -1 && result.size() != 0){
            correct = false;
            JOptionPane.showMessageDialog(this, "Osoba o takim peselu jest już w bazie", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else if (nameField.getText().length() == 0) {
            correct = false;
            JOptionPane.showMessageDialog(this, "Pole imię nie może być puste", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else if (surnameField.getText().length() == 0) {
            correct = false;
            JOptionPane.showMessageDialog(this, "Pole nazwisko nie może być puste", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else if(((Date)dateSpinner.getValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate().compareTo(LocalDate.now()) > 0){
            correct = false;
            JOptionPane.showMessageDialog(this, "Data urodzenia nie moża być późniejsza niż dzisiejsza data", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else if(peselField.getText().length() != 11) {
            correct = false;
            JOptionPane.showMessageDialog(this, "Pesel powinien mieć 11 znaków", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else if(!peselField.getText().matches("[0-9]+")){
            correct = false;
            JOptionPane.showMessageDialog(this, "Pesel może zawierać tylko cyfry", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else if (streetField.getText().length() == 0) {
            correct = false;
            JOptionPane.showMessageDialog(this, "Pole ulica nie może być puste", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else if (houseField.getText().length() == 0) {
            correct = false;
            JOptionPane.showMessageDialog(this, "Pole numer domu nie może być puste", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else if (cityField.getText().length() == 0) {
            correct = false;
            JOptionPane.showMessageDialog(this, "Pole miasto nie może być puste", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else if (postalCodeField.getText().length() == 0 || postalCodeField.getText().charAt(2) != '-') {
            correct = false;
            JOptionPane.showMessageDialog(this, "Nieprawidłowy format kodu pocztowego", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else if (countryField.getText().length() == 0) {
            correct = false;
            JOptionPane.showMessageDialog(this, "Pole kraj nie może być puste", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else if (emailField.getText().length() == 0) {
            correct = false;
            JOptionPane.showMessageDialog(this, "Pole adres e-mail nie może być puste", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else if (!EmailValidator.getInstance().isValid(emailField.getText())) {
            correct = false;
            JOptionPane.showMessageDialog(this, "Błędny adres e-mail", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else if (loginField.getText().length() == 0) {
            correct = false;
            JOptionPane.showMessageDialog(this, "Pole kraj nie może być puste", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else if (changingPatient == null && passwordField.getPassword().length < 3) {
            correct = false;
            JOptionPane.showMessageDialog(this, "Hasło musi zawierać conajmniej 3 znaki", "Błąd", JOptionPane.ERROR_MESSAGE);
        }

        if(correct) {
            int selection = JOptionPane.showConfirmDialog(this, "Czy potwierdzasz dodanie pacjenta?", "Potwierdzenie",
                                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(selection == JOptionPane.OK_OPTION) {
                Patient patient = new Patient();
                Address address = new Address();
                patient.setName(nameField.getText());
                patient.setSurname(surnameField.getText());
                patient.setBirthDate(((Date)dateSpinner.getValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                patient.setPesel(peselField.getText());
                patient.setUsername(loginField.getText());
                if(maleRadioButton.isSelected())
                    patient.setGender('M');
                else
                    patient.setGender('K');
                address.setStreet(streetField.getText());
                address.setHouseNumber(Long.parseLong(houseField.getText()));
                if(flatField.getText().length() == 0)
                    address.setFlatNumber(null);
                else
                    address.setFlatNumber(Long.parseLong(flatField.getText()));
                address.setCity(cityField.getText());
                address.setPostalCode(postalCodeField.getText());
                address.setCountry(countryField.getText());
                patient.setAddress(address);
                patient.setMailAddress(emailField.getText());
                var tx = entityManager.getTransaction();
                tx.begin();
                if(changingPatientId == -1) {
                    String hashedPassword = org.apache.commons.codec.digest.DigestUtils.sha256Hex(String.valueOf(passwordField.getPassword()));
                    patient.setPassword(hashedPassword);
                    entityManager.persist(patient);
                }
                else {
                    patient.setPassword(changingPatient.getPassword());
                    patient.setId(changingPatientId);
                    patient.getAddress().setId(changingPatient.getAddress().getId());
                    patient.setPrescriptions(changingPatient.getPrescriptions());
                    patient.setAppointments(changingPatient.getAppointments());
                    entityManager.merge(patient);
                }
                tx.commit();
                dispose();
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

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
            java.util.logging.Logger.getLogger(NewPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewPatient dialog = new NewPatient(new javax.swing.JFrame(), true);
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
    private long changingPatientId = -1;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel birthDateLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField cityField;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField countryField;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JSpinner dateSpinner;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JTextField flatField;
    private javax.swing.JLabel flatLabel;
    private javax.swing.ButtonGroup genderButtonGroup;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JTextField houseField;
    private javax.swing.JLabel houseLabel;
    private javax.swing.JTextField loginField;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField peselField;
    private javax.swing.JLabel peselLabel;
    private javax.swing.JTextField postalCodeField;
    private javax.swing.JLabel postalCodeLabel;
    private javax.swing.JTextField streetField;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    // End of variables declaration//GEN-END:variables
}
