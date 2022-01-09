package pos;

import java.awt.Frame;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.math.NumberUtils;

public class InvoiceChooser extends javax.swing.JDialog {

    private final SaleInvoice saleInvoice;

    public InvoiceChooser(Frame parent, boolean modal) {
        super(parent, modal);
        this.saleInvoice = new SaleInvoice();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saleInvoiceBTN = new javax.swing.JButton();
        returnInvoiceBTN = new javax.swing.JButton();
        purchaseInvoiceBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Invoice Type");
        setResizable(false);

        saleInvoiceBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        saleInvoiceBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/Icons/Sales.png"))); // NOI18N
        saleInvoiceBTN.setText("Sale Invoice");
        saleInvoiceBTN.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        saleInvoiceBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleInvoiceBTNActionPerformed(evt);
            }
        });

        returnInvoiceBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        returnInvoiceBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/Icons/Returns.png"))); // NOI18N
        returnInvoiceBTN.setText("Return Invoice");
        returnInvoiceBTN.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        returnInvoiceBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnInvoiceBTNActionPerformed(evt);
            }
        });

        purchaseInvoiceBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        purchaseInvoiceBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/Icons/Purchases.png"))); // NOI18N
        purchaseInvoiceBTN.setText("Purchase Invoice");
        purchaseInvoiceBTN.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        purchaseInvoiceBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseInvoiceBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(purchaseInvoiceBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(returnInvoiceBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saleInvoiceBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saleInvoiceBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(returnInvoiceBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(purchaseInvoiceBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saleInvoiceBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleInvoiceBTNActionPerformed
        dispose();
        new SaleInvoice().setVisible(true);
    }//GEN-LAST:event_saleInvoiceBTNActionPerformed

    private void returnInvoiceBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnInvoiceBTNActionPerformed
        int saleInvoiceNo = NumberUtils.toInt(JOptionPane.showInputDialog("Enter the sale invoice number:"));
        if (saleInvoice.isInvoiceExist(saleInvoiceNo)) {
            dispose();
            new ReturnInvoice(saleInvoiceNo).setVisible(true);
        }
    }//GEN-LAST:event_returnInvoiceBTNActionPerformed

    private void purchaseInvoiceBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseInvoiceBTNActionPerformed
        dispose();
        new PurchaseInvoice().setVisible(true);
    }//GEN-LAST:event_purchaseInvoiceBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton purchaseInvoiceBTN;
    private javax.swing.JButton returnInvoiceBTN;
    private javax.swing.JButton saleInvoiceBTN;
    // End of variables declaration//GEN-END:variables

}
