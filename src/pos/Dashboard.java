package pos;

import javax.swing.JOptionPane;

public class Dashboard extends javax.swing.JFrame {

    public Dashboard() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gridPanel = new javax.swing.JPanel();
        reportsBTN = new javax.swing.JButton();
        expensesBTN = new javax.swing.JButton();
        safeBTN = new javax.swing.JButton();
        invoicesBTN = new javax.swing.JButton();
        employeesBTN = new javax.swing.JButton();
        suppliersBTN = new javax.swing.JButton();
        customersBTN = new javax.swing.JButton();
        productsBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Point Of Sale");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(700, 400));

        gridPanel.setLayout(new java.awt.GridLayout(2, 4, 5, 5));

        reportsBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        reportsBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/Icons/Reports.png"))); // NOI18N
        reportsBTN.setText("Reports");
        reportsBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reportsBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        reportsBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportsBTNActionPerformed(evt);
            }
        });
        gridPanel.add(reportsBTN);

        expensesBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        expensesBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/Icons/Expenses.png"))); // NOI18N
        expensesBTN.setText("Expenses");
        expensesBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        expensesBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        expensesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expensesBTNActionPerformed(evt);
            }
        });
        gridPanel.add(expensesBTN);

        safeBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        safeBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/Icons/Safe.png"))); // NOI18N
        safeBTN.setText("Safe");
        safeBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        safeBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        safeBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                safeBTNActionPerformed(evt);
            }
        });
        gridPanel.add(safeBTN);

        invoicesBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        invoicesBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/Icons/Cashier.png"))); // NOI18N
        invoicesBTN.setText("Invoices");
        invoicesBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        invoicesBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        invoicesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoicesBTNActionPerformed(evt);
            }
        });
        gridPanel.add(invoicesBTN);

        employeesBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        employeesBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/Icons/Employees.png"))); // NOI18N
        employeesBTN.setText("Employees");
        employeesBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        employeesBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        employeesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeesBTNActionPerformed(evt);
            }
        });
        gridPanel.add(employeesBTN);

        suppliersBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        suppliersBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/Icons/Suppliers.png"))); // NOI18N
        suppliersBTN.setText("Suppliers");
        suppliersBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        suppliersBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        suppliersBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliersBTNActionPerformed(evt);
            }
        });
        gridPanel.add(suppliersBTN);

        customersBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        customersBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/Icons/Customers.png"))); // NOI18N
        customersBTN.setText("Customers");
        customersBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        customersBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        customersBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersBTNActionPerformed(evt);
            }
        });
        gridPanel.add(customersBTN);

        productsBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        productsBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/Icons/Products.png"))); // NOI18N
        productsBTN.setText("Products");
        productsBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        productsBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        productsBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsBTNActionPerformed(evt);
            }
        });
        gridPanel.add(productsBTN);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gridPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gridPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reportsBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsBTNActionPerformed
        if (Employee.signedEmployee.equals("admin")) {
            new Report(this, true).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "You do not have access permission", "Dashboard", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_reportsBTNActionPerformed

    private void expensesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expensesBTNActionPerformed
        new Expense(this, true).setVisible(true);
    }//GEN-LAST:event_expensesBTNActionPerformed

    private void safeBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_safeBTNActionPerformed
        new Safe(this, true).setVisible(true);
    }//GEN-LAST:event_safeBTNActionPerformed

    private void invoicesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoicesBTNActionPerformed
        new InvoiceChooser(this, true).setVisible(true);
    }//GEN-LAST:event_invoicesBTNActionPerformed

    private void employeesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeesBTNActionPerformed
        if (Employee.signedEmployee.equals("admin")) {
            new Employee(this, true).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "You do not have access permission", "Dashboard", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_employeesBTNActionPerformed

    private void suppliersBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliersBTNActionPerformed
        new Supplier(this, true).setVisible(true);
    }//GEN-LAST:event_suppliersBTNActionPerformed

    private void customersBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersBTNActionPerformed
        new Customer(this, true).setVisible(true);
    }//GEN-LAST:event_customersBTNActionPerformed

    private void productsBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsBTNActionPerformed
        new Product(this, true).setVisible(true);
    }//GEN-LAST:event_productsBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton customersBTN;
    private javax.swing.JButton employeesBTN;
    private javax.swing.JButton expensesBTN;
    private javax.swing.JPanel gridPanel;
    private javax.swing.JButton invoicesBTN;
    private javax.swing.JButton productsBTN;
    private javax.swing.JButton reportsBTN;
    private javax.swing.JButton safeBTN;
    private javax.swing.JButton suppliersBTN;
    // End of variables declaration//GEN-END:variables

}
