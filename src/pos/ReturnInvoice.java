package pos;

import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class ReturnInvoice extends javax.swing.JFrame {

    private final DBManager dbManager = DBManager.getInstance();
    private final Product product;

    private final DefaultTableModel returnItems;

    private final SaleInvoice saleInvoice;
    private final int saleInvoiceNo;

    public ReturnInvoice(int saleInvoiceNo) {
        super();
        this.saleInvoice = new SaleInvoice();
        this.product = new Product(null, false);
        this.saleInvoiceNo = saleInvoiceNo;

        initComponents();
        saleInvoice.loadInvoiceItems(saleInvoiceNo, saleTable);

        returnItems = (DefaultTableModel) returnTable.getModel();
        // Table Values Update Listener
        returnItems.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 3) {
                double price = (double) returnTable.getValueAt(e.getFirstRow(), 2);
                int quantity = (int) returnTable.getValueAt(e.getFirstRow(), 3);
                double discount = (double) returnTable.getValueAt(e.getFirstRow(), 4);
                double total = (price * quantity) - discount;

                returnTable.setValueAt(total, e.getFirstRow(), 5);
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        payBTN = new javax.swing.JButton();
        tableScrollPane = new javax.swing.JScrollPane();
        saleTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tableScrollPane1 = new javax.swing.JScrollPane();
        returnTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Return Invoice");
        setMinimumSize(new java.awt.Dimension(620, 540));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Sale Invoice Items");

        payBTN.setText("Pay");
        payBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBTNActionPerformed(evt);
            }
        });

        saleTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        saleTable.setSurrendersFocusOnKeystroke(true);
        saleTable.getTableHeader().setReorderingAllowed(false);
        saleTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saleTableMouseClicked(evt);
            }
        });
        tableScrollPane.setViewportView(saleTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Returned Items");

        returnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Price", "Quantity", "Discount", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        returnTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        returnTable.setSurrendersFocusOnKeystroke(true);
        returnTable.getTableHeader().setReorderingAllowed(false);
        returnTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnTableMouseClicked(evt);
            }
        });
        returnTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                returnTableKeyPressed(evt);
            }
        });
        tableScrollPane1.setViewportView(returnTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 457, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(payBTN))
                    .addComponent(tableScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(payBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void payBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBTNActionPerformed
        if (returnItems.getRowCount() > 0) {
            new ReturnPayment(this, true, saleInvoiceNo, returnItems).setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Choose products first", "Return Invoice", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_payBTNActionPerformed

    private void saleTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saleTableMouseClicked
        if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1 && saleTable.getSelectedRow() >= 0) {
            addReturnedProduct(saleTable.getSelectedRow());
        }
    }//GEN-LAST:event_saleTableMouseClicked

    private void returnTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnTableMouseClicked
        if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1 && returnTable.getSelectedRow() >= 0) {
            removeReturnedProduct(returnTable.getSelectedRow());
        }
    }//GEN-LAST:event_returnTableMouseClicked

    private void returnTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_returnTableKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE && returnTable.getSelectedRow() >= 0) {
            returnItems.removeRow(returnTable.getSelectedRow());
        }
    }//GEN-LAST:event_returnTableKeyPressed

    private void addReturnedProduct(int saleTableIndex) {
        DefaultTableModel saleModel = (DefaultTableModel) saleTable.getModel();
        String code = saleModel.getValueAt(saleTableIndex, 0).toString();
        String name = saleModel.getValueAt(saleTableIndex, 1).toString();
        double price = (double) saleModel.getValueAt(saleTableIndex, 2);
        int soldQuantity = (int) saleModel.getValueAt(saleTableIndex, 3);
        double discount = (double) saleModel.getValueAt(saleTableIndex, 4);

        // Product Found In Return Items
        for (int i = 0; i < returnItems.getRowCount(); i++) {
            if (returnItems.getValueAt(i, 0).equals(code)) {
                int returnedQuantity = (int) returnItems.getValueAt(i, 3);
                if (returnedQuantity < soldQuantity) {
                    returnItems.setValueAt(returnedQuantity + 1, i, 3);
                } else {
                    JOptionPane.showMessageDialog(this, "All quantity are returned", "Return Invoice", JOptionPane.ERROR_MESSAGE);
                }
                return;
            }
        }

        // Product Was Not Found In In Return Items
        Object[] item = new Object[]{code, name, price, 1, discount, price - discount};
        returnItems.addRow(item);
    }

    private void removeReturnedProduct(int returnTableIndex) {
        int quantity = (int) returnItems.getValueAt(returnTableIndex, 3);

        returnItems.setValueAt(quantity - 1, returnTableIndex, 3);

        // If All Returned Quantity Are Removed
        if (quantity == 1) {
            returnItems.removeRow(returnTable.getSelectedRow());
        }
    }

    public int saveInvoiceRecord(int saleInvoiceNo, int safeID, double total) {
        return dbManager.executeQuery("INSERT INTO RETURNINVOICE VALUES(DEFAULT, " + saleInvoiceNo + ", " + safeID + ", " + total + ")");
    }

    public void saveItemsRecords(int invoiceNo, DefaultTableModel items) {
        for (int i = 0; i < items.getRowCount(); i++) {
            String code = items.getValueAt(i, 0).toString();
            int returnedQuantity = (int) items.getValueAt(i, 3);

            dbManager.executeQuery("INSERT INTO RETURNINVOICE_PRODUCT VALUES(" + invoiceNo + ", '" + code + "', " + returnedQuantity + ")");

            product.increaseProductQuantity(code, returnedQuantity);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton payBTN;
    private javax.swing.JTable returnTable;
    private javax.swing.JTable saleTable;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JScrollPane tableScrollPane1;
    // End of variables declaration//GEN-END:variables

}
