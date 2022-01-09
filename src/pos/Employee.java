package pos;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Employee extends javax.swing.JDialog {

    private final DBManager dbManager = DBManager.getInstance();
    public static String signedEmployee;

    private String username;
    private String password;

    public Employee(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadEmployees();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameTF = new javax.swing.JTextField();
        passwordTF = new javax.swing.JPasswordField();
        showCB = new javax.swing.JCheckBox();
        saveBTN = new javax.swing.JButton();
        newBTN = new javax.swing.JButton();
        tableScrollPane = new javax.swing.JScrollPane();
        employeesTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employees");
        setMinimumSize(new java.awt.Dimension(500, 570));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setLabelFor(usernameTF);
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setLabelFor(passwordTF);
        jLabel2.setText("Password");

        usernameTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        usernameTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        passwordTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        showCB.setText("Show");
        showCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCBActionPerformed(evt);
            }
        });

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

        employeesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        employeesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        employeesTable.getTableHeader().setResizingAllowed(false);
        employeesTable.getTableHeader().setReorderingAllowed(false);
        employeesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                employeesTableMouseReleased(evt);
            }
        });
        employeesTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                employeesTableKeyPressed(evt);
            }
        });
        tableScrollPane.setViewportView(employeesTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saveBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usernameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(passwordTF, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showCB)
                            .addComponent(newBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 136, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showCB)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCBActionPerformed
        if (showCB.isSelected()) {
            passwordTF.setEchoChar('\0');
        } else {
            passwordTF.setEchoChar('●');
        }
    }//GEN-LAST:event_showCBActionPerformed

    private void saveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTNActionPerformed
        String newUsername = usernameTF.getText().trim().toLowerCase();
        String newPassword = passwordTF.getText();

        if (newUsername.isEmpty()) {
            usernameTF.requestFocus();
            JOptionPane.showMessageDialog(this, "You must enter the username", "Employees", JOptionPane.ERROR_MESSAGE);

        } else if (!newUsername.equals(username) && isEmployeeExist(newUsername)) {
            usernameTF.requestFocus();
            JOptionPane.showMessageDialog(this, "Username already used", "Employees", JOptionPane.ERROR_MESSAGE);

        } else if (username.isEmpty()) {
            saveEmployee(newUsername, newPassword);

            clearFields();
            loadEmployees();
            JOptionPane.showMessageDialog(this, "Saved");

        } else {
            updateEmployee(username, newUsername, newPassword);

            clearFields();
            loadEmployees();
            JOptionPane.showMessageDialog(this, "Updated");
        }
    }//GEN-LAST:event_saveBTNActionPerformed

    private void newBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBTNActionPerformed
        clearFields();
    }//GEN-LAST:event_newBTNActionPerformed

    private void employeesTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employeesTableKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE && employeesTable.getSelectedRow() >= 0 && !username.equals("admin")) {
            deleteEmployee(username);

            clearFields();
            loadEmployees();
            JOptionPane.showMessageDialog(this, "Deleted");
        }
    }//GEN-LAST:event_employeesTableKeyPressed

    private void employeesTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeesTableMouseReleased
        DefaultTableModel table = (DefaultTableModel) employeesTable.getModel();
        username = table.getValueAt(employeesTable.getSelectedRow(), 0).toString();
        password = table.getValueAt(employeesTable.getSelectedRow(), 1).toString();

        usernameTF.setText(username);
        passwordTF.setText(password);
        usernameTF.setEditable(!username.equals("admin"));
    }//GEN-LAST:event_employeesTableMouseReleased

    private void clearFields() {
        username = "";
        password = "";

        usernameTF.requestFocus();
        usernameTF.setText(username);
        passwordTF.setText(password);
        usernameTF.setEditable(true);
    }

    private void loadEmployees() {
        dbManager.executeQuery("SELECT * FROM EMPLOYEES");
        dbManager.fillTable(employeesTable, 1);
    }

    public boolean isEmployeeExist(String username) {
        dbManager.executeQuery("SELECT USERNAME FROM EMPLOYEES WHERE USERNAME='" + username + "'");
        return (dbManager.recordsCount > 0);
    }

    public boolean authanticate(String username, String password) {
        dbManager.executeQuery("SELECT * FROM EMPLOYEES WHERE USERNAME='" + username + "' AND PASSWORD='" + password + "'");
        return (dbManager.recordsCount == 1);
    }

    public void saveEmployee(String username, String password) {
        dbManager.executeQuery("INSERT INTO EMPLOYEES VALUES('" + username + "', '" + password + "')");
    }

    public void updateEmployee(String oldUsername, String newUsername, String password) {
        dbManager.executeQuery("UPDATE EMPLOYEES SET USERNAME='" + newUsername + "', PASSWORD='" + password + "' WHERE USERNAME='" + oldUsername + "'");
    }

    public void deleteEmployee(String username) {
        dbManager.executeQuery("DELETE FROM EMPLOYEES WHERE USERNAME='" + username + "'");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable employeesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton newBTN;
    private javax.swing.JPasswordField passwordTF;
    private javax.swing.JButton saveBTN;
    private javax.swing.JCheckBox showCB;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JTextField usernameTF;
    // End of variables declaration//GEN-END:variables

}
