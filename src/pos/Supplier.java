package pos;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Supplier extends javax.swing.JDialog {

    private final DBManager dbManager = DBManager.getInstance();

    private int id;
    private String name;
    private String phone;
    private String address;

    public Supplier(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadSuppliers();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        phoneTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressTA = new javax.swing.JTextArea();
        saveBTN = new javax.swing.JButton();
        newBTN = new javax.swing.JButton();
        tableScrollPane = new javax.swing.JScrollPane();
        suppliersTable = new javax.swing.JTable();
        searchTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Suppliers");
        setMinimumSize(new java.awt.Dimension(500, 570));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setLabelFor(nameTF);
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Phone");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Address");

        nameTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        phoneTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phoneTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        addressTA.setColumns(20);
        addressTA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addressTA.setLineWrap(true);
        addressTA.setRows(3);
        jScrollPane1.setViewportView(addressTA);

        saveBTN.setText("Save");
        saveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTNActionPerformed(evt);
            }
        });

        newBTN.setText("New");
        newBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBTNActionPerformed(evt);
            }
        });

        suppliersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        suppliersTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        suppliersTable.getTableHeader().setReorderingAllowed(false);
        suppliersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                suppliersTableMouseReleased(evt);
            }
        });
        suppliersTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                suppliersTableKeyPressed(evt);
            }
        });
        tableScrollPane.setViewportView(suppliersTable);

        searchTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTFKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameTF)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(saveBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(newBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                                    .addComponent(phoneTF))
                                .addGap(0, 97, Short.MAX_VALUE))
                            .addComponent(searchTF)))
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(phoneTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void suppliersTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suppliersTableKeyPressed
        if (!Employee.signedEmployee.equals("admin")) {
            JOptionPane.showMessageDialog(this, "You do not have this permission", "Products", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE && suppliersTable.getSelectedRow() >= 0) {
            deleteSupplier(id);

            clearFields();
            loadSuppliers();
            JOptionPane.showMessageDialog(this, "Deleted");
        }
    }//GEN-LAST:event_suppliersTableKeyPressed

    private void newBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBTNActionPerformed
        clearFields();
    }//GEN-LAST:event_newBTNActionPerformed

    private void saveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTNActionPerformed
        if (!Employee.signedEmployee.equals("admin")) {
            JOptionPane.showMessageDialog(this, "You do not have this permission", "Suppliers", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String newName = nameTF.getText().trim();
        String newPhone = phoneTF.getText().trim();
        String newAddress = addressTA.getText().trim();

        if (newName.isEmpty()) {
            nameTF.requestFocus();
            JOptionPane.showMessageDialog(this, "You must enter the name", "Suppliers", JOptionPane.ERROR_MESSAGE);

        } else if (id == 0) {
            saveSupplier(newName, newPhone, newAddress);

            clearFields();
            loadSuppliers();
            JOptionPane.showMessageDialog(this, "Saved");

        } else {
            updateSupplier(id, newName, newPhone, newAddress);

            clearFields();
            loadSuppliers();
            JOptionPane.showMessageDialog(this, "Updated");
        }
    }//GEN-LAST:event_saveBTNActionPerformed

    private void searchTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTFKeyReleased
        searchForSuppliers(searchTF.getText().trim().toLowerCase(), suppliersTable);
    }//GEN-LAST:event_searchTFKeyReleased

    private void suppliersTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppliersTableMouseReleased
        DefaultTableModel table = (DefaultTableModel) suppliersTable.getModel();
        id = (int) table.getValueAt(suppliersTable.getSelectedRow(), 0);
        name = table.getValueAt(suppliersTable.getSelectedRow(), 1).toString();
        phone = table.getValueAt(suppliersTable.getSelectedRow(), 2).toString();
        address = table.getValueAt(suppliersTable.getSelectedRow(), 3).toString();

        nameTF.setText(name);
        phoneTF.setText(phone);
        addressTA.setText(address);
    }//GEN-LAST:event_suppliersTableMouseReleased

    private void clearFields() {
        id = 0;
        name = "";
        phone = "";
        address = "";

        nameTF.setText(name);
        phoneTF.setText(phone);
        addressTA.setText(address);
        nameTF.requestFocus();
    }

    private void loadSuppliers() {
        dbManager.executeQuery("SELECT * FROM SUPPLIERS");
        dbManager.fillTable(suppliersTable, 0);
    }

    public void searchForSuppliers(String searchText, JTable resultTable) {
        dbManager.executeQuery("SELECT * FROM SUPPLIERS WHERE LOWER(NAME) LIKE '%" + searchText + "%' OR LOWER(PHONE) LIKE '%" + searchText + "%' OR LOWER(ADDRESS) LIKE '%" + searchText + "%'");
        dbManager.fillTable(resultTable,0);
    }

    public int saveSupplier(String name, String phone, String address) {
        return dbManager.executeQuery("INSERT INTO SUPPLIERS VALUES(DEFAULT, '" + name + "', '" + phone + "', '" + address + "')");
    }

    public void updateSupplier(int id, String name, String phone, String address) {
        dbManager.executeQuery("UPDATE SUPPLIERS SET NAME='" + name + "', PHONE='" + phone + "', ADDRESS='" + address + "' WHERE ID=" + id);
    }

    public void deleteSupplier(int id) {
        dbManager.executeQuery("DELETE FROM SUPPLIERS WHERE ID=" + id);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressTA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTF;
    private javax.swing.JButton newBTN;
    private javax.swing.JTextField phoneTF;
    private javax.swing.JButton saveBTN;
    private javax.swing.JTextField searchTF;
    private javax.swing.JTable suppliersTable;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables

}
