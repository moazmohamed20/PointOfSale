package pos;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.math.NumberUtils;

public class Product extends javax.swing.JDialog {

    private final DBManager dbManager = DBManager.getInstance();

    private String code;
    private String name;
    private double cost;
    private double price;
    private int quantity;
    private double discount;

    public Product(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadProducts();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        costTF = new javax.swing.JTextField();
        priceTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        quantityTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        discountTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        searchTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        saveBTN = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        newBTN = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tableScrollPane = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        codeTF = new javax.swing.JTextField();
        nameTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Products");
        setMinimumSize(new java.awt.Dimension(500, 570));

        costTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        costTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        costTF.setText("0");
        costTF.setNextFocusableComponent(priceTF);

        priceTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        priceTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        priceTF.setText("0");
        priceTF.setNextFocusableComponent(quantityTF);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Code");

        quantityTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quantityTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantityTF.setText("0");
        quantityTF.setNextFocusableComponent(discountTF);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Name");

        discountTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        discountTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        discountTF.setText("0");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Cost");

        searchTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTFKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Price");

        saveBTN.setText("Save");
        saveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTNActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Quantity");

        newBTN.setText("New");
        newBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBTNActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Discount");
        jLabel6.setToolTipText("");

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        productsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        productsTable.getTableHeader().setReorderingAllowed(false);
        productsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                productsTableMouseReleased(evt);
            }
        });
        productsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productsTableKeyPressed(evt);
            }
        });
        tableScrollPane.setViewportView(productsTable);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Search");

        codeTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        codeTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        nameTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchTF))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nameTF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(costTF, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(priceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(discountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(quantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(saveBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(codeTF))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTFKeyReleased
        searchForProducts(searchTF.getText().trim().toLowerCase(), productsTable);
    }//GEN-LAST:event_searchTFKeyReleased

    private void saveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTNActionPerformed
        String newCode = codeTF.getText().trim();
        String newName = nameTF.getText().trim();
        double newCost = NumberUtils.toDouble(costTF.getText().trim());
        double newPrice = NumberUtils.toDouble(priceTF.getText().trim());
        int newQuantity = NumberUtils.toInt(quantityTF.getText().trim());
        double newDiscount = NumberUtils.toDouble(discountTF.getText().trim());

        if (newCode.isEmpty()) {
            codeTF.requestFocus();
            JOptionPane.showMessageDialog(this, "You must enter the code", "Products", JOptionPane.ERROR_MESSAGE);

        } else if (newName.isEmpty()) {
            nameTF.requestFocus();
            JOptionPane.showMessageDialog(this, "You must enter the name", "Products", JOptionPane.ERROR_MESSAGE);

        } else if (!newCode.equals(code) && isProductExist(newCode)) {
            codeTF.requestFocus();
            JOptionPane.showMessageDialog(this, "Code already used", "Products", JOptionPane.ERROR_MESSAGE);

        } else if (code.isEmpty()) {
            saveProduct(newCode, newName, NumberUtils.toDouble(costTF.getText().trim()), NumberUtils.toDouble(priceTF.getText().trim()), NumberUtils.toInt(quantityTF.getText().trim()), NumberUtils.toDouble(discountTF.getText().trim()));

            clearFields();
            loadProducts();
            JOptionPane.showMessageDialog(this, "Saved");
        } else {
            updateProduct(code, newCode, newName, newCost, newPrice, newQuantity, newDiscount);

            clearFields();
            loadProducts();
            JOptionPane.showMessageDialog(this, "Updated");
        }
    }//GEN-LAST:event_saveBTNActionPerformed

    private void newBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBTNActionPerformed
        clearFields();
    }//GEN-LAST:event_newBTNActionPerformed

    private void productsTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productsTableMouseReleased
        DefaultTableModel table = (DefaultTableModel) productsTable.getModel();
        code = table.getValueAt(productsTable.getSelectedRow(), 0).toString();
        name = table.getValueAt(productsTable.getSelectedRow(), 1).toString();
        cost = (double) table.getValueAt(productsTable.getSelectedRow(), 2);
        price = (double) table.getValueAt(productsTable.getSelectedRow(), 3);
        quantity = (int) table.getValueAt(productsTable.getSelectedRow(), 4);
        discount = (double) table.getValueAt(productsTable.getSelectedRow(), 5);

        codeTF.setText(code);
        nameTF.setText(name);
        costTF.setText(String.valueOf(cost));
        priceTF.setText(String.valueOf(price));
        quantityTF.setText(String.valueOf(quantity));
        discountTF.setText(String.valueOf(discount));
    }//GEN-LAST:event_productsTableMouseReleased

    private void productsTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productsTableKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE && productsTable.getSelectedRow() >= 0) {
            deleteProduct(code);

            clearFields();
            loadProducts();
            JOptionPane.showMessageDialog(this, "Deleted");
        }
    }//GEN-LAST:event_productsTableKeyPressed

    private void clearFields() {
        code = "";
        name = "";
        cost = 0;
        price = 0;
        quantity = 0;
        discount = 0;

        codeTF.requestFocus();
        codeTF.setText(code);
        nameTF.setText(name);
        costTF.setText(String.valueOf(cost));
        priceTF.setText(String.valueOf(price));
        quantityTF.setText(String.valueOf(quantity));
        discountTF.setText(String.valueOf(discount));
    }

    private void loadProducts() {
        dbManager.executeQuery("SELECT * FROM PRODUCTS");
        dbManager.fillTable(productsTable);
    }

    public void searchForProducts(String searchText, JTable resultTable, String... columns) {
        if (columns.length == 0) {
            dbManager.executeQuery("SELECT * FROM PRODUCTS WHERE LOWER(NAME) LIKE '%" + searchText + "%' OR LOWER(CODE) LIKE '%" + searchText + "%'");
        } else {
            dbManager.executeQuery("SELECT " + String.join(", ", columns) + " FROM PRODUCTS WHERE LOWER(NAME) LIKE '%" + searchText + "%' OR LOWER(CODE) LIKE '%" + searchText + "%'");
        }
        dbManager.fillTable(resultTable);
    }

    public boolean isProductExist(String code) {
        dbManager.executeQuery("SELECT CODE FROM PRODUCTS WHERE CODE='" + code + "'");
        return (dbManager.recordsCount > 0);
    }

    public void saveProduct(String code, String name, double cost, double price, int quantity, double discount) {
        dbManager.executeQuery("INSERT INTO PRODUCTS VALUES('" + code + "', '" + name + "', " + cost + ", " + price + ", " + quantity + ", " + discount + ")");
    }

    public void updateProduct(String oldCode, String code, String name, double cost, double price, int quantity, double discount) {
        dbManager.executeQuery("UPDATE PRODUCTS SET CODE='" + code + "', NAME='" + name + "', COST=" + cost + ", PRICE=" + price + ", QUANTITY=" + quantity + ", DISCOUNT=" + discount + " WHERE CODE='" + oldCode + "'");
    }

    public void deleteProduct(String code) {
        dbManager.executeQuery("DELETE FROM PRODUCTS WHERE CODE='" + code + "'");
    }

    public void increaseProductQuantity(String code, int quantity) {
        dbManager.executeQuery("UPDATE PRODUCTS SET QUANTITY = QUANTITY + " + quantity + " WHERE CODE='" + code + "'");
    }

    public void updateProductColumn(String code, String column, Object value) {
        if (value instanceof String) {
            dbManager.executeQuery("UPDATE PRODUCTS SET " + column + "='" + value + "' WHERE CODE='" + code + "'");
        } else {
            dbManager.executeQuery("UPDATE PRODUCTS SET " + column + "=" + value + " WHERE CODE='" + code + "'");
        }
    }

    public void decreaseProductQuantity(String code, int quantity) {
        dbManager.executeQuery("UPDATE PRODUCTS SET QUANTITY = QUANTITY - " + quantity + " WHERE CODE='" + code + "'");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codeTF;
    private javax.swing.JTextField costTF;
    private javax.swing.JTextField discountTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nameTF;
    private javax.swing.JButton newBTN;
    private javax.swing.JTextField priceTF;
    private javax.swing.JTable productsTable;
    private javax.swing.JTextField quantityTF;
    private javax.swing.JButton saveBTN;
    private javax.swing.JTextField searchTF;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}
