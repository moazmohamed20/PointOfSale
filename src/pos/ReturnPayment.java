package pos;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.math.NumberUtils;

public class ReturnPayment extends javax.swing.JDialog {

    private final DefaultTableModel returnItems;
    private final Safe safe;
    private double discount;
    private double total;

    private final ReturnInvoice returnInvoice;
    private final SaleInvoice saleInvoice;
    private final int saleInvoiceNo;

    public ReturnPayment(java.awt.Frame parent, boolean modal, int saleInvoiceNo, DefaultTableModel items) {
        super(parent, modal);
        this.returnInvoice = new ReturnInvoice(saleInvoiceNo);
        this.saleInvoice = new SaleInvoice();
        this.safe = new Safe(null, false);
        this.saleInvoiceNo = saleInvoiceNo;
        this.returnItems = items;

        initComponents();
        totalLabel.setText(String.valueOf(calculateTotal(items)));
        discountTF.setText(String.valueOf(saleInvoice.getInvoiceDiscount(saleInvoiceNo)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        totalLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        discountTF = new javax.swing.JTextField();
        saveBTN = new javax.swing.JButton();
        cancelBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Payment");
        setMinimumSize(null);
        setResizable(false);

        totalLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalLabel.setText("0.0");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setLabelFor(discountTF);
        jLabel1.setText("Discount");

        discountTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        discountTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        discountTF.setText("0");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(discountTF)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(discountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBTNActionPerformed
        dispose();
    }//GEN-LAST:event_cancelBTNActionPerformed

    private void saveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTNActionPerformed
        saveInvoice();
        dispose();
    }//GEN-LAST:event_saveBTNActionPerformed

    private double calculateTotal(DefaultTableModel items) {
        double itemsTotal = 0;
        for (int i = 0; i < items.getRowCount(); i++) {
            itemsTotal += (double) items.getValueAt(i, 5);
        }
        return itemsTotal;
    }

    private void saveInvoice() {
        discount = NumberUtils.toDouble(discountTF.getText().trim());
        total = NumberUtils.toDouble(totalLabel.getText()) - discount;

        // ADD RECORD AT SAFE
        int safeID = safe.saveSafeRecord("Return Invoice", -total);

        // ADD RECORD AT RETURN INVOICES
        int invoiceNo = returnInvoice.saveInvoiceRecord(saleInvoiceNo, safeID, total);

        // ADD RECORDS AT RETURNS
        returnInvoice.saveItemsRecords(invoiceNo, returnItems);

        JOptionPane.showMessageDialog(this, "Saved");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBTN;
    private javax.swing.JTextField discountTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton saveBTN;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables

}
