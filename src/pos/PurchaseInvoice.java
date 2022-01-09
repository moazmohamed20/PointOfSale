package pos;

import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class PurchaseInvoice extends javax.swing.JFrame {

    private final DBManager dbManager = DBManager.getInstance();
    private final Product product = new Product(null, false);

    private final DefaultTableModel purchaseItems;

    public PurchaseInvoice() {
        super();
        initComponents();
        purchaseItems = (DefaultTableModel) purchaseTable.getModel();
        // Table Values Update Listener
        purchaseItems.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE && e.getColumn() < 5) {
                double cost = (double) purchaseItems.getValueAt(e.getFirstRow(), 2);
                int quantity = (int) purchaseItems.getValueAt(e.getFirstRow(), 4);
                double total = cost * quantity;

                purchaseItems.setValueAt(total, e.getFirstRow(), 5);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        searchTF = new javax.swing.JTextField();
        payBTN = new javax.swing.JButton();
        tableScrollPane = new javax.swing.JScrollPane();
        purchaseTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Purchase Invoice");
        setMinimumSize(new java.awt.Dimension(620, 540));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Search");

        searchTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTFActionPerformed(evt);
            }
        });
        searchTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTFKeyReleased(evt);
            }
        });

        payBTN.setText("Pay");
        payBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBTNActionPerformed(evt);
            }
        });

        purchaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Cost", "Price", "Quantity", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        purchaseTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        purchaseTable.setSurrendersFocusOnKeystroke(true);
        purchaseTable.getTableHeader().setReorderingAllowed(false);
        purchaseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                purchaseTableMouseClicked(evt);
            }
        });
        purchaseTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                purchaseTableKeyPressed(evt);
            }
        });
        tableScrollPane.setViewportView(purchaseTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchTF, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(payBTN)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(payBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void payBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBTNActionPerformed
        if (purchaseItems.getRowCount() > 0) {
            searchTF.setText("");
            purchaseTable.setModel(purchaseItems);
            new PurchasePayment(this, true, purchaseItems).setVisible(true);
            purchaseItems.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(this, "Add products first", "Purchase Invoice", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_payBTNActionPerformed

    private void purchaseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseTableMouseClicked
        if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1 && !searchTF.getText().isEmpty()) {
            addProductToCart(purchaseTable.getSelectedRow());

            searchTF.setText("");
            searchTF.requestFocus();
            purchaseTable.setModel(purchaseItems);
        }
    }//GEN-LAST:event_purchaseTableMouseClicked

    private void purchaseTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_purchaseTableKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE && searchTF.getText().isEmpty() && purchaseTable.getSelectedRow() >= 0) {
            purchaseItems.removeRow(purchaseTable.getSelectedRow());
        }
    }//GEN-LAST:event_purchaseTableKeyPressed

    private void searchTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTFKeyReleased
        if (!searchTF.getText().isEmpty()) {
            product.searchForProducts(searchTF.getText().trim().toLowerCase(), purchaseTable, "CODE", "NAME", "COST", "PRICE", "QUANTITY");
        } else {
            purchaseTable.setModel(purchaseItems);
        }
    }//GEN-LAST:event_searchTFKeyReleased

    private void searchTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTFActionPerformed
        if (!searchTF.getText().isEmpty() && purchaseTable.getRowCount() == 1) {
            addProductToCart(0);

            searchTF.setText("");
            searchTF.requestFocus();
            purchaseTable.setModel(purchaseItems);
        }
    }//GEN-LAST:event_searchTFActionPerformed

    private void addProductToCart(int searchModelIndex) {
        DefaultTableModel searchTable = (DefaultTableModel) purchaseTable.getModel();
        String code = searchTable.getValueAt(searchModelIndex, 0).toString();
        String name = searchTable.getValueAt(searchModelIndex, 1).toString();
        double cost = (double) searchTable.getValueAt(searchModelIndex, 2);
        double price = (double) searchTable.getValueAt(searchModelIndex, 3);

        // Product Found In Cart
        for (int i = 0; i < purchaseItems.getRowCount(); i++) {
            if (purchaseItems.getValueAt(i, 0).equals(code)) {
                int oldQuantity = (int) purchaseItems.getValueAt(i, 4);
                purchaseItems.setValueAt(oldQuantity + 1, i, 4);
                return;
            }
        }

        // Product Was Not Found In The Cart
        Object[] item = new Object[]{code, name, cost, price, 1, cost};
        purchaseItems.addRow(item);
    }

    public int saveInvoiceRecord(int safeID, int suuplierID, double total) {
        if (suuplierID == 0) {
            return dbManager.executeQuery("INSERT INTO PURCHASEINVOICE VALUES(DEFAULT, " + safeID + ", NULL, " + total + ")");
        } else {
            return dbManager.executeQuery("INSERT INTO PURCHASEINVOICE VALUES(DEFAULT, " + safeID + ", " + suuplierID + ", " + total + ")");
        }
    }

    public void saveItemsRecords(int invoiceNo, DefaultTableModel items) {
        for (int i = 0; i < items.getRowCount(); i++) {
            String code = items.getValueAt(i, 0).toString();
            String newName = items.getValueAt(i, 1).toString();
            double newCost = (double) items.getValueAt(i, 2);
            double newPrice = (double) items.getValueAt(i, 3);
            int newQuantity = (int) items.getValueAt(i, 4);

            dbManager.executeQuery("INSERT INTO PURCHASEINVOICE_PRODUCT VALUES(" + invoiceNo + ", '" + code + "', " + newCost + ", " + newQuantity + ")");

            product.updateProductColumn(code, "NAME", newName);
            product.updateProductColumn(code, "COST", newCost);
            product.updateProductColumn(code, "PRICE", newPrice);
            product.increaseProductQuantity(code, newQuantity);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton payBTN;
    private javax.swing.JTable purchaseTable;
    private javax.swing.JTextField searchTF;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables

}
