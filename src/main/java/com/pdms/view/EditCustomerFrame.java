/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.view;

/**
 *
 * @author Suresh
 */
public class EditCustomerFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame
     */
    public EditCustomerFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblTitle = new javax.swing.JLabel();
        jlblName = new javax.swing.JLabel();
        jtxtName = new javax.swing.JTextField();
        jtxtMobile = new javax.swing.JTextField();
        jtxtPincode = new javax.swing.JTextField();
        jtxtStdCode = new javax.swing.JTextField();
        jtxtPhone = new javax.swing.JTextField();
        jlblPincode = new javax.swing.JLabel();
        jlblAddress = new javax.swing.JLabel();
        jblMobile = new javax.swing.JLabel();
        jlblLandline = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxaAddress = new javax.swing.JTextArea();
        jlblAmount = new javax.swing.JLabel();
        jtxtAmount = new javax.swing.JTextField();
        jbtnSubmit = new javax.swing.JButton();
        jlblerrName = new javax.swing.JLabel();
        jlblerrAddress = new javax.swing.JLabel();
        jlblerrPincode = new javax.swing.JLabel();
        jlblerrMobile = new javax.swing.JLabel();
        jlblerrLandline = new javax.swing.JLabel();
        jlblerrAmount = new javax.swing.JLabel();

        jlblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblTitle.setText("Modify Customer");
        jlblTitle.setToolTipText("");

        jlblName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblName.setLabelFor(jlblName);
        jlblName.setText("Name:");
        jlblName.setToolTipText("");

        jlblPincode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblPincode.setLabelFor(jtxtPincode);
        jlblPincode.setText("Pincode:");

        jlblAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblAddress.setLabelFor(jtxaAddress);
        jlblAddress.setText("Adress:");

        jblMobile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jblMobile.setLabelFor(jtxtMobile);
        jblMobile.setText("Mobile No:");

        jlblLandline.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblLandline.setLabelFor(jlblLandline);
        jlblLandline.setText("Landline No:");

        jtxaAddress.setColumns(20);
        jtxaAddress.setRows(5);
        jScrollPane1.setViewportView(jtxaAddress);

        jlblAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblAmount.setLabelFor(jlblAmount);
        jlblAmount.setText("Amount:");

        jtxtAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtAmount.setText("0.00");

        jbtnSubmit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnSubmit.setText("Submit");

        jlblerrName.setText("jLabel1");

        jlblerrAddress.setText("jLabel2");

        jlblerrPincode.setText("jLabel3");

        jlblerrMobile.setText("jLabel4");

        jlblerrLandline.setText("jLabel5");

        jlblerrAmount.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jlblAmount))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblName, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlblPincode, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlblAddress, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jblMobile, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblerrMobile)
                            .addComponent(jlblerrPincode)
                            .addComponent(jlblerrAddress)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblerrName)
                            .addComponent(jtxtPincode, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtxtStdCode, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlblerrLandline)
                            .addComponent(jtxtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblerrAmount)
                            .addComponent(jtxtName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlblLandline))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jlblTitle)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jlblTitle)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jlblerrName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jlblerrAddress)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtPincode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblPincode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblerrPincode)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jblMobile)
                            .addComponent(jtxtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlblName)
                        .addGap(31, 31, 31)
                        .addComponent(jlblAddress)))
                .addGap(16, 16, 16)
                .addComponent(jlblerrMobile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtStdCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblLandline)
                            .addComponent(jlblerrLandline))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlblAmount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblerrAmount)
                .addGap(18, 18, 18)
                .addComponent(jbtnSubmit)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jblMobile;
    private javax.swing.JButton jbtnSubmit;
    private javax.swing.JLabel jlblAddress;
    private javax.swing.JLabel jlblAmount;
    private javax.swing.JLabel jlblLandline;
    private javax.swing.JLabel jlblName;
    private javax.swing.JLabel jlblPincode;
    private javax.swing.JLabel jlblTitle;
    private javax.swing.JLabel jlblerrAddress;
    private javax.swing.JLabel jlblerrAmount;
    private javax.swing.JLabel jlblerrLandline;
    private javax.swing.JLabel jlblerrMobile;
    private javax.swing.JLabel jlblerrName;
    private javax.swing.JLabel jlblerrPincode;
    private javax.swing.JTextArea jtxaAddress;
    private javax.swing.JTextField jtxtAmount;
    private javax.swing.JTextField jtxtMobile;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JTextField jtxtPhone;
    private javax.swing.JTextField jtxtPincode;
    private javax.swing.JTextField jtxtStdCode;
    // End of variables declaration//GEN-END:variables
}