package pos;

import javax.swing.JTable;

public class Report extends javax.swing.JDialog {

    private final DBManager dbManager = DBManager.getInstance();

    private String reportType;

    public Report(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        reportCB.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        reportCB = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reports");
        setMinimumSize(new java.awt.Dimension(700, 540));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setLabelFor(reportCB);
        jLabel1.setText("Report");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setLabelFor(totalLabel);
        jLabel2.setText("Total");

        totalLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalLabel.setText("0.0");

        reportCB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        reportCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Safe", "Expenses", "Sales", "Sale Invoices", "Returns", "Return Invoices", "Purchases", "Purchase Invoices" }));
        reportCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportCBActionPerformed(evt);
            }
        });

        reportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        reportTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        reportTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(reportTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(totalLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(reportCB, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(reportCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totalLabel))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reportCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportCBActionPerformed
        reportType = reportCB.getSelectedItem().toString();

        String reportQuery = "";
        String totalQuery = "";
        switch (reportType) {
            case "Purchase Invoices":
                reportQuery = "SELECT \"NO\", DATE, NAME AS SUPPLIER, TOTAL "
                        + "FROM PURCHASEINVOICE "
                        + "JOIN SAFE ON SAFEID = SAFE.ID "
                        + "LEFT JOIN SUPPLIERS ON SUPPLIERID = SUPPLIERS.ID";
                totalQuery = "SELECT SUM(TOTAL) FROM PURCHASEINVOICE";
                break;
            case "Purchases":
                reportQuery = "SELECT DATE, NAME AS PRODUCT, PI_P.COST, PI_P.QUANTITY, PI_P.COST * PI_P.QUANTITY AS TOTAL "
                        + "FROM PURCHASEINVOICE_PRODUCT AS PI_P "
                        + "JOIN PRODUCTS ON PRODUCTCODE = PRODUCTS.CODE "
                        + "JOIN PURCHASEINVOICE ON INVOICENO = PURCHASEINVOICE.\"NO\" "
                        + "JOIN SAFE ON SAFEID = SAFE.ID "
                        + "ORDER BY INVOICENO";
                totalQuery = "SELECT SUM(COST * QUANTITY) FROM PURCHASEINVOICE_PRODUCT";
                break;

            case "Return Invoices":
                reportQuery = "SELECT RETURNINVOICE.\"NO\", DATE, NAME AS CUSTOMER, RETURNINVOICE.TOTAL "
                        + "FROM RETURNINVOICE "
                        + "JOIN SAFE ON SAFEID = SAFE.ID "
                        + "JOIN SALEINVOICE ON SALEINVOICENO = SALEINVOICE.\"NO\" LEFT "
                        + "JOIN CUSTOMERS ON CUSTOMERID = CUSTOMERS.ID";
                totalQuery = "SELECT SUM(TOTAL) FROM RETURNINVOICE";
                break;
            case "Returns":
                reportQuery = "SELECT DATE, NAME AS PRODUCT, SI_P.PRICE, RI_P.QUANTITY, SI_P.DISCOUNT, ((SI_P.PRICE * RI_P.QUANTITY) - SI_P.DISCOUNT) AS TOTAL "
                        + "FROM RETURNINVOICE_PRODUCT AS RI_P "
                        + "JOIN PRODUCTS ON PRODUCTCODE = PRODUCTS.CODE "
                        + "JOIN RETURNINVOICE ON INVOICENO = RETURNINVOICE.\"NO\" "
                        + "JOIN SAFE ON SAFEID = SAFE.ID "
                        + "JOIN SALEINVOICE_PRODUCT AS SI_P ON (SALEINVOICENO = SI_P.INVOICENO AND RI_P.PRODUCTCODE = SI_P.PRODUCTCODE) "
                        + "ORDER BY RI_P.INVOICENO";
                totalQuery = "SELECT SUM((PRICE * RI_P.QUANTITY) - DISCOUNT) "
                        + "FROM RETURNINVOICE_PRODUCT AS RI_P "
                        + "JOIN RETURNINVOICE ON INVOICENO = RETURNINVOICE.\"NO\" "
                        + "JOIN SALEINVOICE_PRODUCT AS SI_P ON (SALEINVOICENO = SI_P.INVOICENO AND RI_P.PRODUCTCODE = SI_P.PRODUCTCODE)";
                break;

            case "Sale Invoices":
                reportQuery = "SELECT \"NO\", DATE, NAME AS CUSTOMER, TOTAL "
                        + "FROM SALEINVOICE JOIN SAFE ON SAFEID = SAFE.ID LEFT "
                        + "JOIN CUSTOMERS ON CUSTOMERID = CUSTOMERS.ID";
                totalQuery = "SELECT SUM(TOTAL) FROM SALEINVOICE";
                break;

            case "Sales":
                reportQuery = "SELECT DATE, NAME AS PRODUCT, SI_P.PRICE, SI_P.QUANTITY, SI_P.DISCOUNT, ((SI_P.PRICE * SI_P.QUANTITY) - SI_P.DISCOUNT) AS TOTAL "
                        + "FROM SALEINVOICE_PRODUCT AS SI_P "
                        + "JOIN PRODUCTS ON PRODUCTCODE = PRODUCTS.CODE "
                        + "JOIN SALEINVOICE ON INVOICENO = SALEINVOICE.\"NO\" "
                        + "JOIN SAFE ON SAFEID = SAFE.ID "
                        + "ORDER BY INVOICENO";
                totalQuery = "SELECT SUM((PRICE * QUANTITY) - DISCOUNT) FROM SALEINVOICE_PRODUCT";
                break;

            case "Expenses":
                reportQuery = "SELECT DATE, EXPENSE, COST "
                        + "FROM EXPENSES "
                        + "JOIN SAFE ON SAFEID = SAFE.ID "
                        + "ORDER BY DATE";
                totalQuery = "SELECT SUM(COST) FROM EXPENSES";
                break;

            case "Safe":
                reportQuery = "SELECT DATE, STATEMENT, EMPLOYEE, PRICE "
                        + "FROM SAFE "
                        + "ORDER BY DATE";
                totalQuery = "SELECT SUM(PRICE) FROM SAFE";
                break;
        }
        totalLabel.setText(String.valueOf(calcReportTotal(totalQuery)));
        loadReport(reportQuery, reportTable);
    }//GEN-LAST:event_reportCBActionPerformed

    private void loadReport(String query, JTable resultTable) {
        dbManager.executeQuery(query);
        dbManager.fillTable(resultTable);
    }

    private double calcReportTotal(String query) {
        return dbManager.executeOperation(query);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> reportCB;
    private javax.swing.JTable reportTable;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables

}
