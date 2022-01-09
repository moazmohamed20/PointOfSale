package pos;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Customer extends javax.swing.JDialog {

    private final DBManager dbManager = DBManager.getInstance();

    private int id;
    private String name;
    private String phone;
    private String address;

    public Customer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadCustomers();
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
        customersTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        searchTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customers");
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

        customersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        customersTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        customersTable.getTableHeader().setReorderingAllowed(false);
        customersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                customersTableMouseReleased(evt);
            }
        });
        customersTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customersTableKeyPressed(evt);
            }
        });
        tableScrollPane.setViewportView(customersTable);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Search");

        searchTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTFKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
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
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(searchTF))))
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

    private void saveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTNActionPerformed
        String newName = nameTF.getText().trim();
        String newPhone = phoneTF.getText().trim();
        String newAddress = addressTA.getText().trim();

        if (newName.isEmpty()) {
            nameTF.requestFocus();
            JOptionPane.showMessageDialog(this, "You must enter the name", "Customers", JOptionPane.ERROR_MESSAGE);

        } else if (id == 0) {
            saveCustomer(newName, newPhone, newAddress);

            clearFields();
            loadCustomers();
            JOptionPane.showMessageDialog(this, "Saved");

        } else {
            updateCustomer(id, newName, newPhone, newAddress);

            clearFields();
            loadCustomers();
            JOptionPane.showMessageDialog(this, "Updated");
        }
    }//GEN-LAST:event_saveBTNActionPerformed

    private void newBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBTNActionPerformed
        clearFields();
    }//GEN-LAST:event_newBTNActionPerformed

    private void customersTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customersTableKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE && customersTable.getSelectedRow() >= 0) {
            deleteCustomer(id);

            clearFields();
            loadCustomers();
            JOptionPane.showMessageDialog(this, "Deleted");
        }
    }//GEN-LAST:event_customersTableKeyPressed

    private void searchTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTFKeyReleased
        searchForCustomers(searchTF.getText().trim().toLowerCase(), customersTable);
    }//GEN-LAST:event_searchTFKeyReleased

    private void customersTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customersTableMouseReleased
        DefaultTableModel table = (DefaultTableModel) customersTable.getModel();
        id = (int) table.getValueAt(customersTable.getSelectedRow(), 0);
        name = table.getValueAt(customersTable.getSelectedRow(), 1).toString();
        phone = table.getValueAt(customersTable.getSelectedRow(), 2).toString();
        address = table.getValueAt(customersTable.getSelectedRow(), 3).toString();

        nameTF.setText(name);
        phoneTF.setText(phone);
        addressTA.setText(address);
    }//GEN-LAST:event_customersTableMouseReleased

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

    private void loadCustomers() {
        dbManager.executeQuery("SELECT * FROM CUSTOMERS");
        dbManager.fillTable(customersTable, 0);
    }

    public void searchForCustomers(String searchText, JTable resultTable) {
        dbManager.executeQuery("SELECT * FROM CUSTOMERS WHERE LOWER(NAME) LIKE '%" + searchText + "%' OR LOWER(PHONE) LIKE '%" + searchText + "%' OR LOWER(ADDRESS) LIKE '%" + searchText + "%'");
        dbManager.fillTable(resultTable, 0);
    }

    public int saveCustomer(String name, String phone, String address) {
        return dbManager.executeQuery("INSERT INTO CUSTOMERS VALUES(DEFAULT, '" + name + "', '" + phone + "', '" + address + "')");
    }

    public void updateCustomer(int id, String name, String phone, String address) {
        dbManager.executeQuery("UPDATE CUSTOMERS SET NAME='" + name + "', PHONE='" + phone + "', ADDRESS='" + address + "' WHERE ID=" + id);
    }

    public void deleteCustomer(int id) {
        dbManager.executeQuery("DELETE FROM CUSTOMERS WHERE ID=" + id);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressTA;
    private javax.swing.JTable customersTable;
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
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables

}
