package pos;

import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class SaleInvoice extends javax.swing.JFrame {

    private final DBManager dbManager = DBManager.getInstance();
    private final Product product;

    private final DefaultTableModel saleItems;

    public SaleInvoice() {
        super();
        this.product = new Product(null, false);

        initComponents();
        saleItems = (DefaultTableModel) saleTable.getModel();
        // Table Values Update Listener
        saleItems.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE && (e.getColumn() == 3 || e.getColumn() == 4)) {
                double price = (double) saleItems.getValueAt(e.getFirstRow(), 2);
                int quantity = (int) saleItems.getValueAt(e.getFirstRow(), 3);               
                double discount = (double) saleItems.getValueAt(e.getFirstRow(), 4);
                double total = (price * quantity) - discount;
              
                saleItems.setValueAt(total, e.getFirstRow(), 5);
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
        saleTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sale Invoice");
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

        saleTable.setModel(new javax.swing.table.DefaultTableModel(
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
                false, false, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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
        saleTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                saleTableKeyPressed(evt);
            }
        });
        tableScrollPane.setViewportView(saleTable);

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
        if (saleItems.getRowCount() > 0) {
            searchTF.setText("");
            saleTable.setModel(saleItems);
            new SalePayment(this, true, saleItems).setVisible(true);
            saleItems.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(this, "Add products first", "Sale Invoice", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_payBTNActionPerformed

    private void saleTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saleTableKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE && searchTF.getText().isEmpty() && saleTable.getSelectedRow() >= 0) {
            saleItems.removeRow(saleTable.getSelectedRow());
        }
    }//GEN-LAST:event_saleTableKeyPressed

    private void searchTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTFKeyReleased
        if (!searchTF.getText().isEmpty()) {
            product.searchForProducts(searchTF.getText().trim().toLowerCase(), saleTable, "CODE", "NAME", "PRICE - DISCOUNT AS PRICE", "QUANTITY");
        } else {
            saleTable.setModel(saleItems);
        }
    }//GEN-LAST:event_searchTFKeyReleased

    private void saleTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saleTableMouseClicked
        if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1 && !searchTF.getText().isEmpty()) {
            addProductToCart(saleTable.getSelectedRow());

            searchTF.setText("");
            searchTF.requestFocus();
            saleTable.setModel(saleItems);
        }
    }//GEN-LAST:event_saleTableMouseClicked

    private void searchTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTFActionPerformed
        if (!searchTF.getText().isEmpty() && saleTable.getRowCount() == 1) {
            addProductToCart(0);

            searchTF.setText("");
            searchTF.requestFocus();
            saleTable.setModel(saleItems);
        }
    }//GEN-LAST:event_searchTFActionPerformed

    private void addProductToCart(int searchModelIndex) {
        DefaultTableModel searchTable = (DefaultTableModel) saleTable.getModel();
        String code = searchTable.getValueAt(searchModelIndex, 0).toString();
        String name = searchTable.getValueAt(searchModelIndex, 1).toString();
        double price = (double) searchTable.getValueAt(searchModelIndex, 2);
        int quantity = (int) searchTable.getValueAt(searchModelIndex, 3);

        // Product Is Not Available In The Stock
        if (quantity == 0) {
            JOptionPane.showMessageDialog(this, "Product is not available in the stock", "Sale Invoice", JOptionPane.WARNING_MESSAGE);
        }

        // Product Found In Cart
        for (int i = 0; i < saleItems.getRowCount(); i++) {
            if (saleItems.getValueAt(i, 0).equals(code)) {
                int oldQuantity = (int) saleItems.getValueAt(i, 3);
                saleItems.setValueAt(oldQuantity + 1, i, 3);
                return;
            }
        }

        // Product Was Not Found In The Cart
        Object[] item = new Object[]{code, name, price, 1, 0.0, price};
        saleItems.addRow(item);
    }

    public int saveInvoiceRecord(int safeID, int customerID, double total, double discount) {
        if (customerID == 0) {
            return dbManager.executeQuery("INSERT INTO SALEINVOICE VALUES(DEFAULT, " + safeID + ", NULL, " + total + ", " + discount + ")");
        } else {
            return dbManager.executeQuery("INSERT INTO SALEINVOICE VALUES(DEFAULT, " + safeID + ", " + customerID + ", " + total + ", " + discount + ")");
        }
    }

    public void saveItemsRecords(int invoiceNo, DefaultTableModel items) {
        for (int i = 0; i < items.getRowCount(); i++) {
            String code = items.getValueAt(i, 0).toString();
            double soldPrice = (double) items.getValueAt(i, 2);
            int soldQuantity = (int) items.getValueAt(i, 3);
            double soldDiscount = (double) items.getValueAt(i, 4);

            dbManager.executeQuery("INSERT INTO SALEINVOICE_PRODUCT VALUES(" + invoiceNo + ", '" + code + "', " + soldPrice + ", " + soldQuantity + ", " + soldDiscount + ")");

            product.decreaseProductQuantity(code, soldQuantity);
        }
    }

    public void loadInvoiceItems(int invoiceNo, JTable table) {
        dbManager.executeQuery("SELECT PRODUCTCODE AS CODE, NAME, SI_P.PRICE, SI_P.QUANTITY, SI_P.DISCOUNT, ((SI_P.PRICE * SI_P.QUANTITY) - SI_P.DISCOUNT) AS TOTAL FROM SALEINVOICE_PRODUCT AS SI_P JOIN PRODUCTS ON PRODUCTCODE = PRODUCTS.CODE JOIN SALEINVOICE ON INVOICENO = SALEINVOICE.\"NO\" WHERE INVOICENO=" + invoiceNo);
        dbManager.fillTable(table);
    }

    public double getInvoiceDiscount(int invoiceNo) {
        return dbManager.executeOperation("SELECT DISCOUNT FROM SALEINVOICE WHERE \"NO\"=" + invoiceNo);
    }

    public boolean isInvoiceExist(int invoiceNo) {
        dbManager.executeQuery("SELECT \"NO\" FROM SALEINVOICE WHERE \"NO\"=" + invoiceNo);
        return (dbManager.recordsCount == 1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton payBTN;
    private javax.swing.JTable saleTable;
    private javax.swing.JTextField searchTF;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables

}
