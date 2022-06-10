package pos;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.math.NumberUtils;

public class SalePayment extends javax.swing.JDialog {

    private final DefaultTableModel saleItems;
    private final Safe safe;
    private double discount;
    private double total;

    private final SaleInvoice saleInvoice;
    private final Customer customer;
    private int customerID;

    public SalePayment(java.awt.Frame parent, boolean modal, DefaultTableModel items) {
        super(parent, modal);
        this.saleInvoice = new SaleInvoice();
        this.customer = new Customer(null, false);
        this.safe = new Safe(null, false);
        this.saleItems = items;

        initComponents();
        totalLabel.setText(String.valueOf(calculateTotal(items)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        totalLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        discountTF = new javax.swing.JTextField();
        saveBTN = new javax.swing.JButton();
        cancelBTN = new javax.swing.JButton();
        customerPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        phoneTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressTA = new javax.swing.JTextArea();
        tableScrollPane = new javax.swing.JScrollPane();
        customersTable = new javax.swing.JTable();

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

        customerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setLabelFor(nameTF);
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setLabelFor(nameTF);
        jLabel3.setText("Phone");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Address");

        nameTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameTFKeyReleased(evt);
            }
        });

        phoneTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phoneTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phoneTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phoneTFKeyReleased(evt);
            }
        });

        addressTA.setColumns(20);
        addressTA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addressTA.setRows(2);
        addressTA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                addressTAKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(addressTA);

        customersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        customersTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        customersTable.getTableHeader().setResizingAllowed(false);
        customersTable.getTableHeader().setReorderingAllowed(false);
        customersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                customersTableMouseReleased(evt);
            }
        });
        tableScrollPane.setViewportView(customersTable);

        javax.swing.GroupLayout customerPanelLayout = new javax.swing.GroupLayout(customerPanel);
        customerPanel.setLayout(customerPanelLayout);
        customerPanelLayout.setHorizontalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(customerPanelLayout.createSequentialGroup()
                        .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(nameTF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneTF, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap())
        );
        customerPanelLayout.setVerticalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(phoneTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(customerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void customersTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customersTableMouseReleased
        DefaultTableModel table = (DefaultTableModel) customersTable.getModel();
        int id = (int) table.getValueAt(customersTable.getSelectedRow(), 0);
        String name = table.getValueAt(customersTable.getSelectedRow(), 1).toString();
        String phone = table.getValueAt(customersTable.getSelectedRow(), 2).toString();
        String address = table.getValueAt(customersTable.getSelectedRow(), 3).toString();

        customerID = id;
        nameTF.setText(name);
        phoneTF.setText(phone);
        addressTA.setText(address);
    }//GEN-LAST:event_customersTableMouseReleased

    private void nameTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTFKeyReleased
        customerID = 0;
        customer.searchForCustomers(nameTF.getText().trim().toLowerCase(), customersTable);
    }//GEN-LAST:event_nameTFKeyReleased

    private void phoneTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneTFKeyReleased
        customerID = 0;
        customer.searchForCustomers(phoneTF.getText().trim().toLowerCase(), customersTable);
    }//GEN-LAST:event_phoneTFKeyReleased

    private void addressTAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressTAKeyReleased
        customerID = 0;
        customer.searchForCustomers(addressTA.getText().trim().toLowerCase(), customersTable);
    }//GEN-LAST:event_addressTAKeyReleased

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
        String name = nameTF.getText().trim();
        String phone = phoneTF.getText().trim();
        String address = addressTA.getText().trim();

        // CREATE CUSTOMER IF NOT EXIST
        if (customerID == 0 && !name.isEmpty()) {
            customerID = customer.saveCustomer(name, phone, address);
        }

        // ADD RECORD AT SAFE
        int safeID = safe.saveSafeRecord("Sale Invoice", total);

        // ADD RECORD AT SALE INVOICES
        int invoiceNo = saleInvoice.saveInvoiceRecord(safeID, customerID, total, discount);

        // ADD RECORDS AT SALES
        saleInvoice.saveItemsRecords(invoiceNo, saleItems);

        JOptionPane.showMessageDialog(this, "Saved");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressTA;
    private javax.swing.JButton cancelBTN;
    private javax.swing.JPanel customerPanel;
    private javax.swing.JTable customersTable;
    private javax.swing.JTextField discountTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTF;
    private javax.swing.JTextField phoneTF;
    private javax.swing.JButton saveBTN;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables

}
