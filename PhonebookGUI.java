/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Josh
 */
public class PhonebookGUI extends javax.swing.JFrame {

    /**
     * Creates new form PhonebookGUI
     */
    private ArrayList<Contact> contacts;
    public PhonebookGUI() {
        initComponents();
        contacts = new ArrayList<>();
        File file = new File("phonebook.dat");
        if (file.exists()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                contacts = (ArrayList<Contact>) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                
            }
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

        titleLbl = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        viewAllBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        nameLbl = new javax.swing.JLabel();
        addressLbl = new javax.swing.JLabel();
        phoneNumber = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        addressTF = new javax.swing.JTextField();
        phoneNumberTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLbl.setText("Phonebook");

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        viewAllBtn.setText("View All");
        viewAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllBtnActionPerformed(evt);
            }
        });

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        nameLbl.setText("Name:");

        addressLbl.setText("Address:");

        phoneNumber.setText("Phone Number:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addressLbl)
                                .addComponent(nameLbl)
                                .addComponent(phoneNumber)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addressTF, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(viewAllBtn)
                                .addGap(18, 18, 18)
                                .addComponent(deleteBtn)))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titleLbl)
                        .addGap(158, 158, 158))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titleLbl)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLbl)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLbl)
                    .addComponent(addressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumber)
                    .addComponent(phoneNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBtn)
                    .addComponent(viewAllBtn)
                    .addComponent(addBtn))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        contacts.add(new Contact(nameTF.getText(), addressTF.getText(), phoneNumberTF.getText()));
        writeToFile();
        JOptionPane.showMessageDialog(null, nameTF.getText() + "has been added to the phonebook.");
    }//GEN-LAST:event_addBtnActionPerformed

    private void viewAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllBtnActionPerformed
        // TODO add your handling code here:
        if(contacts.size() == 0) {
            JOptionPane.showMessageDialog(null, "The is no contacts in the phonebook");
        } else {
            for(Contact i: contacts) {
                JOptionPane.showMessageDialog(null, "Name: " + i.getName() + "\nAddress: " + i.getAddress() + "\nPhone Number: " + i.getPhoneNumber());
            }
        }
        
    }//GEN-LAST:event_viewAllBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        boolean isDeleted = false;
        for(int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumberTF.getText())) {
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "Name: " + contacts.get(i).getName() + "\nPhone Number: " + contacts.get(i).getPhoneNumber() + "\nHas been removed from the phonebook.");
                contacts.remove(i);
            }
        }
        if (!isDeleted) {
            JOptionPane.showMessageDialog(null, "Name: " + nameTF.getText() + "\nPhone Number: " + phoneNumberTF.getText() + "\nCould not be deleted as it could not be found");
        }
        writeToFile();
    }//GEN-LAST:event_deleteBtnActionPerformed
    
    public void writeToFile() {
            try {
                File file = new File("phonebook.dat");
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(contacts);
                oos.close();
            } catch (IOException e) {
        }
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
            java.util.logging.Logger.getLogger(PhonebookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhonebookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhonebookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhonebookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhonebookGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel addressLbl;
    private javax.swing.JTextField addressTF;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTF;
    private javax.swing.JLabel phoneNumber;
    private javax.swing.JTextField phoneNumberTF;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JButton viewAllBtn;
    // End of variables declaration//GEN-END:variables
}
