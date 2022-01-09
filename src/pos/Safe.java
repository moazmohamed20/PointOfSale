package pos;

import javax.swing.JOptionPane;
import org.apache.commons.lang3.math.NumberUtils;

public class Safe extends javax.swing.JDialog {

    private final DBManager dbManager = DBManager.getInstance();

    private String statement;
    private double price;

    public Safe(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        updateTotalLabel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        statementTF = new javax.swing.JTextField();
        priceTF = new javax.swing.JTextField();
        saveBTN = new javax.swing.JButton();
        cancelBTN = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Safe");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setLabelFor(statementTF);
        jLabel1.setText("Statement");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setLabelFor(priceTF);
        jLabel2.setText("Price");

        statementTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        statementTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        priceTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        priceTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        priceTF.setText("0");

        saveBTN.setText("Save");
        saveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTNActionPerformed(evt);
            }
        });

        cancelBTN.setText("Cancel");
        cancelBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBTNActionPerformed(evt);
            }
        });

        totalLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalLabel.setText("0.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                    .addComponent(statementTF, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                    .addComponent(priceTF, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(saveBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statementTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBTNActionPerformed
        dispose();
    }//GEN-LAST:event_cancelBTNActionPerformed

    private void saveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTNActionPerformed
        statement = statementTF.getText().trim();
        price = NumberUtils.toDouble(priceTF.getText());

        if (statement.isEmpty()) {
            statementTF.requestFocus();
            JOptionPane.showMessageDialog(this, "You must enter the statement", "Safe", JOptionPane.ERROR_MESSAGE);
        } else {
            saveSafeRecord(statement, price);

            clearFields();
            updateTotalLabel();
            JOptionPane.showMessageDialog(this, "Saved");
        }
    }//GEN-LAST:event_saveBTNActionPerformed

    private void updateTotalLabel() {
        double total = getSafeTotal();
        totalLabel.setText(String.valueOf(total));
    }

    private void clearFields() {
        statementTF.requestFocus();
        statementTF.setText("");
        priceTF.setText("0");
    }

    public double getSafeTotal() {
        return dbManager.executeOperation("SELECT SUM(PRICE) FROM SAFE");
    }

    public int saveSafeRecord(String statement, double price) {
        return dbManager.executeQuery("INSERT INTO SAFE VALUES(DEFAULT, CURRENT_TIMESTAMP, '" + Employee.signedEmployee + "', '" + statement + "', " + price + ")");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField priceTF;
    private javax.swing.JButton saveBTN;
    private javax.swing.JTextField statementTF;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
